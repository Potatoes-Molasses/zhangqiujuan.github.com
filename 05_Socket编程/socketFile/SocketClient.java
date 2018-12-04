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
 * @author �����
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
			System.out.println("����������Ҫ�Ĺ��ܣ�1�����ļ���2�˳�");
			//��ȡ�û����룬ִ����Ӧ����
			String message=sc.next();
			if("2".equals(message)) {
				break;
			}else {
				System.out.println("������Ҫ�����ļ�������·����");
				//�õ�Ҫ�����ļ�������·��
				String path=sc.next();
				try {
					//��ȡ�ļ�����list����ʽ����
					List<String>context=FileUtil.readLogByList(path);
					if(context.size()>0) {
						//path.substring(path.lastIndexOf("\\"), path.length())��ȡ�ļ���
						boolean flag=client.sendFileToServer(context,path.substring(path.lastIndexOf("\\"), path.length()),socket);
						if(flag) {
							System.out.println("�ļ����ͳɹ�");
						}else {
							System.out.println("�ļ�����ʧ��");
						}
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	

	private boolean sendFileToServer(List<String>context,String fileName,Socket socket)throws IOException{
		//�õ����׽������������������
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
        //��һ���԰���
		writer.println("�����ǵػ�");  
        writer.flush();
        //�����ļ�����
        for(String str : context){  
            writer.println(str);
            writer.flush();
        }
       
        //���ͽ�����־
        writer.println("endendend"); 
        writer.flush();
        //�����ļ���
        writer.println(fileName);  
        writer.flush();
        
        //�õ����׽������������������
        Reader reader = new InputStreamReader(socket.getInputStream());
        BufferedReader in = new BufferedReader(reader);
        //��ȡ���������
        String serverMessage = in.readLine();  
        socket.close();
        if("�ļ�����ɹ�".equals(serverMessage)){
            return true;
        }else{
            return false;
        }
    }
}
