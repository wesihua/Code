package 笔试.百度;

import java.util.Scanner;

public class 不等式数列 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[][] dp = new int[n+1][n];
		dp[2][0] = 1;
		dp[2][1] = 1;
		
		for(int i=3;i<dp.length;i++){
			for(int j=0;j<dp[i].length;j++){
				if(j==0 || j==dp[i].length-1)
					dp[i][j] = 1;
				else{
					dp[i][j] += dp[i-1][j]*(j+1) + dp[i-1][j-1]*(i-j);
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
