package 笔试.网易游戏;

import java.util.Scanner;

public class 字符迷阵 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.valueOf(in.nextLine());
		for(int r=0;r<T;r++) {
			String[] inputs = in.nextLine().split(" ");
			int m = Integer.valueOf(inputs[0]);
			int n = Integer.valueOf(inputs[1]);
			
			String[] strings = new String[m];
			for(int i=0;i<m;i++) {
				strings[i] = in.nextLine();
			}
			
			String target = in.nextLine();
			
			if(r!=T-1)
				System.out.println(find(strings, m, n, target));
			else
				System.out.print(find(strings, m, n, target));
			
		}
	}
	
	public static int find(String[] strings,int m,int n,String target) {
		int result = 0;
		
		for(int i=0;i<m;i++) {
			String line = strings[i];
			for(int j=0;j<n;j++) {
				if(line.charAt(j)==target.charAt(0)) {
					boolean flag = true;
					//向右找
					if(target.length()+j-1<n) {
						for(int k=1;k<target.length();k++) {
							if(target.charAt(k)!=line.charAt(j+k)) {
								flag = false;
								break;
							}
						}
						if(flag)
							result++;
					}
					
					flag = true;
					//向下找
					if(target.length()+i-1<m) {
						for(int k=1;k<target.length();k++) {
							if(target.charAt(k)!=strings[i+k].charAt(j)) {
								flag = false;
								break;
							}
						}
						if(flag)
							result++;
					}
					
					flag = true;
					//向右下找
					if(target.length()+j-1<n&&target.length()+i-1<m) {
						for(int k=1;k<target.length();k++) {
							if(target.charAt(k)!=strings[i+k].charAt(j+k)) {
								flag = false;
								break;
							}
						}
						if(flag)
							result++;
					}
				}
			}
		}
		
		return result;
	}
}
