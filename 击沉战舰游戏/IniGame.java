package insist;

import java.util.ArrayList;
import java.util.Random;

/***
 * @project_name ����ս����Ϸ
 * @Package insist
 * @Title IniGame.java
 * @Description: ������Ϸ��ʼ���� 
 * @author �����
 * @date 2018-10-3
 * @version v1.0
 * @update 01 2018-10-3 �����  ����������ս��������
 *
 */

/****
 * @ClassName:Warship
 * @Description:������ҵ÷ֺ�����ս��
 * 			����:	1.�÷�
 * 					2.����
 * 
 * 			����:	1.����÷�checkScore()
 * 					2.�������ս��generateWarship()
 * 				
 * @author �����
 * @date 2018-10-3
 */


public class IniGame {
	
	/***
	 * @Fields �÷� 
	 */
	int score;

	/***
	 * @Fields 7*7����
	 */
	
	String[][] battleground= {
				
				{"A1","A2","A3","A4","A5","A6","A7"},
				{"B1","B2","B3","B4","B5","B6","B7"},
				{"C1","C2","C3","C4","C5","C6","C7"},
				{"D1","D2","D3","D4","D5","D6","D7"},
				{"E1","E2","E3","E4","E5","E6","E7"},
				{"F1","F2","F3","F4","F5","F6","F7"},
				{"G1","G2","G3","G4","G5","G6","G7"}
		};
		
		
	/**   
	 * @Title:checkScore
	 * @Description:�������÷�
	 * @param: firerecord ��ҵĿ�����ϸ
	 * @return: int
	 * @throws   
	 */  
	public int checkScore(ArrayList<String> firerecord) {
		//��ʼ�÷�Ϊ 0
		score=0;
		
		//������¼ս��״̬��ArrayList
		for(String s:firerecord) {
			
			//����¼������Hit/Sunk ����1�� 
			//˵��:�����λ���ʱ������״̬ΪHit�� �ж�λ��Ϊ��ʱ����״̬ΪSunk��������״̬���ص������
			if(s.equals("Hit")||s.equals("Sunk")) {
				
				score=score+1;
			}
			//����¼������Miss ��1��
			if(s.equals("Miss")) {
				
				score=score-1;
			}
		}
		//����÷�
		System.out.println("\nThe score is "+score+"."); 
			
		return score;
	}
	
	
	/**   
	 * @Title:generateWarship
	 * @Description:�������һ�ҳ���Ϊ3��ս�� 
	 * @return: Warship
	 * @throws   
	 */  
	
	
	public Warship generateWarship() {
		
		Warship warship=new Warship();
		//ս���ĺ�������
		int x=0,y=0;
		
		Random random1=new Random();
		Random random2=new Random();
		
		//����һ������� ��ȷ��ս���Ǻ��� ��������
		int random=(int)(Math.random()*100);
	 	
	 	//�����random��Ϊż������ս���Ǻ��ŵ�
	 	if(random%2==0) {
	 		
	 		//�������һ��[0,5)֮���������x ��ʹx�������
	 		x=random1.nextInt(5);
	 		
	 		//�������һ��[0,7)֮���������y
	 		y=random2.nextInt(7);
	 		
	 		//ȷ��ս��λ��
	 		warship.addLocation(battleground[x][y]);
	 		warship.addLocation(battleground[x+1][y]);
	 		warship.addLocation(battleground[x+2][y]);
	 		
	 	}else {
	 		//�����random��Ϊ��������ս�������ŵ�
	 		//�������һ��[0,7)֮���������x 
	 		x=random1.nextInt(7);
	 		
	 		//�������һ��[0,5)֮���������y ��ʹy�������
	 		y=random2.nextInt(5);
	 		
	 		//ȷ��ս��λ��
	 		warship.addLocation(battleground[x][y]);
	 		warship.addLocation(battleground[x][y+1]);
	 		warship.addLocation(battleground[x][y+2]);

	 	}
	
	 	//��ӡ���ս����λ�ã���������
	 	if(!warship.arraylistIsEmpty()) {
	 		System.out.print("The warship is situated in ");
	 		
	 		for(int i=0;i<3;i++){
           
	 			System.out.print(warship.location.get(i)+" ");
	 		}
	 		System.out.print(".\n");
	 	}
	 	return warship;
	}
		
}
     
	