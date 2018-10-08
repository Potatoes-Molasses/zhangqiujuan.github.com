package efforts;

import java.util.Scanner;

/*
 * �������ֵ�����
 * 	��1������ÿ�ε�һ�׸跢�͸�������
 * 	��2��������˳�򲥷��б��еĸ���
 * 	��3��������Ҳ����ָ������һ���ڴ������б��еĸ�
 * ������
 * 	��1�����������Ϣ�࣬���������������֡�ʱ����
 * 	��2�������û��࣬�û����Ե��
 * 	��3��������������,���Բ��Ÿ���,Ҳ����ָ������
 * 	��4�������������������ת����
 */
/***
* @project_name ������
* @Package efforts
* @Title SongDrive.java
* @Description: ������Ƶ���� 
* @author �����
* @date 2018-10-2
* @version v1.0
* @update 01 2018-10-2 �����   ���SongDrive�Ĺ��캯������
*
*/

/****
* @ClassName: SongDrive 
* @Description:���Ƶ�������
* 			����:	1.Master����� ���������赥
* 					2.Playe����	 ���
* 				
* 					
* @author �����
* @date 2018-10-2
*/

public class SongDrive {

	/***
	 * @Fields ������
	 */
	
	public Master master;
	
	/***
	 * @Fields �û�
	 */
	
	public Player player;
	
	/**   
	 * @Title: SongDrive
	 * @Description:����SongDrive����   
	 * @throws   
	 */ 
	
	public SongDrive() {
		
		//�����þ�������ʼ��master��player������ᱨ��
		master=new Master();
		player=new Player();
		
	}
	
	
	public static void main(String[] args) {
		
		SongDrive drive=new SongDrive();
		//��չʾ��ʼ�赥,�ٸ�����ʾ������һ������
		drive.master.showList();
	
		 System.out.println("***********��ӭ������跿***********");
		 System.out.println("1.��Ӹ���");
		 System.out.println("2.ɾ������");
		 System.out.println("3.��ʾ�赥");
		 System.out.println("4.˳�򲥷�");
		 System.out.println("5.���򲥷�");
		 System.out.println("6.ָ������");
		 System.out.println("7.�����ö�");
		 System.out.println("8.�˳�ϵͳ");
		 
		 //�ȴ��û�����
		 while(true) {
			 
			 //��ȡ�����ָ��
			  Scanner input=new Scanner(System.in);
			  int number=input.nextInt();
			  
			  //�����û�ָ�������Ӧ�ķ�����ʵ����Ӧ�Ĺ���
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
				  	System.out.println("�ɹ��˳�!");
				  	System.exit(0);
				  	break;
			  default:
				  	System.out.println("��Ч����!");
				  	break;
			  }
		 }
		
	}
}
