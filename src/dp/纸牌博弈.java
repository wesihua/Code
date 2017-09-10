package dp;

/**
 * 题目：
 * 有一个整型数组A，代表数值不同的纸牌排成一条线。玩家a和玩家b依次拿走每张纸牌，规定玩家a先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家a和玩家b都绝顶聪明，他们总会采用最优策略。请返回最后获胜者的分数。
 * 给定纸牌序列A及序列的大小n，请返回最后分数较高者得分数(相同则返回任意一个分数)。保证A中的元素均小于等于1000。且A的大小小于等于300。
 * 
 * 测试样例：
 * [1,2,100,4],4
 * 返回：101
 * 
 * @author zhenlanghuo
 *
 */
public class 纸牌博弈 {
	/*
	 * dp[i][j]代表最优的情况，如果j-i+1是偶数，dp[i][j]代表的是先手的最优情况，如果j-i+1是奇数，dp[i][j]代表的是后手的最优情况
	 * dp[i][j] = Math.max(A[i]+sum[i+1][j]-dp[i+1][j], A[j]+sum[i][j-1]-dp[i][j-1])，sum[i][j]代表A[i]到A[j]的总和
	 * 比如，dp[0][3]，如果拿A[0],那么在拿A[0]的情况下的最优结果是A[0]+sum[1][3]-dp[1][3](dp[1][3]是另外一个人的最优情况)
	 * 同理拿A[3]的最优结果是A[3]+sum[0][2]-dp[0][2]，所以dp[0][3]的最优情况就是这两个最优结果中更优的一个。
	 */
	public static int cardGame(int[] A, int n) {
		int[][] dp = new int[n][n];
		
		int max = 0;
		
//		int[][] sum = new int[n][n];
//		for(int r=1;r<=n;r++){
//			System.out.println("r:"+r);
//			for(int i=0;i<n-r+1;i++){
//				int j = i+r-1;
//				if(i==j)
//					sum[i][j] = A[j];
//				else
//					sum[i][j] = A[j] + sum[i][j-1];
//				System.out.println("i:"+i+" j:"+j+"   "+sum[i][j]);
//			}
//		}
		
		//优化sum数组，sum[i]代表A[0]到A[i-1]的总和
		//sum[j]-sum[i]代表A[i]到A[j-1]的总和
		int[] sum = new int[n+1];
		for(int i=1;i<=n;i++) {
			sum[i] = sum[i-1] + A[i-1];
		}
		
		for(int r=1;r<=n;r++){
			System.out.println("r:"+r);
			for(int i=0;i<n-r+1;i++){
				int j = i+r-1;
				if(i==j)
					dp[i][j] = A[i];
				else
					//dp[i][j] = Math.max(A[i]+sum[i+1][j]-dp[i+1][j], A[j]+sum[i][j-1]-dp[i][j-1]);
					dp[i][j] = Math.max(A[i]+(sum[j+1]-sum[i+1])-dp[i+1][j], A[j]+(sum[j]-sum[i])-dp[i][j-1]);
				
				System.out.println("i:"+i+" j:"+j+"   "+dp[i][j]);
				
				if(dp[i][j]>max)
					max = dp[i][j];
			}
		}
		
		//return Math.max(dp[0][n-1], sum[0][n-1]-dp[0][n-1]);
		return Math.max(dp[0][n-1], sum[n]-dp[0][n-1]);
    }
	
	public static void main(String args[]){
		int[] A = {19,11,45,45,43,0,77,78,86,50,40,12,35,26,35,3,58,24,63,79,23,59,8,64,99,68,35,28,61,72,54,30,50,70,40,52,82,34,8,9,46,22,84,67,70,56,11,59,54,60,97,38,0,90,81,44,75,76,74,86,73,90,53,70,56,92,50,84,95,9,6,50,39,32,14,93,1,72};
		System.out.println(cardGame(A, A.length));
	}
}
