package communication;




/***
 * @project_name insist
 * @Package communication
 * @Title Patriarch.java
 * @Description: ����Patriarch��
 * @author �����
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 �����  
 *
 */


/****
 * @ClassName:Patriarch
 * @Description:ʵ�ֳ��󷽷�eat()��accommodate()�� travel()
 * @author �����
 * @date 2018-10-20
 */

public class Patriarch  extends AbstractRecption{

	/**   
	 * @Title:Patriarch
	 * @Description:����Patriarch����   
	 * @param: type �ÿ�����
	 * @throws   
	 */ 
	
	public Patriarch(String type) {
		
		/*���û��๹�췽�������÷ÿ�����Ϊ�ҳ�*/
		super(type);
		
		/*�涨�ҳ��ÿ�һ��ͷ�300Ԫ���ù�Ϊ200Ԫ/��������ס�е�70%*/
		super.setMeals(300);
		super.setHotel(200);
		super.setRatio(0.7);
		
		}
	
	
	/**   
	 * @Title:eat
	 * @Description:���㱨�����ܲͷ�
	 * @param: days �Ӵ�����
	 * @return: double
	 * @throws   
	 */  

	@Override
	public double eat(int days) {
		
		/*�������ܲͷ�=һ��ͷ�*����*������*/
		double money=super.getMeals()*days*super.getRatio();
		return money;
		
	}
	
	/**   
	 * @Title:accommodate
	 * @Description:���㱨������ס�޷�
	 * @param: days �Ӵ�����
	 * @return: double
	 * @throws   
	 */  

	@Override
	public double accommodate(int days) {
		
		/*��������ס�޷�=һ���ס�޷�*����*������*/
		double money=super.getHotel()*days*super.getRatio();
		return money;
	}

	
	/**   
	 * @Title:travel
	 * @Description:���㱨������·�ѣ���������
	 * @param: fare ��������
	 * @return: double
	 * @throws   
	 */  
	@Override
	public double travel(double fare) {
		
		/*��������·��=����·��*������*/
		return super.getRatio()*fare;
		
	}

	

}
