package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PipedReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

public class 字符编码 {
	public static void main(String args[]) throws FileNotFoundException{
		String username = "中";  
        try {  
            //得到指定编码的字节数组    字符串--->字节数组  
            byte[] u_iso=username.getBytes("ISO8859-1");  
            byte[] u_gbk=username.getBytes("GBK");  
            byte[] u_utf8=username.getBytes("utf-8");  
            System.out.println(u_iso.length);  
            System.out.println(u_gbk.length);  
            System.out.println(u_utf8.length); 
            System.out.println();
            
            for(int i=0;i<u_iso.length;i++){
            	System.out.print(u_iso[i]);
            }
            System.out.println();
            for(int i=0;i<u_gbk.length;i++){
            	System.out.print(u_gbk[i]);
            }
            System.out.println();
            for(int i=0;i<u_utf8.length;i++){
            	System.out.print(u_utf8[i]);
            }
            System.out.println();
            
            System.out.println();
            
            //跟上面刚好是逆向的，字节数组---->字符串  
            String un_iso=new String(u_iso, "ISO8859-1");  
            String un_gbk=new String(u_gbk, "GBK");  
            String un_utf8=new String(u_utf8, "utf-8");  
            System.out.println(un_iso);  
            System.out.println(un_gbk);  
            System.out.println(un_utf8);
            System.out.println();
            //有时候必须是iso字符编码类型，那处理方式如下  
            String un_utf8_iso=new String(u_utf8, "ISO8859-1");
            
            //将iso编码的字符串进行还原  
            String un_iso_utf8=new String(un_utf8_iso.getBytes("ISO8859-1"),"utf-8");  
            System.out.println(un_iso_utf8);                  
              
        } catch (UnsupportedEncodingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }
        
	}
}
