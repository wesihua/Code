package 笔试.腾讯;

import java.util.Scanner;

public class 数字转换机 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int A = in.nextInt();
		int B = in.nextInt();
		
		if(A>=a&&B>=b&&A%2==B%2) {
			int count = 0;
			do {
				if(A%2==0 && A/2>a) {
					A = A/2;
					B = B/2;
					count++;
				}
				else {
					A--;
					B--;
					count++;
				}
				
				if(A==a&&B==b) {
					System.out.println(count);
					return;
				}
			} while(A>a&&B>b);
			
			System.out.println(-1);
		}
		else 
			System.out.println(-1);
		
	}
}
