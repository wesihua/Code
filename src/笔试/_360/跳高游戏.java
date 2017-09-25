package 笔试._360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 跳高游戏 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bufferedReader.readLine());
		String[] inputs = bufferedReader.readLine().split(" ");
		int[] a = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i] = Integer.valueOf(inputs[i]);
		}
		
		int[] flag = new int[n];
		for(int i=2;i<n;i++) {
			if(a[i]>=a[i-1]&&a[i-1]>=a[i-2])
				flag[i] = 1;
		}
		
		int m = Integer.valueOf(bufferedReader.readLine());
		
		int count = 0;
		for(int i=0;i<m;i++) {
			inputs = bufferedReader.readLine().split(" ");
			int l = Integer.valueOf(inputs[0]);
			int r = Integer.valueOf(inputs[1]);
			
			count = 0;
			for(int j=l;j<=r;j++) {
				if(flag[j-1]==1) {
					if(j-2>=l)
						count++;
				}
			}
			
			if(i!=m-1)
				System.out.println(count);
			else
				System.out.print(count);
		}
	}
}
