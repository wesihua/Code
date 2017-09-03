package 笔试.网易;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Scanner;

public class 优雅的点 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n_2 = in.nextInt();
		
		int sum = 0;
		int n = (int) Math.ceil(Math.pow(n_2, 1.0/2));
		
		if(n*n==n_2)
			sum = 4;

		for(int i=1;i<n;i++){
			int x = (int) Math.pow(n_2-i*i, 1.0/2);
			if(x*x==n_2-i*i){
				sum += 4;
			}
		}
		
		System.out.println(sum);
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		StringBuilder builder = new StringBuilder();
		
	}
}
