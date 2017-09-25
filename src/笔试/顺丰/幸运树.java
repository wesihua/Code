package 笔试.顺丰;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class 幸运树 {
	public static void main(String args[]) throws IOException {
//		Scanner in = new Scanner(System.in);
//		String input = in.nextLine();
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		char[] buf = new char[1024];
		int m = 0;
		BigDecimal n = new BigDecimal("0");
		BigDecimal count_4 = new BigDecimal("0");
		BigDecimal count_7 = new BigDecimal("0");
		BigDecimal one = new BigDecimal("1");
		boolean flag = true;
		while(flag) {
			m = bufferedReader.read(buf);
			for(int i=0;i<m;i++) {
				if(buf[i]=='4')
					count_4 = count_4.add(one);
				else if(buf[i]=='7')
					count_7 = count_7.add(one);
				else if(buf[i]=='\n') {
					flag = false;
				}
			}
			n = n.add(new BigDecimal(m));
		}
		
		n = n.add(new BigDecimal("-2"));
		
		//System.out.println(n+" "+count_4+" "+count_7);
		
		BigDecimal bigDecimal = new BigDecimal("2");
		BigDecimal moDecimal = new BigDecimal("1000000007");
		BigDecimal result = new BigDecimal("0");
		
		result = result.add(bigDecimal.pow(n.intValue())).add(new BigDecimal("-2")).divideAndRemainder(moDecimal)[1];
		
		if(count_4.add(count_7).equals(n)) {
			result = result.add(bigDecimal.pow(count_7.intValue())).divideAndRemainder(moDecimal)[1];
		}
		
//		if(input.charAt(0)=='4') {
//			bigDecimal = bigDecimal.divide(new BigDecimal("2"));
//			result = result.add(bigDecimal).add(new BigDecimal("-2")).divideAndRemainder(moDecimal)[1];
//		}
//		else if(input.charAt(0)=='7') {
//			result = result.add(bigDecimal).divideAndRemainder(moDecimal)[1];
//		}
		
		System.out.println(result.toString());
	}
}
