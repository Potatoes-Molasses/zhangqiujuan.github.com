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
 * @author �����
 * @date 2018-11-24
 */
public class ServerThread implements Runnable{
	
	private Socket socket;
	
	public ServerThread(Socket socket) {
		//���ÿһ���ͻ������󣬷���һ���˿ڸ���Ӧ���߳�
		this.socket=socket;
	}
	
	@Override
	public void run() {
		System.out.println("�������������߳�������");
		Reader read = null;
		try {
			
			//1.��һ�ν������Կͻ��˵���Ϣ
			read = new InputStreamReader(socket.getInputStream());
			BufferedReader in = new BufferedReader(read);
			String str = in.readLine();
			System.out.println("�ͻ��˴���������Ϊ��"+str);
			
			//2.��һ����ͻ��˷�����Ϣ
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println("������࣬�������Ի��ǵ��ʺ�");
			out.flush();
			
			//3.�ڶ��ν������Կͻ��˵���Ϣ
			str = in.readLine();
			System.out.println("�ͻ��˴���������Ϊ��"+str);
			
			//4.�ڶ�����ͻ��˷�����Ϣ
			out.println("�������Ҫ����");
			out.flush();
		}catch(IOException e) {
			
			e.printStackTrace();
		
		}finally {
			try {
				//�ر���Դ
				socket.close();
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
