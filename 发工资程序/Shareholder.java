package effort;

import java.util.Map;
import java.util.Scanner;

/***
 * @project_name insist
 * @Package effort
 * @Title Shareholder.java
 * @Description: 定义股东类
 * @author 张秋娟
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 张秋娟  完善添加股东方法
 *
 */

/****
 * @ClassName:Shareholder
 * @Description:定义Shareholder类的相关属性及方法
 * 			属性:	1.职工号(继承)
 * 					2.姓名(继承)
 * 					3.出生月份(继承)
 * 					4.工资记录(继承)
 * 					5.股份 share
 * 					6.年底分红annualBonus
 * 
 * 			方法:	1.设置奖金setBonus()
 * 					2.获得股份getShare()
 * 					3.添加某年某月的工资到工资记录中setSalary()
 *					4.从工资记录中获得某年某月的工资getSalary()	
 * 					5.增加股东addShareholder()	
 *					6.获得股东姓名toString()
 * @author 张秋娟
 * @date 2018-10-14
 */

public class  Shareholder extends Employee{
	
	/***
	 * @Fields 股份
	 */
	
	private double share;
		
	/***
	 * @Fields 年底分红
	 */
	
	private double annualBonus;

	/**   
	 * @Title: Shareholder
	 * @Description:构造Shareholder对象   
	 * @throws   
	 */  
	
	public Shareholder() {
			
	}
	
	/**   
	 * @Title: Shareholder
	 * @Description:构造Shareholder对象   
	 * @param: name  姓名
	 * @param: share 股份
	 * @throws   
	 */  
	
	
	public Shareholder(String name,double share) {
		
		/*调用基类的构造函数*/
		super(name);
		this.share=share;
		
	}
	
	/**  
	 * @Title:getShare
	 * @Description: 获取股份
	 * @return: double
	 */
	
	public double getShare() {
		
		return share;
	}
		
	/**  
	 * @Title:setSalary 
	 * @Description:  设置某年某月的工资
	 * @param: year   工资的年份
	 * @param: month  工资的月份
	 * @param: money  用于分红的钱
	 * @param: share  股份
	 * @return: void 
	 */ 	
	
	public void setSalary(int year,int month,double money,double share) {
		/*判断当前是否是12月*/
		if(month!=12) {
			
			/*1.非12 月份没有分红*/	
			super.setSalary(year, month, 0);
		}else {
			
			/*2.否则按股份分红*/
			super.setSalary(year, month, money*share);
		}
			
	}
	
	/**   
	 * @Title:toString
	 * @Description:获取股东姓名
	 * @return: String
	 * @throws   
	 */  
	
	public String toString() {

		return super.toString();
		
	}
		
	/**   
	 * @Title:addShareholder
	 * @Description:增加股东
	 * @param: list 职工列表
	 * @return: void
	 * @throws   
	 */  
	
	public void addShareholder(Map<String,Employee>list) {
			
		/*从用户那里获取股东数*/
		Scanner input=new Scanner(System.in);
		System.out.println("请输入股东数:");
		int num=input.nextInt();
		
		/*总股份*/
		double totalShare=0;
		
		/*股东数不为0*/
		if(num!=0) {
			
			/*录入股东信息(id、姓名、生日月份、股份)*/
			System.out.println("请输入股东信息(id、姓名、生日月份、股份):");
			for(int i=0;i<num;i++) {
					
				int id=input.nextInt();
				String name=input.next();
				int month=input.nextInt();
				
				/*最终有效股份*/
				double share=0;
				
				/*用户输入的股份*/
				double temShare=input.nextDouble();
				
				/*股份和，用来判断股份是否合法*/
				totalShare+=temShare;
					
				if(totalShare>1) {
					
					/*总股份>1,重新录入*/
					System.out.println("股份不合理，请重新输入该股东股份!");
					double newShare=input.nextDouble();
					share=newShare;
					
				}else {
					
					/*股份合理，则用户输入的股份为最终有效股份*/
					share=temShare;
				}
				
				/*将获得的信息实例化成Shareholder对象*/
				Shareholder employee=new Shareholder(name,share);
				employee.setID(id);
				employee.setbirMonth(month);
				
				/*将Shareholder对象加入到职工列表中，key是职位加序号，value是股东对象*/
				list.put("股东"+(i+1),employee);
				
				
			}
		}	
	}
		
	
}
