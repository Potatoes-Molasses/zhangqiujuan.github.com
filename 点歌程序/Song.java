package efforts;


/***
 * @project_name ������
 * @Package efforts
 * @Title Song.java
 * @Description:��������� 
 * @author �����
 * @date 2018-10-2
 * @version v1.0
 * @update 01 2018-10-2 ����� ���Ʋ���setter������getter����
 *
 */
/****
 * @ClassName:Song
 * @Description:���ø������������ 
 * 			����:	1.������
 * 					2.����
 * 					3.ʱ��
 * 			����:	1.���ø�����setSongname() 
 * 					2.��ȡ������getSongname()
 * @author �����
 * @date 2018-10-2
 */



public class Song {
	
	/***
	 * @Fields ������
	 */
	
	String songname;
	
	/***
	 * @Fields ����
	 */
	
	String singer;
	
	/***
	 * @Fields ʱ��
	 */
	
	double time;
	
	/**   
	 * @Title: Song 
	 * @Description:����Song����   
	 * @param: songname  ������
	 * @param: singer    ����
	 * @param: time      ʱ��
	 * @throws   
	 */  
	
	public Song(String songname,String singer,double time) {
		this.songname=songname;
		this.singer=singer;
		this.time=time;
	}
	
	
	/**  
	 * @Title:setSongname 
	 * @Description: ���ø����� 
	 * @return: void 
	 */ 
	
	public void setSongname(String songname) {
		this.songname=songname;
	}
	
	/**  
	 * @Title:getSongname
	 * @Description: ��ȡ������
	 * @return: String 
	 */  
	
	public String getSongname() {
		return songname;
	}
}
