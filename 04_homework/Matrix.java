
package persist;

/**
 * @author �����
 * @date 2018.11.11
 */

public class Matrix implements Runnable{
   //��һ������
   private long[][] matrixA = null;  
   //�ڶ�������
   private long[][] matrixB = null;  
   //�������
   private long[][] result  = null; 
   //���㿪ʼλ��,�Դ˻����߳�
   private int start;					   
   //�����СΪsize*size
   private int size; 
   //�����߳���
   private int numOfThread;   
   //�Խ���������λ���ϵ�Ԫ����ͣ���ֱ�Ӽ���Ľ����Ƚϣ���֤����Ƿ���ȷ
   private long sum=0;
    
    //���幹�췽��
    public Matrix(long[][]matrixA,long[][] matrixB,int start,int size,int  numOfThread) {        
        this.matrixA = matrixA;
        this.matrixB =  matrixB;
        this.start=start;
        this.size=size;
        this.numOfThread=numOfThread;
        this.result=new long[size][size];
    }
    
   
  
   //ֱ�Ӽ���������
    public void multiply() {
    	//������һ���������
         for(int i=0;i <size;i++) {
        	 //�����ڶ����������
         	for( int j =0; j <size; j++) {   
         		//������һ��������л��ߵڶ����������
         	  for( int k= 0; k < size; k++ ) {
                //��һ��������г��Եڶ����������,�õ��¾������
            	 result[i][j]+= matrixA[i][k] * matrixB[k][j];  
                 //���
            	 sum+=result[i][j];
            	  }
            }            
        }
    
     }
    
    
    //�õ�����������λ���ϵ�Ԫ�صĺ�
    public long getSum() {
    	return sum;
    }
	
    
    //���ָ����̵߳�����
	@Override
	public void run() {
		    
	     for(int i=start;i <size;i+=numOfThread) {
	        for( int j =0; j <size; j++) {             
	        	for( int k= 0; k < size; k++ ) {
	        		//�����������̣߳���һ���̼߳������һ�У��ڶ����̼߳�����ڶ��У�Ȼ���һ���߳̽��ż��㣬�ڶ����߳��ټ���... ...
	        		//2��8��16��32�߳��Դ�����
	        		result[i][j]+= matrixA[i][k] * matrixB[k][j];  
	                sum+=result[i][j];
	           	  }
	           }            
	       }      	
	}
}
