package dp;

import java.util.Scanner;

/**
 * 题目：
 * 有一条无限长的纸带,分割成一系列的格子,最开始所有格子初始是白色。现在在一个格子上放上一个萌萌的机器人(放上的这个格子也会被染红),机器人一旦走到某个格子上,就会把这个格子涂成红色。
 * 现在给出一个整数n,机器人现在会在纸带上走n步。每一步,机器人都会向左或者向右走一个格子,两种情况概率相等。机器人做出的所有随机选择都是独立的。现在需要计算出最后纸带上红色格子的期望值。 
 * 
 * 输入描述:
 * 输入包括一个整数n(0 ≤ n ≤ 500),即机器人行走的步数。
 * 
 * 输出描述:
 * 输出一个实数,表示红色格子的期望个数,保留一位小数。
 * 
 * 输入例子:
 * 4
 * 
 * 输出例子:
 * 3.4
 * 
 * @author zhenlanghuo
 *
 */
public class 随机的机器人 {
	/**
	 * dp[i%2][j][k]表示走了i步之后恰好有j个红色格子,并且此时机器人正好站在第k个红色格子上的概率。
	 * 最后求一个可能的状态的带权和就是所求期望
	 * 
	 * @param args
	 */
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		double[][][] dp = new double[2][n+3][n+3];
		
		dp[0][1][0] = 1;
		
		for(int i=1;i<=n;i++){
			int cur = i%2;
			int old = 1 - (i%2);
			for(int j=1;j<=i+1;j++){
				for(int k=0;k<j;k++){
					dp[cur][j][k] = 0;
				}
			}
			
			for(int j=1;j<=i+1;j++){
				for(int k=0;k<j;k++){
					//向右走
					int pos1 = j;
					int pos2 = k+1;
					//检查pos1是否等于pos2，如果是的话，向右走将会增加一个红色格子
					if(pos1==pos2)
						pos1++;
					dp[cur][pos1][pos2] += dp[old][j][k]*0.5;
					
					//向左走
					pos1 = j;
					pos2 = k-1;
					//检查pos1是否等于-1，如果是的话，向左走将会增加一个红色格子
					if(pos2==-1){
						pos1++;
						pos2++;
					}
					dp[cur][pos1][pos2] += dp[old][j][k]*0.5;
				}
			}
		}
		
		double reslut = 0;
		
		for(int i=1;i<=n+1;i++){
			for(int j=0;j<i;j++){
				reslut += i*dp[n%2][i][j];
			}
		}
		
		System.out.println(String.format("%.1f", reslut));
		
	}
}
