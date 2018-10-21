package traffic;

import java.text.DecimalFormat;
/***
 * @project_name insist
 * @Package traffic
 * @Title HighSpeedTrain.java
 * @Description: ���������
 * @author �����
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 �����  
 *
 */


/****
 * @ClassName:HighSpeedTrain
 * @Description:ʵ�ֳ��󷽷�	spend
 * @author �����
 * @date 2018-10-20
 */
public class HighSpeedTrain extends Vehicle {

	/**   
	 * @Title:HighSpeedTrain
	 * @Description:����HighSpeedTrain����   
	 * @param: speed ����
	 * @param: price �۸�
	 * @throws   
	 */  

	public HighSpeedTrain(double speed,double price) {
		
		/*���û��๹�췽�������ó��з�ʽΪ����*/
		super("����", speed, price);
		
		/*���ݸ������е��ص㣬����������Ե�ֵ����Щʱ���ܺ�Ϊ1.3h*/
		super.setArriveTime(0.3);
		super.setBackTime(0.3);
		super.setCheckTime(0.1);
		super.setWaitTime(0.5);
		super.setTicketTime(0.1);
	}

	
	/**   
	 * @Title:spend
	 * @Description:�������ĵ�ʱ��ͷ���
	 * @param: distance ���� ��λ����
	 * @return: void
	 * @throws   
	 */  
	@Override
	public void spend(double distance) {
		
		/*������ʱ����ܺ�*/
		double totalTime=distance/super.getSpeed()+super.getArriveTime()+super.getBackTime()
						  +super.getCheckTime()+super.getWaitTime()+super.getTicketTime();
		
		/*���ܷ��ã��ܷ���=����*����*/
		double payMoney=distance*super.getPrice();
		
		/*����DecimalFormat�������ڸ�ʽ�����double�͵ĺ�ʱ�ͷ���*/
		DecimalFormat df=new DecimalFormat(".00");
		
		System.out.println(super.getStyle()+"���з�ʽ��ʱ"+df.format(totalTime)+" ,  Ԥ�ƻ���"+df.format(payMoney)+"Ԫ!");
	}
	
	
}
