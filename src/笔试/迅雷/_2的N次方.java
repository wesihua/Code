package 笔试.迅雷;

import java.math.BigDecimal;
import java.util.Scanner;

public class _2的N次方 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
//		BigDecimal bigDecimal = new BigDecimal(2);
//		bigDecimal = bigDecimal.pow(512);
//		System.out.println(bigDecimal.toString());
		
		System.out.println(pow("2", n));
	}
	
	public static String pow(String n,int m) {
		if(m==1)
			return n;
		else if(m==0)
			return "0";
		
		String result = mutil(pow(n, m/2), pow(n, m/2));
		
		if(m%2==0)
			return result;
		else
			return mutil(result, "2");
	}
	
	
	public static String mutil(String num1,String num2) {
		
		int[] result = new int[num1.length()+num2.length()];
		
		for(int i=0;i<num1.length();i++) {
			for(int j=0;j<num2.length();j++) {
				result[i+j] += (num1.charAt(num1.length()-1-i)-'0')*(num2.charAt(num2.length()-1-j)-'0');
				for(int k=i+j+1;k<num1.length()+num2.length();k++) {
					if(result[k-1]<10)
						break;
					result[k] += result[k-1]/10;
					result[k-1] %= 10;
				}
			}
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		boolean flag = true;
		for(int i=result.length-1;i>=0;i--) {
			if(result[i]==0&flag)
				continue;
			stringBuilder.append(result[i]);
			flag = false;
		}
		return stringBuilder.toString();
	}
}


