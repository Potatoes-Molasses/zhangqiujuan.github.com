package insist;

import java.util.ArrayList;


/***
 * @project_name 击沉战舰游戏
 * @Package insist
 * @Title Player.java
 * @Description: 玩家类 
 * @author 张秋娟
 * @date 2018-10-3
 * @version v1.0
 * @update 01 2018-10-3 张秋娟  解决移除战舰位置时抛出异常的问题
 *
 */

/****
 * @ClassName:Player
 * @Description:定义玩家类
 * 			属性:	开火明细 记录玩家每次开火后，战舰所处的状态
 * 
 * 			方法:	1.每次开火后，增加记录到明细中
 *					2.炮击方法
 * 				
 * @author 张秋娟
 * @date 2018-10-3
 */


public class Player {

	/***
	 * @Fields 记录所有开火明细
	 */
	
	ArrayList<String>firerecord=new ArrayList<String>();
	
	/**   
	 * @Title: addRecord
	 * @Description:增加炮击记录到开火明细中
	 * @param: loca 格子名
	 * @return: void
	 * @throws   
	 */  
	
	
	public void addRecord(String loca) {
		firerecord.add(loca);
	}
	
	
	/**   
	 * @Title: attack
	 * @Description:攻击战舰的结果判断，给玩家提示
	 * @param: warship 要攻击的战舰
	 * @param: str 要攻击的格子
	 * @return: void
	 * @throws   
	 */  
	
	public void attack(Warship warship,String str) {
		
		
		/*list在删除的时候，会抛出异常
		 * 法一:复制到另一集合，在另一集合里删除
		 * 法二:改用for
		 */
		
		for(int i=0;i<warship.location.size();i++) {
			
			//获取战舰所占据的各个格子
			String state=warship.location.get(i);
			
			//与玩家猜测的格子比较
			if(str.equals(state)) {
				
				//情况1.相同则击中
				//操作:移除被击中的位置 置战舰状态为Hit
				System.out.print("---------------------- [Hit!]\n");
			
				warship.location.remove(state);
				warship.status="Hit";
				
				//情况2.不仅击中，且此时location中的格子都已被移除
				//操作: 置战舰状态为Sunk
				if(warship.arraylistIsEmpty()) {
					System.out.print("***********[Sunk!]***********\n");
					warship.status="Sunk";
				}	
			}
			
		}
		
		//情况3.不相同，则战舰没被击中
		//操作:提示Miss
		if(warship.status.equals("Miss")) {
		
		System.out.print("---------------------- [Miss!]\n");
		
		}
	}

}	




















	  
	/* *  for(Boat bot:boats){//遍历存储Boat对象的ArrayList              
             for(String st:bot.getBoatString()){ //遍历存储Boat对象的ArrayList中的，每个存储String类型对象的Arraylist               
                 if(st.equals(str)){
                     System.out.println("You have hit "+bot.boatName+"!!");
                     bot.getBoatString().remove(st); //击中后将boat中的击中位置删去
                     if(bot.getBoatString().isEmpty()){
                         System.out.println("OH GOD!You have sunk "+bot.boatName+"!!\nLet's sink next boat!\n");
                         boats.remove(bot);//从存储Boat对象的Arraylist中，删去某个被三个位置都击中的船对象
                     }
                     ber=true;
                     berHit=false;
                     break;
                 }

             }
             if(ber){//若击中一只船，直接跳出两层循环
                 ber=false;
                 break;
             }               
         }                                               
            if(berHit){//未击中提示
                System.out.println("Good hit,but..you missed (T^T)\nCome on! try again! :) ");
            }
     }
     //游戏结束
     System.out.println("After "+tryTimes+" times hits\nI can't believe it...\n OMG!!YOU HAVE WON ↖(^ω^)↗!!!!");         
     scan.close();           
	 */
	
	

