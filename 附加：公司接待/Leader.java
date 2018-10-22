package communication;


/***
 * @project_name insist
 * @Package communication
 * @Title Leader.java
 * @Description: 定义Leader类
 * @author 张秋娟
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 张秋娟  
 *
 */


/****
 * @ClassName:Leader
 * @Description:实现抽象方法eat()、accommodate()、 travel()、giveGift()
 * @author 张秋娟
 * @date 2018-10-20
 */

public class Leader extends AbstractRecption implements SpecialReception{

	/**   
	 * @Title:Leader
	 * @Description:构造Leader对象   
	 * @param: type 访客类型
	 * @throws   
	 */ 
	
	public Leader(String type) {
		
		/*调用基类构造方法，设置访客类型为领导*/
		super(type);
		
		/*规定领导访客一天餐费1500元，旅馆为1000元/晚，报销吃住行的100%*/
		super.setMeals(1500);
		super.setHotel(1000);
		super.setRatio(1);
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
	
	
	/**   
	 * @Title:giveGift
	 * @Description:赠送礼物
	 * @return: void
	 * @throws   
	 */  
	@Override
	public void giveGift() {
		
		System.out.println("领导来访，赠送高级红酒礼盒一份!");
	}

	

	
	
	
}
