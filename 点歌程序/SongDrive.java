package efforts;

import java.util.Scanner;

/*
 * 需求：音乐点歌程序
 * 	（1）客人每次点一首歌发送给主持人
 * 	（2）主持人顺序播放列表中的歌曲
 * 	（3）主持人也可以指定播放一首在待播放列表中的歌
 * 分析：
 * 	（1）定义歌曲信息类，包含歌曲名、歌手、时长、
 * 	（2）定义用户类，用户可以点歌
 * 	（3）定义主持人类,可以播放歌曲,也可以指定播放
 * 	（4）定义控制类让它们运转起来
 */
/***
* @project_name 点歌程序
* @Package efforts
* @Title SongDrive.java
* @Description: 定义控制点歌类 
* @author 张秋娟
* @date 2018-10-2
* @version v1.0
* @update 01 2018-10-2 张秋娟   解决SongDrive的构造函数问题
*
*/

/****
* @ClassName: SongDrive 
* @Description:控制点歌的流程
* 			属性:	1.Master类对象 用来操作歌单
* 					2.Playe对象	 点歌
* 				
* 					
* @author 张秋娟
* @date 2018-10-2
*/

public class SongDrive {

	/***
	 * @Fields 主持人
	 */
	
	public Master master;
	
	/***
	 * @Fields 用户
	 */
	
	public Player player;
	
	/**   
	 * @Title: SongDrive
	 * @Description:构造SongDrive对象   
	 * @throws   
	 */ 
	
	public SongDrive() {
		
		//必须用具体的类初始化master和player，否则会报错
		master=new Master();
		player=new Player();
		
	}
	
	
	public static void main(String[] args) {
		
		SongDrive drive=new SongDrive();
		//先展示初始歌单,再根据提示进行下一步操作
		drive.master.showList();
	
		 System.out.println("***********欢迎来到点歌房***********");
		 System.out.println("1.添加歌曲");
		 System.out.println("2.删除歌曲");
		 System.out.println("3.显示歌单");
		 System.out.println("4.顺序播放");
		 System.out.println("5.乱序播放");
		 System.out.println("6.指定播放");
		 System.out.println("7.歌曲置顶");
		 System.out.println("8.退出系统");
		 
		 //等待用户输入
		 while(true) {
			 
			 //获取输入的指令
			  Scanner input=new Scanner(System.in);
			  int number=input.nextInt();
			  
			  //根据用户指令，调用相应的方法，实现相应的功能
			  switch(number) {
			  case 1:
				  	Song s =drive.player.addSong();
				  	drive.master.listsong.add(s);
				  	break;
			  case 2:
				   	drive.master.deleteSong();
				   	break;
			  case 3:
				   	drive.master.showList();
				   	break;
			  case 4:
				  	drive.master.sortedPlay();
				  	break;
			  case 5:
				    drive.master.disorderPlay();
				  	break;
			  case 6:
					drive.master.appointSong();
			        break;
			  case 7:
				    drive.master.setTop();
				  	break;
			  case 8: 
				  	System.out.println("成功退出!");
				  	System.exit(0);
				  	break;
			  default:
				  	System.out.println("无效命令!");
				  	break;
			  }
		 }
		
	}
}
