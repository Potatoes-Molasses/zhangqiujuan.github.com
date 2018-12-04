package socketFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张秋娟
 * @date 2018.12.3
 */
public class ServerThread implements Runnable{
	private Socket socket;
	
	public ServerThread(Socket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		System.out.println("服务器传送线程已开启");
		try {
			//得到此套接字用于输入的流对象
			Reader reader=new InputStreamReader(socket.getInputStream());
			BufferedReader in =new BufferedReader(reader);
			
			//对暗号，防止其他恶意程序攻击
			String message=in.readLine();
			if(!"天王盖地虎".equals(message)) {
				return;
			}
			
			System.out.println("服务器暗号对接成功");
			
			//接收传输的文本内容
			List<String>context=getFile(in);
			System.out.println("服务器文件接收完成");
			//客户端指定的文件名
			String filename=in.readLine();
			System.out.println("服务器文件全部接收完成");
			
			//获得文件的绝对路径
			String FullPath=socketFileServer.PATH+filename;
			boolean flag=false;
			for(String str:context) {
				 flag=FileUtil.writeLog(FullPath,str);
			}
			//得到此套接字用于输出的流对象
			PrintWriter writer=new PrintWriter(socket.getOutputStream());
			if(flag) {
				writer.println("文件保存成功");
			}else {
				writer.println("文件保存失败");
			}
			writer.flush();
		
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket!=null){
					socket.close();
				}
			}catch(IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	/***
	 * 
	 * @param in 用于读客户端发送字符的文件流对象
	 * @return  客户端发送所有字符的list集合
	 * @throws IOException
	 */
	private List<String>getFile(BufferedReader in)throws IOException{
		List<String>context=new ArrayList();
		while(true) {
			String tempStr=in.readLine();
			//如果接收到"endendend"字符串,则说明文件内容传输完毕
			if("endendend".equals(tempStr)) {
				break;
			}
			context.add(tempStr);
		}
		return context;
	}
}
