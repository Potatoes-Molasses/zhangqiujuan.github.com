package communication;


/***
 * @project_name insist
 * @Package communication
 * @Title AbstractRecption.java
 * @Description: ���������
 * @author �����
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 �����  
 *
 */


/****
 * @ClassName:AbstractRecption
 * @Description:���������AbstractRecption
 * @author �����
 * @date 2018-10-20
 */

public abstract class AbstractRecption implements Reception{
	
	/***
	 * @Fields �ÿ�����
	 */
	
	private String type;
	
	/***
	 * @Fields һ��Ĳͷ�   ��λ��Ԫ
	 */
	
	private double meals;
	
	/***
	 * @Fields �ùݼ۸�  ��λ��Ԫ/��
	 */
	private double hotel;
	
	/***
	 * @Fields �������� 
	 */
	
	private double ratio;
	
	
	/**   
	 * @Title:AbstractRecption
	 * @Description:����AbstractRecption����   
	 * @param: type �ÿ�����
	 * @throws   
	 */  
	
	public AbstractRecption(String type) {
		this.type=type;
	}
	
	/**  
	 * @Title:getMeals
	 * @Description: ��ȡһ��Ĳͷ�
	 * @return: double
	 */  
	
	public double getMeals() {
		return meals;
	}
	
	/**  
	 * @Title:setMeals
	 * @Description: ����һ��Ĳͷ�
	 * @param: meals һ��Ĳͷ�
	 * @return: void 
	 */ 
	
	public void setMeals(double meals) {
		this.meals = meals;
	}
	
	/**  
	 * @Title:getHotel
	 * @Description: ��ȡ�ùݼ۸�
	 * @return: double
	 */  
	
	public double getHotel() {
		return hotel;
	}
	
	/**  
	 * @Title:setHotel
	 * @Description: �����ùݼ۸�
	 * @param: hotel �ùݼ۸�
	 * @return: void 
	 */ 
	
	public void setHotel(double hotel) {
		this.hotel = hotel;
	}
	
	
	/**  
	 * @Title:getRatio
	 * @Description: ��ȡ�������� 
	 * @return: double
	 */  
	
	public double getRatio() {
		return ratio;
	}
	
	/**  
	 * @Title:setRatio
	 * @Description: ���ñ������� 
	 * @param: ratio �������� 
	 * @return: void 
	 */ 
	
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	
	/**  
	 * @Title:getType
	 * @Description: ��ȡ�ÿ�����
	 * @return:String
	 */  
	
	public String getType() {
		return type;
	}
	
	/**  
	 * @Title:setType
	 * @Description: ���÷ÿ����� 
	 * @param: type �ÿ����� 
	 * @return: void 
	 */ 
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
