package persist;

/**
 * @author �����
 * @date 2018.11.11
 */

public class test {
	
	    public static void main(String args[]) throws InterruptedException {
	    	//�����СΪ1000
	    	int size=1000;
	    	//����32���߳�
	    	int numOfThread=32;
	    	//�������mA mB
	    	long[][]mA=new long [size][size];
	    	long[][]mB=new long [size][size];	    	
	    	
	    	//��ʼ������mA mB
	    	for(int i=0;i<size;i++) {
	    		for(int j=0;j<size;j++) {
	    			for(int k=0;k<size;k++) {
	    				//������������������ʼ�����ٶȱȽ������ȴ������ʱ��Ƚϳ�
	    				//Ϊ�˿��ٿ�������������������new Random().nextInt(10)
	    				mA[i][j]=i+1;
	    				mB[i][j]=1;
	    			}
	    		}
	    	}		    	
	    	
	    	
	    	//�����������̵߳�����,��СΪ�߳���
	    	Thread [] threads = new Thread[numOfThread];   
	    	//������Matrix���������,��СΪ�߳���
	    	Matrix [] matrixs=new Matrix[numOfThread];
	    	
	    	//�����߳�
	    	for(int i=0;i<numOfThread;i++) {
	    		 matrixs[i] = new Matrix(mA,mB,i,size,numOfThread); 
	    		 Thread thread=new Thread(matrixs[i]);
	    		 threads[i]=thread;
	    		 
	    	}
	    	
	    	
	    	//��ʼ��ʱ
	    	//System.currentTimeMillis()������ȡ���Ǵ�1970��01��01��00ʱ00��00��000���뵽�˿̵ĺ�����������������long����
	    	long before=System.currentTimeMillis();
	    	
	    	//�����߳�
	    	for(int i=0;i<numOfThread;i++) {
	    		threads[i].start();
	    	}
	    	
	    	//�ȴ���ǰ�߳�ִ�н���
	    	for(int i=0;i<numOfThread;i++) {
	    		try {
	    			threads[i].join();
	    		}catch(InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    	
	    	//������ʱ
	    	long after=System.currentTimeMillis();
	    	
	    	//��ȡ�����̵߳ļ������������
	    	long sum = 0;
	    	for(int i=0;i<numOfThread;i++) {
	    		sum+=matrixs[i].getSum();
	    	}
	    	
	    	
	    	System.out.println("�����"+sum); 
	    	System.out.println("����"+numOfThread+"�̣߳���ʱ"+(after-before)+"ms"); 
	    	
	    	//ֱ�Ӽ�����󣬿�ʼ��ʱ
	    	long begin=System.currentTimeMillis();
	    	
	    	Matrix m3 = new Matrix(mA,mB,0,size,1);
	    	m3.multiply();
	    	
	    	//������ʱ
	    	long end=System.currentTimeMillis();
	    	
	    	System.out.println("�����"+m3.getSum()); 
	    	System.out.println("ֱ�Ӽ��㣬��ʱ"+(end-begin)+"ms"); 
	    	
	   }
  
}





