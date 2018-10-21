package traffic;

import java.text.DecimalFormat;


/***
 * @project_name insist
 * @Package traffic
 * @Title Plane.java
 * @Description: 定义飞机类
 * @author 张秋娟
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 张秋娟  
 *
 */


/****
 * @ClassName:Plane
 * @Description:实现抽象方法	spend
 * @author 张秋娟
 * @date 2018-10-20
 */



public class Plane extends Vehicle{

	/**   
	 * @Title:Plane
	 * @Description:构造Plane对象   
	 * @param: speed 车速
	 * @param: price 价格
	 * @throws   
	 */  
	
	public Plane(double speed,double price) {
		
		/*调用基类构造方法，设置出行方式为飞机*/
		super("飞机", speed, price);
		
		/*根据飞机出行的特点，设置相关属性的值，这些时间总和为1.7h*/
		super.setArriveTime(0.5);
		super.setBackTime(0.5);
		super.setCheckTime(0.1);
		super.setWaitTime(0.5);
		super.setTicketTime(0.1);
	}

	
	
	/**   
	 * @Title:spend
	 * @Description:计算消耗的时间和费用
	 * @param: distance 距离 单位公里
	 * @return: void
	 * @throws   
	 */  
	@Override
	public void spend(double distance) {
		
		/*求所有时间的总和*/
		double totalTime=distance/super.getSpeed()+super.getArriveTime()+super.getBackTime()
						  +super.getCheckTime()+super.getWaitTime()+super.getTicketTime();
		
		/*求总费用，总费用=单价*距离*/
		double payMoney=distance*super.getPrice();
		
		/*创建DecimalFormat对象，用于格式化输出double型的耗时和费用*/
		DecimalFormat df=new DecimalFormat(".00");
		
		System.out.println(super.getStyle()+"出行方式耗时"+df.format(totalTime)+" ,  预计花费"+df.format(payMoney)+"元!");
	}
	

}
