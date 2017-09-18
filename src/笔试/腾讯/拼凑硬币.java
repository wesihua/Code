package 笔试.腾讯;

import java.util.Scanner;

public class 拼凑硬币 {
	public static void main (String[]args){
	      Scanner in = new Scanner(System.in);
	      long n = in.nextLong();
	      int m = (int) Math.sqrt(n);
	      //System.out.println(m);
	      long[] array = new long[m+1];
	      array[0] = 1;
	      for(int i=1;i<=m;i++){
	      	array[i] = array[i-1]*2;
	      }
	      long[][] dp = new long[m+1][(int)(n+1)];
	      
	      for(int i=0;i<dp.length;i++){
	      	dp[i][0] = 1;
	      }
	      
	      for(int i=1;i<=2&&array[0]*i<n;i++){
	        dp[0][(int) (array[0]*i)] = 1;
	      }
	      
	      for(int i=1;i<array.length;i++){
	        for(int j=1;j<=n;j++){
	          long num = 0;
	          for(int k=0;k<=2;k++){
	          	num += j-array[i]*k>=0?dp[i-1][(int) (j-array[i]*k)]:0;
	          }
	          dp[i][j] = num;
	        }
	      }
	      
	      System.out.println(dp[array.length-1][(int) n]);
	}
}
