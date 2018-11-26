package netTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/**
 * @author 张秋娟
 * @date 2018-11-24
 *
 */

/**
 * 实现步骤：
 * 1、线程池服务器首先创建一个ServerSocket实例。
 * 2、然后创建N个线程，每个线程反复循环，从（共享的）ServerSocket实例接收客户端连接。
 *    当多个线程同时调用一个ServerSocket实例的accept()方法时，它们都将阻塞等待。
 *    直到一个新的连接成功建立，然后系统选择一个线程，为建立起的连接提供服务，其他线程则继续阻塞等待。
 * 3、线程在完成对一个客户端的服务后，继续等待其他的连接请求，而不终止。
 *    如果在一个客户端连接被创建时，没有线程在accept()方法上阻塞（即所有的线程都在为其他连接服务），
 *    系统则将新的连接排列在一个队列中，直到下一次调用accept()方法。
 * */
/**
*FixedThreadPool
*1. 通过Exector的newFixedThreadPool静态方法来创建
*2. 线程数量固定的线程池
*3. 只有核心线程切并且不会被回收
*4. 当所有线程都处于活动状态时，新任务都会处于等待状态，直到有线程空闲出来
*/
public class MyServer {

	
	public static void main(String [] args) {
		
		ServerSocket serverSocket = null;
		try {
			//ServerSocket 构造方法的 backlog 参数用来显式设置连接请求队列的长度, 它将覆盖操作系统限定的队列的最大长度. 
			//serverSocket = new ServerSocket(9093,3);

			//服务端在9093端口监听客户端请求的TCP连接 
			 serverSocket = new ServerSocket(9093);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		if(serverSocket == null) {
			return;
		}
		System.out.println("服务器已启动");
	
		//创建大小为3的线程池
		Executor servicePool = Executors.newFixedThreadPool(3);
		
		//循环等待其他的连接请求
		while(true){
			
			System.out.println("等待客户端连接");
			Socket socket = null;
			try {
				
				//调用 accept方法开始监听，等待客户端连接
				socket = serverSocket.accept();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			if(socket!=null) {
				 
				System.out.println("收到客户端连接");
				ServerThread serverThread = new ServerThread(socket);
				//Thread thread = new Thread(serverThread);
				
				//调用execute()开启线程执行池中的任务
				servicePool.execute(new Thread(serverThread));
				
			}
		}
	}
}

