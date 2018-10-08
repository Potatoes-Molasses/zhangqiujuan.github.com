import java.util.Scanner;
/****
 * @description:汽车类
 * @ClassName:Car.java
 * @author Administrator
 * @version 1.00
 * @Date 2018-9-22 19:28:31
 */
public class Car{//类成员变量初始化
	private String name="福特";//汽车型号
	private int tank=70;//油箱容量 单位L
	private double oilConsumption=6.3;//油耗 单位L/百公里
	
	/****
	 * 含参构造函数 
	 * @param name 型号
	 * @param tank 油箱容量
	 * @param oilConsumption 油耗
	 */
	
	public Car(String name,int tank,double oilConsumption) {
		this.name= name;
		this.tank=tank;
		this.oilConsumption=oilConsumption;
	}
	
	public Car(){//空构造函数
	
	}
	
	public String getName() {//获取汽车型号
		return name;
	}
	
	public int getTank() {//获取油箱容量
		return tank;
	}
	
	public double getOilConsumption() {//获取油耗
		return oilConsumption;
	}
	
	public void addGas(int litre) {//汽车加油升数作形参
		System.out.println("加油"+litre+"升");
	}
	
	public void isRunning() {
		System.out.println("能跑");
	}
	
	
	public void display(Car car) {//形参为汽车类对象car 调用三个get函数 得到三个属性值
		System.out.print("型号:"+car.getName());
		System.out.print(" 油箱容量:"+car.getTank()+"L");
		System.out.print(" 油耗:"+car.getOilConsumption()+"L/百公里\n");
	}
	
	public static void main(String[] args) {
		System.out.print("请输入汽车个数num:");//确定汽车类对象数组的长度	
		Scanner input=new Scanner(System.in);	
		int num=input.nextInt();
		Car [] cars=new Car[num];
		
		System.out.println("请输入"+num+"台汽车的型号 油箱大小 油耗:");//提示用户输入

		for(int i=0;i<cars.length;i++) {//for循环 依次读取每个对象的属性 
			String name=input.next();
			int tank=input.nextInt();
			Double oilConsumption=input.nextDouble();
			cars[i]=new Car(name,tank,oilConsumption);//构造汽车类对象,存放到数组中
		}
		
		
		System.out.println("\n*****************************************");
		for(int i=0;i<cars.length;i++){//遍历数组，调用display函数展现各汽车属性
		cars[i].display(cars[i]);
		}
		System.out.println("*****************************************");
	}
}
