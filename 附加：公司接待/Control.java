package communication;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*程序简介:
 *除了发工资之外，接待也是公司的一项重要支出。
 *接待主要是解决来访人员的吃住两大问题，同时要报销来往车费。
 *接待时按照不同级别，吃住行的报销标准也不一样，需要区别对待。
 *
 *程序要求:
 *1.设计一个接口，含有吃住行三个方法。
 *2.分别编写学生、老师、家长三个实现类，实现上述接口。
 *3.编写一个总控制类，由用户输入出发地、目的地和接待天数三个信息，自动计算并输出每一种类型花费的费用明细和总和。
 *
 *程序扩展:
 *1.有时候我们还需要接待一些高级别的访客，这些访客除了吃住行外，还需要送礼物。
 *2.编写另一个接口，该接口定义一个送礼物的方法。
 *3.编写领导和外宾两个实现类，这两个实现类要实现以上的两个接口，并按照级别不同赠送价值不等的礼物。
 * */


/***
 * @project_name insist
 * @Package communication
 * @Title Control.java
 * @Description: 定义Control类
 * @author 张秋娟
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 张秋娟  
 *
 */


/****
 * @ClassName: Control
 * @Description:由用户输入出发地、目的地和接待天数三个信息，自动计算并输出每一种类型花费的费用明细和总和
 * @author 张秋娟
 * @date 2018-10-20
 */







public class Control {
	
	/***
	 * @Fields 行程列表
	 */
	
	private static Map<String,Double>list=new HashMap();
	
	
	/**   
	 * @Title:add
	 * @Description:添加行程到行程列表中
	 * @return: void
	 * @throws   
	 */  
	
	public void add() {
		
		/*Key 为行程，Value为单程车费*/
		list.put("北京-上海", new Double(553));
		list.put("深圳-上海", new Double(478));
		list.put("重庆-上海", new Double(585));
		list.put("南京-上海", new Double(50));
		list.put("武汉-上海", new Double(320));
		list.put("合肥-上海", new Double(180));

	}
	
	/**   
	 * @Title:getFare
	 * @Description:获取行程的往返车费
	 * @param: from 出发地
	 * @param: destination 目的地
	 * @return: double
	 * @throws   
	 */  
	
	public double getFare(String from,String destination) {
		
		/*根据出发地和目的地，生成Key*/
		String trip=from+"-"+destination;
		double	fare=0;
		
	    /*遍历行程列表，匹配该行程*/
		for(Map.Entry<String, Double> entry:list.entrySet()) {
			
			/*行程匹配，获取往返车费*/
			if(trip.equals(entry.getKey()))
			{ 
			
				fare=entry.getValue()*2;
			}else {
				
			/*不匹配，跳出此次循环，继续匹配*/
				continue;
				
			}
		}
		
		return fare;
	}
	
