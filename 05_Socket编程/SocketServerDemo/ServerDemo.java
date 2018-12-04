package SocketServerDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 张秋娟
 * @date 2018.12.2
 */
/*1、线程池刚创建时，里面没有一个线程。任务队列是作为参数传进来的。不过，就算队列里面有任务，线程池也不会马上执行它们。
  2、当调用 execute() 方法添加一个任务时，线程池会做如下判断：
    a. 如果正在运行的线程数量小于 corePoolSize，那么马上创建线程运行这个任务；
    b. 如果正在运行的线程数量大于或等于 corePoolSize，那么将这个任务放入队列。
    c. 如果这时候队列满了，而且正在运行的线程数量小于 maximumPoolSize，那么还是要创建线程运行这个任务；
    d. 如果队列满了，而且正在运行的线程数量大于或等于 maximumPoolSize，那么线程池会抛出异常，告诉调用者“我不能再接受任务了”。
  3、当一个线程完成任务时，它会从队列中取下一个任务来执行。
  4、当一个线程无事可做，超过一定的时间（keepAliveTime）时，线程池会判断，如果当前运行的线程数大于 corePoolSize，那么这个线程就被停掉。
 所以线程池的所有任务完成后，它最终会收缩到 corePoolSize 的大小。 
 
【总结】这个过程说明，并不是先加入任务就一定会先执行。假设队列大小为 4，corePoolSize为2，maximumPoolSize为6，那么当加入15个任务时，
执行的顺序类似这样：首先执行任务 1、2，然后任务3~6被放入队列。这时候队列满了，任务7、8、9、10 会被马上执行，而任务 11~15 则会抛出异常。
最终顺序是：1、2、7、8、9、10、3、4、5、6。当然这个过程是针对指定大小的*/


public class ServerDemo {
	
	private static BlockingQueue<Runnable> queue=new ArrayBlockingQueue<Runnable>(4);
	public static void main(String[]args) {
		
		ServerSocket serverSocket=null;
		try {
			serverSocket =new ServerSocket(9090);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		if(serverSocket==null) {
			return;
		}
		System.out.println("服务器打开完成");
		//核心线程数为2，线程池的最大大小为6，队列大小为4，空闲线程结束的超时时间为1天，queue是放任务的队列
		ThreadPoolExecutor executor=new ThreadPoolExecutor(2,6,1,TimeUnit.DAYS,queue);
		while(true) {
			try {
				System.out.println("服务器等待客户端连接！");
				Socket socket=serverSocket.accept();
				SocketServerThread socketThread=new SocketServerThread(socket);
				executor.execute(new Thread(socketThread));
				//new Thread(socketThread).start();
				System.out.println("服务器处理客户端连接完成");
			}catch(IOException e) {
				e.printStackTrace();
			}
			//executor.shutdown();
		}
	}
}
