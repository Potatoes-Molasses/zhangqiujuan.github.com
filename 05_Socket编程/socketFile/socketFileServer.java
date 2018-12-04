package socketFile;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 张秋娟
 * @date 2018.12.3
 */
public class socketFileServer {

	//默认要保存文件的文件夹路径
	public final static String PATH="D:\\socketfile";
	
	public static void main(String[]args) {
		ServerSocket serverSocket=null;
		try {
			serverSocket=new ServerSocket(9898);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		if(serverSocket==null) {
			System.out.println("服务器启动失败");
			return;
		}
		System.out.println("服务器已启动");
		while(true) {
			try {
			System.out.println("等待客户端连接... ...");
			Socket socket=serverSocket.accept();
			ServerThread serverThread=new ServerThread(socket);
			new Thread(serverThread).start();
			}catch(IOException e) {	
				System.out.println("服务器打开客户端失败");
				e.printStackTrace();
			}
		}
	}
}
