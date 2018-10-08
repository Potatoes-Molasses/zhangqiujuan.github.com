import java.util.Random;
import java.util.Scanner;
/****
 * @description:猜数字小游戏类
 * @ClassName:GuessNum.java
 * @author Administrator
 * @version 1.00
 * @Date 2018-9-22 19:48:39
 */
public class GuessNum {
	public static void main(String[] args) {
		
		int guess=-1;//保存玩家猜的数字，初始化为-1
		int []score=new int [3];//成绩数组保存三个玩家的得分
		
		System.out.println("****大侠想猜几回合？****");
		Scanner input =new Scanner(System.in);		
		int num=input.nextInt();//获取回合数，为终止下面的循环做准备
		
		for(int j=1;j<=num;j++) {
			Random random=new Random();//随机产生一个0-9之间的整数
			int number=random.nextInt(10);
			//System.out.print(number);
			System.out.println("****请你猜猜0-9之间的一个整数---回合"+j+"****");
			for(int i=0;i<3;i++) {//for循环内 三个玩家轮流猜产生的随机数
				System.out.print("请玩家"+(i+1)+"猜:");
				 guess=input.nextInt();
				if(guess==number)//猜对加1分
					score[i]+=1;
			}
		}
		
		System.out.println("*********************************************");
		for(int i=0;i<score.length;i++) {//回合结束，计算最后得分
			System.out.print("玩家"+(i+1)+"得"+score[i]+"分   ");
		}
		System.out.println("\n*********************************************");
		
	}
}