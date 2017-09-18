package dp;

/**
 * 
	序列中任意个连续的元素组成的子序列称为该序列的子串。
	现在给你一个序列P和一个整数K，询问元素和是K的倍数的子串的最大长度。
	比如序列【1,2,3,4,5】，给定的整数K为 5，其中满足条件的子串为{5}、{2,3}、{1,2,3,4}、{1,2,3,4,5}，
	那么答案就为 5，因为最长的子串为{1,2,3,4,5}；如果满足条件的子串不存在，就输出 0。
 * @author zhenlanghuo
 *
 */
public class 和为k的倍数的最长子串 {
	/**
	 * sum[i]等于array[0...i-1]的和
	 * dp[i]代表的是array数组中前n个连续元素的和与k的mod为i的最小的n值
	 * 
	 * 对sum数组进行遍历，记录dp[sum[i]%k]的最小i值
	 * dp[sum[i]%k] = dp[sum[i]%k]==-1 ? i : dp[sum[i]%k]
	 * 
	 * 若dp[sum[i]%k]！=-1，(sum[i]-sum[dp[sum[i]%k]])%k==0，也就是array[dp[sum[i]%k]+1...i]子串和为k的倍数
	 * 
	 */
	public static int getKMaxLength(int[] array,int k) {
		int[] sum = new int[array.length+1];
		int[] dp = new int[k];
		
		for(int i=0;i<array.length;i++) {
			sum[i+1] = sum[i] + array[i];
		}
		
		for(int i=1;i<dp.length;i++) {
			dp[i] = -1;
		}
		
		int ans = 0;
		for(int i=1;i<sum.length;i++) {
			ans = Math.max(ans, dp[sum[i]%k]==-1 ? -1 : i-dp[sum[i]%k]);
			dp[sum[i]%k] = dp[sum[i]%k]==-1 ? i : dp[sum[i]%k];
		}
		
		return ans;
	}
	
	public static void main(String args[]) {
		int[] array = {3,1,2,3,4,6};
		System.out.println(getKMaxLength(array, 5));
	}
}
