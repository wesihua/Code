package 笔试.滴滴;

import java.util.Scanner;

public class 翻转句子中的单词顺序 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String content = in.nextLine();
		
		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder result = new StringBuilder();
		for(int i=0;i<content.length();i++){
			if(content.charAt(i)!=' '){
				stringBuilder.append(content.charAt(i));
			}
			else{
				if(stringBuilder.length()!=0){
					result.append(stringBuilder.reverse()+" ");
					stringBuilder.delete(0, stringBuilder.length());
				}
			}
		}
		if(stringBuilder.length()!=0){
			result.append(stringBuilder.reverse());
			stringBuilder.delete(0, stringBuilder.length()-1);
		}
		
		System.out.println(result.toString());
	}
}
