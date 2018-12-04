package socketFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

/**
 * @author 张秋娟
 * @date 2018.12.3
 */
public class SocketClient {
	public static void main(String[]args) {
		Socket socket=null;
		try {
			socket=new Socket("localhost",9898);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		Scanner sc=new Scanner(System.in);
		SocketClient client=new SocketClient();
		while(true) {
			System.out.println("请输入您需要的功能：1传送文件，2退出");
			//获取用户输入，执行相应操作
			String message=sc.next();
			if("2".equals(message)) {
				break;
			}else {
				System.out.println("请输入要传送文件的完整路径：");
				//得到要传送文件的完整路径
				String path=sc.next();
				try {
					//读取文件，以list的形式返回
					List<String>context=FileUtil.readLogByList(path);
					if(context.size()>0) {
						//path.substring(path.lastIndexOf("\\"), path.length())提取文件名
						boolean flag=client.sendFileToServer(context,path.substring(path.lastIndexOf("\\"), path.length()),socket);
						if(flag) {
							System.out.println("文件传送成功");
						}else {
							System.out.println("文件传送失败");
						}
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	

	private boolean sendFileToServer(List<String>context,String fileName,Socket socket)throws IOException{
		//得到此套接字用于输出的流对象
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
        //第一步对暗号
		writer.println("天王盖地虎");  
        writer.flush();
        //发送文件内容
        for(String str : context){  
            writer.println(str);
            writer.flush();
        }
       
        //发送结束标志
        writer.println("endendend"); 
        writer.flush();
        //发送文件名
        writer.println(fileName);  
        writer.flush();
        
        //得到此套接字用于输入的流对象
        Reader reader = new InputStreamReader(socket.getInputStream());
        BufferedReader in = new BufferedReader(reader);
        //获取结果并返回
        String serverMessage = in.readLine();  
        socket.close();
        if("文件保存成功".equals(serverMessage)){
            return true;
        }else{
            return false;
        }
    }
}
