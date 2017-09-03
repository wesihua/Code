package 笔试.华为;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
	int i = 1;
	public final void test(){
		System.out.println("test");
	}
	
	public static String test(String s){
		try {
			s = "11";
			return "try";
		} finally {
			System.out.println("...");
			//return "finally";
		}
	}
	
	public static void main(String[] args){
		Integer a = -2>>>1;
		Integer b = -2>>1;
		Integer c = 5;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		System.out.println(a+" "+b);
		System.out.println(test("1"));
		
		c %= 4;
		System.out.println(c);
		Scanner in = new Scanner(System.in);
		String s = "";
	}
}
