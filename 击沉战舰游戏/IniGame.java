package insist;

import java.util.ArrayList;
import java.util.Random;

/***
 * @project_name 击沉战舰游戏
 * @Package insist
 * @Title IniGame.java
 * @Description: 定义游戏初始化类 
 * @author 张秋娟
 * @date 2018-10-3
 * @version v1.0
 * @update 01 2018-10-3 张秋娟  解决随机生成战舰的问题
 *
 */

/****
 * @ClassName:Warship
 * @Description:计算玩家得分和生成战舰
 * 			属性:	1.得分
 * 					2.棋盘
 * 
 * 			方法:	1.计算得分checkScore()
 * 					2.随机生成战舰generateWarship()
 * 				
 * @author 张秋娟
 * @date 2018-10-3
 */


public class IniGame {
	
	/***
	 * @Fields 得分 
	 */
	int score;

	/***
	 * @Fields 7*7棋盘
	 */
	
	String[][] battleground= {
				
				{"A1","A2","A3","A4","A5","A6","A7"},
				{"B1","B2","B3","B4","B5","B6","B7"},
				{"C1","C2","C3","C4","C5","C6","C7"},
				{"D1","D2","D3","D4","D5","D6","D7"},
				{"E1","E2","E3","E4","E5","E6","E7"},
				{"F1","F2","F3","F4","F5","F6","F7"},
				{"G1","G2","G3","G4","G5","G6","G7"}
		};
		
		
	/**   
	 * @Title:checkScore
	 * @Description:计算最后得分
	 * @param: firerecord 玩家的开火明细
	 * @return: int
	 * @throws   
	 */  
	public int checkScore(ArrayList<String> firerecord) {
		//开始得分为 0
		score=0;
		
		//遍历记录战舰状态的ArrayList
		for(String s:firerecord) {
			
			//若记录中碰到Hit/Sunk 均加1分 
			//说明:第三次击中时，先置状态为Hit， 判断位置为空时后置状态为Sunk，故两种状态无重叠的情况
			if(s.equals("Hit")||s.equals("Sunk")) {
				
				score=score+1;
			}
			//若记录中碰到Miss 减1分
			if(s.equals("Miss")) {
				
				score=score-1;
			}
		}
		//输出得分
		System.out.println("\nThe score is "+score+"."); 
			
		return score;
	}
	
	
	/**   
	 * @Title:generateWarship
	 * @Description:随机生成一艘长度为3的战舰 
	 * @return: Warship
	 * @throws   
	 */  
	
	
	public Warship generateWarship() {
		
		Warship warship=new Warship();
		//战舰的横纵坐标
		int x=0,y=0;
		
		Random random1=new Random();
		Random random2=new Random();
		
		//生成一个随机数 来确定战舰是横着 还是竖着
		int random=(int)(Math.random()*100);
	 	
	 	//随机数random若为偶数，则战舰是横着的
	 	if(random%2==0) {
	 		
	 		//随机产生一个[0,5)之间的整数作x ，使x不会溢出
	 		x=random1.nextInt(5);
	 		
	 		//随机产生一个[0,7)之间的整数作y
	 		y=random2.nextInt(7);
	 		
	 		//确定战舰位置
	 		warship.addLocation(battleground[x][y]);
	 		warship.addLocation(battleground[x+1][y]);
	 		warship.addLocation(battleground[x+2][y]);
	 		
	 	}else {
	 		//随机数random若为奇数，则战舰是竖着的
	 		//随机产生一个[0,7)之间的整数作x 
	 		x=random1.nextInt(7);
	 		
	 		//随机产生一个[0,5)之间的整数作y ，使y不会溢出
	 		y=random2.nextInt(5);
	 		
	 		//确定战舰位置
	 		warship.addLocation(battleground[x][y]);
	 		warship.addLocation(battleground[x][y+1]);
	 		warship.addLocation(battleground[x][y+2]);

	 	}
	
	 	//打印输出战舰的位置，用来测试
	 	if(!warship.arraylistIsEmpty()) {
	 		System.out.print("The warship is situated in ");
	 		
	 		for(int i=0;i<3;i++){
           
	 			System.out.print(warship.location.get(i)+" ");
	 		}
	 		System.out.print(".\n");
	 	}
	 	return warship;
	}
		
}
     
	