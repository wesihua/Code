package 笔试.阿里;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 过滤 {
//	public static void main(String args[]){
//		Scanner in = new Scanner(System.in);
//		String str = in.nextLine();
//		String pattern = in.nextLine();
//		char[] str_ = new char[str.length()];
//		char[] pattern_ = new char[pattern.length()];
//		for(int i=0;i<str.length();i++){
//			str_[i] = str.charAt(i);
//		}
//		for(int i=0;i<pattern.length();i++){
//			pattern_[i] = pattern.charAt(i);
//		}
//		
//		if(match(str_, 0, pattern_, 0))
//			System.out.println(1);
//		else
//			System.out.println(0);
//		
//		 Pattern p = Pattern.compile("a*b");
//		 Matcher m = p.matcher("aaaaab");
//		 boolean b = m.matches();
//	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String s = sc.next();
			String p = sc.next();
			boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
			dp[0][0] = true;
			for (int i = 1; i < dp[0].length; i ++) {
				if(p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 1];
			}
			for (int i = 1; i < dp.length; i ++) {
				for (int j = 1; j < dp[0].length; j ++) {
					if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
					else if(p.charAt(j - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
			if(dp[s.length()][p.length()]) System.out.println(1);
			else System.out.println(0);
		}
	}
	
	public static boolean match(char[] str,int strIndex,char[] pattern,int patternIndex){
		//str到尾，pattern到尾，匹配成功
		if(strIndex==str.length && patternIndex == pattern.length){
			return true;
		}
		//pattern先到尾，匹配失败
		if(strIndex!=str.length && patternIndex == pattern.length){
			return false;
		}
		
		if(strIndex!=str.length && pattern[patternIndex]=='?' && patternIndex+1<pattern.length && pattern[patternIndex+1]=='*'){
			return match(str, strIndex, pattern, patternIndex+2)
					|| match(str, strIndex+1, pattern, patternIndex)
					|| match(str, strIndex+1, pattern, patternIndex+1)
					|| match(str, strIndex+1, pattern, patternIndex+2);
		}
		
		if(pattern[patternIndex]=='*'){
			if(strIndex!=str.length){
				return match(str, strIndex, pattern, patternIndex+1)
						|| match(str, strIndex+1, pattern, patternIndex)
						|| match(str, strIndex+1, pattern, patternIndex+1);
			}
			else
				return match(str, strIndex, pattern, patternIndex+1);
		}
		
		//模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
		if((strIndex!=str.length && pattern[patternIndex]==str[strIndex]) || (strIndex!=str.length && pattern[patternIndex]=='?')){
			return match(str, strIndex+1, pattern, patternIndex+1);
		}
		
		return false;
	}
	
}
