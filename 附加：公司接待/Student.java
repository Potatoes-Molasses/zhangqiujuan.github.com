package communication;


/***
 * @project_name insist
 * @Package communication
 * @Title Student.java
 * @Description: ����Student��
 * @author �����
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 �����  
 *
 */


/****
 * @ClassName:Student
 * @Description:ʵ�ֳ��󷽷�eat()��accommodate()�� travel()
 * @author �����
 * @date 2018-10-20
 */


public class Student extends AbstractRecption{
	
	/**   
	 * @Title:Student
	 * @Description:����Student����   
	 * @param: type �ÿ�����
	 * @throws   
	 */ 
	public Student(String type) {
		/*���û��๹�췽�������÷ÿ�����Ϊѧ��*/
		super(type);
		
		/*�涨ѧ���ÿ�һ��ͷ�100Ԫ���ù�Ϊ80Ԫ/��������ס�е�50%*/
		super.setMeals(100);
		super.setHotel(80);
		super.setRatio(0.5);
		
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
