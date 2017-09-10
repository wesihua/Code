package dp;

/**
 * 题目：
 * 对于两个字符串，请设计一个高效算法，求他们的最长公共子序列的长度，这里的最长公共子序列定义为有两个序列U1,U2,U3...Un和V1,V2,V3...Vn,
 * 其中Ui&ltUi+1，Vi&ltVi+1。且A[Ui]== B[Vi]。
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 * 
 * 测试样例：
 * "1A2C3D4B56",10,"B1D23CA45B6A",12
 * 返回：6
 * 
 * @author zhenlanghuo
 *
 */
public class 最长公共子序列 {
	
	/**
	 * dp[i][j]代表子串A[0...i]和子串B[0...j]最长公共子序列的长度
	 * 
	 * 如果A[i]==B[j],dp[i][j]=dp[i-1][j-1]
	 * 否则，dp[i][j]=max{dp[i][j-1],dp[i-1][j]}
	 * 
	 */
	public static int findLCS(String A, int n, String B, int m) {
		int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
         
        int max = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int tempMax = 0;
                if(A.charAt(i-1)==B.charAt(j-1))
                    tempMax = dp[i-1][j-1]+1;
                else
                    tempMax = Math.max(dp[i][j-1], dp[i-1][j]);
                dp[i][j] = tempMax;
            }
        }
        
        return dp[n][m];
    }
	
	public static void main(String args[]){
		String A = "rsymsknwbiapzhuoeyhjubogitoqfkswhbqhwqzyjuvdlzjlhlaubecnkzgvurdsuvqghpjazgxvue";
		String B = "sclzdzbtrrkdybusjyjrszzqaebkpdtqnqadndvkenqirqqsplmceuuzhukcxxnkcyyvucqjlkysfarxkulpayvtwfmfaqpikzdslpklomafvtesecxygahwnyljldutzsoywiwkugerfbfefcqfvcrzcvbevufzbkbhfeshhdasqo";
		System.out.println(findLCS(A, A.length(), B, B.length()));
	}
	
}
