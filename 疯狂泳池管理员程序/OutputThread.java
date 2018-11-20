package TimerTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 放水线程
 */
public class OutputThread implements Callable<Object>{

	//用阻塞队列模拟游泳池，长度为泳池容量
    private BlockingQueue<String> queue;

    public OutputThread(BlockingQueue queue){
        this.queue = queue;
    }

    //继承Callable接口，实现call方法
    @Override
    public Object call() throws InterruptedException {
        while(true){
        	//加锁，使线程同步
        	synchronized(queue) {
        		
        		//判断是否注满,注满则跳出while循环
        		if(queue.size()==100){
        			break;
        		}
        		
        		//for循环实现队列长度-3，实现放水
        		for(int cnt=0;cnt<3;cnt++){
        			//获取并移除头部元素
        			queue.poll();
        		}
        		System.out.println("放水3立方米，当前水量："+queue.size());
           
        		
        	}
        	 //线程休眠1ms，主动放弃时间片
        	 TimeUnit.MILLISECONDS.sleep(1);
        }
      //返回Object对象
        return "success";
    }
}
