package leetcode;

/**
 * 	Given a m x n grid filled with non-negative numbers, 
 * 	find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	Note: You can only move either down or right at any point in time.

 * @author zhenlanghuo
 *
 */
public class minimum_path_sum {
	public int minPathSum(int[][] grid) {
		
		int row = grid.length;
		int col = grid[0].length;
        int[][] dp = new int[row+1][col+1];
        for(int i=0;i<=row;i++) {
        	dp[i][0] = Integer.MAX_VALUE;
        }
        for(int j=0;j<=col;j++) {
        	dp[0][j] = Integer.MAX_VALUE;
        }
        for(int i=1;i<=row;i++) {
        	for(int j=1;j<=col;j++) {
        		if(i!=1||j!=1)
        			dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
        	}
        }
        
        return dp[row][col];
        
    }
}
