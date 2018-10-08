package insist;

import java.util.Scanner;

/*
 * ���󣺻���ս����Ϸ
 * 	��1����Ϸ��ʼ��������7*7�����̣�����������һ��ս��������Ϊ3��
 * 	��2����Ҳ²�ս��λ�ã������ڹ���
 * 	��3�����ݼ�����Ļ�������ʾ�������Hit/Sunk(+1��)��Miss(-1��)
 * 	��4�����һֱ�²⣬ֱ���������Σ�ս����û
 * 	��5��ͳ�Ƶ÷֣���Ϸ����
 * ������
 * 	��1���ֱ����ս���ࡢ����ࡢ��Ϸ��ʼ���ࡢ��ʼ��Ϸ�����ƣ���
 * 	��2���������������ս��λ��
 * 	��3��ʹ��ArrayList����ط�������ɹ�����ͳ�Ƶ÷�
 * 	��4������״̬��־������ʾ
 */




/***
 * @project_name ����ս����Ϸ
 * @Package insist
 * @Title StartGame.java
 * @Description: ���忪ʼ��Ϸ��
 * @author �����
 * @date 2018-10-3
 * @version v1.0
 * @update 01 2018-10-3 �����  ϸ����������
 *
 */

/***
 * @ClassName:StartGame
 * @Description:������Ϸ����			
 * @author �����
 * @date 2018-10-3
 */

public class StartGame {
	
	public static void main(String[] args) {
		
		//�ȳ�ʼ����Ϸ������ս�����ٶ������

		IniGame game=new IniGame();
		Warship warship=game.generateWarship();
		Player player=new Player();
		
		//��ս����ռ�ݵ��������Ӷ�û���������������Ϸ
		while(!warship.arraylistIsEmpty()) {
			
			//ÿ�α�������ʱ������״̬ΪMiss
			warship.status="Miss";
			
			//��ʾ��Ҳ²�ս��λ��
			System.out.print("Input yuor target: ");
			Scanner input=new Scanner(System.in);
			String str=input.next();
			
			//ȷ��λ�ú���ҿ��ڹ��������Ѽ�¼���뵽������ϸ��
			player.attack(warship,str);
			player.addRecord(warship.status);			
			
			
		}
		
		//���ͳ����ϸ�е�״̬������÷֣���Ϸ����
		
		/*������
		 for(int i=0;i<player.firerecord.size();i++) {
		System.out.print("\n"+player.firerecord.get(i)+" ");
		}
		*/
		game.checkScore(player.firerecord);
		
	}
	
}
