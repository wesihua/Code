package 背包问题;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：
 * 有 N 种物品和一个容量为 V 的背包，每种物品都有无限件可用。放入第 i 种物品
         的费用是 Ci，价值是 Wi。求解：将哪些物品装入背包，可使这些物品的耗费的费用总
        和不超过背包容量，且价值总和最大。
 * @author zhenlanghuo
 *
 */
public class 完全背包 {
	
	/**
	 * 设F[i,v]表示前i个物品放进一个容量为V的背包可以获得的最大价值
	 * F[i,v] = max{F[i-1,v-kCi]+kWi|0<=kCi<=v}
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
			 for(int j=C[i-1];j<=V;j++){
				 int k = 0;
				 while(j>=k*C[i-1]){
					 F[i][j] = Math.max(F[i][j],F[i-1][j-k*C[i-1]]+k*W[i-1]);
					 k++;
				 }
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
			while(F[i][V]!=F[i-1][V]){
				list.add(i-1);
				V -= C[i-1];
			}
		}
		
		return list;
	}
	
	
	/**
	 * 01 背包中要按照v递减的次序来循环。
	 * 让 v递减是为了保证第 i 次循环中的状态 F[i,v] 是由状态 F[i−1,v−Ci] 递推而来。
	 * 换句话说，这正是为了保证每件物品只选一次，保证在考虑“选入第 i件物品”这件策略时，依据的是一个绝无已经选入第 i件物品的子结果 F[i−1,v−Ci]。
	 * 
	 * 而现在完全背包的特点恰是每种物品可选无限件，所以在考虑“加选一件第 i 种物品”这种策略时，
	 * 却正需要一个可能已选入第 i种物品的子结果 F[i,v−Ci]，所以就可以并且必须采用 v递增的顺序循环。
	 *
	 * @param N	物品的个数
	 * @param V 背包的容量
	 * @param C	各个物品需要占用的容量
	 * @param W 各个物品的价值
	 * @return
	 */
	public static int[] solution_opt(int N,int V,int[] C,int[] W){
		int[] F = new int[V+1];
		
		for(int i=1;i<=N;i++){
			for(int j=C[i-1];j<=V;j++){
				F[j] = Math.max(F[j], F[j-C[i-1]]+W[i-1]);
			}
		}
		
		return F;
	}
	
	public static void main(String args[]){
		int N = 5;
		int V = 10;
		int[] C = {3,2,6,5,4};
		int[] W = {6,3,5,4,7};
		
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
