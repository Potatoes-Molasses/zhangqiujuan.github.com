package effort;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/***
 * @project_name insist
 * @Package effort
 * @Title PaySalary.java
 * @Description: 定义支付工资类 
 * @author 张秋娟
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 张秋娟  实现查询工资功能
 *
 */

/****
 * @ClassName:PaySalary
 * @Description:实现支付工资和查询工资记录的功能
 * 			属性:	1.所有经理和员工的工资奖金之和 account 
 * 					2.职工列表 list，存放所有员工，包括员工、经理、股东对象
 * 					
 * 
 * 			方法:	1.发工资pay()
 * 					2.查询某员工的工资记录findRecord()
 * @author 张秋娟
 * @date 2018-10-14
 */
public class PaySalary {
	
	/***
	 * @Fields 除股东外的所有工资支出
	 */
	
	static double account=0;
	
	/***
	 * @Fields 职工列表 存放所有员工，包括员工、经理、股东对象
	 */
	
	static Map<String,Employee>list=new HashMap();
	
	/**   
	 * @Title:pay
	 * @Description:支付工资
	 * @param: income 全年盈利
	 * @return: void
	 * @throws   
	 */  
	
	public void pay(double income){
		
		/*用户指定发哪年哪月的工资*/
		Scanner input=new Scanner(System.in);
		System.out.println("要发哪年哪月的工资？");
		
		/*获取年月*/
		int year=input.nextInt();
		int month=input.nextInt();
		
		/*直接遍历整个职工列表,先给所有员工发工资*/
		for(Map.Entry<String, Employee> entry:list.entrySet()) {
			
			/*判断value是否是Staff类型*/
			if(entry.getValue() instanceof Staff) {
				
				/*强制类型转换成Staff,才可调用子类特有的函数*/
				Staff person=(Staff)entry.getValue();
				
				/*获取员工姓名*/
				String name=entry.getValue().toString();
				
				/*输出职位、姓名，提示用户发工资*/
				System.out.println("【"+entry.getKey()+"】 "+name+" 工资:");
				
				/*获取发的工资金额*/
				double salary=input.nextDouble();
				
				/*设置某年某月的工资到工资记录中*/
				person.setSalary(year,month,salary);
				
				/*将工资加入到工资支出中，有待优化*/
				account+=salary;
			}else {
				/*若当前不是Staff类型，则跳出此次循环，进行下次循环，直到找遍所有Staff*/
				continue;
			}
		}	
		
		/*直接遍历整个职工列表,给所有经理发工资*/
		for(Map.Entry<String, Employee> entry:list.entrySet()) {
			
			/*判断value是否是Manager类型*/
			if(entry.getValue() instanceof Manager) {
				
				/*强制类型转换成Manager,才可调用子类特有的函数*/
				Manager person=(Manager)entry.getValue();
				
				/*获取经理姓名*/
				String name=entry.getValue().toString();
				
				/*输出职位、姓名，提示用户发工资*/
				System.out.println("【"+entry.getKey()+"】 "+name+" 工资和奖金:");
				
				/*获取工资金额和奖金*/
				double salary=input.nextDouble();
				double bonus=input.nextDouble();
				
				/*设置某年某月的工资到工资记录中*/
				person.setSalary(year,month,salary,bonus);
				//person.getSalary(year, month);测试
				
				/*将工资加入到工资支出中，有待优化*/
				account+=bonus+salary;
			}else {
				
				/*若当前不是Manager类型，则跳出此次循环，进行下次循环，直到找遍所有Manager*/
				continue;
			}
		}
		
		/*直接遍历整个职工列表,给所有股东发年底分红*/
		for(Map.Entry<String, Employee> entry:list.entrySet()) {
			
			/*判断value是否是Shareholder类型*/
			if(entry.getValue() instanceof Shareholder) {
				
				/*判断当前月份是否是12月*/
				if(month!=12) {
					
					/*非12月份跳出，没有分红*/
					continue;
					
				}else {
					
					/*12月份，全年盈利减去工资支出算得用于分红的资金*/
					double money=(income-account)*0.1;
					
					/*强制类型转换成Shareholder,才可调用子类特有的函数*/
					Shareholder person=(Shareholder)entry.getValue();
					
					/*获得股东姓名*/
					String name=entry.getValue().toString();
					
					/*获取股东股份*/
					double share=person.getShare();
					
					/*设置某年12月的分红到工资记录中*/
					person.setSalary(year,month,money,share);
					
					System.out.println("【"+entry.getKey()+"】 "+name+" 有年底分红!");
			
				}
			}
		}
		
		
	}
	
	/**   
	 * @Title:findRecord
	 * @Description:查询某职工的工资记录
	 * @return: void
	 * @throws   
	 */  
	
	public void findRecord() {
		
		/*提示用户输入要查询的职工名*/
		Scanner input=new Scanner(System.in);
		System.out.println("\n请输入职工名:");
		
		/*获取职工名*/
		String str=input.next();
		
		/*查找结果状态标志，false表示没找到*/
		boolean status=false;
		
		/*直接遍历整个职工列表*/
		for(Map.Entry<String, Employee> entry:list.entrySet()) {
			
			/*判断输入的职工名是否与某职工对象的姓名相同*/
			if(str.equals(entry.getValue().toString())){
				
				/*若相同，则先置状态标志为true*/
				status=true;
				
				/*输出职工姓名*/
				System.out.print(entry.getValue().toString()+" 发放记录:");
				
				/*获取该职工的工资记录*/
				 Map<String,Double>bill=entry.getValue().getSalaryBill();
				 
				 /*遍历工资记录，输出所有的工资*/
				 for(Map.Entry<String,Double>object:bill.entrySet()) {
					 
					 System.out.print(" "+object.getKey()+" 工资:"+object.getValue()+"  ");
					
				 }
			
			}else {
				/*若当前循环找不到相同姓名的职工对象，则跳出此次，继续下一次循环*/
				 continue;
			}
		
		}
		
		/*最终找不到，则提示信息*/
		if(!status) {
			
			System.out.println("员工名不存在!");
			
		}
	}
	
	
}




