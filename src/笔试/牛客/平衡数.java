package 笔试.牛客;

import java.util.Scanner;

public class 平衡数 {
	public static String judge(int num){
		String numStr = String.valueOf(num);
		
		if(numStr.length()<2)
			return "NO";
		
		for(int i=0;i<numStr.length()-1;i++){
			String a = numStr.substring(0, i+1);
			String b = numStr.substring(i+1, numStr.length());
			if(claculate(a)==claculate(b))
				return "YES";
		}
		
		return "NO";
	}
	
	public static int claculate(String num){
		int result = 1;
		for(int i=0;i<num.length();i++){
			result *= (num.charAt(i)-48);
		}
		
		return result;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			System.out.println(judge(num));
		}
		
//		char c = '1';
//		System.out.println(c-48);
	}
}
