package leetcode;

/**
 * 	Given a string S and a string T, count the number of distinct subsequences of T in S.
	A subsequence of a string is a new string which is formed from the original string by deleting some 
	(can be none) of the characters without disturbing the relative positions of the remaining characters. 
	(ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).
	Here is an example:
	S ="rabbbit", T ="rabbit"
	Return3.
 * @author zhenlanghuo
 *
 */
public class distinct_subsequences {
	
	//dp[i][j]表示S[0...i-1]种有T[0...j-1]不同子串的数目
	//如果S[i-1]!=T[j-1],那么不使用S[i-1](对结果没有影响),即 dp[i][j] = dp[i-1][j]
	//如果S[i-1]==T[j-1],那么可以选择使用或者不使用S[i-1],即 dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
	public static int numDistinct(String S, String T) {
        
		int[][] dp = new int[S.length()+1][T.length()+1];
		
		for(int i=1;i<=T.length();i++) {
			dp[0][i] = 0;
		}
		
		for(int i=1;i<=S.length();i++) {
			dp[i][0] = 1;
		}
		
		dp[0][0] = 1;
		
		for(int i=1;i<=S.length();i++) {
			for(int j=1;j<=T.length();j++) {
				if(S.charAt(i-1)==T.charAt(j-1))
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
        return dp[S.length()][T.length()];
    }
	
	public static void main(String args[]) {
		String S = "rabbbit";
		String T = "rabbit";
		
		System.out.println(numDistinct(S, T));
	}
}
