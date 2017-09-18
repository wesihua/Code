package test;

import java.math.BigDecimal;

public class 大数相乘 {
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
	
	public static void main(String args[]) {
		System.out.println(mutil("56546748", "999"));
		BigDecimal bigDecimal1 = new BigDecimal("56546748");
		BigDecimal bigDecimal2 = new BigDecimal("999");
		System.out.println(bigDecimal1.multiply(bigDecimal2).toString());
	}
}
