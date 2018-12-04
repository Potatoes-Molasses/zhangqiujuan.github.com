package socketFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author �����
 * @date 2018.12.3
 */
public class ServerThread implements Runnable{
	private Socket socket;
	
	public ServerThread(Socket socket) {
		this.socket=socket;
	}

	@Override
	public void run() {
		System.out.println("�����������߳��ѿ���");
		try {
			//�õ����׽������������������
			Reader reader=new InputStreamReader(socket.getInputStream());
			BufferedReader in =new BufferedReader(reader);
			
			//�԰��ţ���ֹ����������򹥻�
			String message=in.readLine();
			if(!"�����ǵػ�".equals(message)) {
				return;
			}
			
			System.out.println("���������ŶԽӳɹ�");
			
			//���մ�����ı�����
			List<String>context=getFile(in);
			System.out.println("�������ļ��������");
			//�ͻ���ָ�����ļ���
			String filename=in.readLine();
			System.out.println("�������ļ�ȫ���������");
			
			//����ļ��ľ���·��
			String FullPath=socketFileServer.PATH+filename;
			boolean flag=false;
			for(String str:context) {
				 flag=FileUtil.writeLog(FullPath,str);
			}
			//�õ����׽������������������
			PrintWriter writer=new PrintWriter(socket.getOutputStream());
			if(flag) {
				writer.println("�ļ�����ɹ�");
			}else {
				writer.println("�ļ�����ʧ��");
			}
			writer.flush();
		
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
	
	/***
	 * 
	 * @param in ���ڶ��ͻ��˷����ַ����ļ�������
	 * @return  �ͻ��˷��������ַ���list����
	 * @throws IOException
	 */
	private List<String>getFile(BufferedReader in)throws IOException{
		List<String>context=new ArrayList();
		while(true) {
			String tempStr=in.readLine();
			//������յ�"endendend"�ַ���,��˵���ļ����ݴ������
			if("endendend".equals(tempStr)) {
				break;
			}
			context.add(tempStr);
		}
		return context;
	}
}
