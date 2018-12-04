package SocketServerDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author �����
 * @date 2018.12.2
 */
/*1���̳߳ظմ���ʱ������û��һ���̡߳������������Ϊ�����������ġ�������������������������̳߳�Ҳ��������ִ�����ǡ�
  2�������� execute() �������һ������ʱ���̳߳ػ��������жϣ�
    a. ����������е��߳�����С�� corePoolSize����ô���ϴ����߳������������
    b. ����������е��߳��������ڻ���� corePoolSize����ô��������������С�
    c. �����ʱ��������ˣ������������е��߳�����С�� maximumPoolSize����ô����Ҫ�����߳������������
    d. ����������ˣ������������е��߳��������ڻ���� maximumPoolSize����ô�̳߳ػ��׳��쳣�����ߵ����ߡ��Ҳ����ٽ��������ˡ���
  3����һ���߳��������ʱ������Ӷ�����ȡ��һ��������ִ�С�
  4����һ���߳����¿���������һ����ʱ�䣨keepAliveTime��ʱ���̳߳ػ��жϣ������ǰ���е��߳������� corePoolSize����ô����߳̾ͱ�ͣ����
 �����̳߳ص�����������ɺ������ջ������� corePoolSize �Ĵ�С�� 
 
���ܽ᡿�������˵�����������ȼ��������һ������ִ�С�������д�СΪ 4��corePoolSizeΪ2��maximumPoolSizeΪ6����ô������15������ʱ��
ִ�е�˳����������������ִ������ 1��2��Ȼ������3~6��������С���ʱ��������ˣ�����7��8��9��10 �ᱻ����ִ�У������� 11~15 ����׳��쳣��
����˳���ǣ�1��2��7��8��9��10��3��4��5��6����Ȼ������������ָ����С��*/


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
		System.out.println("�����������");
		//�����߳���Ϊ2���̳߳ص�����СΪ6�����д�СΪ4�������߳̽����ĳ�ʱʱ��Ϊ1�죬queue�Ƿ�����Ķ���
		ThreadPoolExecutor executor=new ThreadPoolExecutor(2,6,1,TimeUnit.DAYS,queue);
		while(true) {
			try {
				System.out.println("�������ȴ��ͻ������ӣ�");
				Socket socket=serverSocket.accept();
				SocketServerThread socketThread=new SocketServerThread(socket);
				executor.execute(new Thread(socketThread));
				//new Thread(socketThread).start();
				System.out.println("����������ͻ����������");
			}catch(IOException e) {
				e.printStackTrace();
			}
			//executor.shutdown();
		}
	}
}