	public static void main(String []args) {
		
		/*新建control对象*/
		Control control=new Control();
		Scanner input=new Scanner(System.in);
		
		/*提示用户输入，获取用户输入*/
		System.out.println("请输入出发地、目的地、接待天数:");
		String from=input.next();
		String destination=input.next();
		int days=input.nextInt();
		
		/*生成行程列表*/
		control.add();
		
		/*得到往返车费*/
		double fare=control.getFare(from, destination);
		
		/*创建学生对象，设置访问类型为学生*/
		Student student=new Student("学生");
		
		/*创建DecimalFormat对象，用于格式化输出double型变量*/
		DecimalFormat df=new DecimalFormat(".00");
		
		/*计算学生类型的吃住行的报销费用和*/
		double tatal1=student.eat(days)+student.accommodate(days)+student.travel(fare);
		
		System.out.println("\n"+student.getType()+" 报销餐费："+df.format(student.eat(days))+"  报销住宿费："+df.format(student.accommodate(days))+
							" 报销车费："+df.format(student.travel(fare))+" 总计："+df.format(tatal1));
		
		/*创建教师对象，设置访问类型为教师*/
		Teacher teacher=new Teacher("教师");
		
		/*计算教师类型的吃住行的报销费用和*/
		double tatal2=teacher.eat(days)+teacher.accommodate(days)+teacher.travel(fare);
		
		System.out.println(teacher.getType()+" 报销餐费："+df.format(teacher.eat(days))+"  报销住宿费："+df.format(teacher.accommodate(days))+
							" 报销车费："+df.format(teacher.travel(fare))+" 总计："+df.format(tatal2));
		
		/*创建家长对象，设置访问类型为家长*/
		Patriarch patriarch=new Patriarch("家长");
		
		/*计算家长类型的吃住行的报销费用和*/
		double tatal3=patriarch.eat(days)+patriarch.accommodate(days)+patriarch.travel(fare);
		
		System.out.println(patriarch.getType()+" 报销餐费："+df.format(patriarch.eat(days))+"  报销住宿费："+df.format(patriarch.accommodate(days))+
							" 报销车费："+df.format(patriarch.travel(fare))+" 总计："+df.format(tatal3));
		
		System.out.println("\n--------------------------------------------------------------------------\n");
		
		
		/*创建领导对象，设置访问类型为领导*/
		Leader leader=new Leader("领导");
		
		/*计算领导类型的吃住行的报销费用和*/
		double tatal4=leader.eat(days)+leader.accommodate(days)+leader.travel(fare);
		
		System.out.println(leader.getType()+" 报销餐费："+df.format(leader.eat(days))+"  报销住宿费："+df.format(leader.accommodate(days))+
							" 报销车费："+df.format(leader.travel(fare))+" 总计："+df.format(tatal4));
		
		/*给领导分发礼物*/
		leader.giveGift();
		
		/*创建外宾对象，设置访问类型为外宾*/
		Guest guest=new Guest("外宾");
		
		/*计算外宾类型的吃住行的报销费用和*/
		double tatal5=guest.eat(days)+guest.accommodate(days)+guest.travel(fare);
		
		System.out.println(guest.getType()+" 报销餐费："+df.format(guest.eat(days))+"  报销住宿费："+df.format(guest.accommodate(days))+
							" 报销车费："+df.format(guest.travel(fare))+" 总计："+df.format(tatal5));
		/*给外宾分发礼物*/
		guest.giveGift();
	
	}
	
}

/**********************运行结果*****************************
 请输入出发地、目的地、接待天数:
北京 上海 2

学生 报销餐费：100.00  报销住宿费：80.00 报销车费：553.00 总计：733.00
教师 报销餐费：800.00  报销住宿费：480.00 报销车费：884.80 总计：2164.80
家长 报销餐费：420.00  报销住宿费：280.00 报销车费：774.20 总计：1474.20

--------------------------------------------------------------------------

领导 报销餐费：3000.00  报销住宿费：2000.00 报销车费：1106.00 总计：6106.00
领导来访，赠送高级红酒礼盒一份!
外宾 报销餐费：1600.00  报销住宿费：1000.00 报销车费：1106.00 总计：3706.00
外宾来访，赠送本地特产一份！
*/

/*********************结果分析*****************************
 * 北京到上海来回车费共：1106
 * 规定学生访客一天餐费100元，旅馆为80元/晚，报销吃住行的50%
 * 规定教师访客一天餐费500元，旅馆为300元/晚，报销吃住行的80%
 * 规定家长访客一天餐费300元，旅馆为200元/晚，报销吃住行的70%
 * 规定领导访客一天餐费1500元，旅馆为1000元/晚，报销吃住行的100%
 * 规定外宾访客一天餐费800元，旅馆为500元/晚，报销吃住行的100%
 * 
 * 学生：100*2*0.5+80*2*0.5+1106*0.5=733.00
 * 教师：500*2*0.8+300*2*0.8+1106*0.8 =2164.80
 * 家长：300*2*0.7+200*2*0.7+1106*0.7=1474.20
 * 领导：1500*2*1+1000*2*1+1106*1=6106.00
 * 外宾：800*2*1+500*2*1+1106*1=3706.00
 * 
 */






























