public class test1{
	public static void main(String[] args) {
		String a="java";//内存会查找常量池，如果没有，就会在常量池中开辟一块内存空间，把指针赋给栈指针；
		//如果已经有了，则直接把地址赋给栈指针
		String c=a;//c为a的引用，指向同一个常量"java"		
		System.out.println("判断地址是否相同："+(a==c));
		System.out.println("value of a: "+a);
		System.out.println("value of c: "+c);
		System.out.println("address of a: "+a.hashCode());//.java是在JVM上运行的，只能查看JVM中地址的哈希码
		System.out.println("address of c: "+c.hashCode());//a c指向同一个地址
		System.out.println("=============================================");
		c="abc";//修改c的值后,c指向常量池中的另一个值为"abc"的对象地址，而a仍指向"java"常量
		System.out.println("判断地址是否相同："+(a==c));
		System.out.println("value of a': "+a);
		System.out.println("value of c': "+c);
		System.out.println("address of a': "+a.hashCode());
		System.out.println("address of c': "+c.hashCode());
		
		String m=new String("zhang");//用new String创建的字符串不是常量，不能在编译期就确定，
		//故new String创建的字符串不放在常量池中，他们自己有自己的地址空间
		String n="zhang";
		
		System.out.println("=============================================");
		System.out.println("判断地址是否相同："+(m==n));//比较地址是否相同 new是在堆中开辟空间，直接赋值是在方法区中开辟空间
		System.out.println("value of m: "+m);
		System.out.println("value of n: "+n);
		System.out.println("address of m: "+m.hashCode());
		System.out.println("address of n: "+n.hashCode());
}
}