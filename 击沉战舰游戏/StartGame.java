package insist;

import java.util.Scanner;

/*
 * 需求：击沉战舰游戏
 * 	（1）游戏初始化，生成7*7的棋盘，且棋盘上有一艘战舰（长度为3）
 * 	（2）玩家猜测战舰位置，并开炮攻击
 * 	（3）根据计算机的回馈，提示攻击情况Hit/Sunk(+1分)、Miss(-1分)
 * 	（4）玩家一直猜测，直到击中三次，战舰沉没
 * 	（5）统计得分，游戏结束
 * 分析：
 * 	（1）分别设计战舰类、玩家类、游戏初始化类、开始游戏（控制）类
 * 	（2）利用随机数生成战舰位置
 * 	（3）使用ArrayList的相关方法，完成攻击和统计得分
 * 	（4）设置状态标志进行提示
 */




/***
 * @project_name 击沉战舰游戏
 * @Package insist
 * @Title StartGame.java
 * @Description: 定义开始游戏类
 * @author 张秋娟
 * @date 2018-10-3
 * @version v1.0
 * @update 01 2018-10-3 张秋娟  细化控制流程
 *
 */

/***
 * @ClassName:StartGame
 * @Description:控制游戏过程			
 * @author 张秋娟
 * @date 2018-10-3
 */

public class StartGame {
	
	public static void main(String[] args) {
		
		//先初始化游戏，生成战舰，再定义玩家

		IniGame game=new IniGame();
		Warship warship=game.generateWarship();
		Player player=new Player();
		
		//若战舰所占据的三个格子都没被消除，则继续游戏
		while(!warship.arraylistIsEmpty()) {
			
			//每次遍历查找时，先置状态为Miss
			warship.status="Miss";
			
			//提示玩家猜测战舰位置
			System.out.print("Input yuor target: ");
			Scanner input=new Scanner(System.in);
			String str=input.next();
			
			//确定位置后，玩家开炮攻击，并把记录加入到开火明细中
			player.attack(warship,str);
			player.addRecord(warship.status);			
			
			
		}
		
		//最后统计明细中的状态，计算得分，游戏结束
		
		/*测试用
		 for(int i=0;i<player.firerecord.size();i++) {
		System.out.print("\n"+player.firerecord.get(i)+" ");
		}
		*/
		game.checkScore(player.firerecord);
		
	}
	
}
