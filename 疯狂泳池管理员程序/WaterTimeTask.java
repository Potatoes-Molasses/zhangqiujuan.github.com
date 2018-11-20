package TimerTest;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * ���ڷ�ˮ��
 */
public class WaterTimeTask extends TimerTask {
	
	
	@Override
    public void run() {
       
		//�������еĳ���Ϊ100��ģ��Ӿ�ش�ˮ��
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
		
		//����3��עˮ�̣߳��ٶȾ�Ϊ5������/��
        InputThread thread1 = new InputThread(queue);
        InputThread thread3=new InputThread(queue);
        InputThread thread4=new InputThread(queue);
        
        //����2����ˮ�̣߳��ٶȾ�Ϊ3������/��
        OutputThread thread2 = new OutputThread(queue);
        OutputThread thread5 = new OutputThread(queue);
        
        //װ�����̵߳�����threadList
        List<Callable<Object>> threadList = new ArrayList<>(2);
        threadList.add(thread1);
        threadList.add(thread3);
        threadList.add(thread4);       
        threadList.add(thread2);
        threadList.add(thread5);
        
        //װ�����̷߳���ֵ��List
        List<Object> returnValue = null;
        try {        	
        	// ����һ����з���ֵ���̣߳�Ȼ���ɹ�����ͳһ�����������յ��߳����м��Ϸ���
            returnValue = ThreadUtil.runCheckCallable(threadList,true);
       
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
        //��ӡ����߳����м���
        System.out.println("Ӿ���Ѿ�ע��!");
        System.out.println(returnValue.get(0));
        System.out.println(returnValue.get(1));
        System.out.println(returnValue.get(2));
        System.out.println(returnValue.get(3));
        System.out.println(returnValue.get(4));
        
    }
}
