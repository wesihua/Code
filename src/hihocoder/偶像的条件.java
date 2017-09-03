package hihocoder;

import java.util.Arrays;
import java.util.Scanner;

public class 偶像的条件 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int L = in.nextInt();
		
		int[] A = new int[N];
		int[] B = new int[M];
		int[] C = new int[L];
		
		for(int i=0;i<N;i++){
			A[i] = in.nextInt();
		}
		for(int i=0;i<M;i++){
			B[i] = in.nextInt();
		}
		for(int i=0;i<L;i++){
			C[i] = in.nextInt();
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		Arrays.sort(C);
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(A[i]<B[j] && Math.abs(A[i]-B[j])>min)
					break;
				if(Math.abs(A[i]-B[j])>min)
					continue;
				for(int k=0;k<L;k++){
					int D = Math.abs(A[i]-B[j])+Math.abs(B[j]-C[k])+Math.abs(C[k]-A[i]);
					if(A[i]<C[k]&&B[j]<C[k]&&D>min)
						break;
					if(D<min)
						min = D;
				}
			}
		}
		
		System.out.println(min);
	}
}
