package socketFile;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author �����
 * @date 2018.12.3
 */
public class socketFileServer {

	//Ĭ��Ҫ�����ļ����ļ���·��
	public final static String PATH="D:\\socketfile";
	
	public static void main(String[]args) {
		ServerSocket serverSocket=null;
		try {
			serverSocket=new ServerSocket(9898);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		if(serverSocket==null) {
			System.out.println("����������ʧ��");
			return;
		}
		System.out.println("������������");
		while(true) {
			try {
			System.out.println("�ȴ��ͻ�������... ...");
			Socket socket=serverSocket.accept();
			ServerThread serverThread=new ServerThread(socket);
			new Thread(serverThread).start();
			}catch(IOException e) {	
				System.out.println("�������򿪿ͻ���ʧ��");
				e.printStackTrace();
			}
		}
	}
}
