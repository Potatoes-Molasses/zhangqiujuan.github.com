package traffic;

import java.text.DecimalFormat;
/***
 * @project_name insist
 * @Package traffic
 * @Title Car.java
 * @Description: 定义汽车类
 * @author 张秋娟
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 张秋娟  
 *
 */

/****
 * @ClassName:Car
 * @Description:实现抽象方法	spend
 * @author 张秋娟
 * @date 2018-10-20
 */


public class Car extends Vehicle{

	/**   
	 * @Title:Car
	 * @Description:构造Car对象   
	 * @param: speed 车速
	 * @param: price 价格
	 * @throws   
	 */  
	
	public Car(double speed,double price) {
		
		/*调用基类构造方法，设置出行方式为汽车*/
		super("汽车", speed, price);
		
		/*根据汽车出行的特点，设置相关属性的值，这些时间总和为1.3h*/
		super.setArriveTime(0.3);	
		super.setBackTime(0.3);
		super.setTicketTime(0.1);
		super.setCheckTime(0.1);
		super.setWaitTime(0.5);
		
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
