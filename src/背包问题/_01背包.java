package 背包问题;

import java.util.ArrayList;
import java.util.List;

import leetcode.candy;

/**
 * 	
 	题目描述：
 	有 N 件物品和一个容量为 V 的背包。放入第 i 件物品耗费的费用是 Ci，得到的
	价值是 Wi。求解将哪些物品装入背包可使价值总和最大。
 * @author zhenlanghuo
 *
 */
public class _01背包 {
	
	/**
	 * 设F[i,v]表示前i个物品放进一个容量为V的背包可以获得的最大价值
	 * F[i,v] = max{F[i-1,v],F[i-1,v-Ci]+Wi}
	 * 
	 * @param N	物品的个数
	 * @param V 背包的容量
	 * @param C	各个物品需要占用的容量
	 * @param W 各个物品的价值
	 * @return F
	 * 
	 */
	public static int[][] solution(int N,int V,int[] C,int[] W){
		 int[][] F = new int[N+1][V+1];
		 
		 for(int i=1;i<=N;i++){
			 for(int j=1;j<=(C[i-1]<=V?C[i-1]:V);j++) {
				 F[i][j] = F[i-1][j];
			 }
			 for(int j=C[i-1];j<=V;j++){
				 F[i][j] = Math.max(F[i-1][j], F[i-1][j-C[i-1]]+W[i-1]);
			 }
		 }
		 
		 return F;
	}
	
	/**
	 * 上面solution的优化版，空间复杂度优化到O(V)
	 * 
	 * @param N	物品的个数
	 * @param V 背包的容量
	 * @param C	各个物品需要占用的容量
	 * @param W 各个物品的价值
	 * @return F
	 */
	public static int[] solution_opt(int N,int V,int[] C,int[] W){
		int[] F = new int[V+1];
		
		for(int i=1;i<=N;i++){
			for(int j=V;j>=C[i-1];j--){
				F[j] = Math.max(F[j], F[j-C[i-1]]+W[i-1]);
			}
		}
		
		return F;
		
	}
	
	/**
	 * 如果F[i][V]!=F[i-1][V]表明第i个物品需要放进背包
	 * 
	 * @param N 物品的个数
	 * @param V 背包的容量
	 * @param F 前i个物品放进一个容量为V的背包可以获得的最大价值
	 * @param C 各个物品需要占用的容量
	 * @return 返回需要装进背包的物品index（从0计数的）
	 */
	public static List<Integer> traceback(int N,int V,int[][] F,int[] C){
		List<Integer> list = new ArrayList<>();
		
		for(int i=N;i>=1;i--){
			if(F[i][V]!=F[i-1][V]){
				list.add(i-1);
				V -= C[i-1];
			}
		}
		
		return list;
	}
	
	public static void main(String args[]){
		int V = 10;
		int[] C = {20,15,15,15,15,15,15,15,15,15,15,15,15,15,15,7,2,15,15,15,15};
		int[] W = {20,15,15,15,15,15,15,15,15,15,15,15,15,15,15,7,2,15,15,15,15};
		int N = C.length;
		
		int[][] F = solution(N, V, C, W);
		
		System.out.println(F[N][V]);
		
		List<Integer> list = traceback(N, V, F, C);
		
		for(int i=list.size()-1;i>=0;i--){
			int itemIndex = list.get(i);
			System.out.println("物品"+itemIndex+" 容量："+C[itemIndex]+" 价值："+W[itemIndex]);
		}
		
		int[] F_opt = solution_opt(N, V, C, W);
		
		System.out.println(F_opt[V]);
		
	}
}
