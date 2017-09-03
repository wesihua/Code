package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class 字符串交错组成 {
	public static boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        if(n+m!=v)
        	return false;
        
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{0,0});
        map.put(-1, list);
        
        for(int i=0;i<v;i++){
        	if(map.get(i-1).size()==0){
        		return false;
        	}
        	List<Integer[]> tempList = new ArrayList<>();
            map.put(i, tempList);
        	for(Integer[] array:map.get(i-1)){
        		int index_A = array[0];
        		int index_B = array[1];
        		if(index_A<n && A.charAt(index_A)==C.charAt(i))
        			map.get(i).add(new Integer[]{index_A+1,index_B});
        		if(index_B<m && B.charAt(index_B)==C.charAt(i))
        			map.get(i).add(new Integer[]{index_A,index_B+1});
        	}
        }
        
        if(map.get(v-1).size()!=0)
        	return true;
        else{
        	return false;
        }
    }
	
	public static void main(String args[]){
		String A = "bcbccabccacccbcac";
		String B = "abbbacaabccbccaaaabbcbcbaaacccbaaba";
		String C = "babbbacaabccbccaaaabbcbcbaaacccbaabacbccabccacccbcac";
		System.out.println(chkMixture(A, A.length(), B, B.length(), C, C.length()));
	}
}
