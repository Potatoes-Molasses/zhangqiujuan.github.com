package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*����:
 * ����ѭ����������ѡ�����ֻ�Ǵ���һ���������ô�����쳣��ֱ���׳����Ͳ����ټ���ѭ������ʱӦ��try catch ��ѭ������;
 * �����һ���������߳�ά��һֱ���������̲߳��������ݣ�Ϊ�˱�֤ϵͳ���ȶ��ԣ��ͱ����try catch ��ѭ�����ڡ� 
 * */
public class Test {
	
	public static void main(String []args) {
		/*1.try catch ��ѭ�����ڣ��׳�10���쳣��Ϣ��������ִ�����׳��쳣�����ѭ�������ѭ���������࣬���ܵ����ڴ����*/
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

		/*2.try catch ��ѭ�����⣬�׳�1���쳣��Ϣ��ѭ�������׳��쳣�Ļ�����ֱ��������ѭ��*/
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
