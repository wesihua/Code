package 笔试.牛客;

import java.util.Scanner;

public class 超级素数幂 {
	public static String check(long n){
		for(long i=2;true;i++){
			double p = Math.pow(n, 1.0/i);
			System.out.println(p+" "+i);
			if(p<2.0)
				break;
			else{
				long p_long = (long)p;
				if(Math.pow(p_long, i)==((double)n)){
					boolean flag = true;
					for(int j=1;j<=Math.sqrt(p_long);j++){
						if(p_long%j==0 && j!=1 && j!=p_long){
							flag = false;
							break;
						}
					}
					if(flag)
						return p_long+" "+i;
				}
			}
		}
		
		return "No";
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		System.out.println(check(n));
	}
	
}
