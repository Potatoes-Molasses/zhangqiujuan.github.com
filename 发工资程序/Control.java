package effort;

import java.util.Random;
import java.util.Scanner;

/****
 * �������顿
 * ����һ�ҹ�˾���ԣ������ʺ͸��ָ����Ǳ���Ҫ���Ĺ���������ʵ��������ܡ�
 * ��Ҫ��
 * 1.��˾��Ա���������ɶ����ֽ�ɫ
 * 2.ÿ����ɫ�������������ʡ����յ�����
 * 3.ÿ��15�ŷ����ʣ���ͨԱ���������ʣ�������˹����⻹�е��½���
 * 4.��˾����Ϊ��Ӫҵ�������㣩��ȥȫ�깤��֧��
 * 5.�ɶ��йɷݣ�û�е��½��𣬵������շֺ죨12�·ݣ������շֺ�Ϊȫ�������10%��ȫ���ɶ����չɷݷֺ졣
 * 6.ȫ���ɶ��Ĺɷݼ�����ҪС�ڻ����100%
 * 7.ÿ�·�����ʱ����Ҫ�����¹����յ�Ա���;�������ɶ�û�����
 * ��ʵ�֡�
 * 1.Ա����Ϣ�ڳ�������ʱ����
 * 2.��Ҫ�������������µĹ������û�ָ��
 * 3.������Ϣ���ʱ��������Ա�����پ������ɶ���˳�����
 * ���Ľ������������ѯ����
 * 1.�����û������û���������ѯһ���û����еĹ��ʡ�����ͷֺ췢�ż�¼
 * 2.Ҳ���Բ鿴����Ա���Ĺ��ʡ�����ͷֺ췢�ż�¼
 * @author �����
 *
 */



/***
 * @project_name insist
 * @Package effort
 * @Title Control.java
 * @Description: ����Control��
 * @author �����
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 �����   ������򣬷ָ��
 *
 */

/****
 * @ClassName:Control
 * @Description:ʵ�ַ����ʵľ�������		
 * @author �����
 * @date 2018-10-14
 */


public class Control {
	
	public static void main(String []args) {
		
		/*���������Ӫҵ���Χ5��-14��*/
		Random random=new Random();
		double income=random.nextInt(10)*10000+50000;
		
		/*�����Ӫҵ��*/
		System.out.println("��Ӫҵ��:"+income);
		Scanner input=new Scanner(System.in);
		
		
		/*����ְ���б�*/
		PaySalary pay=new PaySalary();
		
		/*��������Ŀչ��캯����ǰ���ǻ�����пչ��캯��*/
		Staff staff=new Staff();
		
		/*����Ա����ͨ���������þ�̬����*/
		staff.addStaff(PaySalary.list);
		
		System.out.println("-----------------------------------------------------------------");
		
		 /*���Ӿ���*/
		 Manager manager=new Manager();
		 manager.addManager(PaySalary.list);
		 
		System.out.println("-----------------------------------------------------------------");

		/*���ӹɶ�*/
		Shareholder shareholder=new Shareholder();
		shareholder.addShareholder(PaySalary.list);
	
		
		/*������ְ����Ϣд��EmployeeMsg.txt�ļ���\\��ת���ַ�*/
		WriteTxt txt=new WriteTxt("F:\\Test\\EmployeeMsg.txt",PaySalary.list);
		txt.WriteMsg();
		
		/*������ְ����Ϣ��EmployeeMsg.txt�ļ��ж���*/
		ReadTxt readtxt=new ReadTxt("F:\\Test\\EmployeeMsg.txt");
		
		try {
			readtxt.getMap();
		}catch(Exception e) {
			
		}
		
		System.out.println("-----------------------------------------------------------------");
		/*�����ι���*/
		for(int i=0;i<2;i++) {
			
			pay.pay(income);
			
		}
		
		System.out.println("-----------------------------------------------------------------");
		
		/*������ְ�����ʼ�¼д��SalaryRecord.txt�ļ���\\��ת���ַ�*/
		WriteTxt txt1=new WriteTxt("F:\\Test\\SalaryRecord.txt",PaySalary.list);
		txt1.WriteSalary();
		
		/*������ְ�����ʼ�¼��SalaryRecord.txt�ļ��ж���*/
		ReadTxt readtxt1=new ReadTxt("F:\\Test\\SalaryRecord.txt");
		try {
		readtxt1.getMap();
		}catch(Exception e) {
			
		}
		
		/*����ְ������������ѯĳְ���Ĺ��ʼ�¼*/
		pay.findRecord();
		
	}
}
