package leetcode;

import java.util.ArrayList;

/**
 * 	Given a string s, partition s such that every substring of the partition is a palindrome.
	Return all possible palindrome partitioning of s.
	For example, given s ="aab",
	Return
	
	[
    	["aa","b"],
    	["a","a","b"]
  	]
 * @author zhenlanghuo
 *
 */
public class palindrome_partitioning {
	
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		
		//dp[i][j]表示字符串s i到j的子串是否是回文
		boolean[][] dp = new boolean[s.length()][s.length()];
		
		//dp[i][j] = s.charAt(i)==s.charAt(j) && (j-i<2 || dp[i+1][j-1]) i<=j
		//下面l代表步长
		for(int l=0;l<s.length();l++) {
			for(int j=0;j<s.length()-l;j++) {
				dp[j][j+l] = s.charAt(j)==s.charAt(j+l) && (l<=2 || dp[j+1][j+l-1]);
			}
		}
		
//		for(int i=0;i<s.length();i++) {
//			for(int j=i;j<s.length();j++) {
//				System.out.println(i+"-"+j+":"+dp[i][j]);
//			}
//		}
		
		findPartition(s, 0, dp, result, temp);
		
		return result;
		
    }
	
	public void findPartition(String s,int start,boolean[][] dp,ArrayList<ArrayList<String>> result,ArrayList<String> temp) {
		if(start>=s.length()) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i=start;i<s.length();i++) {
			if(dp[start][i]) {
				temp.add(s.substring(start, i+1));
				findPartition(s, i+1, dp, result, temp);
				temp.remove(temp.size()-1);
			}
		}
	}
	
//	public ArrayList<ArrayList<String>> partition(String s) {
//		ArrayList<ArrayList<String>> result = new ArrayList<>();
//		ArrayList<String> temp = new ArrayList<>();
//		
//		findPartition(s, 0, result, temp);
//		
//		return result;
//	}
//	
//	//深度优先搜索（递归实现）
//	public void findPartition(String s,int start,ArrayList<ArrayList<String>> result,ArrayList<String> temp) {
//		if(start>=s.length()) {
//			result.add(new ArrayList<>(temp));
//			return;
//		}
//		
//		for(int i=start;i<s.length();i++) {
//			//判断子串s[start,i]是否回文，若是，则找到分割点，对剩余的子串进行递归计算
//			if(isPalindrome(s, start, i)) {
//				temp.add(s.substring(start, i+1));
//				findPartition(s, i+1, result, temp);
//				temp.remove(temp.size()-1);
//			}
//		}
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
		palindrome_partitioning palindrome_partitioning = new palindrome_partitioning();
		
		String s = "ababababababababababababcbabababababababababababa";
		ArrayList<ArrayList<String>> result = palindrome_partitioning.partition(s);
		
		for(int i=0;i<result.size();i++) {
			for(String str:result.get(i)) {
				System.out.print(str+" ");
			}
			System.out.println();
		}
	}
	
	
}
