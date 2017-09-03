package dp;

import java.util.Scanner;

/**
 * 题目：
 * 牛牛在农场饲养了n只奶牛,依次编号为0到n-1, 牛牛的好朋友羊羊帮牛牛照看着农场.有一天羊羊看到农场中逃走了k只奶牛,
 * 但是他只会告诉牛牛逃走的k只奶牛的编号之和能被n整除。你现在需要帮牛牛计算有多少种不同的逃走的奶牛群。因为结果可能很大,输出结果对1,000,000,007取模。
 * 例如n = 7 k = 4:
 * 7只奶牛依次编号为0到6, 逃走了4只
 * 编号和为7的有:{0, 1, 2, 4}
 * 编号和为14的有:{0, 3, 5, 6}, {1, 2, 5, 6}, {1, 3, 4, 6},{2, 3, 4, 5}
 * 4只牛的编号和不会大于18,所以输出5. 
 *
 * 输入描述：
 * 输入包括一行,两个整数n和k(1 ≤ n ≤ 1000),(1 ≤ k ≤ 50),以空格分割。
 *
 * 输出描述:
 * 输出一个整数表示题设所求的种数。
 *
 * 输入例子:
 * 7 4
 *
 * 输出例子：
 * 5
 * @author zhenlanghuo
 *
 */
public class 逃离农场 {
	/**
	 * dp[i][k][sum]表示前i个奶牛中选取k个他们的编号和对n取模为sum的方案数
	 * dp[i][k][sum] = dp[i - 1][k][sum] + dp[i - 1][k - 1][(sum - i + n) % n]
	 * 然后可以滚动优化或者压缩一维空间。
	 * 压缩一维空间的道理就好像01背包问题的优化一样，每一次只用到前一次的值，第二层循环变成是递减的就可以使到，在计算dp[j][sum]的时候可以用到前一次的值
	 * 
	 */
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[][] dp = new int[51][1005];
		
		int mod = 1000000007;
		
		dp[0][0] = 1;
		
		for(int i=1;i<=n;i++){
			for(int j=k;j>0;j--){
				for(int x=0;x<n;x++){
					dp[j][x] = (dp[j][x] + dp[j-1][(x-i+n)%n])%mod;
				}
			}
		}
		
		System.out.println(dp[k][0]);
	}
}
