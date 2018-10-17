package effort;

import java.util.Map;
import java.util.Scanner;

/***
 * @project_name insist
 * @Package effort
 * @Title Manager.java
 * @Description: 定义经理类
 * @author 张秋娟
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 张秋娟  完善工资的设置和获取方法
 *
 */

/****
 * @ClassName:Manager
 * @Description:定义Manager类的相关属性及方法
 * 			属性:	1.职工号(继承)
 * 					2.姓名(继承)
 * 					3.出生月份(继承)
 * 					4.工资记录(继承)
 * 					5.奖金bonus
 * 
 * 			方法:	1.设置奖金setBonus()
 * 					2.获得奖金getBonus()
 * 					3.添加某年某月的工资到工资记录中setSalary()
 *					4.从工资记录中获得某年某月的工资getSalary()	
 * 					5.增加经理addManager()	
 *					6.获得职工的姓名toString()
 * @author 张秋娟
 * @date 2018-10-14
 */

public class Manager extends Employee{
	
	/***
	 * @Fields 奖金
	 */
	private double bonus;
		
	
	/**   
	 * @Title: Manager
	 * @Description:构造Manager对象   
	 * @throws   
	 */  
	
	public Manager() {
			
	}
	
	
	/**   
	 * @Title: Manager
	 * @Description:构造Manager对象   
	 * @param: name 姓名
	 * @throws   
	 */  
	
	public Manager(String name) {
		
		/*调用基类构造函数*/	
		super(name);
			
	}
		
	/**  
	 * @Title:setBonus
	 * @Description: 设置奖金
	 * @param: bonus 奖金金额
	 * @return: void
	 */ 
	
	public  void setBonus(double bonus) {
			 
		this.bonus=bonus;
		
	}
	
	/**  
	 * @Title:getBonus
	 * @Description: 获取奖金
	 * @return: double
	 */  
	public double  getBonus() {
				
		return bonus;
		
	}
	
	/**  
	 * @Title:setSalary
	 * @Description: 设置某年某月的工资和奖金到工资记录中
	 * @param: bonus 奖金金额
	 * @return: void
	 */ 
		
	public void setSalary(int year,int month,double salary,double bonus) {
		
		/*判断是否是当月过生日*/
		if(super.getbirMonth()==month) {
			
			/*若是则分发生日礼物*/
			System.out.print("生日礼物一份，请查收!\n");
		}
		
		/*这里将年份月份和奖金作为key,工资作为value,放到工资记录中*/	
		super.getSalaryBill().put((year+"年"+month+"月"+"奖金:"+bonus),new Double(salary));
		
			
			
	}
	
	/**  
	 * @Title:getSalary
	 * @Description: 获取工资记录中某年某月的工资
	 * @param year  年份
	 * @param month 月份
	 * @return: void
	 */  
	public void  getSalary(int year,int month) {
		
		/*调用基类的getSalary*/
		super.getSalary(year, month);
	}
		
	/**   
	 * @Title:toString
	 * @Description:获取经理姓名
	 * @return: String
	 * @throws   
	 */  
	
	public String toString() {
			
		return super.toString();
		
	}
		
	/**   
	 * @Title:addManager
	 * @Description:增加经理
	 * @param: list 职工列表
	 * @return: void
	 * @throws   
	 */  
	
	public void addManager(Map<String,Employee>list) {
		
		/*从用户那里获取经理数*/	
		Scanner input=new Scanner(System.in);
		System.out.println("请输入经理数:");
		int num=input.nextInt();
		
		/*若经理数不为0*/
		if(num!=0) {
			
			/*录入经理信息(id、姓名、生日月份)*/
			System.out.println("请输入经理信息(id、姓名、生日月份):");
			for(int i=0;i<num;i++) {
			
				int id=input.nextInt();
				String name=input.next();
				int month=input.nextInt();
				
				/*把收到的信息实例化Manager对象*/
				Manager manager=new Manager(name);
				manager.setID(id);
				manager.setbirMonth(month);
			
				/*把Manager对象加入到职工列表中，key是职位加序号，value是经理对象*/
				list.put("经理"+(i+1),manager);
				
			}
		}
	}


}
