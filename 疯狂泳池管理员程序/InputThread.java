package TimerTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * עˮ�߳�
 */
public class InputThread implements Callable<Object>{

	//����������ģ����Ӿ�أ�����ΪӾ������
    private BlockingQueue<String> queue;

    public InputThread(BlockingQueue queue){
        this.queue = queue;
    }

    //�̳�Callable�ӿڣ�ʵ��call����
    @Override
    public Object call() throws InterruptedException {
        
    	while(true){
    		//������ʹ�߳�ͬ��
    		synchronized(queue) {
    			
    			boolean flag = true;
                //עˮ5�����ף����ö��г���+5
                for(int cnt=0;cnt<5;cnt++){
                	
                	//����Ԫ��,�������� �ɹ��򷵻�true,ʧ���򷵻�false
                    flag = queue.offer("��һ������");
                    
                    //������ʧ�ܣ�����ע��5�����׵�ˮ�Ĺ�����,Ӿ������,������forѭ��
                    if(!flag){
                        break;
                    }
                }
                System.out.println("עˮ5�����ף���ǰˮ����"+queue.size());
               
                //������ʧ�ܣ�������whileѭ��
                if(!flag){
                    break;
                }
                
    		}
    		 //�߳�����1ms����������ʱ��Ƭ
            TimeUnit.MILLISECONDS.sleep(1);
        }
    	//����Object����
        return "success";
    }
}
