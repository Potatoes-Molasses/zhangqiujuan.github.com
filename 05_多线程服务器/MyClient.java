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
 * @author 张秋娟
 * @date 2018-11-24
 *
 */
public class MyClient {
	
	public static void main(String [] args) throws UnknownHostException, IOException, InterruptedException {
		 
		// 1.创建 socket 指定服务器地址和端口
		Socket client=new Socket("localhost",9093);
		
		// 2.客户端第一次向服务器发送信息
		PrintWriter out = new PrintWriter(client.getOutputStream());
		out.println("肖特呼唤康德，肖特呼唤康德");
		out.flush();
		
		//3.客户端第一次接收来自服务器的信息
		Reader read=new InputStreamReader(client.getInputStream());
		BufferedReader in = new BufferedReader(read);
		String str = in.readLine();
		System.out.println("服务器返回的内容为："+str);
		
		TimeUnit.SECONDS.sleep(60);
		
		//4.客户端第二次向服务器发送信息
		out.println("空气在颤抖，仿佛天空在燃烧");
		out.flush();
		
		//5.客户端第二次接收来自服务器的信息
		str = in.readLine();
		System.out.println("服务器返回的内容为："+str);
		client.close();
		
	}
}
