package 笔试.牛客;

import java.util.Scanner;

public class 奶牛逃跑 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		int max = (2*n-k-1)*k/2;
		
		int temp = n;
		
		long count = 0;
		while(temp<max){
			count += count(k, n-1, temp, 0);
			count = count%1000000007;
			temp += n;
		}
		
		System.out.println(count);
	}
	
	public static long count(int level,int nowNum,int target, int sum){
		if(level==0&&target==sum)
			return 1;
		long count = 0;
		for(int i=nowNum;i>=0;i--){
			if(sum>target)
				return 0;
			count += count(level-1, i-1, target, sum+i);
		}
		
		return count%1000000007;
	}
}
