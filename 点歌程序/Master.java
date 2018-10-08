package efforts;

import java.util.List;
import  java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


/***
* @project_name 点歌程序
* @Package efforts
* @Title Master.java
* @Description: 主持人类 
* @author 张秋娟
* @date 2018-10-2
* @version v1.0
* @update 01 2018-10-2 张秋娟 更改删除歌曲时的查找逻辑判断及歌曲乱序问题
*
*/

/****
* @ClassName:Master
* @Description:实现主持人对歌单的操作 
* 			属性:	1.歌单	
* 			方法:	1.展示歌单showList()
* 					2.顺序播放sortedPlay()
* 					3.乱序播放disorderPlay()
* 					4.删除歌曲deleteSong()
* 					5.置顶歌曲setTop() 
* 					6.指定播放appointSong()
* @author 张秋娟
* @date 2018-10-2
*/
public class Master {
	/***
	 * @Fields 静态歌单 默认访问 同一包内的类可访问
	 */
	static List<Song> listsong;
	
	/**   
	 * @Title: Master 
	 * @Description:构造Master对象   初始化listsong
	 * @throws   
	 */  
	
	public Master() {
		
		//接口类型的对象如果没有用具体的类初始化，否则会报java.lang.NullPointerException错误
		 listsong=new ArrayList();
		 
		 //实例化Song对象
		Song song1=new Song("冰菊物语","周桃桃",4);
		Song song2=new Song("大鱼","周深",4);
		Song song3=new Song("今年勇","许嵩",4);
		Song song4=new Song("凉风有信","洪尘",4);
		
		//把Song添加到歌单中
		listsong.add(song1);
		listsong.add(song2);
		listsong.add(song3);
		listsong.add(song4);
	}
	
	/**   
	 * @Title: showList  
	 * @Description:展示歌单   
	 * @return: void
	 * @throws   
	 */  


	public void showList() {
		 System.out.println("--------------当前歌单-------------");
		 //遍历listsong 打印歌名
	     for (Song s:listsong) { 
        	System.out.println(s.songname+" "+s.singer+" ");
	      } 
	     System.out.println("--------------共"+listsong.size()+"首歌--------------");
	}
	
	/**   
	 * @Title: sortedPlay  
	 * @Description:顺序播放歌单中的歌曲   
	 * @return: void
	 * @throws   
	 */  
	
	public void sortedPlay() {
		 System.out.println("--------------顺序播放-------------");
			for(int i=0;i<listsong.size();i++) {
				//判断是否是最后一首歌
				if(i==(listsong.size()-1)){	
					
					System.out.println("当前播放["+listsong.get(i).songname+"]     下一首无!");
				}else {
					System.out.println("当前播放["+listsong.get(i).songname+"]     下一首["+listsong.get(i+1).songname+"]");
				}
			}
	}
	
	/**   
	 * @Title: disoederPlay 
	 * @Description:乱序播放歌单中的歌曲   
	 * @return: void
	 * @throws   
	 */  
	
	public void disorderPlay() {
		
		 System.out.println("--------------乱序播放-------------");
		//直接调用shuffle，随机排序
		Collections.shuffle(listsong);  
		
		for(int i=0;i<listsong.size();i++) {
			//判断是否是最后一首歌
			if(i==(listsong.size()-1)){
				System.out.println("当前播放["+listsong.get(i).songname+"]        下一首无!");
		
			}else {
				System.out.println("当前播放["+listsong.get(i).songname+"]         下一首["+listsong.get(i+1).songname+"]");
			}
		}
	}
	
	/**   
	 * @Title: deleteSong 
	 * @Description:删除歌单中的歌曲   
	 * @return: void
	 * @throws   
	 */  
	
	public void deleteSong() {
		System.out.println("删除歌曲名:");
		Scanner input=new Scanner(System.in);
		String songname=input.next();
		
		//查找歌曲的状态标志 false表示找不到
		boolean status=false;
		
		for (Song s:listsong) {
			
			//判断输入的歌曲名与歌单中的歌曲有无相同
			if(songname.equals(s.songname)) {
				
				//若找到，则移除此歌曲，置状态标志为true，并跳出循环
				System.out.println("删除成功，已删除["+songname+"]!");
				listsong.remove(s);
				status=true;
				break;
			}
		}
		
		//若没找到，则提示
		if(!status) {
			 System.out.println("查无此歌曲!");
		 }
		// input.close();
	}
	
	
	/**   
	 * @Title: setTop 
	 * @Description:将歌单中的某首歌曲置顶  
	 * @return: void
	 * @throws   
	 */  
	public void setTop() {
		
		System.out.println("置顶歌曲名:");
		Scanner input=new Scanner(System.in);
		String songname=input.next();
		
		//查找歌曲的状态标志 false表示找不到
		boolean status=false;
		
		for(Song s:listsong) {
			//判断输入的歌曲名与歌单中的歌曲有无相同
			if(songname.equals(s.songname)) {
				
				//若找到，则获取此歌曲的下标，用来判断在listsong中的位置
				int index=listsong.indexOf(s);
			
				//情况1.此歌曲已在顶部 
				//操作:置状态标志为true，并跳出循环
				if(0==index) {
					System.out.println("歌曲已在顶部!");
					status=true;
					break;
				}else {
				
					//情况2.此歌曲不在顶部，但在列表中 
					//操作:将此歌曲从原有位置移除，在头部加入，置状态标志为true，并跳出循环
					listsong.remove(s);
					listsong.add(0,s);
					System.out.println("置顶成功!");
					status=true;
					break;
				}			
			}			
		}
		
		//情况3.此歌曲不在列表中
		//操作:提示
		if(!status) {
			 System.out.println("查无此歌曲!");
		 }
		
	}
	
	/**   
	 * @Title: appointSong
	 * @Description:指定播放歌单中的某首歌曲  
	 * @return: void
	 * @throws   
	 */  
	
	public void appointSong() {
		System.out.println("指定播放歌曲名:");
		Scanner input=new Scanner(System.in);
		String songname=input.next();
		
		//查找歌曲的状态标志 false表示找不到
		boolean status=false;
		
		for (Song s:listsong) {
			
			//判断输入的歌曲名与歌单中的歌曲有无相同
			if(songname.equals(s.songname)) {
				
				//若找到，则播放此歌曲，置状态标志为true，并跳出循环
				System.out.println("指定成功，当前播放["+songname+"]!");
				status=true;
				break;
			}
		}
		
		//若没找到，则提示
		if(!status) {
			 System.out.println("查无此歌曲!");
		 }
	}
	
}
	