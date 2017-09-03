package leetcode;

public class unique_paths_II {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] dp = new int[m+1][n+1];
		
		dp[1][1] = 1;
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(i==1&&j==1&&obstacleGrid[i-1][j-1]==1)
					dp[i][j] = 0;
				if((i!=1||j!=1)&&obstacleGrid[i-1][j-1]!=1)
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
	
		return dp[m][n];
    }
}
