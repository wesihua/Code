package leetcode;

import java.util.ArrayList;

/**
 * 	Given a string s, partition s such that every substring of the partition is a palindrome.
	Return the minimum cuts needed for a palindrome partitioning of s.
	For example, given s ="aab",
	Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 * @author zhenlanghuo
 *
 */
public class palindrome_partitioning_II {
	public int minCut(String s) {
		//return findMinPartitions(s, 0, new ArrayList<>()) - 1;
		
		//isPalindrome[i][j]表示字符串s i到j的子串是否是回文
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		
//		//isPalindrome[i][j] = s.charAt(i)==s.charAt(j) && (j-i<2 || isPalindrome[i+1][j-1]) i<=j
//		//下面l代表步长
//		for(int l=0;l<s.length();l++) {
//			for(int j=0;j<s.length()-l;j++) {
//				isPalindrome[j][j+l] = s.charAt(j)==s.charAt(j+l) && (l<=2 || isPalindrome[j+1][j+l-1]);
//			}
//		}
		
		//dp[i]表示当前i到len-1这段的最小分割数
		//dp[i]=min{dp[j+1]+1}（i=<j<len）其中str[i..j]必须是回文
		int[] dp = new int[s.length()+1];
		dp[s.length()] = -1;//确保dp[s.length()-1]=0
		for(int i=s.length()-1;i>=0;i--) {
			dp[i] = Integer.MAX_VALUE;
			for(int j=i;j<s.length();j++) {
				if(s.charAt(j)==s.charAt(i) && (j-i<=2 || isPalindrome[i+1][j-1])) {
					isPalindrome[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j+1]+1);
				}
			}
		}
		
		return dp[0];
		
//		//dp[i]表示当前0到i这段的最小分割数
//		//dp[i]=min{dp[j-1]+1} (j<=i<len) 其中str[j..i]必须是回文
//		int[] dp = new int[s.length()+1];
//		dp[0] = -1;
//		for(int i=1;i<=s.length();i++) {
//			dp[i] = Integer.MAX_VALUE;
//			for(int j=1;j<=i;j++) {
//				if(isPalindrome[j-1][i-1])
//					dp[i] = Math.min(dp[i],dp[j-1]+1);
//			}
//		}
//		
//		return dp[s.length()];
    }
	
	
	
//	//深度优先搜索（递归实现）
//	public int findMinPartitions(String s,int start,ArrayList<String> temp) {
//		if(start>=s.length()) {
//			return temp.size();
//		}
//		
//		int min = Integer.MAX_VALUE;
//		
//		for(int i=start;i<s.length();i++) {
//			//判断子串s[start,i]是否回文，若是，则找到分割点，对剩余的子串进行递归计算
//			if(isPalindrome(s, start, i)) {
//				temp.add(s.substring(start, i+1));
//				min = Math.min(min, findMinPartitions(s, i+1, temp));
//				temp.remove(temp.size()-1);
//			}
//		}
//		
//		return min;	
//	}
//	
//	//判断子串s[start,end]是否回文
//	public boolean isPalindrome(String s,int start,int end) {
//		for(int i=start,j=end;i<=j;i++,j--) {
//			if(s.charAt(i)!=s.charAt(j))
//				return false;
//		}
//		
//		return true;
//	}
	
	public static void main(String args[]) {
		palindrome_partitioning_II palindrome_partitioning_II = new palindrome_partitioning_II();
		
		String s = "ababababababababababababcbabababababababababababa";
		System.out.println(palindrome_partitioning_II.minCut(s));
		
		
	}
}

