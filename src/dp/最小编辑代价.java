package dp;

import java.util.ArrayList;

/**
 * 题目：
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。
 * 
 * 测试样例：
 * "abc",3,"adc",3,5,3,100
 * 返回：8
 * 
 * @author zhenlanghuo
 *
 */
public class 最小编辑代价 {
	/**
	 * dp[i][j]代表子串A[0...i-1]变为子串B[0,,,j-1]的最小编辑距离
	 * 当A=="" 或者B==""时，cost是删除或插入的代价            
	 * 当A!="" 且 B!= ""时            
	 * A[i-1] == B[j-1] D[i][j] = D[i-1][j-1]            
	 * A[i-1] != B[j-1] D[i][j] = MIN{D[i-1][j-1]+c2(修改一个值)，D[i-1][j]+c1(删除一个值)，D[i][j-1]+c0(插入一个值)} 
	 * 
	 */
	public static int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
		int[][] dp = new int[n+1][m+1];

		for(int i=1;i<=n;i++){
			dp[i][0] = dp[i-1][0] + c1;
		}
		
		for(int i=1;i<=m;i++){
			dp[0][i] = dp[0][i-1] + c0;
		}
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(A.charAt(i-1)==B.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}
				else{
					dp[i][j] = Math.min(Math.min(dp[i-1][j]+c1, dp[i][j-1]+c0), dp[i-1][j-1]+c2);
				}
			}
		}
		
        return dp[n][m];
    }
	
	public static void main(String args[]){
		String A = "abc";
		String B = "adc";
		Object o;
		System.out.println(findMinCost(A, A.length(), B, B.length(), 5, 3, 100));
	}
}
