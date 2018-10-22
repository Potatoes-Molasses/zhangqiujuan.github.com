package communication;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*������:
 *���˷�����֮�⣬�Ӵ�Ҳ�ǹ�˾��һ����Ҫ֧����
 *�Ӵ���Ҫ�ǽ��������Ա�ĳ�ס�������⣬ͬʱҪ�����������ѡ�
 *�Ӵ�ʱ���ղ�ͬ���𣬳�ס�еı�����׼Ҳ��һ������Ҫ����Դ���
 *
 *����Ҫ��:
 *1.���һ���ӿڣ����г�ס������������
 *2.�ֱ��дѧ������ʦ���ҳ�����ʵ���࣬ʵ�������ӿڡ�
 *3.��дһ���ܿ����࣬���û���������ء�Ŀ�ĵغͽӴ�����������Ϣ���Զ����㲢���ÿһ�����ͻ��ѵķ�����ϸ���ܺ͡�
 *
 *������չ:
 *1.��ʱ�����ǻ���Ҫ�Ӵ�һЩ�߼���ķÿͣ���Щ�ÿͳ��˳�ס���⣬����Ҫ�����
 *2.��д��һ���ӿڣ��ýӿڶ���һ��������ķ�����
 *3.��д�쵼���������ʵ���࣬������ʵ����Ҫʵ�����ϵ������ӿڣ������ռ���ͬ���ͼ�ֵ���ȵ����
 * */


/***
 * @project_name insist
 * @Package communication
 * @Title Control.java
 * @Description: ����Control��
 * @author �����
 * @date 2018-10-20
 * @version v1.0
 * @update 01 2018-10-20 �����  
 *
 */


/****
 * @ClassName: Control
 * @Description:���û���������ء�Ŀ�ĵغͽӴ�����������Ϣ���Զ����㲢���ÿһ�����ͻ��ѵķ�����ϸ���ܺ�
 * @author �����
 * @date 2018-10-20
 */







public class Control {
	
	/***
	 * @Fields �г��б�
	 */
	
	private static Map<String,Double>list=new HashMap();
	
	
	/**   
	 * @Title:add
	 * @Description:����г̵��г��б���
	 * @return: void
	 * @throws   
	 */  
	
	public void add() {
		
		/*Key Ϊ�г̣�ValueΪ���̳���*/
		list.put("����-�Ϻ�", new Double(553));
		list.put("����-�Ϻ�", new Double(478));
		list.put("����-�Ϻ�", new Double(585));
		list.put("�Ͼ�-�Ϻ�", new Double(50));
		list.put("�人-�Ϻ�", new Double(320));
		list.put("�Ϸ�-�Ϻ�", new Double(180));

	}
	
	/**   
	 * @Title:getFare
	 * @Description:��ȡ�г̵���������
	 * @param: from ������
	 * @param: destination Ŀ�ĵ�
	 * @return: double
	 * @throws   
	 */  
	
	public double getFare(String from,String destination) {
		
		/*���ݳ����غ�Ŀ�ĵأ�����Key*/
		String trip=from+"-"+destination;
		double	fare=0;
		
	    /*�����г��б�ƥ����г�*/
		for(Map.Entry<String, Double> entry:list.entrySet()) {
			
			/*�г�ƥ�䣬��ȡ��������*/
			if(trip.equals(entry.getKey()))
			{ 
			
				fare=entry.getValue()*2;
			}else {
				
			/*��ƥ�䣬�����˴�ѭ��������ƥ��*/
				continue;
				
			}
		}
		
		return fare;
	}
	
