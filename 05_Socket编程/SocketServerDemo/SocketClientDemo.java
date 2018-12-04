package SocketServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author �����
 * @date 2018.12.2
 */
public class SocketClientDemo {

	public static void  main(String[]args) {
		Socket client=null;
		try {
			client=new Socket("localhost",9090);
			//��һ��ͨѶ
			//д����Ϣ��������
			PrintWriter out=new PrintWriter(client.getOutputStream());
			out.println("Ф�غ������£�Ф�غ�������");
			out.flush();
			
			//��ȡ�ӷ������ش�����Ϣ
			Reader reader=new InputStreamReader(client.getInputStream());
			BufferedReader in=new BufferedReader(reader);
			String serverMessage=in.readLine();
			System.out.println("�������ش�����Ϣ��"+serverMessage);
			
			TimeUnit.SECONDS.sleep(60);
			
			//�ڶ���ͨѶ
			out.println("�����ڲ������·������ȼ��");
			out.flush();
			serverMessage=in.readLine();
			System.out.println("���������ص��ź�Ϊ��"+serverMessage);
			
		}catch(IOException |InterruptedException e) {
			e.printStackTrace();
		}finally {
			try {
				if(client!=null) {
					client.close();
				}
			}catch(IOException e) {	
				e.printStackTrace();
			}
		}
	}
}
