package communication;


/***
 * @project_name insist
 * @Package communication
 * @Title Leader.java
 * @Description: ����Leader��
 * @author �����
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 �����  
 *
 */


/****
 * @ClassName:Leader
 * @Description:ʵ�ֳ��󷽷�eat()��accommodate()�� travel()��giveGift()
 * @author �����
 * @date 2018-10-20
 */

public class Leader extends AbstractRecption implements SpecialReception{

	/**   
	 * @Title:Leader
	 * @Description:����Leader����   
	 * @param: type �ÿ�����
	 * @throws   
	 */ 
	
	public Leader(String type) {
		
		/*���û��๹�췽�������÷ÿ�����Ϊ�쵼*/
		super(type);
		
		/*�涨�쵼�ÿ�һ��ͷ�1500Ԫ���ù�Ϊ1000Ԫ/��������ס�е�100%*/
		super.setMeals(1500);
		super.setHotel(1000);
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
		
		System.out.println("�쵼���ã����͸߼�������һ��!");
	}

	

	
	
	
}
