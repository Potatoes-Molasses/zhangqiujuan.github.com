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
 * @Description: �����.txt�ļ��� 
 * @author �����
 * @date 2018-10-14
 * @version v1.0
 * @update 01 2018-10-14 �����  ����getMap����
 *
 */

/****
 * @ClassName:ReadTxt
 * @Description:��ȡ.txt�ļ�
 * 			����:	1.�ļ�·�� path
 * 					2.��Ŷ�ȡ���ݵļ����� map
 * 
 * 			����:	1.����ȡ�����ݷ��뼯����getMap()
 * 					
 * @author �����
 * @date 2018-10-14
 */

public  class ReadTxt {

	/***
	 * @Fields �ļ�·��
	 */
	String path;
	
	/***
	 * @Fields Ҫ��ȡ�ļ�����
	 */
	Map map = new HashMap();

	/**   
	 * @Title: ReadTxt
	 * @Description:����ReadTxt����   
	 * @throws   
	 */  
	
	public ReadTxt(String path) {
		
		this.path = path; 
		
	}

	/**  
	 * @Title:getMap
	 * @Description: ����ȡ�����ݷ���Map��
	 * @return: void
	 */ 
	public void getMap() throws Exception{
		
		/*�½�BufferedReader����*/
		BufferedReader br = new BufferedReader(new InputStreamReader(		
		new FileInputStream(new File(path)
				)));
		/*�½�String ���󣬴�Ŷ�ȡ��ÿ������*/
		String str = null;
		
		/*i����Key��һ����*/
		int i = 0;
		
		/*ֻҪ��ȡ��ÿ�����ݲ�Ϊ�գ��������ȡ*/
		while ((str = br.readLine()) != null) {
			
			/*����ֱ�������ȡ��ÿ������*/
			System.out.println(str);
			
			/*���Ѷ�ȡ��ÿ��������ΪValue�ŵ�Map��*/
			map.put("ROW"+i,str );
			
			i++;
		}
		System.out.println(" ����ȡ���ݣ�����> "+map.size());
		
	}

}




