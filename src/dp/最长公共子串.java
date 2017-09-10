package dp;

/**
 * 题目：
 * 对于两个字符串，请设计一个时间复杂度为O(m*n)的算法(这里的m和n为两串的长度)，求出两串的最长公共子串的长度。
 * 这里的最长公共子串的定义为两个序列U1,U2,..Un和V1,V2,...Vn，其中Ui + 1 == Ui+1,Vi + 1 == Vi+1，同时Ui == Vi。
 * 给定两个字符串A和B，同时给定两串的长度n和m。
 * 
 * 测试样例：
 * "1AB2345CD",9,"12345EF",7
 * 返回：4
 * 
 * 
 * @author zhenlanghuo
 *
 */
public class 最长公共子串 {
	
	/**
	 * dp[i][j]代表已A[i-1]和B[j-1]为结尾的公共子串的最长长度（若A[i-1]!=B[j-1],dp[i][j]==0）
	 *
	 * 如果A[i-1]==B[i-1]&&A[i-2]==B[i-2], dp[i][j] == dp[i-1][j-1] + 1
	 * 如果A[i-1]==B[i-1], dp[i][j] = 1
	 * 如果A[i-1]!=B[i-1], dp[i][j] = 0
	 *
	 */
	public static int findLongest(String A, int n, String B, int m) {
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<=n;i++){
        	dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
        	dp[0][i] = 0;
        }
        
        int max = 0;
        for(int i=1;i<=n;i++){
        	for(int j=1;j<=m;j++){
        		if(A.charAt(i-1)==B.charAt(j-1)){
        			if(i-2>=0 && j-2>=0 && A.charAt(i-2)==B.charAt(j-2))
        				dp[i][j] = dp[i-1][j-1] + 1;
        			else{
        				dp[i][j] = 1;
        			}
        			
        			if(dp[i][j]>max)
            			max = dp[i][j];
        		}
        		else{
        			dp[i][j] = 0;
        		}
        	}
        }
        
        return max;
    }
	
	public static void main(String args[]){
		String A = "12345CC1235";
		String B = "12345B12345";
		System.out.println(findLongest(A, A.length(), B, B.length()));
	}
}
