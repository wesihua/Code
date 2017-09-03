package 笔试.牛客;

import java.util.HashMap;
import java.util.Map.Entry;

public class 优美的回文串 {
	
	static String[] word = {"A","B","C","D","E","F","G","H","I","J","K"};
	
	public static void re(int M,StringBuilder s,int temp){
		if(temp<=0){
			System.out.println(s);
			return;
		}
		for(int i=0;i<M;i++){
			s.append(word[i]);
			re(M, s, temp-1);
			s.deleteCharAt(s.length()-1);
		}
	}
	
	public static void find(int M,int n,int k){
		for(int i=0;i<M;i++){
			for(int j=0;j<26;j++){
				
			}
		}
	}
	
	public static void main(String[] args){
		re(5, new StringBuilder(),5);
	}
}