	public static void main(String []args) {
		
		/*�½�control����*/
		Control control=new Control();
		Scanner input=new Scanner(System.in);
		
		/*��ʾ�û����룬��ȡ�û�����*/
		System.out.println("����������ء�Ŀ�ĵء��Ӵ�����:");
		String from=input.next();
		String destination=input.next();
		int days=input.nextInt();
		
		/*�����г��б�*/
		control.add();
		
		/*�õ���������*/
		double fare=control.getFare(from, destination);
		
		/*����ѧ���������÷�������Ϊѧ��*/
		Student student=new Student("ѧ��");
		
		/*����DecimalFormat�������ڸ�ʽ�����double�ͱ���*/
		DecimalFormat df=new DecimalFormat(".00");
		
		/*����ѧ�����͵ĳ�ס�еı������ú�*/
		double tatal1=student.eat(days)+student.accommodate(days)+student.travel(fare);
		
		System.out.println("\n"+student.getType()+" �����ͷѣ�"+df.format(student.eat(days))+"  ����ס�޷ѣ�"+df.format(student.accommodate(days))+
							" �������ѣ�"+df.format(student.travel(fare))+" �ܼƣ�"+df.format(tatal1));
		
		/*������ʦ�������÷�������Ϊ��ʦ*/
		Teacher teacher=new Teacher("��ʦ");
		
		/*�����ʦ���͵ĳ�ס�еı������ú�*/
		double tatal2=teacher.eat(days)+teacher.accommodate(days)+teacher.travel(fare);
		
		System.out.println(teacher.getType()+" �����ͷѣ�"+df.format(teacher.eat(days))+"  ����ס�޷ѣ�"+df.format(teacher.accommodate(days))+
							" �������ѣ�"+df.format(teacher.travel(fare))+" �ܼƣ�"+df.format(tatal2));
		
		/*�����ҳ��������÷�������Ϊ�ҳ�*/
		Patriarch patriarch=new Patriarch("�ҳ�");
		
		/*����ҳ����͵ĳ�ס�еı������ú�*/
		double tatal3=patriarch.eat(days)+patriarch.accommodate(days)+patriarch.travel(fare);
		
		System.out.println(patriarch.getType()+" �����ͷѣ�"+df.format(patriarch.eat(days))+"  ����ס�޷ѣ�"+df.format(patriarch.accommodate(days))+
							" �������ѣ�"+df.format(patriarch.travel(fare))+" �ܼƣ�"+df.format(tatal3));
		
		System.out.println("\n--------------------------------------------------------------------------\n");
		
		
		/*�����쵼�������÷�������Ϊ�쵼*/
		Leader leader=new Leader("�쵼");
		
		/*�����쵼���͵ĳ�ס�еı������ú�*/
		double tatal4=leader.eat(days)+leader.accommodate(days)+leader.travel(fare);
		
		System.out.println(leader.getType()+" �����ͷѣ�"+df.format(leader.eat(days))+"  ����ס�޷ѣ�"+df.format(leader.accommodate(days))+
							" �������ѣ�"+df.format(leader.travel(fare))+" �ܼƣ�"+df.format(tatal4));
		
		/*���쵼�ַ�����*/
		leader.giveGift();
		
		/*��������������÷�������Ϊ���*/
		Guest guest=new Guest("���");
		
		/*����������͵ĳ�ס�еı������ú�*/
		double tatal5=guest.eat(days)+guest.accommodate(days)+guest.travel(fare);
		
		System.out.println(guest.getType()+" �����ͷѣ�"+df.format(guest.eat(days))+"  ����ס�޷ѣ�"+df.format(guest.accommodate(days))+
							" �������ѣ�"+df.format(guest.travel(fare))+" �ܼƣ�"+df.format(tatal5));
		/*������ַ�����*/
		guest.giveGift();
	
	}
	
}

/**********************���н��*****************************
 ����������ء�Ŀ�ĵء��Ӵ�����:
���� �Ϻ� 2

ѧ�� �����ͷѣ�100.00  ����ס�޷ѣ�80.00 �������ѣ�553.00 �ܼƣ�733.00
��ʦ �����ͷѣ�800.00  ����ס�޷ѣ�480.00 �������ѣ�884.80 �ܼƣ�2164.80
�ҳ� �����ͷѣ�420.00  ����ס�޷ѣ�280.00 �������ѣ�774.20 �ܼƣ�1474.20

--------------------------------------------------------------------------

�쵼 �����ͷѣ�3000.00  ����ס�޷ѣ�2000.00 �������ѣ�1106.00 �ܼƣ�6106.00
�쵼���ã����͸߼�������һ��!
��� �����ͷѣ�1600.00  ����ס�޷ѣ�1000.00 �������ѣ�1106.00 �ܼƣ�3706.00
������ã����ͱ����ز�һ�ݣ�
*/

/*********************�������*****************************
 * �������Ϻ����س��ѹ���1106
 * �涨ѧ���ÿ�һ��ͷ�100Ԫ���ù�Ϊ80Ԫ/��������ס�е�50%
 * �涨��ʦ�ÿ�һ��ͷ�500Ԫ���ù�Ϊ300Ԫ/��������ס�е�80%
 * �涨�ҳ��ÿ�һ��ͷ�300Ԫ���ù�Ϊ200Ԫ/��������ס�е�70%
 * �涨�쵼�ÿ�һ��ͷ�1500Ԫ���ù�Ϊ1000Ԫ/��������ס�е�100%
 * �涨����ÿ�һ��ͷ�800Ԫ���ù�Ϊ500Ԫ/��������ס�е�100%
 * 
 * ѧ����100*2*0.5+80*2*0.5+1106*0.5=733.00
 * ��ʦ��500*2*0.8+300*2*0.8+1106*0.8 =2164.80
 * �ҳ���300*2*0.7+200*2*0.7+1106*0.7=1474.20
 * �쵼��1500*2*1+1000*2*1+1106*1=6106.00
 * �����800*2*1+500*2*1+1106*1=3706.00
 * 
 */






























