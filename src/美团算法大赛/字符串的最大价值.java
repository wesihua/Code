package 美团算法大赛;

import java.util.Scanner;

public class 字符串的最大价值 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		for(int i=0;i<n;i++){
			String A = in.nextLine();
			String B = in.nextLine();
			StringBuilder stringBuilder = new StringBuilder();
			System.out.println(solution(A, 0, B, 0, stringBuilder));
		}
	}
	
	public static int solution(String A,int A_start,String B,int B_start,StringBuilder stringBuilder){
		if(stringBuilder.length()==A.length()+B.length()){
			System.out.println(stringBuilder.toString());
			return maxValue(stringBuilder);
		}
		
		int max = 0;
		
		for(int i=A_start;i<A.length();i++){
			stringBuilder.append(A.charAt(i));
			max = Math.max(max, solution(A, i+1, B, B_start, stringBuilder));
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
		
		for(int i=B_start;i<B.length();i++){
			stringBuilder.append(B.charAt(i));
			max = Math.max(max, solution(A, A_start, B, i+1, stringBuilder));
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
		
		return max;
	}
	
	public static int maxValue(StringBuilder stringBuilder){
		StringBuilder stringBuilder2 = stringBuilder.reverse();
		int max = 1;
		int now_max = 0;
		for(int i=0;i<stringBuilder.length();i++){
			if(stringBuilder.charAt(i)==stringBuilder2.charAt(i))
				now_max++;
			else{
				if(now_max>max)
					max = now_max;
				now_max = 0;
			}
		}
		
		if(now_max>max)
			max = now_max;
		
		return max;
	}
}
