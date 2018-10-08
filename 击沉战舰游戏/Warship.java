package insist;

import java.util.ArrayList;


/***
 * @project_name 击沉战舰游戏
 * @Package insist
 * @Title Warship.java
 * @Description: 定义战舰类 
 * @author 张秋娟
 * @date 2018-10-3
 * @version v1.0
 * @update 01 2018-10-3 张秋娟  完善状态属性
 *
 */

/****
 * @ClassName:Warship
 * @Description:定义一个战舰类 
 * 			属性:	1.当前所处的三个格子 如A1 A2 A3
 * 					2.当前状态 Hit/Miss/Sunk
 * 
 * 			方法:	1.获取当前占据的三个格子getLocation() 
 * 					2.增加一个格子到位置中addLocation()
 * 					3.移除所占据的一个格子removeLocation()
 *					4.判断是否三个格子都被移除，即战舰是否被击沉arraylistIsEmpty()
 * @author 张秋娟
 * @date 2018-10-3
 */



public class Warship {
	
	/***
	 * @Fields 战舰的位置即战舰当前占据的三个格子
	 */
	
	//默认访问 使同一包内可见
	ArrayList<String>location=new ArrayList<String>();
	
	/***
	 * @Fields 战舰当前状态 Hit/Miss/Sunk
	 */
	
	String status;

	/**  
	 * @Title:getLocation
	 * @Description: 获取战舰位置
	 * @return: ArrayList<String>
	 */  
	
	public ArrayList<String> getLocation(){
		return location;
	}
	
	/**   
	 * @Title: addLocation 
	 * @Description:增加某个格子到位置中
	 * @param: loca 格子名称
	 * @return: void
	 * @throws   
	 */  
	
	public void addLocation(String loca) {
		location.add(loca);
	}
	

	/**   
	 * @Title: removeLocation
	 * @Description:移除位置中的某个格子
	 * @param: index 格子所在数组的下标
	 * @return: void
	 * @throws   
	 */  
	
	public void removeLocation(int index) {
		location.remove(index);
	}
	
	

	/**   
	 * @Title: arraylistIsEmpty
	 * @Description:判断存储战舰位置的ArrayList是否为空
	 * @return: boolean
	 * @throws   
	 */  
	public boolean arraylistIsEmpty() {
		if(location.isEmpty())
			return true;
		return false;
	}
}
