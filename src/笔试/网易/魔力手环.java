package 笔试.网易;

import java.util.Scanner;

public class 魔力手环 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String[] n_k = in.nextLine().split(" ");
		int n = Integer.valueOf(n_k[0]);
		int k = Integer.valueOf(n_k[1]);
		int[] array = new int[n];
		for(int i=0;i<n;i++){
			array[i] = in.nextInt();
		}
		
		
		int[] array_new = new int[n];
//		for(int i=0;i<n;i++){
//			int end = k>n?(i-1+n);
//			for(int j=1;j<k;j++){
//				array_new[i] = k*array[j];
//			}
//			
//			array_new[i] = (int) Math.ceil(k/n);
//		}
		
//		for(int i=0;i<n-1;i++){
//			System.out.print(array[i]+" ");
//		}
//		System.out.println(array[n-1]);
	}
}
