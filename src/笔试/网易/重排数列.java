package 笔试.网易;

import java.util.Scanner;

public class 重排数列 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++) {
			int n = in.nextInt();
			int sum_2 = 0;
			int sum_4 = 0;
			for(int j=0;j<n;j++) {
				int num = in.nextInt();
				if(num%4==0)
					sum_4++;
				else if(num%2==0)
					sum_2++;
			}
			
			if(sum_2>=n-2*sum_4)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
