package effort;

import java.util.Map;
import java.util.Scanner;

/***
 * @project_name insist
 * @Package effort
 * @Title Staff.java
 * @Description: ����Ա���� 
 * @author �����
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 �����  ʵ������Ա���������ڲ�ϸ��
 *
 */

/****
 * @ClassName:Staff
 * @Description:����Employee�����ࡪ��Ա�����������Լ�����
 * 			����:	1.ְ����(�̳�)
 * 					2.����(�̳�)
 * 					3.�����·�(�̳�)
 * 					4.���ʼ�¼(�̳�)
 * 
 * 			����:	1.���ù���setSalary()
 * 					2.��ù���getSalary()
 * 					3.�������toString()
 * 					4.����Ա��������Ա����Ϣ������addStaff()				
 * @author �����
 * @date 2018-10-14
 */

public class Staff extends Employee{
	
	/**   
	 * @Title: Staff 
	 * @Description:����Staff����   
	 * @throws   
	 */  
	
	public Staff(){
		
	}
	
	
	/**   
	 * @Title: Staff
	 * @Description:����Staff����   
	 * @param: name  ����
	 * @throws   
	 */  
	
	public Staff(String name) {
		
		/*���û��๹�캯��*/
		super(name);
	}
	
	
	/**  
	 * @Title:setSalary 
	 * @Description:  ����ĳ��ĳ�µĹ��ʵ����ʼ�¼��
	 * @param: year   ���ʵ����
	 * @param: month  ���ʵ��·�
	 * @param: salary ���ʽ��
	 * @return: void 
	 */ 
	
	public void setSalary(int year,int month,double salary) {
		
		/*���жϷ����ʵ��·�Ա���Ƿ������*/
		if(super.getbirMonth()==month) {
			
			/*�����¹����գ���һ����������*/
			System.out.print("��������һ�ݣ������!\n");
		}
		
		/*���û����setSalary����*/
		super.setSalary(year, month,salary);
		
	}
	
	
	/**  
	 * @Title:getSalary
	 * @Description: ��ȡĳ��ĳ�µĹ���
	 * @param: year  ��ȡ������һ��Ĺ���
	 * @param: month ��ȡ������һ�µĹ���
	 * @return: void
	 */  
	
	public void  getSalary(int year,int month) {
		
		/*���û����getSalary����*/
		 super.getSalary(year, month);
	}
	
	/**   
	 * @Title:toString
	 * @Description:��ȡԱ������
	 * @return: String
	 * @throws   
	 */  
	
	public String toString() {
		
		return super.toString();
	
	}
	
	
	/**   
	 * @Title:addStaff
	 * @Description:����Ա��
	 * @param: list ְ���б�
	 * @return: void
	 * @throws   
	 */  
	
	public void addStaff(Map<String,Employee>list) {
		
		Scanner input=new Scanner(System.in);
		
		/*���û������ȡԱ������*/
		System.out.println("��������ͨԱ����:");
		int num=input.nextInt();
		
		/*Ա�������Ƿ�Ϊ0*/
		if(num!=0) {
			
			/*���1.Ա������Ϊ0��¼��Ա����Ϣ(id�������������·�)*/
			System.out.println("��������ͨԱ����Ϣ(id�������������·�):");
			for(int i=0;i<num;i++) {
		
				int id=input.nextInt();
				String name=input.next();
				int month=input.nextInt();
				
				/*�û�ȡ����Ϣʵ����һ��Staff����*/
				Staff employee=new Staff(name);
				employee.setID(id);
				employee.setbirMonth(month);
	
				/*������ְԱ�б�,key��ְλ����ţ�value��Ա������*/
				list.put("Ա��"+(i+1),employee);
				
			}
		}
	}
}
