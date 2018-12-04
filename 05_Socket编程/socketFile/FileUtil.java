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
 * @author 张秋娟
 * @date 2018.12.3
 */
public class FileUtil {

	String newline = "\r\n";
    
    /**
     * 写入文件,末尾自动添加\r\n
     * utf-8  追加
     * @param path
     * @param str
     */
    public static boolean writeLog(String path, String str)
    {
        try
        {	//在指定目录下创建一个File对象
            File file = new File(path);
            
            //判断文件是否存在
            if(!file.exists())
                file.createNewFile();
           
            //以一个File对象创建一个FileOutputStream
            FileOutputStream out = new FileOutputStream(file); //true表示追加 
            StringBuffer sb = new StringBuffer();
           
            //将指定字符追加到此字符序列
            sb.append(str + "\r\n");
            //将一个字符串转化为一个字节数组byte[],采用UTF-8的编码表
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
     * 写入文件,末尾自动添加\r\n,指定编码格式
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
            FileOutputStream out = new FileOutputStream(file, is_append); //true表示追加 
            StringBuffer sb = new StringBuffer();
            sb.append(str + "\r\n");
            out.write(sb.toString().getBytes(encode));
            out.close();
        } catch(IOException ex) {
        	System.out.println(ex.getStackTrace());
        }
    }
    
    
    
    /**
     * 整个文件以string放回，添加\r\n换行
     * @param path
     * @return
     */
    public static String readLogByString(String path)
    {
    	//新建字符缓冲区对象，用于存放文件内容
        StringBuffer sb=new StringBuffer();
        String tempstr=null;
        try {
        	//在指定目录下创建一个File对象
            File file=new File(path);
            
            if(!file.exists())
                throw new FileNotFoundException();
            //以一个File对象创建一个FileInputStream
            FileInputStream fis=new FileInputStream(file);
           
            //InputStreamReader是将字节流转换为字符流的桥梁，它读取一些字节并使用规定的字符集将它们编译为字符。
            BufferedReader br=new BufferedReader(new InputStreamReader(fis, "utf-8"));
           
            //读取文件，同时将读到的字符放进字符缓冲区
            while((tempstr=br.readLine())!=null) {
                sb.append(tempstr + "\r\n");
            }
        } catch(IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        return sb.toString();
    }
    
    /**
     * 指定编码格式
     * 整个文件以string放回，添加\r\n换行
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
     * 按行读取文件，以list<String>的形式返回
     * @param path
     * @return
     */
    public static List<String> readLogByList(String path) {
    	//新建List对象,用于存放文件内容
        List<String> lines = new ArrayList<String>();
        String tempstr = null;
        try {
        	//在指定目录下创建一个File对象
            File file = new File(path);
            if(!file.exists()) {
                throw new FileNotFoundException();
            }   
            //以一个File对象创建一个FileInputStream
            FileInputStream fis = new FileInputStream(file);
            
            //InputStreamReader是将字节流转换为字符流的桥梁，它读取一些字节并使用规定的字符集将它们编译为字符。
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "utf-8"));
           
            //读取文件，同时将读到的字符放进List对象
            while((tempstr = br.readLine()) != null) {
                lines.add(tempstr.toString());
            }
        } catch(IOException ex) {
            System.out.println(ex.getStackTrace());
        }
        return lines;
    }
}