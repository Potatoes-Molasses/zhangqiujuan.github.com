package TimerTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 注水线程
 */
public class InputThread implements Callable<Object>{

	//用阻塞队列模拟游泳池，长度为泳池容量
    private BlockingQueue<String> queue;

    public InputThread(BlockingQueue queue){
        this.queue = queue;
    }

    //继承Callable接口，实现call方法
    @Override
    public Object call() throws InterruptedException {
        
    	while(true){
    		//加锁，使线程同步
    		synchronized(queue) {
    			
    			boolean flag = true;
                //注水5立方米，即让队列长度+5
                for(int cnt=0;cnt<5;cnt++){
                	
                	//插入元素,立即返回 成功则返回true,失败则返回false
                    flag = queue.offer("加一立方米");
                    
                    //若插入失败，即在注入5立方米的水的过程中,泳池满了,则跳出for循环
                    if(!flag){
                        break;
                    }
                }
                System.out.println("注水5立方米，当前水量："+queue.size());
               
                //若插入失败，则跳出while循环
                if(!flag){
                    break;
                }
                
    		}
    		 //线程休眠1ms，主动放弃时间片
            TimeUnit.MILLISECONDS.sleep(1);
        }
    	//返回Object对象
        return "success";
    }
}
