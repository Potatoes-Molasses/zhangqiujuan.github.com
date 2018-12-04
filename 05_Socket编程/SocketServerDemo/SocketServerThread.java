package SocketServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;

/**
 * @author �����
 * @date 2018.12.2
 */
public class SocketServerThread implements Runnable{
	
	//�ͻ��˴򿪵�����
	private Socket socket;
	
	/**
     * ����ͻ��˴򿪵�����
     * @param socket
     */
	public SocketServerThread(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		System.out.println("����ͻ���ҵ���߳�����");
		try {
			//��һ��ͨѶ
			//��ȡ�ӿͻ��˴�������Ϣ
			Reader reader=new InputStreamReader(socket.getInputStream());
			BufferedReader in=new BufferedReader(reader);
			//��ȡһ�пͻ��˴�������Ϣ������
			String clientMessage=in.readLine();
			System.out.println("�ͻ��˴�������Ϣ��"+clientMessage);
			
			//�ش���Ϣ���ͻ���
			PrintWriter out=new PrintWriter(socket.getOutputStream());
			out.println("�������Ի��ǵ��ʺ�");
			out.flush();
			
			//�ڶ���ͨѶ
			clientMessage=in.readLine();
			System.out.println("�ͻ��˴����İ��ţ�"+clientMessage);
			out.println("�������Ҫ����!");
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
