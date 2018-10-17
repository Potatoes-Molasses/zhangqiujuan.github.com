package effort;

import java.util.Map;
import java.util.Scanner;

/***
 * @project_name insist
 * @Package effort
 * @Title Manager.java
 * @Description: ���徭����
 * @author �����
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 �����  ���ƹ��ʵ����úͻ�ȡ����
 *
 */

/****
 * @ClassName:Manager
 * @Description:����Manager���������Լ�����
 * 			����:	1.ְ����(�̳�)
 * 					2.����(�̳�)
 * 					3.�����·�(�̳�)
 * 					4.���ʼ�¼(�̳�)
 * 					5.����bonus
 * 
 * 			����:	1.���ý���setBonus()
 * 					2.��ý���getBonus()
 * 					3.���ĳ��ĳ�µĹ��ʵ����ʼ�¼��setSalary()
 *					4.�ӹ��ʼ�¼�л��ĳ��ĳ�µĹ���getSalary()	
 * 					5.���Ӿ���addManager()	
 *					6.���ְ��������toString()
 * @author �����
 * @date 2018-10-14
 */

public class Manager extends Employee{
	
	/***
	 * @Fields ����
	 */
	private double bonus;
		
	
	/**   
	 * @Title: Manager
	 * @Description:����Manager����   
	 * @throws   
	 */  
	
	public Manager() {
			
	}
	
	
	/**   
	 * @Title: Manager
	 * @Description:����Manager����   
	 * @param: name ����
	 * @throws   
	 */  
	
	public Manager(String name) {
		
		/*���û��๹�캯��*/	
		super(name);
			
	}
		
	/**  
	 * @Title:setBonus
	 * @Description: ���ý���
	 * @param: bonus ������
	 * @return: void
	 */ 
	
	public  void setBonus(double bonus) {
			 
		this.bonus=bonus;
		
	}
	
	/**  
	 * @Title:getBonus
	 * @Description: ��ȡ����
	 * @return: double
	 */  
	public double  getBonus() {
				
		return bonus;
		
	}
	
	/**  
	 * @Title:setSalary
	 * @Description: ����ĳ��ĳ�µĹ��ʺͽ��𵽹��ʼ�¼��
	 * @param: bonus ������
	 * @return: void
	 */ 
		
	public void setSalary(int year,int month,double salary,double bonus) {
		
		/*�ж��Ƿ��ǵ��¹�����*/
		if(super.getbirMonth()==month) {
			
			/*������ַ���������*/
			System.out.print("��������һ�ݣ������!\n");
		}
		
		/*���ｫ����·ݺͽ�����Ϊkey,������Ϊvalue,�ŵ����ʼ�¼��*/	
		super.getSalaryBill().put((year+"��"+month+"��"+"����:"+bonus),new Double(salary));
		
			
			
	}
	
	/**  
	 * @Title:getSalary
	 * @Description: ��ȡ���ʼ�¼��ĳ��ĳ�µĹ���
	 * @param year  ���
	 * @param month �·�
	 * @return: void
	 */  
	public void  getSalary(int year,int month) {
		
		/*���û����getSalary*/
		super.getSalary(year, month);
	}
		
	/**   
	 * @Title:toString
	 * @Description:��ȡ��������
	 * @return: String
	 * @throws   
	 */  
	
	public String toString() {
			
		return super.toString();
		
	}
		
	/**   
	 * @Title:addManager
	 * @Description:���Ӿ���
	 * @param: list ְ���б�
	 * @return: void
	 * @throws   
	 */  
	
	public void addManager(Map<String,Employee>list) {
		
		/*���û������ȡ������*/	
		Scanner input=new Scanner(System.in);
		System.out.println("�����뾭����:");
		int num=input.nextInt();
		
		/*����������Ϊ0*/
		if(num!=0) {
			
			/*¼�뾭����Ϣ(id�������������·�)*/
			System.out.println("�����뾭����Ϣ(id�������������·�):");
			for(int i=0;i<num;i++) {
			
				int id=input.nextInt();
				String name=input.next();
				int month=input.nextInt();
				
				/*���յ�����Ϣʵ����Manager����*/
				Manager manager=new Manager(name);
				manager.setID(id);
				manager.setbirMonth(month);
			
				/*��Manager������뵽ְ���б��У�key��ְλ����ţ�value�Ǿ������*/
				list.put("����"+(i+1),manager);
				
			}
		}
	}


}
