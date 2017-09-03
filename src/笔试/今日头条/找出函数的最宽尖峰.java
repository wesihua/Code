package 笔试.今日头条;

import java.util.Scanner;

public class 找出函数的最宽尖峰 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] array = new int[n];
		for(int i=0;i<n;i++){
			array[i] = in.nextInt();
		}
		
		int start = -1;
		int end = -1;
		
		int[] max = new int[2];
		max[0] = -1;
		max[1] = -1;
		
		//0为上升，1为下降
		int status = -1;
		
		//System.out.println("-----");
		
		for(int i=0;i<n;){
			if(i==n-1){
				if(status==1){
					if(max[1]-max[0]<i-start){
						max[0] = start;
						max[1] = i;
					}
				}
				break;
			}
			if(status==-1){
				if(array[i]<array[i+1]){
					status = 0;
					start = i;
				}
			}
			else if(status==0){
				if(array[i]>array[i+1]){
					status = 1;
				}
			}
			else if(status==1){
				if(array[i]<array[i+1]){
					status = -1;
					if(max[1]-max[0]<i-start){
						max[0] = start;
						max[1] = i;
					}
					continue;
				}
			}
			i++;
		}
		
		System.out.println(max[0]+" "+max[1]);
	}
}
