package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class 字符串排列 {
	public static ArrayList<String> Permutation(String str) {
		Set<String> set = new HashSet<>();
		StringBuffer stringBuffer = new StringBuffer(str);
		StringBuffer result = new StringBuffer();
		permutation(stringBuffer, 0, result, set);
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list);
		return list;
    }
	
	public static void permutation(StringBuffer stringBuffer,int start,StringBuffer result,Set<String> set){
		for(int i=start;i<stringBuffer.length();i++){
			result.append(stringBuffer.charAt(i));
			if(start==stringBuffer.length()-1){
				set.add(result.toString());
			}
			swap(stringBuffer, i, start);
			permutation(stringBuffer, start+1,result,set);
			result.deleteCharAt(result.length()-1);
			swap(stringBuffer, i, start);
		}
	}
	
	public static void swap(StringBuffer str,int x,int y){
		char temp = str.charAt(x);
		str.setCharAt(x, str.charAt(y));
		str.setCharAt(y, temp);;
	}
	
	public static void main(String[] args){
		String str = "cabd";
		ArrayList<String> list = Permutation(str);
		System.out.println(list);
		
	}
}
