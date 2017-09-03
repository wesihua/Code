package hihocoder;

import java.util.Scanner;

public class 投掷硬币 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		double[] p = new double[n+1];
		for(int i=1;i<n+1;i++){
			p[i] = in.nextDouble();
		}
		
		double[][] dp = new double[n+1][n+1];
		
		dp[1][0] = 1-p[1];
		dp[1][1] = p[1];
		
		for(int i=2;i<dp.length;i++){
			for(int j=0;j<=i;j++){
				
				if(j==0)
					dp[i][j] = dp[i-1][j]*(1-p[i]);
				else
					dp[i][j] = dp[i-1][j]*(1-p[i]) + dp[i-1][j-1]*p[i];
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
