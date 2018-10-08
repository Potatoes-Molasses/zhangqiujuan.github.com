package insist;

import java.util.ArrayList;


/***
 * @project_name ����ս����Ϸ
 * @Package insist
 * @Title Warship.java
 * @Description: ����ս���� 
 * @author �����
 * @date 2018-10-3
 * @version v1.0
 * @update 01 2018-10-3 �����  ����״̬����
 *
 */

/****
 * @ClassName:Warship
 * @Description:����һ��ս���� 
 * 			����:	1.��ǰ�������������� ��A1 A2 A3
 * 					2.��ǰ״̬ Hit/Miss/Sunk
 * 
 * 			����:	1.��ȡ��ǰռ�ݵ���������getLocation() 
 * 					2.����һ�����ӵ�λ����addLocation()
 * 					3.�Ƴ���ռ�ݵ�һ������removeLocation()
 *					4.�ж��Ƿ��������Ӷ����Ƴ�����ս���Ƿ񱻻���arraylistIsEmpty()
 * @author �����
 * @date 2018-10-3
 */



public class Warship {
	
	/***
	 * @Fields ս����λ�ü�ս����ǰռ�ݵ���������
	 */
	
	//Ĭ�Ϸ��� ʹͬһ���ڿɼ�
	ArrayList<String>location=new ArrayList<String>();
	
	/***
	 * @Fields ս����ǰ״̬ Hit/Miss/Sunk
	 */
	
	String status;

	/**  
	 * @Title:getLocation
	 * @Description: ��ȡս��λ��
	 * @return: ArrayList<String>
	 */  
	
	public ArrayList<String> getLocation(){
		return location;
	}
	
	/**   
	 * @Title: addLocation 
	 * @Description:����ĳ�����ӵ�λ����
	 * @param: loca ��������
	 * @return: void
	 * @throws   
	 */  
	
	public void addLocation(String loca) {
		location.add(loca);
	}
	

	/**   
	 * @Title: removeLocation
	 * @Description:�Ƴ�λ���е�ĳ������
	 * @param: index ��������������±�
	 * @return: void
	 * @throws   
	 */  
	
	public void removeLocation(int index) {
		location.remove(index);
	}
	
	

	/**   
	 * @Title: arraylistIsEmpty
	 * @Description:�жϴ洢ս��λ�õ�ArrayList�Ƿ�Ϊ��
	 * @return: boolean
	 * @throws   
	 */  
	public boolean arraylistIsEmpty() {
		if(location.isEmpty())
			return true;
		return false;
	}
}
