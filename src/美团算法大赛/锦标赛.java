package 美团算法大赛;

import java.util.Scanner;

public class 锦标赛 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//小美的积分
		int score = in.nextInt();
		int bigger = 0;
		int smaller = 0;
		for(int i=0;i<n-1;i++){
			if(in.nextInt()>score)
				bigger++;
			else
				smaller++;
		}
		
		int count = 0;
		while(smaller>0){
			if(bigger%2==0){
				bigger = bigger/2;
				smaller = (smaller-1)/2;
			}
			else{
				bigger = (bigger+1)/2;
				smaller = (smaller-2)/2;
			}
			count++;
		}
		
		System.out.println(count);
	}
}
