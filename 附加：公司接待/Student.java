package communication;


/***
 * @project_name insist
 * @Package communication
 * @Title Student.java
 * @Description: 定义Student类
 * @author 张秋娟
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 张秋娟  
 *
 */


/****
 * @ClassName:Student
 * @Description:实现抽象方法eat()、accommodate()和 travel()
 * @author 张秋娟
 * @date 2018-10-20
 */


public class Student extends AbstractRecption{
	
	/**   
	 * @Title:Student
	 * @Description:构造Student对象   
	 * @param: type 访客类型
	 * @throws   
	 */ 
	public Student(String type) {
		/*调用基类构造方法，设置访客类型为学生*/
		super(type);
		
		/*规定学生访客一天餐费100元，旅馆为80元/晚，报销吃住行的50%*/
		super.setMeals(100);
		super.setHotel(80);
		super.setRatio(0.5);
		
	}

	/**   
	 * @Title:eat
	 * @Description:计算报销的总餐费
	 * @param: days 接待天数
	 * @return: double
	 * @throws   
	 */  

	@Override
	public double eat(int days) {
		
		/*报销的总餐费=一天餐费*天数*报销比*/
		double money=super.getMeals()*days*super.getRatio();
		return money;
		
	}
	
	/**   
	 * @Title:accommodate
	 * @Description:计算报销的总住宿费
	 * @param: days 接待天数
	 * @return: double
	 * @throws   
	 */  

	@Override
	public double accommodate(int days) {
		
		/*报销的总住宿费=一天的住宿费*天数*报销比*/
		double money=super.getHotel()*days*super.getRatio();
		return money;
	}

	
	/**   
	 * @Title:travel
	 * @Description:计算报销的总路费，包括来回
	 * @param: fare 往返车费
	 * @return: double
	 * @throws   
	 */  
	@Override
	public double travel(double fare) {
		
		/*报销的总路费=来回路费*报销比*/
		return super.getRatio()*fare;
		
	}


}
