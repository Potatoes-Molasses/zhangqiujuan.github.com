package netTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;


/**
 * @author �����
 * @date 2018-11-24
 *
 */
public class MyClient {
	
	public static void main(String [] args) throws UnknownHostException, IOException, InterruptedException {
		 
		// 1.���� socket ָ����������ַ�Ͷ˿�
		Socket client=new Socket("localhost",9093);
		
		// 2.�ͻ��˵�һ���������������Ϣ
		PrintWriter out = new PrintWriter(client.getOutputStream());
		out.println("Ф�غ������£�Ф�غ�������");
		out.flush();
		
		//3.�ͻ��˵�һ�ν������Է���������Ϣ
		Reader read=new InputStreamReader(client.getInputStream());
		BufferedReader in = new BufferedReader(read);
		String str = in.readLine();
		System.out.println("���������ص�����Ϊ��"+str);
		
		TimeUnit.SECONDS.sleep(60);
		
		//4.�ͻ��˵ڶ����������������Ϣ
		out.println("�����ڲ������·������ȼ��");
		out.flush();
		
		//5.�ͻ��˵ڶ��ν������Է���������Ϣ
		str = in.readLine();
		System.out.println("���������ص�����Ϊ��"+str);
		client.close();
		
	}
}
