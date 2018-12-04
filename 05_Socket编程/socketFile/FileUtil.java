package socketFile;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author �����
 * @date 2018.12.3
 */
public class FileUtil {

	String newline = "\r\n";
    
    /**
     * д���ļ�,ĩβ�Զ����\r\n
     * utf-8  ׷��
     * @param path
     * @param str
     */
    public static boolean writeLog(String path, String str)
    {
        try
        {	//��ָ��Ŀ¼�´���һ��File����
            File file = new File(path);
            
            //�ж��ļ��Ƿ����
            if(!file.exists())
                file.createNewFile();
           
            //��һ��File���󴴽�һ��FileOutputStream
            FileOutputStream out = new FileOutputStream(file); //true��ʾ׷�� 
            StringBuffer sb = new StringBuffer();
           
            //��ָ���ַ�׷�ӵ����ַ�����
            sb.append(str + "\r\n");
            //��һ���ַ���ת��Ϊһ���ֽ�����byte[],����UTF-8�ı����
            out.write(sb.toString().getBytes("utf-8"));
            out.close();
            return true;
        }
        catch(IOException ex)
        {
            System.out.println(ex.getStackTrace());
            return false;
        }
    }
    
    /**
     * д���ļ�,ĩβ�Զ����\r\n,ָ�������ʽ
     * @param path
     * @param str
     */
    public static void writeLog(String path, String str, boolean is_append, String encode)
    {
        try
        {
            File file = new File(path);
            if(!file.exists())
                file.createNewFile();
            FileOutputStream out = new FileOutputStream(file, is_append); //true��ʾ׷�� 
            StringBuffer sb = new StringBuffer();
            sb.append(str + "\r\n");
            out.write(sb.toString().getBytes(encode));
            out.close();
        } catch(IOException ex) {
        	System.out.println(ex.getStackTrace());
        }
    }
    
    
    
    /**
     * �����ļ���string�Żأ����\r\n����
     * @param path
     * @return
     */
    public static String readLogByString(String path)
    {
    	//�½��ַ��������������ڴ���ļ�����
        StringBuffer sb=new StringBuffer();
        String tempstr=null;
        try {
        	//��ָ��Ŀ¼�´���һ��File����
            File file=new File(path);
            
            if(!file.exists())
                throw new FileNotFoundException();
            //��һ��File���󴴽�һ��FileInputStream
            FileInputStream fis=new FileInputStream(file);
           
            //InputStreamReader�ǽ��ֽ���ת��Ϊ�ַ���������������ȡһЩ�ֽڲ�ʹ�ù涨���ַ��������Ǳ���Ϊ�ַ���
            BufferedReader br=new BufferedReader(new InputStreamReader(fis, "utf-8"));
           
            //��ȡ�ļ���ͬʱ���������ַ��Ž��ַ�������
            while((tempstr=br.readLine())!=null) {
                sb.append(tempstr + "\r\n");
            }
        } catch(IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        return sb.toString();
    }
    
    /**
     * ָ�������ʽ
     * �����ļ���string�Żأ����\r\n����
     * @param path
     * @return
     */
    public static String readLogByStringAndEncode(String path, String encode)
    {
        StringBuffer sb=new StringBuffer();
        String tempstr=null;
        try {
            File file=new File(path);
            if(!file.exists())
                throw new FileNotFoundException();
         
            FileInputStream fis=new FileInputStream(file);
            BufferedReader br=new BufferedReader(new InputStreamReader(fis, encode));
            while((tempstr=br.readLine())!=null) {
                sb.append(tempstr + "\r\n");
            }
        } catch(IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        return sb.toString();
    }
    
    /**
     * ���ж�ȡ�ļ�����list<String>����ʽ����
     * @param path
     * @return
     */
    public static List<String> readLogByList(String path) {
    	//�½�List����,���ڴ���ļ�����
        List<String> lines = new ArrayList<String>();
        String tempstr = null;
        try {
        	//��ָ��Ŀ¼�´���һ��File����
            File file = new File(path);
            if(!file.exists()) {
                throw new FileNotFoundException();
            }   
            //��һ��File���󴴽�һ��FileInputStream
            FileInputStream fis = new FileInputStream(file);
            
            //InputStreamReader�ǽ��ֽ���ת��Ϊ�ַ���������������ȡһЩ�ֽڲ�ʹ�ù涨���ַ��������Ǳ���Ϊ�ַ���
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "utf-8"));
           
            //��ȡ�ļ���ͬʱ���������ַ��Ž�List����
            while((tempstr = br.readLine()) != null) {
                lines.add(tempstr.toString());
            }
        } catch(IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        return lines;
    }
}