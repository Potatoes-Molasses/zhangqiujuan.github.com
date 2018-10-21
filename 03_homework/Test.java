package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*结论:
 * 根据循环的内容来选择，如果只是处理一个结果，那么出现异常，直接抛出，就不必再继续循环，这时应把try catch 放循环体外;
 * 如果是一个服务器线程维持一直处理其它线程产生的数据，为了保证系统的稳定性，就必须把try catch 放循环体内。 
 * */
public class Test {
	
	public static void main(String []args) {
		/*1.try catch 放循环体内，抛出10个异常信息，表明在执行中抛出异常会继续循环，如果循环次数过多，可能导致内存溢出*/
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		List<Date>list=new ArrayList<>(10);{
			for(int cnt=0;cnt<10;cnt++) {
				try {
					Date date=dateformat.parse("09-12");
					list.add(date);
			
				}catch(ParseException e) {
					e.printStackTrace();
				}
			}
	
		}

		/*2.try catch 放循环体外，抛出1个异常信息，循环内容抛出异常的话，就直接跳出了循环*/
		SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd");
		List<Date>list1=new ArrayList<>(10);
		{
			try{
				for(int cnt=0;cnt<10;cnt++) {
					Date date=dateformat1.parse("09-12");
					list1.add(date);
  
				}
			}catch(ParseException e){
			
				e.printStackTrace();
			}
 
		}
 
	}
}
