public class test{
	public static void main(String[] args) {
		int nummax=99;
		int nummin=1;
		String word="bottels";//为区别单复数的不同，把该单词抽出来单独判断
		for(int i=nummax;i>=nummin;i--) {
			/*if(1==i){ //当i=2,i-1=1,下面的if把word修改后，i--,i=1,word值已是"bottle"不必多此一举
				word="bottle";//数最后一个瓶子时"bottles"要变成"bottle"
			}*/
			System.out.println("=================================================");
			System.out.println(i+" "+word+" of beer on the wall,"+i+" "+word+" of beer.");
			System.out.println(" Take one down.");
			System.out.println(" Pass it around.");
			if(1==(i-1)){//数倒数第二个瓶子，i-1为1，最后一句中"bottles"要变成"bottle"
				word="bottle";
			}
			System.out.println((i-1)+" "+word+" of beer on the wall.");
			System.out.println("=================================================\n");
			}		
		System.out.println("No more bottels of beer on the wall.");//此时1-99个瓶子已经数完，最后无瓶子可数，打印最后一句话
		
	}
}
/* 未抽出"bottles"的代码
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