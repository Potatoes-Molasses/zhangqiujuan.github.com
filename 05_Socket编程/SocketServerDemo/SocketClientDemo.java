package SocketServerDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @author 张秋娟
 * @date 2018.12.2
 */
public class SocketClientDemo {

	public static void  main(String[]args) {
		Socket client=null;
		try {
			client=new Socket("localhost",9090);
			//第一次通讯
			//写入信息给服务器
			PrintWriter out=new PrintWriter(client.getOutputStream());
			out.println("肖特呼唤康德，肖特呼唤康德");
			out.flush();
			
			//获取从服务器回传的信息
			Reader reader=new InputStreamReader(client.getInputStream());
			BufferedReader in=new BufferedReader(reader);
			String serverMessage=in.readLine();
			System.out.println("服务器回传的信息："+serverMessage);
			
			TimeUnit.SECONDS.sleep(60);
			
			//第二次通讯
			out.println("空气在颤抖，仿佛天空在燃烧");
			out.flush();
			serverMessage=in.readLine();
			System.out.println("服务器返回的信号为："+serverMessage);
			
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
