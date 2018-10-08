package efforts;

import java.util.List;
import  java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


/***
* @project_name ������
* @Package efforts
* @Title Master.java
* @Description: �������� 
* @author �����
* @date 2018-10-2
* @version v1.0
* @update 01 2018-10-2 ����� ����ɾ������ʱ�Ĳ����߼��жϼ�������������
*
*/

/****
* @ClassName:Master
* @Description:ʵ�������˶Ը赥�Ĳ��� 
* 			����:	1.�赥	
* 			����:	1.չʾ�赥showList()
* 					2.˳�򲥷�sortedPlay()
* 					3.���򲥷�disorderPlay()
* 					4.ɾ������deleteSong()
* 					5.�ö�����setTop() 
* 					6.ָ������appointSong()
* @author �����
* @date 2018-10-2
*/
public class Master {
	/***
	 * @Fields ��̬�赥 Ĭ�Ϸ��� ͬһ���ڵ���ɷ���
	 */
	static List<Song> listsong;
	
	/**   
	 * @Title: Master 
	 * @Description:����Master����   ��ʼ��listsong
	 * @throws   
	 */  
	
	public Master() {
		
		//�ӿ����͵Ķ������û���þ�������ʼ��������ᱨjava.lang.NullPointerException����
		 listsong=new ArrayList();
		 
		 //ʵ����Song����
		Song song1=new Song("��������","������",4);
		Song song2=new Song("����","����",4);
		Song song3=new Song("������","����",4);
		Song song4=new Song("��������","�鳾",4);
		
		//��Song��ӵ��赥��
		listsong.add(song1);
		listsong.add(song2);
		listsong.add(song3);
		listsong.add(song4);
	}
	
	/**   
	 * @Title: showList  
	 * @Description:չʾ�赥   
	 * @return: void
	 * @throws   
	 */  


	public void showList() {
		 System.out.println("--------------��ǰ�赥-------------");
		 //����listsong ��ӡ����
	     for (Song s:listsong) { 
        	System.out.println(s.songname+" "+s.singer+" ");
	      } 
	     System.out.println("--------------��"+listsong.size()+"�׸�--------------");
	}
	
	/**   
	 * @Title: sortedPlay  
	 * @Description:˳�򲥷Ÿ赥�еĸ���   
	 * @return: void
	 * @throws   
	 */  
	
	public void sortedPlay() {
		 System.out.println("--------------˳�򲥷�-------------");
			for(int i=0;i<listsong.size();i++) {
				//�ж��Ƿ������һ�׸�
				if(i==(listsong.size()-1)){	
					
					System.out.println("��ǰ����["+listsong.get(i).songname+"]     ��һ����!");
				}else {
					System.out.println("��ǰ����["+listsong.get(i).songname+"]     ��һ��["+listsong.get(i+1).songname+"]");
				}
			}
	}
	
	/**   
	 * @Title: disoederPlay 
	 * @Description:���򲥷Ÿ赥�еĸ���   
	 * @return: void
	 * @throws   
	 */  
	
	public void disorderPlay() {
		
		 System.out.println("--------------���򲥷�-------------");
		//ֱ�ӵ���shuffle���������
		Collections.shuffle(listsong);  
		
		for(int i=0;i<listsong.size();i++) {
			//�ж��Ƿ������һ�׸�
			if(i==(listsong.size()-1)){
				System.out.println("��ǰ����["+listsong.get(i).songname+"]        ��һ����!");
		
			}else {
				System.out.println("��ǰ����["+listsong.get(i).songname+"]         ��һ��["+listsong.get(i+1).songname+"]");
			}
		}
	}
	
	/**   
	 * @Title: deleteSong 
	 * @Description:ɾ���赥�еĸ���   
	 * @return: void
	 * @throws   
	 */  
	
	public void deleteSong() {
		System.out.println("ɾ��������:");
		Scanner input=new Scanner(System.in);
		String songname=input.next();
		
		//���Ҹ�����״̬��־ false��ʾ�Ҳ���
		boolean status=false;
		
		for (Song s:listsong) {
			
			//�ж�����ĸ�������赥�еĸ���������ͬ
			if(songname.equals(s.songname)) {
				
				//���ҵ������Ƴ��˸�������״̬��־Ϊtrue��������ѭ��
				System.out.println("ɾ���ɹ�����ɾ��["+songname+"]!");
				listsong.remove(s);
				status=true;
				break;
			}
		}
		
		//��û�ҵ�������ʾ
		if(!status) {
			 System.out.println("���޴˸���!");
		 }
		// input.close();
	}
	
	
	/**   
	 * @Title: setTop 
	 * @Description:���赥�е�ĳ�׸����ö�  
	 * @return: void
	 * @throws   
	 */  
	public void setTop() {
		
		System.out.println("�ö�������:");
		Scanner input=new Scanner(System.in);
		String songname=input.next();
		
		//���Ҹ�����״̬��־ false��ʾ�Ҳ���
		boolean status=false;
		
		for(Song s:listsong) {
			//�ж�����ĸ�������赥�еĸ���������ͬ
			if(songname.equals(s.songname)) {
				
				//���ҵ������ȡ�˸������±꣬�����ж���listsong�е�λ��
				int index=listsong.indexOf(s);
			
				//���1.�˸������ڶ��� 
				//����:��״̬��־Ϊtrue��������ѭ��
				if(0==index) {
					System.out.println("�������ڶ���!");
					status=true;
					break;
				}else {
				
					//���2.�˸������ڶ����������б��� 
					//����:���˸�����ԭ��λ���Ƴ�����ͷ�����룬��״̬��־Ϊtrue��������ѭ��
					listsong.remove(s);
					listsong.add(0,s);
					System.out.println("�ö��ɹ�!");
					status=true;
					break;
				}			
			}			
		}
		
		//���3.�˸��������б���
		//����:��ʾ
		if(!status) {
			 System.out.println("���޴˸���!");
		 }
		
	}
	
	/**   
	 * @Title: appointSong
	 * @Description:ָ�����Ÿ赥�е�ĳ�׸���  
	 * @return: void
	 * @throws   
	 */  
	
	public void appointSong() {
		System.out.println("ָ�����Ÿ�����:");
		Scanner input=new Scanner(System.in);
		String songname=input.next();
		
		//���Ҹ�����״̬��־ false��ʾ�Ҳ���
		boolean status=false;
		
		for (Song s:listsong) {
			
			//�ж�����ĸ�������赥�еĸ���������ͬ
			if(songname.equals(s.songname)) {
				
				//���ҵ����򲥷Ŵ˸�������״̬��־Ϊtrue��������ѭ��
				System.out.println("ָ���ɹ�����ǰ����["+songname+"]!");
				status=true;
				break;
			}
		}
		
		//��û�ҵ�������ʾ
		if(!status) {
			 System.out.println("���޴˸���!");
		 }
	}
	
}
	