package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Scanner;

import leetcode.main;

public class 字节流与字符流 {
	public static void main(String args[]) throws IOException{
//		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//		OutputStream outputStream = new FileOutputStream(new File("test1.dat"));
//		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//		String str = "Hello World!";
//		String str1 = "!!!dddd";
//		String str2 = "中国";
//		byte[] bytes = str.getBytes();
//		//outputStream.write(bytes);
////		outputStream.write(str1.getBytes());
//		//dataOutputStream.writeChars(str);
//		objectOutputStream.writeObject(str);
		

//		InputStream inputStream = new FileInputStream(new File("test.dat"));
////		byte[] bytes = new byte[1];
////		while(inputStream.read(bytes)!=-1){
////			System.out.println(Integer.toHexString(Byte.toUnsignedInt(bytes[0])));
////		}
//		byte[] bytes = new byte[7];
//		inputStream.read(bytes);
//		byte[] bytes_ = new byte[Byte.toUnsignedInt(bytes[6])];
//		while(inputStream.read(bytes_)!=-1){
//			//System.out.println(Integer.toHexString(Byte.toUnsignedInt(bytes_[0])));
//			System.out.println(new String(bytes_,"UTF-8"));
//		}
		
//		DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File("test2.dat")));
//		String str = "我们是共产主义接班人123 ";
//		for(int i=0;i<5;i++){
//			str += str;
//		}
//		byte[] bytes = str.getBytes("UTF-8");
//		System.out.println(bytes.length);
//		dataOutputStream.writeShort(bytes.length);
//		dataOutputStream.write(bytes);
//		dataOutputStream.close();
		
		DataInputStream inputStream = new DataInputStream(new FileInputStream(new File("test2.dat")));
		short length = inputStream.readShort();
		System.out.println(length);
		byte[] bytes = new byte[length];
		inputStream.read(bytes);
		inputStream.close();
		System.out.println(new String(bytes,"UTF-8"));
		
	}
}
