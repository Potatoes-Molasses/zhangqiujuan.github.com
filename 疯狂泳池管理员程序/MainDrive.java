package TimerTest;

import java.util.Calendar;
import java.util.Timer;

public class MainDrive {

    public static void main(String[] args) {
    	
    	//Calendar没有公共的构造方法，要得到其引用，不能使用new，要调用其静态方法getInstance得到一个Calendar对象
        Calendar calendar = Calendar.getInstance();
        
        //得到一个Calendar实例化对象之后，getTime()获得的时间对象就是实例化对象时的时间。
        //换水时间为早上10点 
        calendar.set(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE),
                10,0,0
        );
        
       WaterTimeTask task = new WaterTimeTask();
       Timer timer = new Timer();
   
        //安排指定的任务在指定的时间 10:00 开始进行重复的固定延迟 (一天)执行
        timer.schedule(task,calendar.getTime(),1000*60*60*24);
       
    }
}
