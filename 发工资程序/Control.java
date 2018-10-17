package effort;

import java.util.Random;
import java.util.Scanner;

/****
 * 【程序简介】
 * 对于一家公司而言，发工资和各种福利是必须要做的工作，请编程实现这个功能。
 * 【要求】
 * 1.公司有员工、经理、股东三种角色
 * 2.每个角色都有姓名、工资、生日等属性
 * 3.每月15号发工资，普通员工仅发工资，经理除了工资外还有当月奖金
 * 4.公司利润为总营业额（随机运算）减去全年工资支出
 * 5.股东有股份，没有当月奖金，但有年终分红（12月份），年终分红为全年利润的10%，全部股东按照股份分红。
 * 6.全部股东的股份加起来要小于或等于100%
 * 7.每月发工资时，需要给当月过生日的员工和经理发礼物，股东没有礼物。
 * 【实现】
 * 1.员工信息在程序启动时输入
 * 2.将要发的是哪年哪月的工资由用户指定
 * 3.工资信息输出时，按照先员工，再经理，最后股东的顺序输出
 * 【改进】添加两个查询功能
 * 1.允许用户根据用户姓名，查询一个用户所有的工资、奖金和分红发放记录
 * 2.也可以查看所有员工的工资、奖金和分红发放记录
 * @author 张秋娟
 *
 */



/***
 * @project_name insist
 * @Package effort
 * @Title Control.java
 * @Description: 定义Control类
 * @author 张秋娟
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 张秋娟   整理程序，分割功能
 *
 */

/****
 * @ClassName:Control
 * @Description:实现发工资的具体流程		
 * @author 张秋娟
 * @date 2018-10-14
 */


public class Control {
	
	public static void main(String []args) {
		
		/*随机计算总营业额，范围5万-14万*/
		Random random=new Random();
		double income=random.nextInt(10)*10000+50000;
		
		/*输出总营业额*/
		System.out.println("总营业额:"+income);
		Scanner input=new Scanner(System.in);
		
		
		/*完善职工列表*/
		PaySalary pay=new PaySalary();
		
		/*调用子类的空构造函数，前提是基类必有空构造函数*/
		Staff staff=new Staff();
		
		/*增加员工，通过类名调用静态变量*/
		staff.addStaff(PaySalary.list);
		
		System.out.println("-----------------------------------------------------------------");
		
		 /*增加经理*/
		 Manager manager=new Manager();
		 manager.addManager(PaySalary.list);
		 
		System.out.println("-----------------------------------------------------------------");

		/*增加股东*/
		Shareholder shareholder=new Shareholder();
		shareholder.addShareholder(PaySalary.list);
	
		
		/*将所有职工信息写入EmployeeMsg.txt文件，\\是转义字符*/
		WriteTxt txt=new WriteTxt("F:\\Test\\EmployeeMsg.txt",PaySalary.list);
		txt.WriteMsg();
		
		/*将所有职工信息从EmployeeMsg.txt文件中读出*/
		ReadTxt readtxt=new ReadTxt("F:\\Test\\EmployeeMsg.txt");
		
		try {
			readtxt.getMap();
		}catch(Exception e) {
			
		}
		
		System.out.println("-----------------------------------------------------------------");
		/*发两次工资*/
		for(int i=0;i<2;i++) {
			
			pay.pay(income);
			
		}
		
		System.out.println("-----------------------------------------------------------------");
		
		/*将所有职工工资记录写入SalaryRecord.txt文件，\\是转义字符*/
		WriteTxt txt1=new WriteTxt("F:\\Test\\SalaryRecord.txt",PaySalary.list);
		txt1.WriteSalary();
		
		/*将所有职工工资记录从SalaryRecord.txt文件中读出*/
		ReadTxt readtxt1=new ReadTxt("F:\\Test\\SalaryRecord.txt");
		try {
		readtxt1.getMap();
		}catch(Exception e) {
			
		}
		
		/*根据职工的姓名，查询某职工的工资记录*/
		pay.findRecord();
		
	}
}
