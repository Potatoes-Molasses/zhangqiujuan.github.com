package insist;

import java.util.ArrayList;


/***
 * @project_name ����ս����Ϸ
 * @Package insist
 * @Title Player.java
 * @Description: ����� 
 * @author �����
 * @date 2018-10-3
 * @version v1.0
 * @update 01 2018-10-3 �����  ����Ƴ�ս��λ��ʱ�׳��쳣������
 *
 */

/****
 * @ClassName:Player
 * @Description:���������
 * 			����:	������ϸ ��¼���ÿ�ο����ս��������״̬
 * 
 * 			����:	1.ÿ�ο�������Ӽ�¼����ϸ��
 *					2.�ڻ�����
 * 				
 * @author �����
 * @date 2018-10-3
 */


public class Player {

	/***
	 * @Fields ��¼���п�����ϸ
	 */
	
	ArrayList<String>firerecord=new ArrayList<String>();
	
	/**   
	 * @Title: addRecord
	 * @Description:�����ڻ���¼��������ϸ��
	 * @param: loca ������
	 * @return: void
	 * @throws   
	 */  
	
	
	public void addRecord(String loca) {
		firerecord.add(loca);
	}
	
	
	/**   
	 * @Title: attack
	 * @Description:����ս���Ľ���жϣ��������ʾ
	 * @param: warship Ҫ������ս��
	 * @param: str Ҫ�����ĸ���
	 * @return: void
	 * @throws   
	 */  
	
	public void attack(Warship warship,String str) {
		
		
		/*list��ɾ����ʱ�򣬻��׳��쳣
		 * ��һ:���Ƶ���һ���ϣ�����һ������ɾ��
		 * ����:����for
		 */
		
		for(int i=0;i<warship.location.size();i++) {
			
			//��ȡս����ռ�ݵĸ�������
			String state=warship.location.get(i);
			
			//����Ҳ²�ĸ��ӱȽ�
			if(str.equals(state)) {
				
				//���1.��ͬ�����
				//����:�Ƴ������е�λ�� ��ս��״̬ΪHit
				System.out.print("---------------------- [Hit!]\n");
			
				warship.location.remove(state);
				warship.status="Hit";
				
				//���2.�������У��Ҵ�ʱlocation�еĸ��Ӷ��ѱ��Ƴ�
				//����: ��ս��״̬ΪSunk
				if(warship.arraylistIsEmpty()) {
					System.out.print("***********[Sunk!]***********\n");
					warship.status="Sunk";
				}	
			}
			
		}
		
		//���3.����ͬ����ս��û������
		//����:��ʾMiss
		if(warship.status.equals("Miss")) {
		
		System.out.print("---------------------- [Miss!]\n");
		
		}
	}

}	




















	  
	/* *  for(Boat bot:boats){//�����洢Boat�����ArrayList              
             for(String st:bot.getBoatString()){ //�����洢Boat�����ArrayList�еģ�ÿ���洢String���Ͷ����Arraylist               
                 if(st.equals(str)){
                     System.out.println("You have hit "+bot.boatName+"!!");
                     bot.getBoatString().remove(st); //���к�boat�еĻ���λ��ɾȥ
                     if(bot.getBoatString().isEmpty()){
                         System.out.println("OH GOD!You have sunk "+bot.boatName+"!!\nLet's sink next boat!\n");
                         boats.remove(bot);//�Ӵ洢Boat�����Arraylist�У�ɾȥĳ��������λ�ö����еĴ�����
                     }
                     ber=true;
                     berHit=false;
                     break;
                 }

             }
             if(ber){//������һֻ����ֱ����������ѭ��
                 ber=false;
                 break;
             }               
         }                                               
            if(berHit){//δ������ʾ
                System.out.println("Good hit,but..you missed (T^T)\nCome on! try again! :) ");
            }
     }
     //��Ϸ����
     System.out.println("After "+tryTimes+" times hits\nI can't believe it...\n OMG!!YOU HAVE WON �I(^��^)�J!!!!");         
     scan.close();           
	 */
	
	

