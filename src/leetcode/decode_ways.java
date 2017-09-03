package leetcode;

/**
 * 
 * 	A message containing letters fromA-Zis being encoded to numbers using the following mapping:
	'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	Given an encoded message containing digits, determine the total number of ways to decode it.
	For example,
	Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
	The number of ways decoding"12"is 2.
 * 
 * @author zhenlanghuo
 *
 */
public class decode_ways {
	public static int numDecodings(String s) {
		if(s.length()<1)
			return s.length();
		
		int[] dp = new int[s.length()+1];
		
		if(s.charAt(0)-'0'>0)
			dp[1] = 1;
		
		for(int i=2;i<=s.length();i++) {
			if(dp[i-1]==0)
				break;
			if(s.charAt(i-1)=='0') {
				if(s.charAt(i-2)!='0'&&Integer.valueOf(s.substring(i-2, i))<=26)
					dp[i] = (dp[i-2]==0?1:dp[i-2]);
				else
					dp[i] = 0;
			}
			else {
				if(s.charAt(i-2)!='0'&&Integer.valueOf(s.substring(i-2, i))<=26)
					dp[i] = dp[i-1] + (dp[i-2]==0?1:dp[i-2]);
				else
					dp[i] = dp[i-1];
			}
		}
		
		return dp[s.length()];
    }
	
	public static void main(String args[]) {
		System.out.println(numDecodings("012"));
	}
}
