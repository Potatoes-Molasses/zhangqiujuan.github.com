package communication;


/***
 * @project_name insist
 * @Package communication
 * @Title AbstractRecption.java
 * @Description: 定义抽象类
 * @author 张秋娟
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 张秋娟  
 *
 */


/****
 * @ClassName:AbstractRecption
 * @Description:定义抽象类AbstractRecption
 * @author 张秋娟
 * @date 2018-10-20
 */

public abstract class AbstractRecption implements Reception{
	
	/***
	 * @Fields 访客类型
	 */
	
	private String type;
	
	/***
	 * @Fields 一天的餐费   单位：元
	 */
	
	private double meals;
	
	/***
	 * @Fields 旅馆价格  单位：元/晚
	 */
	private double hotel;
	
	/***
	 * @Fields 报销比率 
	 */
	
	private double ratio;
	
	
	/**   
	 * @Title:AbstractRecption
	 * @Description:构造AbstractRecption对象   
	 * @param: type 访客类型
	 * @throws   
	 */  
	
	public AbstractRecption(String type) {
		this.type=type;
	}
	
	/**  
	 * @Title:getMeals
	 * @Description: 获取一天的餐费
	 * @return: double
	 */  
	
	public double getMeals() {
		return meals;
	}
	
	/**  
	 * @Title:setMeals
	 * @Description: 设置一天的餐费
	 * @param: meals 一天的餐费
	 * @return: void 
	 */ 
	
	public void setMeals(double meals) {
		this.meals = meals;
	}
	
	/**  
	 * @Title:getHotel
	 * @Description: 获取旅馆价格
	 * @return: double
	 */  
	
	public double getHotel() {
		return hotel;
	}
	
	/**  
	 * @Title:setHotel
	 * @Description: 设置旅馆价格
	 * @param: hotel 旅馆价格
	 * @return: void 
	 */ 
	
	public void setHotel(double hotel) {
		this.hotel = hotel;
	}
	
	
	/**  
	 * @Title:getRatio
	 * @Description: 获取报销比率 
	 * @return: double
	 */  
	
	public double getRatio() {
		return ratio;
	}
	
	/**  
	 * @Title:setRatio
	 * @Description: 设置报销比率 
	 * @param: ratio 报销比率 
	 * @return: void 
	 */ 
	
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	
	/**  
	 * @Title:getType
	 * @Description: 获取访客类型
	 * @return:String
	 */  
	
	public String getType() {
		return type;
	}
	
	/**  
	 * @Title:setType
	 * @Description: 设置访客类型 
	 * @param: type 访客类型 
	 * @return: void 
	 */ 
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
