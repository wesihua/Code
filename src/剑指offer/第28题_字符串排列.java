package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class 第28题_字符串排列 {
	public static ArrayList<String> Permutation(String str) {
		Set<String> set = new HashSet<>();
		StringBuffer stringBuffer = new StringBuffer(str);
		StringBuffer result = new StringBuffer();
		permutation(stringBuffer, 0, set);
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list);
		return list;
    }
	
	public static void permutation(StringBuffer stringBuffer,int start,Set<String> set){
		for(int i=start;i<stringBuffer.length();i++){
			if(start==stringBuffer.length()-1){
				set.add(stringBuffer.toString());
			}
			swap(stringBuffer, i, start);
			permutation(stringBuffer, start+1,set);
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
