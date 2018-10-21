package traffic;

/***
 * @project_name insist
 * @Package traffic
 * @Title Vehicle.java
 * @Description: ����ӿںͽ�ͨ������
 * @author �����
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 �����  
 *
 */


/****
 * @InterfaceName:Transport
 * @Description:����ӿ�,����һ�����󷽷�spend
 * @author �����
 * @date 2018-10-20
 */
	
 interface Transport{
	 
	 public void spend(double distance);
	 
}

 /****
  * @ClassName:Vehicle
  * @Description:��������࣬�̳нӿ�Transport
  * @author �����
  * @date 2018-10-20
  */
 	
public abstract class Vehicle implements Transport{
	
	/*��protected ������ܹ����ʸ��������*/
	/***
	 * @Fields ���з�ʽ
	 */
	
	private String style;
	
	/***
	 * @Fields ���ﳵվ(����)��ʱ��  ��λ��h
	 */
	
	private double arriveTime;
	
	/***
	 * @Fields �ӳ�վ(����)�ķ���ʱ��  ��λ��h
	 */
	
	private double backTime;
	
	/***
	 * @Fields ȡƱʱ�� ��λ��h
	 */
	
	private double ticketTime;
	
	/***
	 * @Fields ����ʱ�� ��λ��h
	 */
	
	
	private double checkTime;
	
	/***
	 * @Fields �ȴ�ʱ��  ��λ��h
	 */
	
	private double waitTime;
	
	/***
	 * @Fields �ٶ�  ��λ������/ÿСʱ
	 */
	
	private double speed;
	
	/***
	 * @Fields  �۸� ��λ��Ԫ/����
	 */
	
	private double price;
	
	
	/**   
	 * @Title:Vehicl
	 * @Description:  ���콻ͨ���������   
	 * @param: style ���з�ʽ
	 * @param: speed ����
	 * @param: price �۸�
	 * @throws   
	 */ 
	
	public Vehicle(String style,double speed,double price){
			
		this.style=style;
		this.speed=speed;
		this.price=price;
	}

	
	/**   
	 * @Title:spend
	 * @Description:���󷽷� �����ʱ�ͷ���
	 * @param: distance ����
	 * @return: void
	 * @throws   
	 */  
	
	public abstract void spend(double distance);
	
	
	/**   
	 * @Title:show
	 * @Description:���ó��󷽷���չ�ֺ�ʱ�ͷ���
	 * @param: distance ����
	 * @return: void
	 * @throws   
	 */  
	
	public void show(double distance) {
		
		spend(distance);
		
	}
	
	/**  
	 * @Title:setStyle 
	 * @Description: ���ó��з�ʽ
	 * @param: style ���з�ʽ
	 * @return: void 
	 */ 
	
	public void setStyle(String style) {
		this.style=style;
	}
	
	
	/**  
	 * @Title:getStyle
	 * @Description: ��ȡ���з�ʽ
	 * @return:String
	 */  
	
	public String getStyle(){
		return style;
	}
	
	
	/**  
	 * @Title:setArriveTime
	 * @Description: ���õ��ﳵվ��������ʱ��
	 * @param: arriveTime ��������ʱ��
	 * @return: void 
	 */ 
	public void setArriveTime(double arriveTime) {
		this.arriveTime = arriveTime;
	}
	
	

	/**  
	 * @Title:getArriveTime
	 * @Description: ��ȡ���ﳵվ��������ʱ��
	 * @return: double
	 */  
	
	public double getArriveTime() {
		return arriveTime;
	}
	
	/**  
	 * @Title:setBackTime
	 * @Description: ���ôӳ�վ������������ʱ��
	 * @param: backTime ����ʱ��
	 * @return: void 
	 */ 
	
	public void setBackTime(double backTime) {
		this.backTime=backTime;
	}
	

	/**  
	 * @Title:getBackTime
	 * @Description: ��ȡ�ӳ�վ������������ʱ��
	 * @return: double
	 */  
	
	public double getBackTime() {
		return backTime;
	}
	
	
	/**  
	 * @Title:setTicketTime
	 * @Description: ����ȡƱʱ��
	 * @param: ticketTime ȡƱʱ��
	 * @return: void 
	 */ 

	public void setTicketTime(double ticketTime) {
		this.ticketTime = ticketTime;
	}
	
	/**  
	 * @Title:getTicketTime
	 * @Description: ��ȡȡƱʱ��
	 * @return: double
	 */  
	
	public double getTicketTime() {
		return ticketTime;
	}
	
	
	/**  
	 * @Title:setCheckTime
	 * @Description: ���ð���ʱ��
	 * @param: checkTime ����ʱ��
	 * @return: void 
	 */ 
	
	public void setCheckTime(double checkTime) {
		this.checkTime=checkTime;
	}
	
	/**  
	 * @Title:getCheckTime
	 * @Description: ��ȡ����ʱ��
	 * @return: double
	 */  
	
	public double getCheckTime() {
		return checkTime;
	}
	

	/**  
	 * @Title:setWaitTime
	 * @Description: ���õȴ�ʱ��
	 * @param: waitTime �ȴ�ʱ��
	 * @return: void 
	 */ 
	
	public void setWaitTime(double waitTime) {
		this.waitTime=waitTime;
	}
	
	/**  
	 * @Title:getWaitTime
	 * @Description: ��ȡ�ȴ�ʱ��
	 * @return: double
	 */  
	public double getWaitTime() {
		return waitTime;
	}
	
	/**  
	 * @Title:setSpeed
	 * @Description: �����ٶ�
	 * @param: speed ����
	 * @return: void 
	 */ 
	public void setSpeed(double speed) {
		this.speed=speed;
	}
	

	/**  
	 * @Title:getSpeed
	 * @Description: ��ȡ����
	 * @return: double
	 */  
	public double getSpeed() {
		return speed;
	}
	
	/**  
	 * @Title:setPrice
	 * @Description: ���ü۸�
	 * @param: price �۸�
	 * @return: void 
	 */ 
	public void setPrice(double price) {
		this.price=price;
	}
	
	/**  
	 * @Title:getPrice
	 * @Description: ��ȡ�۸�
	 * @return: double
	 */  
	public double getPrice() {
		return price;
	}

		
	
}


