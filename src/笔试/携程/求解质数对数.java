package 笔试.携程;

import java.util.Scanner;

public class 求解质数对数 {
	static int test(int n) {
		int count = 0;
		for(int i=1;i<=n/2;i++) {
			if(isPrime(i)&&isPrime(n-i)) {
				//System.out.println(i);
				count++;
			}
		}
		
		return count;
    }
	
	static boolean isPrime(int n) {
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
            
        int _;
        _ = Integer.parseInt(in.nextLine().trim());
  
        res = test(_);
        System.out.println(String.valueOf(res));    

    }
}
