package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * 	Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
	For example, given the following triangle
	
	[
     	  [2],
    	 [3,4],
   		[6,5,7],
  	   [4,1,8,3]
	]
	
	The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
	
	Note: 
	Bonus point if you are able to do this using only O(n) extra space, 
	where n is the total number of rows in the triangle.
 * 
 * @author zhenlanghuo
 *
 */
public class triangle {
	
	//dp[i][j]表示到行为i列为j的所有路径中的最小路径和
	//dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j])+val[i][j]
	//然后做一下滚动优化，空间复杂度优化成O(n)
	//另外要注意处理一下边界问题，比如每行最左和最右的数与上一行相邻的数只有一个
	//我这里是特地开了triangle.size()+2大小的数组，dp[i]代表某行第i-1列，这样可以比较好的应对边界问题
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] dp = new int[triangle.size()+2];
		
		for(int i=0;i<dp.length;i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		dp[1] = 0;
		for(int i=0;i<triangle.size();i++) {
			for(int j=triangle.get(i).size()-1;j>=0;j--) {
				int num = triangle.get(i).get(j);
				dp[j+1] = Math.min(dp[j], dp[j+1]) + num;
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int i=0;i<dp.length;i++) {
			result = Math.min(result, dp[i]);
		}
		
		return result;
    }
	
	public static void main(String args[]) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
		ArrayList<Integer> list0 = new ArrayList<>();
		list0.add(2);
		triangle.add(list0);
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(3);
		list1.add(4);
		triangle.add(list1);
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(5);
		list2.add(6);
		list2.add(7);
		triangle.add(list2);
		ArrayList<Integer> list3 = new ArrayList<>();
		list3.add(4);
		list3.add(1);
		list3.add(8);
		list3.add(3);
		triangle.add(list3);
		
		System.out.println(minimumTotal(triangle));
	}
}
