package communication;


/***
 * @project_name insist
 * @Package communication
 * @Title Teacher.java
 * @Description: ����Teacher��
 * @author �����
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 �����  
 *
 */


/****
 * @ClassName:Teacher
 * @Description:ʵ�ֳ��󷽷�eat()��accommodate()�� travel()
 * @author �����
 * @date 2018-10-20
 * myBranch--------------------------111
 */

public class Teacher extends AbstractRecption{


	/**   
	 * @Title:Teacher
	 * @Description:����Teacher����   
	 * @param: type �ÿ�����
	 * @throws   
	 */ 
	
	public Teacher(String type) {
		
		/*���û��๹�췽�������÷ÿ�����Ϊ��ʦ*/
		super(type);
		
		/*�涨��ʦ�ÿ�һ��ͷ�500Ԫ���ù�Ϊ300Ԫ/��������ס�е�80%*/
		super.setMeals(500);
		super.setHotel(300);
		super.setRatio(0.8);
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
