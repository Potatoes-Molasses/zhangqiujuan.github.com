package SocketServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;

/**
 * @author 张秋娟
 * @date 2018.12.2
 */
public class SocketServerThread implements Runnable{
	
	//客户端打开的连接
	private Socket socket;
	
	/**
     * 传入客户端打开的连接
     * @param socket
     */
	public SocketServerThread(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		System.out.println("处理客户端业务线程启动");
		try {
			//第一次通讯
			//获取从客户端传来的信息
			Reader reader=new InputStreamReader(socket.getInputStream());
			BufferedReader in=new BufferedReader(reader);
			//读取一行客户端传来的信息，阻塞
			String clientMessage=in.readLine();
			System.out.println("客户端传来的信息："+clientMessage);
			
			//回传信息给客户端
			PrintWriter out=new PrintWriter(socket.getOutputStream());
			out.println("这是来自火星的问候");
			out.flush();
			
			//第二次通讯
			clientMessage=in.readLine();
			System.out.println("客户端传来的暗号："+clientMessage);
			out.println("暴风雨就要来了!");
			out.flush();
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
}
