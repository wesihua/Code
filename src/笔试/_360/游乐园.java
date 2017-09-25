package 笔试._360;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 游乐园 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t = in.nextInt();
		int[] a = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i] = in.nextInt();
		}
		
		Arrays.sort(a);
		int[] c = new int[n-1];
		for(int i=0;i<n-1;i++) {
			c[i] = a[i];
		}
		
		int[] F = _01bag(n-1, t-1, c, c);
		
		System.out.println(F[t-1]+a[n-1]);
			
	}
	
	public static int[] _01bag(int N,int V,int[] C,int[] W){
		int[] F = new int[V+1];
		
		for(int i=1;i<=N;i++){
			for(int j=V;j>=C[i-1];j--){
				F[j] = Math.max(F[j], F[j-C[i-1]]+W[i-1]);
			}
		}
		
		return F;
		
	}
}
