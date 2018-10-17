package effort;

import java.util.Map;
import java.util.Scanner;

/***
 * @project_name insist
 * @Package effort
 * @Title Staff.java
 * @Description: 定义员工类 
 * @author 张秋娟
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 张秋娟  实现增添员工方法的内部细节
 *
 */

/****
 * @ClassName:Staff
 * @Description:定义Employee的子类——员工类的相关属性及方法
 * 			属性:	1.职工号(继承)
 * 					2.姓名(继承)
 * 					3.出生月份(继承)
 * 					4.工资记录(继承)
 * 
 * 			方法:	1.设置工资setSalary()
 * 					2.获得工资getSalary()
 * 					3.获得名字toString()
 * 					4.增加员工，用于员工信息的输入addStaff()				
 * @author 张秋娟
 * @date 2018-10-14
 */

public class Staff extends Employee{
	
	/**   
	 * @Title: Staff 
	 * @Description:构造Staff对象   
	 * @throws   
	 */  
	
	public Staff(){
		
	}
	
	
	/**   
	 * @Title: Staff
	 * @Description:构造Staff对象   
	 * @param: name  姓名
	 * @throws   
	 */  
	
	public Staff(String name) {
		
		/*调用基类构造函数*/
		super(name);
	}
	
	
	/**  
	 * @Title:setSalary 
	 * @Description:  设置某年某月的工资到工资记录中
	 * @param: year   工资的年份
	 * @param: month  工资的月份
	 * @param: salary 工资金额
	 * @return: void 
	 */ 
	
	public void setSalary(int year,int month,double salary) {
		
		/*先判断发工资的月份员工是否过生日*/
		if(super.getbirMonth()==month) {
			
			/*若当月过生日，则发一份生日礼物*/
			System.out.print("生日礼物一份，请查收!\n");
		}
		
		/*调用基类的setSalary方法*/
		super.setSalary(year, month,salary);
		
	}
	
	
	/**  
	 * @Title:getSalary
	 * @Description: 获取某年某月的工资
	 * @param: year  获取的是哪一年的工资
	 * @param: month 获取的是哪一月的工资
	 * @return: void
	 */  
	
	public void  getSalary(int year,int month) {
		
		/*调用基类的getSalary方法*/
		 super.getSalary(year, month);
	}
	
	/**   
	 * @Title:toString
	 * @Description:获取员工姓名
	 * @return: String
	 * @throws   
	 */  
	
	public String toString() {
		
		return super.toString();
	
	}
	
	
	/**   
	 * @Title:addStaff
	 * @Description:增加员工
	 * @param: list 职工列表
	 * @return: void
	 * @throws   
	 */  
	
	public void addStaff(Map<String,Employee>list) {
		
		Scanner input=new Scanner(System.in);
		
		/*从用户那里获取员工数量*/
		System.out.println("请输入普通员工数:");
		int num=input.nextInt();
		
		/*员工数量是否为0*/
		if(num!=0) {
			
			/*情况1.员工数不为0，录入员工信息(id、姓名、生日月份)*/
			System.out.println("请输入普通员工信息(id、姓名、生日月份):");
			for(int i=0;i<num;i++) {
		
				int id=input.nextInt();
				String name=input.next();
				int month=input.nextInt();
				
				/*用获取的信息实例化一个Staff对象*/
				Staff employee=new Staff(name);
				employee.setID(id);
				employee.setbirMonth(month);
	
				/*最后加入职员列表,key是职位加序号，value是员工对象*/
				list.put("员工"+(i+1),employee);
				
			}
		}
	}
}
