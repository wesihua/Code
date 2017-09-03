package 笔试.微众;

import java.util.Scanner;

public class 装卸竞赛 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			//int[][] array = new int[n][2];
			long sum = 0;
			for(int i=0;i<n;i++){
//				String[] content = in.nextLine().split(" ");
				long xi = in.nextLong();
				long mi = in.nextLong();
				for(long j=0;j<mi;j++){
					sum = sum^(xi+j);
				}
			}
			
			if(sum==0)
				System.out.println("second");
			else
				System.out.println("first");
		}
	}
}
