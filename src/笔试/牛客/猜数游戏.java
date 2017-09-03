package 笔试.牛客;

import java.util.Scanner;

public class 猜数游戏 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int result = 0;
		
		for(int i=1;i<=n;i++) {
			if(i==1)
				result = 1;
			else if(i==2)
				result++;
			else if(i%2==1)
				result = (result*2)%1000000007;
			else if(i%2==0)
				result = (result + i-2)%1000000007;
		}
		
		System.out.println(result);
	}
}
