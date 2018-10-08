import java.util.Scanner;
/****
 * @description:������
 * @ClassName:Car.java
 * @author Administrator
 * @version 1.00
 * @Date 2018-9-22 19:28:31
 */
public class Car{//���Ա������ʼ��
	private String name="����";//�����ͺ�
	private int tank=70;//�������� ��λL
	private double oilConsumption=6.3;//�ͺ� ��λL/�ٹ���
	
	/****
	 * ���ι��캯�� 
	 * @param name �ͺ�
	 * @param tank ��������
	 * @param oilConsumption �ͺ�
	 */
	
	public Car(String name,int tank,double oilConsumption) {
		this.name= name;
		this.tank=tank;
		this.oilConsumption=oilConsumption;
	}
	
	public Car(){//�չ��캯��
	
	}
	
	public String getName() {//��ȡ�����ͺ�
		return name;
	}
	
	public int getTank() {//��ȡ��������
		return tank;
	}
	
	public double getOilConsumption() {//��ȡ�ͺ�
		return oilConsumption;
	}
	
	public void addGas(int litre) {//���������������β�
		System.out.println("����"+litre+"��");
	}
	
	public void isRunning() {
		System.out.println("����");
	}
	
	
	public void display(Car car) {//�β�Ϊ���������car ��������get���� �õ���������ֵ
		System.out.print("�ͺ�:"+car.getName());
		System.out.print(" ��������:"+car.getTank()+"L");
		System.out.print(" �ͺ�:"+car.getOilConsumption()+"L/�ٹ���\n");
	}
	
	public static void main(String[] args) {
		System.out.print("��������������num:");//ȷ���������������ĳ���	
		Scanner input=new Scanner(System.in);	
		int num=input.nextInt();
		Car [] cars=new Car[num];
		
		System.out.println("������"+num+"̨�������ͺ� �����С �ͺ�:");//��ʾ�û�����

		for(int i=0;i<cars.length;i++) {//forѭ�� ���ζ�ȡÿ����������� 
			String name=input.next();
			int tank=input.nextInt();
			Double oilConsumption=input.nextDouble();
			cars[i]=new Car(name,tank,oilConsumption);//�������������,��ŵ�������
		}
		
		
		System.out.println("\n*****************************************");
		for(int i=0;i<cars.length;i++){//�������飬����display����չ�ָ���������
		cars[i].display(cars[i]);
		}
		System.out.println("*****************************************");
	}
}
