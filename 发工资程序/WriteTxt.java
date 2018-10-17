package effort;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/***
 * @project_name insist
 * @Package effort
 * @Title  WriteTxt.java
 * @Description: ����WriteTxt�� 
 * @author �����
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 �����  ��дְ����Ϣ������д���ʼ�¼�ķ������뿪��
 *
 */

/****
 * @ClassName: WriteTxt
 * @Description:���� WriteTxt���������Լ�����
 * 			����:	1.�ļ�·��path
 *					2.ְ���б�list
 * 
 * 			����:	1.���ù���setSalary()
 * 					2.��ù���getSalary()
 * 					3.�������toString()
 * 					4.����Ա��������Ա����Ϣ������addStaff()				
 * @author �����
 * @date 2018-10-14
 */
public class WriteTxt {

	/***
	 * @Fields �ļ����·��
	 */
	
	String path;
	

	/***
	 * @Fields ְ���б����ڴ��Ա���������ɶ�����
	 */
	
	 Map<String,Employee>list=new HashMap();
	 

	/**   
	* @Title: WriteTxt
	 * @Description:����WriteTxt����   
	 * @param: path �ļ�·��
	 * @param: list ְ���б�
	 * @throws   
	 */  
		 
	public WriteTxt(String path , Map list) {
		
		this.path = path;
		this.list = list;
		
	}
	
	/**   
	 * @Title:newTxt
	 * @Description:�½�.txt�ļ�
	 * @return: void
	 * @throws   
	 */  
	public  void newTxt()throws Exception{
		
		/*ʵ����һ��File����*/
		File file = new File(path);
		
		/*������ļ�����*/
		if(file.exists()) {
			
			/*file.mkdir()����ָ��·����Ŀ¼�������·�������ڣ��ᴴ��ʧ�ܱ���*/
			/*file.mkdirs()�Զ����������ڵĸ�·��*/
			file.mkdirs();
		}
		
	}
	
	
	
	/**   
	 * @Title:WriteSalary
	 * @Description:����Ա�����پ�����ɶ���˳�򽫹��ʼ�¼д��.txt�ļ�
	 * @return: boolean
	 * @throws   
	 */  
	
