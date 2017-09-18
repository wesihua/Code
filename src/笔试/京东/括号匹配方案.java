package 笔试.京东;

import java.util.Scanner;
import java.util.Stack;

public class 括号匹配方案 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		StringBuilder input = new StringBuilder(in.nextLine());
		
		int result = 1;
		
		while(input.length()!=0) {
			Stack<Integer> stack = new Stack<>();
			int[] array = new int[input.length()];
			int[] sum = new int[input.length()+1];
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)=='(') {
					stack.push(i);
					sum[i+1] = sum[i];
				}
				else if(input.charAt(i)==')'){
					array[stack.pop()] = i;
					sum[i+1] = sum[i] + 1;
				}
				else {
					sum[i+1] = sum[i];
				}
			}
			
			for(int i=0;i<array.length;i++) {
				if(array[i]!=0) {
					result *= sum[array[i]+1] - sum[i+1];
					break;
				}
			}
		}
		
		System.out.println(result);
	}
}





