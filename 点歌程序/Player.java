package efforts;

import java.util.Scanner;

/***
* @project_name 点歌程序
* @Package efforts
* @Title Player.java
* @Description: 定义用户类 
* @author 张秋娟
* @date 2018-10-2
* @version v1.0
* @update 01 2018-10-2 张秋娟   解决添加歌曲时一次添加一首歌还是多首歌的问题
*
*/

/****
* @ClassName:Player
* @Description:实现用户点歌
* 			属性:	无	
* 			方法:	点歌addSong()
* 					
* @author 张秋娟
* @date 2018-10-2
*/

public class Player {

	/**   
	 * @Title: addSong  
	 * @Description:向歌单中添加一首歌曲  
	 * @return: Song类的对象
	 * @throws   
	 */  
	public Song addSong() {
		
		//获取用户输入的歌曲信息
		Scanner input=new Scanner(System.in);	
		System.out.println("歌曲信息: ");
		//获取歌名
		String songname=input.next();
		//获取歌手
		String singer=input.next();
		//获取时长
		double time=input.nextDouble();
		//把获取到的信息实例化成Song对象
		Song song=new Song(songname,singer,time);
		return song;
	}

}
