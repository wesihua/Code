package 笔试.网易;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 最长公共子括号序列 {
	public static void main(String args[]) {
//		Scanner in = new Scanner(System.in);
//		String s = in.nextLine();
//		
//		HashSet<String> set = new HashSet<>();
//		StringBuilder stringBuilder = new StringBuilder();
//		
//		getStrings(s.length()/2, 0, 0, set, stringBuilder);
//		
//		int[] array = new int[s.length()+1];
//		
//		set.remove(s);
//		
//		for(String str:set) {
//			array[findLCS(str, s.length(), s, s.length())]++;
//		}
//		
//		for(int i=s.length()-1;i>=0;i++) {
//			if(array[i]!=0) {
//				System.out.println(array[i]);
//				return;
//			}
//		}
		
		String s = "((())())";

		HashSet<String> set = new HashSet<>();
		StringBuilder stringBuilder = new StringBuilder();

		//getStrings(s.length() / 2, 0, 0, set, stringBuilder);

		for (int i = 0; i < s.length(); i++) {
			String w = s.substring(0, i) + s.substring(i + 1);
			for (int j = 0; j < s.length() - 1; j++) {
				String u = w.substring(0, j) + s.charAt(i) + w.substring(j);
				int temp = 0;
				for (int k = 0; k < s.length(); k++) {
					temp += u.charAt(k) == '(' ? 1 : -1;
					if (temp < 0)
						break;
				}
				if(temp>=0)
					set.add(u);
			}
		}
		
		for(String str:set) {
			System.out.print(str+" "+findLCS(str, str.length(), s, s.length()));
			System.out.println();
		}
		
		
		
		
		
	}
	
	public static void getStrings(int n,int left,int right,HashSet<String> set,StringBuilder s) {
		if(left==n) {
			for(int i=0;i<left-right;i++) {
				s.append(")");
			}
			set.add(s.toString());
			for(int i=0;i<left-right;i++) {
				s.deleteCharAt(s.length()-1);
			}
			return;
		}
		
		s.append("(");
		getStrings(n, left+1, right, set, s);
		s.deleteCharAt(s.length()-1);
		
		if(left>right) {
			s.append(")");
			getStrings(n, left, right+1, set, s);
			s.deleteCharAt(s.length()-1);
		}
	}
	
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
	
	
}
