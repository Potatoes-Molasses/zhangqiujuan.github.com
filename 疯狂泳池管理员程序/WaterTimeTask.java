package TimerTest;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * 定期放水类
 */
public class WaterTimeTask extends TimerTask {
	
	
	@Override
    public void run() {
       
		//阻塞队列的长度为100，模拟泳池储水量
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
		
		//创建3个注水线程，速度均为5立方米/秒
        InputThread thread1 = new InputThread(queue);
        InputThread thread3=new InputThread(queue);
        InputThread thread4=new InputThread(queue);
        
        //创建2个放水线程，速度均为3立方米/秒
        OutputThread thread2 = new OutputThread(queue);
        OutputThread thread5 = new OutputThread(queue);
        
        //装所有线程的链表threadList
        List<Callable<Object>> threadList = new ArrayList<>(2);
        threadList.add(thread1);
        threadList.add(thread3);
        threadList.add(thread4);       
        threadList.add(thread2);
        threadList.add(thread5);
        
        //装所有线程返回值的List
        List<Object> returnValue = null;
        try {        	
        	// 传入一组带有返回值的线程，然后由工具类统一管理，并把最终的线程运行集合返回
            returnValue = ThreadUtil.runCheckCallable(threadList,true);
       
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
        //打印输出线程运行集合
        System.out.println("泳池已经注满!");
        System.out.println(returnValue.get(0));
        System.out.println(returnValue.get(1));
        System.out.println(returnValue.get(2));
        System.out.println(returnValue.get(3));
        System.out.println(returnValue.get(4));
        
    }
}
