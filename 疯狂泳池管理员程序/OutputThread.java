package TimerTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * ��ˮ�߳�
 */
public class OutputThread implements Callable<Object>{

	//����������ģ����Ӿ�أ�����ΪӾ������
    private BlockingQueue<String> queue;

    public OutputThread(BlockingQueue queue){
        this.queue = queue;
    }

    //�̳�Callable�ӿڣ�ʵ��call����
    @Override
    public Object call() throws InterruptedException {
        while(true){
        	//������ʹ�߳�ͬ��
        	synchronized(queue) {
        		
        		//�ж��Ƿ�ע��,ע��������whileѭ��
        		if(queue.size()==100){
        			break;
        		}
        		
        		//forѭ��ʵ�ֶ��г���-3��ʵ�ַ�ˮ
        		for(int cnt=0;cnt<3;cnt++){
        			//��ȡ���Ƴ�ͷ��Ԫ��
        			queue.poll();
        		}
        		System.out.println("��ˮ3�����ף���ǰˮ����"+queue.size());
           
        		
        	}
        	 //�߳�����1ms����������ʱ��Ƭ
        	 TimeUnit.MILLISECONDS.sleep(1);
        }
      //����Object����
        return "success";
    }
}
