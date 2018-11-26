/**
 * 
 */
package netTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;

/**
 * @author 张秋娟
 * @date 2018-11-24
 */
public class ServerThread implements Runnable{
	
	private Socket socket;
	
	public ServerThread(Socket socket) {
		//针对每一个客户端请求，分配一个端口给相应的线程
		this.socket=socket;
	}
	
	@Override
	public void run() {
		System.out.println("服务器处理器线程已启动");
		Reader read = null;
		try {
			
			//1.第一次接收来自客户端的信息
			read = new InputStreamReader(socket.getInputStream());
			BufferedReader in = new BufferedReader(read);
			String str = in.readLine();
			System.out.println("客户端传来的内容为："+str);
			
			//2.第一次向客户端发送信息
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println("你好人类，这是来自火星的问候");
			out.flush();
			
			//3.第二次接收来自客户端的信息
			str = in.readLine();
			System.out.println("客户端传来的内容为："+str);
			
			//4.第二次向客户端发送信息
			out.println("暴风雨就要来了");
			out.flush();
		}catch(IOException e) {
			
			e.printStackTrace();
		
		}finally {
			try {
				//关闭资源
				socket.close();
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
