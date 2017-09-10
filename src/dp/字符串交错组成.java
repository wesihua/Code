package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class 字符串交错组成 {
//	public static boolean chkMixture(String A, int n, String B, int m, String C, int v) {
//        if(n+m!=v)
//        	return false;
//        
//        Map<Integer, List<Integer[]>> map = new HashMap<>();
//        List<Integer[]> list = new ArrayList<>();
//        list.add(new Integer[]{0,0});
//        map.put(-1, list);
//        
//        for(int i=0;i<v;i++){
//        	if(map.get(i-1).size()==0){
//        		return false;
//        	}
//        	List<Integer[]> tempList = new ArrayList<>();
//            map.put(i, tempList);
//        	for(Integer[] array:map.get(i-1)){
//        		int index_A = array[0];
//        		int index_B = array[1];
//        		if(index_A<n && A.charAt(index_A)==C.charAt(i))
//        			map.get(i).add(new Integer[]{index_A+1,index_B});
//        		if(index_B<m && B.charAt(index_B)==C.charAt(i))
//        			map.get(i).add(new Integer[]{index_A,index_B+1});
//        	}
//        }
//        
//        if(map.get(v-1).size()!=0)
//        	return true;
//        else{
//        	return false;
//        }
//    }
	
	/**
	 * dp[i][j]表示A[0...i-1]和B[0...j-1]是否能交错组成C[0...i+j-1]
	 * 对于dp[i][j]，如果A[i-1]==C[i+j-1]且dp[i-1][j]为true，或者B[i-1]==C[i+j-1]且dp[i][j-1]为true，则dp[i][j]也为true
	 * 
	 * 
	 */
	public static boolean chkMixture(String A, int n, String B, int m, String C, int v) {
		if (n + m != v)
			return false;

		boolean[][] dp = new boolean[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				dp[i][j] = false;
			}
		}

		dp[0][0] = true;

		for (int i = 1; i <= n; i++) {
			if (A.charAt(i - 1) == C.charAt(i - 1))
				dp[i][0] = true;
			else
				break;
		}

		for (int i = 1; i <= m; i++) {
			if (B.charAt(i - 1) == C.charAt(i - 1))
				dp[0][i] = true;
			else
				break;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A.charAt(i - 1) != C.charAt(i + j - 1) && B.charAt(j - 1) != C.charAt(i + j - 1))
					dp[i][j] = false;

				if (A.charAt(i - 1) == C.charAt(i + j - 1))
					dp[i][j] = dp[i - 1][j] || dp[i][j];

				if (B.charAt(j - 1) == C.charAt(i + j - 1))
					dp[i][j] = dp[i][j - 1] || dp[i][j];
			}
		}

		return dp[n][m];
	}
	
	public static void main(String args[]){
		String A = "bcbccabccacccbcac";
		String B = "abbbacaabccbccaaaabbcbcbaaacccbaaba";
		String C = "babbbacaabccbccaaaabbcbcbaaacccbaabacbccabccacccbcac";
		System.out.println(chkMixture(A, A.length(), B, B.length(), C, C.length()));
	}
}
