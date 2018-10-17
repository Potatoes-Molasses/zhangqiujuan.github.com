package effort;

import java.io.BufferedReader;
import java.io .File;
import java.io .FileInputStream;
import java.io .InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/***
 * @project_name insist
 * @Package effort
 * @Title ReadTxt.java
 * @Description: 定义读.txt文件类 
 * @author 张秋娟
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 张秋娟  完善getMap方法
 *
 */

/****
 * @ClassName:ReadTxt
 * @Description:读取.txt文件
 * 			属性:	1.文件路径 path
 * 					2.存放读取内容的集合类 map
 * 
 * 			方法:	1.将读取的内容放入集合类getMap()
 * 					
 * @author 张秋娟
 * @date 2018-10-14
 */

public  class ReadTxt {

	/***
	 * @Fields 文件路径
	 */
	String path;
	
	/***
	 * @Fields 要读取的集合类
	 */
	Map map = new HashMap();

	/**   
	 * @Title: ReadTxt
	 * @Description:构造ReadTxt对象   
	 * @throws   
	 */  
	
	public ReadTxt(String path) {
		
		this.path = path; 
		
	}

	/**  
	 * @Title:getMap
	 * @Description: 将读取的内容放入Map中
	 * @return: void
	 */ 
	public void getMap() throws Exception{
		
		/*新建BufferedReader对象*/
		BufferedReader br = new BufferedReader(new InputStreamReader(		
		new FileInputStream(new File(path)
				)));
		/*新建String 对象，存放读取的每行内容*/
		String str = null;
		
		/*i构成Key的一部分*/
		int i = 0;
		
		/*只要读取的每行内容不为空，则继续读取*/
		while ((str = br.readLine()) != null) {
			
			/*这里直接输出读取的每行内容*/
			System.out.println(str);
			
			/*并把读取的每行内容作为Value放到Map中*/
			map.put("ROW"+i,str );
			
			i++;
		}
		System.out.println(" 共读取数据－－－> "+map.size());
		
	}

}




