package TimerTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * �̹߳�������
 */
public class ThreadUtil {

    private static ExecutorService exec;
    /**
     * �̳߳ع�����
     * ����һ����з���ֵ���̣߳�Ȼ���ɹ�����ͳһ�����������յ��߳����м��Ϸ���
     * @param list       �̼߳���
     * @param isBlock    �Ƿ�������ʾλ�����Ϊfalse�����߳��������������أ�����ȴ������߳̾��н���󷵻أ��Ƽ�ʹ��true��
     * @return           �߳����н�����ϣ������������н������̼߳��ϣ��綼δ�������򷵻سߴ�Ϊ0��list
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static List<Object> runCheckCallable(List<Callable<Object>> list, boolean isBlock) throws InterruptedException, ExecutionException {
        
    	//�Բ������м��
        if (CheckNull(list)) {
            return new ArrayList<>();
        }

        //��ʼ���̣߳���һ���̳߳�
        //newCachedThreadPool����һ���ɻ����̳߳أ�����̳߳س��ȳ���������Ҫ���������տ����̣߳����޿ɻ��գ����½��̡߳�
        exec = Executors.newCachedThreadPool();
        
        //ִ�������б��е��������񣬲�������ÿ�������Ӧ��Future��Ҳ����˵������˴�֮�䲻���໥Ӱ�죬����ͨ��future����ÿһ�������ִ�����.
        //����̲߳�����Future�߳�
        List<Future<Object>> futureList = exec.invokeAll(list);

        //�ж��Ƿ�����
        if (!isBlock){
            return new ArrayList<>();
        }
       
        //��鲢��ȡ�̷߳���ֵ
        return getAllCallableReturn(futureList);
    }

    /**
     * �Է����д���Ĳ������м��
     * @param list   ����ļ��϶���
     * @return       ������Ϊ�գ�����true����֮������false
     */
    private static boolean CheckNull(List<Callable<Object>> list) {
        //���list�Ƿ�Ϊ��
        if (list==null||list.size()<1){
            return true;
        }
        //���list�ж����Ƿ�Ϊ��
        for (Callable callable :list){
            if (callable==null){
                return true;
            }
        }
        return false;
    }

   
    /**
     * ��ѯ��ȡ����Callable�̵߳ķ���ֵ��ֱ�����з���ֵ������ȡ����������
     * @param futureList     �����̵߳Ĺ����༯��
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    
    private static List<Object> getAllCallableReturn(List<Future<Object>> futureList) throws ExecutionException, InterruptedException {
    	
    	//Ϊ��ʹ���ܱȽϺã���˽�ArrayList�ĳ���Ϊ�߳�����
    	List<Object> returnValue = new ArrayList<>(futureList.size());
       
    	while(true){
           
    		Iterator<Future<Object>> iterator = futureList.iterator();
            
    		while(iterator.hasNext()){
                
    			Future<Object> future = iterator.next();
                
    			//boolean isDone():���Callable��������ɣ��򷵻�true��
    			if (future.isDone()){
                	//V get() :����Callable������call()�����ķ���ֵ�����ø÷����ᵼ�³�������������ȵ����߳̽�����Ż�õ�����ֵ��
                    Object o = future.get();
                    returnValue.add(o);
                    iterator.remove();
                }
            }
            //�ж��Ƿ����з���ֵ������ȡ��
            if (futureList.size()==0){
                break;
            }
            
            //�߳�����10s����������ʱ��Ƭ
            TimeUnit.MILLISECONDS.sleep(10*1000);
        }
        //�õ�����Callable�̵߳ķ���ֵ
        return returnValue;
    }

    /**
     * �̳߳ع�����
     * ����һ�鲻���з���ֵ���̣߳�Ȼ���ɹ�����ͳһ�����Ե�ǰ���߳̽��м���
     * @param RunnableList       �̼߳���
     * @param isBlock            �Ƿ�������ʾλ�����Ϊfalse�����߳��������������أ�����ȴ������߳̾��н���󷵻أ��Ƽ�ʹ��true��
     * @return                   
     * @throws ExecutionException
     * @throws InterruptedException
     */
    
    public static void runCheckRunnable(List<Runnable> RunnableList,boolean isBlock) throws InterruptedException {
        
    	//���list�Ƿ�Ϊ��
        if (RunnableList==null||RunnableList.size()<1){
            return;
        }
        
        //��ʼ���̳߳أ�ʹ��һ���̳߳ؿ���һ���߳�
        ExecutorService exec = Executors.newCachedThreadPool();
        
        //����̲߳�����Future�߳�
        List<Future> futureList = new ArrayList<>(RunnableList.size());
        
        //ѭ����������ÿ���߳�������ӽ�ȥ
        for (Runnable runnable:RunnableList){
            if (runnable!=null){
                Future future = exec.submit(runnable);
                futureList.add(exec.submit(runnable));
            }
        }
        //�̲߳�����
        if (!isBlock){
            return;
        }
        while(true){
            
        	Iterator<Future> iterator = futureList.iterator();
            
        	while(iterator.hasNext()) {
                Future<Object> future = iterator.next();
                
                //boolean isDone():���Callable��������ɣ��򷵻�true��
                if (future.isDone()) {              
                    
                	iterator.remove();
                }
            }
          //�ж��Ƿ������̶߳�����
            if (futureList.size()==0){
                break;
            }
            
            //�߳�����10ms����������ʱ��Ƭ
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }

    /**
     * �̳߳ع�����
     * ����һ�鲻���з���ֵ���̣߳�Ȼ���ɹ�����ͳһ�����Ե�ǰ���߳̽��м���
     * @param RunnableList       �̼߳���
     * @return                  
     */
    public static void runCheckRunnable(Runnable runnable){

        if (exec==null){
        	//newCachedThreadPool����һ���ɻ����̳߳أ�����̳߳س��ȳ���������Ҫ���������տ����̣߳����޿ɻ��գ����½��̡߳�
            exec = Executors.newCachedThreadPool();
        }
        
        //�ύ�̵߳��̳߳�
        exec.submit(runnable);
    }
}
