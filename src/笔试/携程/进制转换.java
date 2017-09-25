package 笔试.携程;

import java.util.Scanner;
import java.util.Stack;

public class 进制转换 {
	static String change(int m, int n) {
		if(m==0)
			return "0";
		
		char[] chars = {'a','b','c','d','e','f'};
		StringBuilder stringBuilder = new StringBuilder();
		while(m!=0) {
			if(m%n>=10)
				stringBuilder.append(chars[m%n-10]);
			else
				stringBuilder.append(m%n);
			m = m/n;
		}
		
		return stringBuilder.reverse().toString();
    }
	
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;
            
        int _m;
        _m = Integer.parseInt(in.nextLine().trim());
        
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());
  
        res = change(_m, _n);
        System.out.println(res);
    }
}
