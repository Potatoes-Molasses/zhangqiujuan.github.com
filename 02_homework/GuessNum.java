import java.util.Random;
import java.util.Scanner;
/****
 * @description:������С��Ϸ��
 * @ClassName:GuessNum.java
 * @author Administrator
 * @version 1.00
 * @Date 2018-9-22 19:48:39
 */
public class GuessNum {
	public static void main(String[] args) {
		
		int guess=-1;//������Ҳµ����֣���ʼ��Ϊ-1
		int []score=new int [3];//�ɼ����鱣��������ҵĵ÷�
		
		System.out.println("****������¼��غϣ�****");
		Scanner input =new Scanner(System.in);		
		int num=input.nextInt();//��ȡ�غ�����Ϊ��ֹ�����ѭ����׼��
		
		for(int j=1;j<=num;j++) {
			Random random=new Random();//�������һ��0-9֮�������
			int number=random.nextInt(10);
			//System.out.print(number);
			System.out.println("****����²�0-9֮���һ������---�غ�"+j+"****");
			for(int i=0;i<3;i++) {//forѭ���� ������������²����������
				System.out.print("�����"+(i+1)+"��:");
				 guess=input.nextInt();
				if(guess==number)//�¶Լ�1��
					score[i]+=1;
			}
		}
		
		System.out.println("*********************************************");
		for(int i=0;i<score.length;i++) {//�غϽ������������÷�
			System.out.print("���"+(i+1)+"��"+score[i]+"��   ");
		}
		System.out.println("\n*********************************************");
		
	}
}