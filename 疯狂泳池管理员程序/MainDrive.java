package TimerTest;

import java.util.Calendar;
import java.util.Timer;

public class MainDrive {

    public static void main(String[] args) {
    	
    	//Calendarû�й����Ĺ��췽����Ҫ�õ������ã�����ʹ��new��Ҫ�����侲̬����getInstance�õ�һ��Calendar����
        Calendar calendar = Calendar.getInstance();
        
        //�õ�һ��Calendarʵ��������֮��getTime()��õ�ʱ��������ʵ��������ʱ��ʱ�䡣
        //��ˮʱ��Ϊ����10�� 
        calendar.set(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE),
                10,0,0
        );
        
       WaterTimeTask task = new WaterTimeTask();
       Timer timer = new Timer();
   
        //����ָ����������ָ����ʱ�� 10:00 ��ʼ�����ظ��Ĺ̶��ӳ� (һ��)ִ��
        timer.schedule(task,calendar.getTime(),1000*60*60*24);
       
    }
}
