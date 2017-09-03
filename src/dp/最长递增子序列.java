package dp;

/**
 * 题目：
 * 对于一个数字序列，请设计一个复杂度为O(nlogn)的算法，返回该序列的最长上升子序列的长度，这里的子序列定义为这样一个序列U1，U2...，其中Ui < Ui+1，且A[Ui] < A[Ui+1]。
 * 给定一个数字序列A及序列的长度n，请返回最长上升子序列的长度。
 * 
 * 测试样例：
 * [2,1,4,3,1,5,6],7
 * 返回：4
 * 
 * @author zhenlanghuo
 *
 */
public class 最长递增子序列 {
	
	/**
	 * dp[i]记录长度为i的上升子序列的最后一个数中的最小值（可能有多个长度为i的上升子序列，我们只记录最后一个数最小的那个）
	 * 每次遍历的时候在dp[0,max]中找出第一个比A[i]大的数进行替换
	 *
	 */
	public static int findLongest(int[] A,int n){
		int[] dp = new int[n];
		dp[0] = A[0];
		int max = 0;
		
		for(int i=0;i<n;i++){
			int index = binarySearch(dp, 0, max, A[i]);
			if(index<n){
				dp[index] = A[i];
				if(index>max)
					max = index;
			}
		}
		
		return max+1;
	}
	
	/**
	 * 返回第一个比target大的数的下标
	 * 如果没有target大的数，则返回end+1
	 * 
	 */
	public static int binarySearch(int[] dp,int start,int end,int target){
		if(start==end){
			if(dp[start]>=target)
				return start;
			else
				return start+1;
		}
		
		int mid = (start+end)/2;
		if(dp[mid]>target){
			if(mid==start)
				return start;
			return binarySearch(dp, start, mid-1, target);
		}
		else if(dp[mid]<target)
			return binarySearch(dp, mid+1, end, target);
		else
			return mid;
	}
	
	public static void main(String args[]){
		int[] A = {2,1,4,3,1,5,6};
		System.out.println(findLongest(A, A.length));
	}
}