	public boolean WriteSalary() {
		try {
			
			/*���½���һ��.txt�ļ�*/
			newTxt(); 
 
			/*����FileWriter���󣬲�ʵ����fw*/
			FileWriter fw=new FileWriter(path);
			
			/*ֱ�ӱ�������ְ���б�,��д����Ա���Ĺ��ʼ�¼*/
			for(Map.Entry<String, Employee> entry:list.entrySet()) {
				
				/*�ж�value�Ƿ���Staff����*/
				if(entry.getValue() instanceof Staff) {
					
					/*ǿ������ת����Staff,�ſɵ����������еĺ���*/
					Staff person=(Staff)entry.getValue();
					
					/*���ļ�д��ְλ������*/
					fw.write("��"+entry.getKey()+"�� "+person.toString()+" ���ż�¼:");
					
					/*��ȡ���ʼ�¼*/
					 Map<String,Double>bill=person.getSalaryBill();
					 
					 /*�������ʼ�¼��д���ļ���*/
					 for(Map.Entry<String,Double>object:bill.entrySet()) {
						 
						 /*д�����º͹��ʽ��*/
						 fw.write(" "+object.getKey()+" ����:"+object.getValue()+"  ");
							
					 }
					 
					 fw.write("\n");
				}else {
					
					/*����ǰ����Staff���ͣ��������˴�ѭ���������´�ѭ����ֱ���ұ�����Staff*/
					continue;
				}
			}
			
			/*ֱ�ӱ�������ְ���б�,д���о���Ĺ��ʼ�¼*/
			for(Map.Entry<String, Employee> entry:list.entrySet()) {
				
				/*�ж�value�Ƿ���Manager����*/
				if(entry.getValue() instanceof Manager) {
					
					/*ǿ������ת����Manager,�ſɵ����������еĺ���*/
					Manager person=(Manager)entry.getValue();
					
					/*д��ְλ������*/
					fw.write("��"+entry.getKey()+"�� "+person.toString()+" ���ż�¼:");
					
					/*��ȡ���ʼ�¼*/
					 Map<String,Double>bill=person.getSalaryBill();
					 
					 /*�������ʼ�¼��д���ļ���*/
					 for(Map.Entry<String,Double>object:bill.entrySet()) {
						 
						 /*д�����¡�����͹��ʽ��*/
						 fw.write(" "+object.getKey()+" ����:"+object.getValue()+"  ");
							
					 }
					 
					 fw.write("\n");
				}else {
					
					/*����ǰ����Manager���ͣ��������˴�ѭ���������´�ѭ����ֱ���ұ�����Manager*/
					continue;
				
				}
			}
			
			/*ֱ�ӱ�������ְ���б�,д���йɶ��ķֺ��¼*/
			for(Map.Entry<String, Employee> entry:list.entrySet()) {
				
				/*�ж�value�Ƿ���Shareholder����*/
				if(entry.getValue() instanceof Shareholder) {
					
					/*ǿ������ת����Shareholder,�ſɵ����������еĺ���*/
					Shareholder person=(Shareholder)entry.getValue();
					
					/*д��ְλ������*/
					fw.write("��"+entry.getKey()+"�� "+person.toString()+" ���ż�¼:");
					
					/*��ȡ���ʼ�¼*/
					 Map<String,Double>bill=person.getSalaryBill();
					 
					 /*�������ʼ�¼��д���ļ���*/
					 for(Map.Entry<String,Double>object:bill.entrySet()) {
						 
						 /*д�����ºͷֺ�*/
						 fw.write(" "+object.getKey()+" �ֺ�:"+object.getValue()+"  ");
							
					 }
					 
					 fw.write("\n");
				}
			}

			fw.close();
			
		} catch (Exception e) {
			
			/*��ӡ�쳣*/
			e.printStackTrace();
			return false;

		}
		return true;
	}

	
	/**   
	 * @Title:WriteMsg
	 * @Description:��ְ����Ϣд��.txt�ļ�
	 * @return: boolean
	 * @throws   
	 */  
	
	
	public boolean WriteMsg() {
		try {
			
			/*���½���һ��txt�ļ�*/
			newTxt(); //
 
			/*����FileWriter���󣬲�ʵ����fw*/
			FileWriter fw=new FileWriter(path);
			
			/*ֱ�ӱ�������ְ���б�,д������ְ������Ϣ*/
			for(Map.Entry<String, Employee> entry:list.entrySet()) {
				
				/*��ȡְ��������*/
				String name=entry.getValue().toString();
				
				/*��ȡְ����*/
				int id=entry.getValue().getID();
				
				/*��ȡ�����·�*/
				int month=entry.getValue().getbirMonth();
				
				/*�жϵ�ǰ�����Ƿ��ǹɶ�����*/
				if(entry.getValue() instanceof Shareholder) {
					
					/*ǿ������װ��������Shareholder���еķ���*/
					Shareholder person=(Shareholder)entry.getValue();
					
					/*��ȡ�ɶ��Ĺɷ�*/
					double share=person.getShare();
					
					/*���ǹɶ����ͣ���д��������ְ���š������·ݺ͹ɷ�*/
					fw.write("��"+entry.getKey()+"�� "+name+" ְ����:"+id+" �����·�:"+month+"�ɷ�:"+share+"\n");
				}else {
					/*�����ǹɶ����ͣ���д��������ְ���š������·�*/
					fw.write("��"+entry.getKey()+"�� "+name+" ְ����:"+id+" �����·�:"+month+"\n");//д���ļ�����;
				}
			}

			fw.close();
			
		} catch (Exception e) {
			
			/*��ӡ�쳣*/
			e.printStackTrace();
			return false;

		}
		
		return true;
		
	}
	
}


