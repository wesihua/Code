package 笔试.网易游戏;

import java.util.Scanner;

public class 时钟 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		for(int i=0;i<n;i++) {
			String str  = in.nextLine();
			String[] strs = str.split(":");
			
			if(Integer.valueOf(strs[0])>23) {
				StringBuilder stringBuilder = new StringBuilder(strs[0]);
				stringBuilder.setCharAt(0, '0');
				strs[0] = stringBuilder.toString();
			}
			
			if(Integer.valueOf(strs[1])>59) {
				StringBuilder stringBuilder = new StringBuilder(strs[1]);
				stringBuilder.setCharAt(0, '0');
				strs[1] = stringBuilder.toString();
			}
			
			if(Integer.valueOf(strs[2])>59) {
				StringBuilder stringBuilder = new StringBuilder(strs[2]);
				stringBuilder.setCharAt(0, '0');
				strs[2] = stringBuilder.toString();
			}
			
			if(i!=n-1)
				System.out.println(strs[0]+":"+strs[1]+":"+strs[2]);
			else
				System.out.print(strs[0]+":"+strs[1]+":"+strs[2]);
		}
	}
}
