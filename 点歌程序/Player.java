package efforts;

import java.util.Scanner;

/***
* @project_name ������
* @Package efforts
* @Title Player.java
* @Description: �����û��� 
* @author �����
* @date 2018-10-2
* @version v1.0
* @update 01 2018-10-2 �����   �����Ӹ���ʱһ�����һ�׸軹�Ƕ��׸������
*
*/

/****
* @ClassName:Player
* @Description:ʵ���û����
* 			����:	��	
* 			����:	���addSong()
* 					
* @author �����
* @date 2018-10-2
*/

public class Player {

	/**   
	 * @Title: addSong  
	 * @Description:��赥�����һ�׸���  
	 * @return: Song��Ķ���
	 * @throws   
	 */  
	public Song addSong() {
		
		//��ȡ�û�����ĸ�����Ϣ
		Scanner input=new Scanner(System.in);	
		System.out.println("������Ϣ: ");
		//��ȡ����
		String songname=input.next();
		//��ȡ����
		String singer=input.next();
		//��ȡʱ��
		double time=input.nextDouble();
		//�ѻ�ȡ������Ϣʵ������Song����
		Song song=new Song(songname,singer,time);
		return song;
	}

}
