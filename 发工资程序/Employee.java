package effort;

import java.util.HashMap;
import java.util.Map;


/***
 * @project_name insist
 * @Package effort
 * @Title Employee.java
 * @Description: 定义基类——Employee
 * @author 张秋娟
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 张秋娟  更改工资属性的类型，由double到HashMap
 *
 */

/****
 * @ClassName:Employee
 * @Description:定义Employee类的相关属性及方法
 * 			属性:	1.职工号
 * 					2.姓名
 * 					3.出生月份
 * 					4.工资记录
 * 
 * 			方法:	1.获得工资记录getSalaryBill()
 * 					2.设置职工号setID()
 * 					3.获得职工号getID()
 * 					4.设置出生月份setbirMonth()	
 * 					5.获得出生月份getbirMonth()	
 * 					6.添加某年某月的工资到工资记录中setSalary()
 *					7.从工资记录中获得某年某月的工资getSalary()		
 *					8.获得职工的姓名toString()
 * @author 张秋娟
 * @date 2018-10-14
 */

public class Employee {
	
	/***
	 * @Fields 职工号
	 */
	
	private int id;
	
	/***
	 * @Fields 职工姓名
	 */
	
 	private String name;
 	
 	/***
	 * @Fields 出生月份
	 */
 	
 	private int birMonth;
 	
 	/***
	 * @Fields 工资记录
	 */
 	
 	private Map<String,Double>salarybill=new HashMap();
 	
 	/**   
	 * @Title: Employee 
	 * @Description:构造Employee对象   
	 * @throws   
	 */  
 	
	public Employee() {
		
	 }
	
	/**   
	 * @Title: Employee
	 * @Description:构造Employee对象   
	 * @param: name  姓名
	 * @throws   
	 */  
	
 	public Employee(String name) {
 		
 		this.name=name;
	 
 	}
 	
	/**  
	 * @Title:getSalaryBill
	 * @Description: 获取工资记录
	 * @return: Map<String,Double>
	 */  
 	
 	
 	public  Map<String,Double> getSalaryBill(){
 		
 		return salarybill;
 		
 	}
 	
 	/**  
	 * @Title:setID 
	 * @Description:  设置职工号
	 * @param: id  职工号
	 * @return: void 
	 */ 
 	
 	public  void setID(int id) {
 		
 	    this.id=id;
 	    
 	}
 	
 	/**  
	 * @Title:getID
	 * @Description: 获取职工号
	 * @return: int
	 */  
 	
  	public int  getID() {
  		
 		return id;
 		
 	}
  	
  	/**  
	 * @Title:setbirMonth
	 * @Description: 设置出生月份
	 * @param: birMonth  出生月份
	 * @return: void 
	 */ 
  	
 	public  void setbirMonth(int birMonth) {
 		
	   this.birMonth=birMonth;
	   
	}
 	
 	/**  
	 * @Title:getbirMonth
	 * @Description: 获取出生月份
	 * @return: int
	 */  
 	
 	public int  getbirMonth() {
 		
		return birMonth;
		
	}
	
 	/**  
	 * @Title:setSalary
	 * @Description:  设置工资记录中某年某月的工资
	 * @param: year   年份
	 * @param: month  月份
	 * @param: salary 工资金额
	 * @return: void 
	 */ 
 	
	public  void setSalary(int year,int month,double salary) {
		
		/*年份和月份作为key,工资金额作为value,放入工资记录中*/
		salarybill.put((year+"年"+month+"月"),new Double(salary));
	 
	}

 	/**  
	 * @Title:getSalary
	 * @Description: 获取工资记录中某年某月的工资
	 * @param year  年份
	 * @param month 月份
	 * @return: void
	 */  
	
	public void getSalary(int year,int month) {
		
		/*查找结果状态标志,false 表示找不到*/
		boolean find=false;
		
		/*直接遍历整个工资记录*/
		for(Map.Entry<String,Double>entry:salarybill.entrySet()) {
			
			/*转换成key的格式*/
			String date=year+"年"+month+"月";
			
			/*若工资记录中有当年当月的工资*/
			if(date.equals(entry.getKey())) {
				
				/*输出工资金额，并设标志为 true*/
				System.out.print(entry.getValue());
				find=true;
		
			}else{
				/*若找不到，跳出此次循环，开始下一轮循环*/
				continue;	
			}
		}
		
		/*根据状态标志，提示信息*/
		if(!find) {
			
			System.out.print("无此条工资记录!");
		}
	}
	
	
	/**  
	 * @Title:toString
	 * @Description: 获取职工的姓名
	 * @return: String
	 */ 
	
	public String toString() {
		
		return name;
	}
	
}


