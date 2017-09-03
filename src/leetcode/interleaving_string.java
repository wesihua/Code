package leetcode;

/**
 * 	Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
	For example,
	Given:
	s1 ="aabcc",
	s2 ="dbbca",
	When s3 ="aadbbcbcac", return true.
	When s3 ="aadbbbaccc", return false.
 *
 * @author zhenlanghuo
 *
 */
public class interleaving_string {
	/**
	 * dp[i][j]代表用s1的前i个字符和s2的前j个字符，是否能穿插生成和s3前i+j个字符一样的字符串
	 * dp[0][0] = true
	 * s1.charAt(i-1)==s3.charAt(k-1)&&dp[i-1][j] => dp[i][j] = true;
	 * s2.charAt(j-1)==s3.charAt(k-1)&&dp[i][j-1] => dp[i][j] = true;
	 * 
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length()+s2.length()!=s3.length())
			return false;
		
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        
        dp[0][0] = true;
        
        for(int i=0;i<=s1.length();i++) {
        	for(int j=0;j<=s2.length();j++) {
        		int k = i+j;
        		
        		if(i>0&&s1.charAt(i-1)==s3.charAt(k-1)) {
        			if(dp[i-1][j])
        				dp[i][j] = dp[i][j] || true;
        		}
        		if(j>0&&s2.charAt(j-1)==s3.charAt(k-1)) {
        			if(dp[i][j-1])
        				dp[i][j] = dp[i][j] || true;
        		}
        	}
        }
		
		return dp[s1.length()][s2.length()];
    }
	
	public static void main(String args[]) {
		System.out.println(isInterleave("a", "b", "aa"));
	}
}
