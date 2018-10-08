package efforts;


/***
 * @project_name 点歌程序
 * @Package efforts
 * @Title Song.java
 * @Description:定义歌曲类 
 * @author 张秋娟
 * @date 2018-10-2
 * @version v1.0
 * @update 01 2018-10-2 张秋娟 完善部分setter方法及getter方法
 *
 */
/****
 * @ClassName:Song
 * @Description:设置歌曲的相关属性 
 * 			属性:	1.歌曲名
 * 					2.歌手
 * 					3.时长
 * 			方法:	1.设置歌曲名setSongname() 
 * 					2.获取歌曲名getSongname()
 * @author 张秋娟
 * @date 2018-10-2
 */



public class Song {
	
	/***
	 * @Fields 歌曲名
	 */
	
	String songname;
	
	/***
	 * @Fields 歌手
	 */
	
	String singer;
	
	/***
	 * @Fields 时长
	 */
	
	double time;
	
	/**   
	 * @Title: Song 
	 * @Description:构造Song对象   
	 * @param: songname  歌曲名
	 * @param: singer    歌手
	 * @param: time      时长
	 * @throws   
	 */  
	
	public Song(String songname,String singer,double time) {
		this.songname=songname;
		this.singer=singer;
		this.time=time;
	}
	
	
	/**  
	 * @Title:setSongname 
	 * @Description: 设置歌曲名 
	 * @return: void 
	 */ 
	
	public void setSongname(String songname) {
		this.songname=songname;
	}
	
	/**  
	 * @Title:getSongname
	 * @Description: 获取歌曲名
	 * @return: String 
	 */  
	
	public String getSongname() {
		return songname;
	}
}
