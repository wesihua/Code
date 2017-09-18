package 笔试.迅雷;

import java.util.Scanner;

public class 位数和 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int sum = 0;
		for(int i=2;i<=5;i++) {
			String str = Integer.toString(n, i);
			//System.out.println(str);
			for(int j=0;j<str.length();j++) {
				sum += str.charAt(j)-'0';
			}
		}
		
		System.out.println(sum);
	}
}
