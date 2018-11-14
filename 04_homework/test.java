package persist;

/**
 * @author 张秋娟
 * @date 2018.11.11
 */

public class test {
	
	    public static void main(String args[]) throws InterruptedException {
	    	//矩阵大小为1000
	    	int size=1000;
	    	//划分32个线程
	    	int numOfThread=32;
	    	//定义矩阵mA mB
	    	long[][]mA=new long [size][size];
	    	long[][]mB=new long [size][size];	    	
	    	
	    	//初始化矩阵mA mB
	    	for(int i=0;i<size;i++) {
	    		for(int j=0;j<size;j++) {
	    			for(int k=0;k<size;k++) {
	    				//利用随机数，给矩阵初始化的速度比较慢，等待结果的时间比较长
	    				//为了快速看到结果，不采用随机数new Random().nextInt(10)
	    				mA[i][j]=i+1;
	    				mB[i][j]=1;
	    			}
	    		}
	    	}		    	
	    	
	    	
	    	//定义存放所有线程的数组,大小为线程数
	    	Thread [] threads = new Thread[numOfThread];   
	    	//定义存放Matrix对象的数组,大小为线程数
	    	Matrix [] matrixs=new Matrix[numOfThread];
	    	
	    	//创建线程
	    	for(int i=0;i<numOfThread;i++) {
	    		 matrixs[i] = new Matrix(mA,mB,i,size,numOfThread); 
	    		 Thread thread=new Thread(matrixs[i]);
	    		 threads[i]=thread;
	    		 
	    	}
	    	
	    	
	    	//开始计时
	    	//System.currentTimeMillis()方法获取的是从1970年01月01日00时00分00秒000毫秒到此刻的毫秒数，返回类型是long类型
	    	long before=System.currentTimeMillis();
	    	
	    	//启动线程
	    	for(int i=0;i<numOfThread;i++) {
	    		threads[i].start();
	    	}
	    	
	    	//等待当前线程执行结束
	    	for(int i=0;i<numOfThread;i++) {
	    		try {
	    			threads[i].join();
	    		}catch(InterruptedException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    	
	    	//结束计时
	    	long after=System.currentTimeMillis();
	    	
	    	//获取各个线程的计算结果，并求和
	    	long sum = 0;
	    	for(int i=0;i<numOfThread;i++) {
	    		sum+=matrixs[i].getSum();
	    	}
	    	
	    	
	    	System.out.println("结果："+sum); 
	    	System.out.println("并发"+numOfThread+"线程，耗时"+(after-before)+"ms"); 
	    	
	    	//直接计算矩阵，开始计时
	    	long begin=System.currentTimeMillis();
	    	
	    	Matrix m3 = new Matrix(mA,mB,0,size,1);
	    	m3.multiply();
	    	
	    	//结束计时
	    	long end=System.currentTimeMillis();
	    	
	    	System.out.println("结果："+m3.getSum()); 
	    	System.out.println("直接计算，耗时"+(end-begin)+"ms"); 
	    	
	   }
  
}





