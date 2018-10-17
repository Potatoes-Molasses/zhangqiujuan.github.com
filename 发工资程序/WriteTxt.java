package effort;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/***
 * @project_name insist
 * @Package effort
 * @Title  WriteTxt.java
 * @Description: 定义WriteTxt类 
 * @author 张秋娟
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 张秋娟  将写职工信息方法和写工资记录的方法分离开来
 *
 */

/****
 * @ClassName: WriteTxt
 * @Description:定义 WriteTxt类的相关属性及方法
 * 			属性:	1.文件路径path
 *					2.职工列表list
 * 
 * 			方法:	1.设置工资setSalary()
 * 					2.获得工资getSalary()
 * 					3.获得名字toString()
 * 					4.增加员工，用于员工信息的输入addStaff()				
 * @author 张秋娟
 * @date 2018-10-14
 */
public class WriteTxt {

	/***
	 * @Fields 文件存放路径
	 */
	
	String path;
	

	/***
	 * @Fields 职工列表，用于存放员工、经理、股东对象
	 */
	
	 Map<String,Employee>list=new HashMap();
	 

	/**   
	* @Title: WriteTxt
	 * @Description:构造WriteTxt对象   
	 * @param: path 文件路径
	 * @param: list 职工列表
	 * @throws   
	 */  
		 
	public WriteTxt(String path , Map list) {
		
		this.path = path;
		this.list = list;
		
	}
	
	/**   
	 * @Title:newTxt
	 * @Description:新建.txt文件
	 * @return: void
	 * @throws   
	 */  
	public  void newTxt()throws Exception{
		
		/*实例化一个File对象*/
		File file = new File(path);
		
		/*如果该文件存在*/
		if(file.exists()) {
			
			/*file.mkdir()创建指定路径的目录。如果父路径不存在，会创建失败报错*/
			/*file.mkdirs()自动创建不存在的父路径*/
			file.mkdirs();
		}
		
	}
	
	
	
	/**   
	 * @Title:WriteSalary
	 * @Description:按先员工、再经理、后股东的顺序将工资记录写入.txt文件
	 * @return: boolean
	 * @throws   
	 */  
	
	public boolean WriteSalary() {
		try {
			
			/*重新建立一个.txt文件*/
			newTxt(); 
 
			/*建立FileWriter对象，并实例化fw*/
			FileWriter fw=new FileWriter(path);
			
			/*直接遍历整个职工列表,先写所有员工的工资记录*/
			for(Map.Entry<String, Employee> entry:list.entrySet()) {
				
				/*判断value是否是Staff类型*/
				if(entry.getValue() instanceof Staff) {
					
					/*强制类型转换成Staff,才可调用子类特有的函数*/
					Staff person=(Staff)entry.getValue();
					
					/*向文件写入职位和姓名*/
					fw.write("【"+entry.getKey()+"】 "+person.toString()+" 发放记录:");
					
					/*获取工资记录*/
					 Map<String,Double>bill=person.getSalaryBill();
					 
					 /*遍历工资记录，写入文件中*/
					 for(Map.Entry<String,Double>object:bill.entrySet()) {
						 
						 /*写入年月和工资金额*/
						 fw.write(" "+object.getKey()+" 工资:"+object.getValue()+"  ");
							
					 }
					 
					 fw.write("\n");
				}else {
					
					/*若当前不是Staff类型，则跳出此次循环，进行下次循环，直到找遍所有Staff*/
					continue;
				}
			}
			
			/*直接遍历整个职工列表,写所有经理的工资记录*/
			for(Map.Entry<String, Employee> entry:list.entrySet()) {
				
				/*判断value是否是Manager类型*/
				if(entry.getValue() instanceof Manager) {
					
					/*强制类型转换成Manager,才可调用子类特有的函数*/
					Manager person=(Manager)entry.getValue();
					
					/*写入职位和姓名*/
					fw.write("【"+entry.getKey()+"】 "+person.toString()+" 发放记录:");
					
					/*获取工资记录*/
					 Map<String,Double>bill=person.getSalaryBill();
					 
					 /*遍历工资记录，写入文件中*/
					 for(Map.Entry<String,Double>object:bill.entrySet()) {
						 
						 /*写入年月、奖金和工资金额*/
						 fw.write(" "+object.getKey()+" 工资:"+object.getValue()+"  ");
							
					 }
					 
					 fw.write("\n");
				}else {
					
					/*若当前不是Manager类型，则跳出此次循环，进行下次循环，直到找遍所有Manager*/
					continue;
				
				}
			}
			
			/*直接遍历整个职工列表,写所有股东的分红记录*/
			for(Map.Entry<String, Employee> entry:list.entrySet()) {
				
				/*判断value是否是Shareholder类型*/
				if(entry.getValue() instanceof Shareholder) {
					
					/*强制类型转换成Shareholder,才可调用子类特有的函数*/
					Shareholder person=(Shareholder)entry.getValue();
					
					/*写入职位和姓名*/
					fw.write("【"+entry.getKey()+"】 "+person.toString()+" 发放记录:");
					
					/*获取工资记录*/
					 Map<String,Double>bill=person.getSalaryBill();
					 
					 /*遍历工资记录，写入文件中*/
					 for(Map.Entry<String,Double>object:bill.entrySet()) {
						 
						 /*写入年月和分红*/
						 fw.write(" "+object.getKey()+" 分红:"+object.getValue()+"  ");
							
					 }
					 
					 fw.write("\n");
				}
			}

			fw.close();
			
		} catch (Exception e) {
			
			/*打印异常*/
			e.printStackTrace();
			return false;

		}
		return true;
	}

	
	/**   
	 * @Title:WriteMsg
	 * @Description:把职工信息写入.txt文件
	 * @return: boolean
	 * @throws   
	 */  
	
	
	public boolean WriteMsg() {
		try {
			
			/*重新建立一个txt文件*/
			newTxt(); //
 
			/*建立FileWriter对象，并实例化fw*/
			FileWriter fw=new FileWriter(path);
			
			/*直接遍历整个职工列表,写入所有职工的信息*/
			for(Map.Entry<String, Employee> entry:list.entrySet()) {
				
				/*获取职工的姓名*/
				String name=entry.getValue().toString();
				
				/*获取职工号*/
				int id=entry.getValue().getID();
				
				/*获取出生月份*/
				int month=entry.getValue().getbirMonth();
				
				/*判断当前对象是否是股东类型*/
				if(entry.getValue() instanceof Shareholder) {
					
					/*强制类型装换，调用Shareholder特有的方法*/
					Shareholder person=(Shareholder)entry.getValue();
					
					/*获取股东的股份*/
					double share=person.getShare();
					
					/*若是股东类型，则写入姓名、职工号、生日月份和股份*/
					fw.write("【"+entry.getKey()+"】 "+name+" 职工号:"+id+" 生日月份:"+month+"股份:"+share+"\n");
				}else {
					/*若不是股东类型，则写入姓名、职工号、生日月份*/
					fw.write("【"+entry.getKey()+"】 "+name+" 职工号:"+id+" 生日月份:"+month+"\n");//写入文件内容;
				}
			}

			fw.close();
			
		} catch (Exception e) {
			
			/*打印异常*/
			e.printStackTrace();
			return false;

		}
		
		return true;
		
	}
	
}


