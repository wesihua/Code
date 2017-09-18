package 笔试.今日头条;

import java.util.HashMap;
import java.util.Scanner;

public class 字母交换 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine().split(" ")[0];
		HashMap<Character, Integer> map = new HashMap<>();
		int max = 0;
		int count = 1;
		for(int i=1;i<str.length();i++) {
			if(str.charAt(i)==str.charAt(i-1)) {
				count++;
				max = Math.max(max, count);
			}
			else {
				count = 1;
			}
		}
		
		System.out.println(max);
	}
}
