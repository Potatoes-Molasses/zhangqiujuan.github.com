public class test1{
	public static void main(String[] args) {
		String a="java";//�ڴ����ҳ����أ����û�У��ͻ��ڳ������п���һ���ڴ�ռ䣬��ָ�븳��ջָ�룻
		//����Ѿ����ˣ���ֱ�Ӱѵ�ַ����ջָ��
		String c=a;//cΪa�����ã�ָ��ͬһ������"java"		
		System.out.println("�жϵ�ַ�Ƿ���ͬ��"+(a==c));
		System.out.println("value of a: "+a);
		System.out.println("value of c: "+c);
		System.out.println("address of a: "+a.hashCode());//.java����JVM�����еģ�ֻ�ܲ鿴JVM�е�ַ�Ĺ�ϣ��
		System.out.println("address of c: "+c.hashCode());//a cָ��ͬһ����ַ
		System.out.println("=============================================");
		c="abc";//�޸�c��ֵ��,cָ�������е���һ��ֵΪ"abc"�Ķ����ַ����a��ָ��"java"����
		System.out.println("�жϵ�ַ�Ƿ���ͬ��"+(a==c));
		System.out.println("value of a': "+a);
		System.out.println("value of c': "+c);
		System.out.println("address of a': "+a.hashCode());
		System.out.println("address of c': "+c.hashCode());
		
		String m=new String("zhang");//��new String�������ַ������ǳ����������ڱ����ھ�ȷ����
		//��new String�������ַ��������ڳ������У������Լ����Լ��ĵ�ַ�ռ�
		String n="zhang";
		
		System.out.println("=============================================");
		System.out.println("�жϵ�ַ�Ƿ���ͬ��"+(m==n));//�Ƚϵ�ַ�Ƿ���ͬ new���ڶ��п��ٿռ䣬ֱ�Ӹ�ֵ���ڷ������п��ٿռ�
		System.out.println("value of m: "+m);
		System.out.println("value of n: "+n);
		System.out.println("address of m: "+m.hashCode());
		System.out.println("address of n: "+n.hashCode());
}
}