package effort;

import java.util.Map;
import java.util.Scanner;

/***
 * @project_name insist
 * @Package effort
 * @Title Shareholder.java
 * @Description: ����ɶ���
 * @author �����
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 �����  ������ӹɶ�����
 *
 */

/****
 * @ClassName:Shareholder
 * @Description:����Shareholder���������Լ�����
 * 			����:	1.ְ����(�̳�)
 * 					2.����(�̳�)
 * 					3.�����·�(�̳�)
 * 					4.���ʼ�¼(�̳�)
 * 					5.�ɷ� share
 * 					6.��׷ֺ�annualBonus
 * 
 * 			����:	1.���ý���setBonus()
 * 					2.��ùɷ�getShare()
 * 					3.���ĳ��ĳ�µĹ��ʵ����ʼ�¼��setSalary()
 *					4.�ӹ��ʼ�¼�л��ĳ��ĳ�µĹ���getSalary()	
 * 					5.���ӹɶ�addShareholder()	
 *					6.��ùɶ�����toString()
 * @author �����
 * @date 2018-10-14
 */

public class  Shareholder extends Employee{
	
	/***
	 * @Fields �ɷ�
	 */
	
	private double share;
		
	/***
	 * @Fields ��׷ֺ�
	 */
	
	private double annualBonus;

	/**   
	 * @Title: Shareholder
	 * @Description:����Shareholder����   
	 * @throws   
	 */  
	
	public Shareholder() {
			
	}
	
	/**   
	 * @Title: Shareholder
	 * @Description:����Shareholder����   
	 * @param: name  ����
	 * @param: share �ɷ�
	 * @throws   
	 */  
	
	
	public Shareholder(String name,double share) {
		
		/*���û���Ĺ��캯��*/
		super(name);
		this.share=share;
		
	}
	
	/**  
	 * @Title:getShare
	 * @Description: ��ȡ�ɷ�
	 * @return: double
	 */
	
	public double getShare() {
		
		return share;
	}
		
	/**  
	 * @Title:setSalary 
	 * @Description:  ����ĳ��ĳ�µĹ���
	 * @param: year   ���ʵ����
	 * @param: month  ���ʵ��·�
	 * @param: money  ���ڷֺ��Ǯ
	 * @param: share  �ɷ�
	 * @return: void 
	 */ 	
	
	public void setSalary(int year,int month,double money,double share) {
		/*�жϵ�ǰ�Ƿ���12��*/
		if(month!=12) {
			
			/*1.��12 �·�û�зֺ�*/	
			super.setSalary(year, month, 0);
		}else {
			
			/*2.���򰴹ɷݷֺ�*/
			super.setSalary(year, month, money*share);
		}
			
	}
	
	/**   
	 * @Title:toString
	 * @Description:��ȡ�ɶ�����
	 * @return: String
	 * @throws   
	 */  
	
	public String toString() {

		return super.toString();
		
	}
		
	/**   
	 * @Title:addShareholder
	 * @Description:���ӹɶ�
	 * @param: list ְ���б�
	 * @return: void
	 * @throws   
	 */  
	
	public void addShareholder(Map<String,Employee>list) {
			
		/*���û������ȡ�ɶ���*/
		Scanner input=new Scanner(System.in);
		System.out.println("������ɶ���:");
		int num=input.nextInt();
		
		/*�ܹɷ�*/
		double totalShare=0;
		
		/*�ɶ�����Ϊ0*/
		if(num!=0) {
			
			/*¼��ɶ���Ϣ(id�������������·ݡ��ɷ�)*/
			System.out.println("������ɶ���Ϣ(id�������������·ݡ��ɷ�):");
			for(int i=0;i<num;i++) {
					
				int id=input.nextInt();
				String name=input.next();
				int month=input.nextInt();
				
				/*������Ч�ɷ�*/
				double share=0;
				
				/*�û�����Ĺɷ�*/
				double temShare=input.nextDouble();
				
				/*�ɷݺͣ������жϹɷ��Ƿ�Ϸ�*/
				totalShare+=temShare;
					
				if(totalShare>1) {
					
					/*�ܹɷ�>1,����¼��*/
					System.out.println("�ɷݲ���������������ùɶ��ɷ�!");
					double newShare=input.nextDouble();
					share=newShare;
					
				}else {
					
					/*�ɷݺ������û�����Ĺɷ�Ϊ������Ч�ɷ�*/
					share=temShare;
				}
				
				/*����õ���Ϣʵ������Shareholder����*/
				Shareholder employee=new Shareholder(name,share);
				employee.setID(id);
				employee.setbirMonth(month);
				
				/*��Shareholder������뵽ְ���б��У�key��ְλ����ţ�value�ǹɶ�����*/
				list.put("�ɶ�"+(i+1),employee);
				
				
			}
		}	
	}
		
	
}
