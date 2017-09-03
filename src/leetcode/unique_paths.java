package leetcode;

import java.math.BigDecimal;

public class unique_paths {
	public static int uniquePaths(int m, int n) {
		//return factorial(m+n-2).divide(factorial(m-1).multiply(factorial(n-1))).intValue();
        
		int[][] dp = new int[m+1][n+1];
		
		dp[1][1] = 1;
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(i!=1||j!=1)
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
	
		return dp[m][n];
    }
	
    public static BigDecimal factorial(int n){
        BigDecimal result = new BigDecimal(1);  
        BigDecimal a;  
        for(int i=n;i>=1;i--){
        	a = new BigDecimal(i);
        	result = result.multiply(a);
        }
        
        return result;
    }
    
    public static void main(String args[]) {
    	System.out.println(uniquePaths(23, 12));
    	System.out.println(factorial(22));
    }
    
}
