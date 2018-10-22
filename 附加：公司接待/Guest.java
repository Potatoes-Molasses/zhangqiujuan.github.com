package communication;



/***
 * @project_name insist
 * @Package communication
 * @Title Guest.java
 * @Description: ����Guest��
 * @author �����
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 �����  
 *
 */


/****
 * @ClassName:Guest
 * @Description:ʵ�ֳ��󷽷�eat()��accommodate()�� travel()��giveGift()
 * @author �����
 * @date 2018-10-20
 */

public class Guest extends AbstractRecption implements SpecialReception{
	
	
	/**   
	 * @Title:Guest
	 * @Description:����Guest����   
	 * @param: type �ÿ�����
	 * @throws   
	 */ 
	public Guest(String type) {
		
		/*���û��๹�췽�������÷ÿ�����Ϊ���*/
		super(type);
		
		/*�涨����ÿ�һ��ͷ�800Ԫ���ù�Ϊ500Ԫ/��������ס�е�100%*/
		super.setMeals(800);
		super.setHotel(500);
		super.setRatio(1);
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
	
	
	/**   
	 * @Title:giveGift
	 * @Description:��������
	 * @return: void
	 * @throws   
	 */  
	@Override
	public void giveGift() {
		
		System.out.println("������ã����ͱ����ز�һ�ݣ�");
		
	}

	

}
