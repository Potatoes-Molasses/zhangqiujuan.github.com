package netTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/**
 * @author �����
 * @date 2018-11-24
 *
 */

/**
 * ʵ�ֲ��裺
 * 1���̳߳ط��������ȴ���һ��ServerSocketʵ����
 * 2��Ȼ�󴴽�N���̣߳�ÿ���̷߳���ѭ�����ӣ�����ģ�ServerSocketʵ�����տͻ������ӡ�
 *    ������߳�ͬʱ����һ��ServerSocketʵ����accept()����ʱ�����Ƕ��������ȴ���
 *    ֱ��һ���µ����ӳɹ�������Ȼ��ϵͳѡ��һ���̣߳�Ϊ������������ṩ���������߳�����������ȴ���
 * 3���߳�����ɶ�һ���ͻ��˵ķ���󣬼����ȴ��������������󣬶�����ֹ��
 *    �����һ���ͻ������ӱ�����ʱ��û���߳���accept()�����������������е��̶߳���Ϊ�������ӷ��񣩣�
 *    ϵͳ���µ�����������һ�������У�ֱ����һ�ε���accept()������
 * */
/**
*FixedThreadPool
*1. ͨ��Exector��newFixedThreadPool��̬����������
*2. �߳������̶����̳߳�
*3. ֻ�к����߳��в��Ҳ��ᱻ����
*4. �������̶߳����ڻ״̬ʱ�������񶼻ᴦ�ڵȴ�״̬��ֱ�����߳̿��г���
*/
public class MyServer {

	
	public static void main(String [] args) {
		
		ServerSocket serverSocket = null;
		try {
			//ServerSocket ���췽���� backlog ����������ʽ��������������еĳ���, �������ǲ���ϵͳ�޶��Ķ��е���󳤶�. 
			//serverSocket = new ServerSocket(9093,3);

			//�������9093�˿ڼ����ͻ��������TCP���� 
			 serverSocket = new ServerSocket(9093);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		if(serverSocket == null) {
			return;
		}
		System.out.println("������������");
	
		//������СΪ3���̳߳�
		Executor servicePool = Executors.newFixedThreadPool(3);
		
		//ѭ���ȴ���������������
		while(true){
			
			System.out.println("�ȴ��ͻ�������");
			Socket socket = null;
			try {
				
				//���� accept������ʼ�������ȴ��ͻ�������
				socket = serverSocket.accept();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			if(socket!=null) {
				 
				System.out.println("�յ��ͻ�������");
				ServerThread serverThread = new ServerThread(socket);
				//Thread thread = new Thread(serverThread);
				
				//����execute()�����߳�ִ�г��е�����
				servicePool.execute(new Thread(serverThread));
				
			}
		}
	}
}

