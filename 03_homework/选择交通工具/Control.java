package traffic;

import java.util.Scanner;

/*程序简介：
 * 随着飞机的降价和高铁的广泛开通，出行也有很多选择，
 * 请编程实现从出发地到目的地，哪种交通方式最快，费用分别是多少。
 * 程序要求：
 * 1.设计一个抽象类，这个抽象类有两个方法，一个抽象方法计算消耗时间和价格，一个实例方法调用抽象方法输出。
 * 2.该抽象类有交通方式名称、到车站（机场）时间、从车站（机场）返回时间、取票时间、安检时间、 候车时间、
 * 	车速、单价（汽车0.32元/公里，高铁二等座0.45元/公里，飞机0.75元/公里）等属性。
 * 3.分别撰写汽车、高铁、飞机三个实现类，实例化上述抽象类。
 * 4.编写一个总控制类，由用户输入出发地、目的地和距离三个信息，自动计算并输出每一种交通工具所需的时间。
 * 
 * */
/***
 * @project_name insist
 * @Package traffic
 * @Title Control.java
 * @Description: 定义控制类
 * @author 张秋娟
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 张秋娟  
 *
 */


/****
 * @ClassName:Control
 * @Description:用户输入出发地、目的地和距离三个信息，自动计算并输出每一种交通工具所需的时间和费用
 * @author 张秋娟
 * @date 2018-10-20
 */

public class Control {
	
	public static void main(String []args) {
		
		/*新建Car对象，速度为100公里每小时，单价0.32元每公里*/
		Car car=new Car(100,0.32);
		
		/*新建HighSpeedTrain对象，速度为250公里每小时，单价0.45元每公里*/
		HighSpeedTrain highspeedtrain=new HighSpeedTrain(250,0.45);
		
		/*新建Plane对象，速度为870公里每小时，单价0.75元每公里*/
		Plane plane=new Plane(870,0.75);
		
		/*用户输入出发地、目的地、距离*/
		Scanner input=new Scanner(System.in);
		System.out.println("请输入出发地、目的地、距离:");
		
		/*获得出发地、目的地、距离*/
		String from=input.next();
		String destination=input.next();	
		double distance=input.nextDouble();
		
		/*根据距离，计算三种方式所需时间和费用，并显示*/
		car.show(distance);
		highspeedtrain.show(distance);
		plane.show(distance);
	}

}


/*****运行结果******
 请输入出发地、目的地、距离:
 北京 上海 1212
 汽车出行方式耗时13.42 ,  预计花费387.84元!
 高铁出行方式耗时6.15 ,  预计花费545.40元!
飞机出行方式耗时3.09 ,  预计花费909.00元!
*/


/***结果分析***
 *   汽车耗时1212/100+1.3=12.12+1.3=13.42h    费用0.32*1212=387.84 元
 *   高铁耗时1212/250+1.3=4.85+1.3=6.15h      费用0.45*1212=545.4 元
 *  飞机耗时1212/870+1.7=1.39+1.7=3.09h	 费用0.75*1212=909 元
 */