public class test{
	public static void main(String[] args) {
		int nummax=99;
		int nummin=1;
		String word="bottels";//Ϊ���𵥸����Ĳ�ͬ���Ѹõ��ʳ���������ж�
		for(int i=nummax;i>=nummin;i--) {
			/*if(1==i){ //��i=2,i-1=1,�����if��word�޸ĺ�i--,i=1,wordֵ����"bottle"���ض��һ��
				word="bottle";//�����һ��ƿ��ʱ"bottles"Ҫ���"bottle"
			}*/
			System.out.println("=================================================");
			System.out.println(i+" "+word+" of beer on the wall,"+i+" "+word+" of beer.");
			System.out.println(" Take one down.");
			System.out.println(" Pass it around.");
			if(1==(i-1)){//�������ڶ���ƿ�ӣ�i-1Ϊ1�����һ����"bottles"Ҫ���"bottle"
				word="bottle";
			}
			System.out.println((i-1)+" "+word+" of beer on the wall.");
			System.out.println("=================================================\n");
			}		
		System.out.println("No more bottels of beer on the wall.");//��ʱ1-99��ƿ���Ѿ����꣬�����ƿ�ӿ�������ӡ���һ�仰
		
	}
}
/* δ���"bottles"�Ĵ���
for(int i=nummax;i>=nummin;i--) {
			if(1==i){
					System.out.println("=================================================\n");
					System.out.println(i+" bottle of beer on the wall,"+i+" bottle of beer.");
					System.out.println(" Take one down.");
					System.out.println(" Pass it around.");
					System.out.println((i-1)+" bottle of beer on the wall.");
					System.out.println("=================================================\n");
			}else {
					System.out.println("=================================================\n");
				    System.out.println(i+" bottles of beer on the wall,"+i+" bottles of beer.");
				    System.out.println(" Take one down.");
				    System.out.println(" Pass it around.");
				    if(1==(i-1)) {
						System.out.println((i-1)+" bottle of beer on the wall.");
					}else {
						System.out.println((i-1)+" bottles of beer on the wall.");
					}
				   
				    System.out.println("=================================================\n");
			}
		}

*/