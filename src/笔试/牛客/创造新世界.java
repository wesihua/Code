package 笔试.牛客;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class 创造新世界 {
	
	public static int find(int[][] countOf01,int end,int n,int m){
		if(n==0&&m==0)
			return 0;
		if(end<0)
			return 0;
		
		int sum_0 = countOf01[end][0];
		int sum_1 = countOf01[end][1];
		
		int max_1 = -1;
		int max_0 = 0;
		if(sum_0<=n&&sum_1<=m)
			max_1 = find(countOf01, end-1, n-sum_0, m-sum_1);
		
		max_0 = find(countOf01, end-1, n, m);
		
		//System.out.println("end:"+end+" max_1:"+max_1+" max_0:"+max_0);
		
		return Math.max(max_1+1, max_0);
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String firstLine = in.nextLine();
		String[] content = firstLine.split(" ");
		int x = Integer.valueOf(content[0]);
		int n = Integer.valueOf(content[1]);
		int m = Integer.valueOf(content[2]);
		int[][] countOf01 = new int[x][2];
		for(int i=0;i<x;i++){
			String str = in.nextLine();
			int length = str.length();
			countOf01[i][0] = str.replace("1", "").length();
			countOf01[i][1] = length - countOf01[i][0];
		}
		in.close();
		
//		for(int i=0;i<x;i++){
//			System.out.println("0:"+countOf01[i][0]+"  1:"+countOf01[i][1]);
//		}
		System.out.println(find(countOf01, countOf01.length-1, n, m));
	}
}
