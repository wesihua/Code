package hihocoder;

import java.util.Arrays;
import java.util.Scanner;


public class 小Hi和小Ho的礼物 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for(int i=0;i<n;i++){
			A[i] = in.nextInt();
		}
		Arrays.sort(A);
		boolean[] flag = new boolean[n];
		Holder holder = new Holder();
		solution(A, flag, 0, 0, 0, 0, holder);
		System.out.println(holder.count);
		
	}
	
	public static void solution(int[] A,boolean[] flag,int level,int index,int hi,int ho,Holder holder){
		if(level==4){
			if(hi==ho)
				holder.count++;
		}
		
		if(level==0){
			for(int i=0;i<A.length;i++){
				if(!flag[i]){
					flag[i] = true;
					solution(A, flag, level+1, i, hi+A[i], ho, holder);
					flag[i] = false;
				}
			}
		}
		else if(level==1){
			for(int i=index+1;i<A.length;i++){
				if(!flag[i]){
					flag[i] = true;
					solution(A, flag, level+1, index, hi+A[i], ho, holder);
					flag[i] = false;
				}
			}
		}
		else if(level==2){
			for(int i=0;i<A.length;i++){
				if(hi<A[i])
					return;
				if(!flag[i]){
					flag[i] = true;
					solution(A, flag, level+1, i, hi, ho+A[i], holder);
					flag[i] = false;
				}
			}
		}
		else if(level==3){
			for(int i=index+1;i<A.length;i++){
				if(hi<A[i])
					return;
				if(!flag[i]){
					flag[i] = true;
					solution(A, flag, level+1, i, hi, ho+A[i], holder);
					flag[i] = false;
				}
			}
		}
	}
}

class Holder{
	int count;
}
