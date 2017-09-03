package 笔试.牛客;

import java.util.Scanner;

public class 序列和 {
	public static String find(long n,int l){
		for(int i=l;i<=100;i++){
			long mid = n/i;
			long j=mid-i;
			if(j<0)
				j = 0;
			while(j+i<=mid+i){
				long result = 0;
				String str = "";
				for(long h=0;h<i;h++){
					result = result+j+h;
					str += j+h+" ";
				}
				if(result==n)
					return str.trim();
				else if(result>n)
					break;
				j++;
				
			}
		}
		return "No";
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		int l = sc.nextInt();
		System.out.println(find(n, l));
	}
}
