
package persist;

/**
 * @author 张秋娟
 * @date 2018.11.11
 */

public class Matrix implements Runnable{
   //第一个矩阵
   private long[][] matrixA = null;  
   //第二个矩阵
   private long[][] matrixB = null;  
   //结果矩阵
   private long[][] result  = null; 
   //计算开始位置,以此划分线程
   private int start;					   
   //矩阵大小为size*size
   private int size; 
   //划分线程数
   private int numOfThread;   
   //对结果矩阵各个位置上的元素求和，和直接计算的结果相比较，验证结果是否正确
   private long sum=0;
    
    //定义构造方法
    public Matrix(long[][]matrixA,long[][] matrixB,int start,int size,int  numOfThread) {        
        this.matrixA = matrixA;
        this.matrixB =  matrixB;
        this.start=start;
        this.size=size;
        this.numOfThread=numOfThread;
        this.result=new long[size][size];
    }
    
   
  
   //直接计算矩阵相乘
    public void multiply() {
    	//遍历第一个矩阵的行
         for(int i=0;i <size;i++) {
        	 //遍历第二个矩阵的列
         	for( int j =0; j <size; j++) {   
         		//遍历第一个矩阵的列或者第二个矩阵的行
         	  for( int k= 0; k < size; k++ ) {
                //第一个矩阵的行乘以第二个矩阵的列,得到新矩阵的行
            	 result[i][j]+= matrixA[i][k] * matrixB[k][j];  
                 //求和
            	 sum+=result[i][j];
            	  }
            }            
        }
    
     }
    
    
    //得到结果矩阵各个位置上的元素的和
    public long getSum() {
    	return sum;
    }
	
    
    //划分各个线程的任务
	@Override
	public void run() {
		    
	     for(int i=start;i <size;i+=numOfThread) {
	        for( int j =0; j <size; j++) {             
	        	for( int k= 0; k < size; k++ ) {
	        		//若划分两个线程，第一个线程计算出第一行，第二个线程计算出第二行，然后第一个线程接着计算，第二个线程再计算... ...
	        		//2、8、16、32线程以此类推
	        		result[i][j]+= matrixA[i][k] * matrixB[k][j];  
	                sum+=result[i][j];
	           	  }
	           }            
	       }      	
	}
}
