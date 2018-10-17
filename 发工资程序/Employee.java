package effort;

import java.util.HashMap;
import java.util.Map;


/***
 * @project_name insist
 * @Package effort
 * @Title Employee.java
 * @Description: ������ࡪ��Employee
 * @author �����
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 �����  ���Ĺ������Ե����ͣ���double��HashMap
 *
 */

/****
 * @ClassName:Employee
 * @Description:����Employee���������Լ�����
 * 			����:	1.ְ����
 * 					2.����
 * 					3.�����·�
 * 					4.���ʼ�¼
 * 
 * 			����:	1.��ù��ʼ�¼getSalaryBill()
 * 					2.����ְ����setID()
 * 					3.���ְ����getID()
 * 					4.���ó����·�setbirMonth()	
 * 					5.��ó����·�getbirMonth()	
 * 					6.���ĳ��ĳ�µĹ��ʵ����ʼ�¼��setSalary()
 *					7.�ӹ��ʼ�¼�л��ĳ��ĳ�µĹ���getSalary()		
 *					8.���ְ��������toString()
 * @author �����
 * @date 2018-10-14
 */

public class Employee {
	
	/***
	 * @Fields ְ����
	 */
	
	private int id;
	
	/***
	 * @Fields ְ������
	 */
	
 	private String name;
 	
 	/***
	 * @Fields �����·�
	 */
 	
 	private int birMonth;
 	
 	/***
	 * @Fields ���ʼ�¼
	 */
 	
 	private Map<String,Double>salarybill=new HashMap();
 	
 	/**   
	 * @Title: Employee 
	 * @Description:����Employee����   
	 * @throws   
	 */  
 	
	public Employee() {
		
	 }
	
	/**   
	 * @Title: Employee
	 * @Description:����Employee����   
	 * @param: name  ����
	 * @throws   
	 */  
	
 	public Employee(String name) {
 		
 		this.name=name;
	 
 	}
 	
	/**  
	 * @Title:getSalaryBill
	 * @Description: ��ȡ���ʼ�¼
	 * @return: Map<String,Double>
	 */  
 	
 	
 	public  Map<String,Double> getSalaryBill(){
 		
 		return salarybill;
 		
 	}
 	
 	/**  
	 * @Title:setID 
	 * @Description:  ����ְ����
	 * @param: id  ְ����
	 * @return: void 
	 */ 
 	
 	public  void setID(int id) {
 		
 	    this.id=id;
 	    
 	}
 	
 	/**  
	 * @Title:getID
	 * @Description: ��ȡְ����
	 * @return: int
	 */  
 	
  	public int  getID() {
  		
 		return id;
 		
 	}
  	
  	/**  
	 * @Title:setbirMonth
	 * @Description: ���ó����·�
	 * @param: birMonth  �����·�
	 * @return: void 
	 */ 
  	
 	public  void setbirMonth(int birMonth) {
 		
	   this.birMonth=birMonth;
	   
	}
 	
 	/**  
	 * @Title:getbirMonth
	 * @Description: ��ȡ�����·�
	 * @return: int
	 */  
 	
 	public int  getbirMonth() {
 		
		return birMonth;
		
	}
	
 	/**  
	 * @Title:setSalary
	 * @Description:  ���ù��ʼ�¼��ĳ��ĳ�µĹ���
	 * @param: year   ���
	 * @param: month  �·�
	 * @param: salary ���ʽ��
	 * @return: void 
	 */ 
 	
	public  void setSalary(int year,int month,double salary) {
		
		/*��ݺ��·���Ϊkey,���ʽ����Ϊvalue,���빤�ʼ�¼��*/
		salarybill.put((year+"��"+month+"��"),new Double(salary));
	 
	}

 	/**  
	 * @Title:getSalary
	 * @Description: ��ȡ���ʼ�¼��ĳ��ĳ�µĹ���
	 * @param year  ���
	 * @param month �·�
	 * @return: void
	 */  
	
	public void getSalary(int year,int month) {
		
		/*���ҽ��״̬��־,false ��ʾ�Ҳ���*/
		boolean find=false;
		
		/*ֱ�ӱ����������ʼ�¼*/
		for(Map.Entry<String,Double>entry:salarybill.entrySet()) {
			
			/*ת����key�ĸ�ʽ*/
			String date=year+"��"+month+"��";
			
			/*�����ʼ�¼���е��굱�µĹ���*/
			if(date.equals(entry.getKey())) {
				
				/*������ʽ������־Ϊ true*/
				System.out.print(entry.getValue());
				find=true;
		
			}else{
				/*���Ҳ����������˴�ѭ������ʼ��һ��ѭ��*/
				continue;	
			}
		}
		
		/*����״̬��־����ʾ��Ϣ*/
		if(!find) {
			
			System.out.print("�޴������ʼ�¼!");
		}
	}
	
	
	/**  
	 * @Title:toString
	 * @Description: ��ȡְ��������
	 * @return: String
	 */ 
	
	public String toString() {
		
		return name;
	}
	
}


