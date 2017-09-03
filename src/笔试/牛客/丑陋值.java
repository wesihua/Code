package 笔试.牛客;

import java.util.Scanner;

public class 丑陋值 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		int start = 0;
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)=='?')
				continue;
			start = i;
			break;
		}
		
		char preChar = ' ';
		int count = 0;
		for(int i=start;i<input.length();i++){
			if(preChar==' '){
				preChar = input.charAt(i);
			}
			else{
				if(input.charAt(i)!='?'){
					if(input.charAt(i)==preChar)
						count++;
					preChar = input.charAt(i);
				}
				else{
					if(preChar=='A')
						preChar = 'B';
					else
						preChar = 'A';
				}
			}
		}
		
		System.out.println(count);
	}
}
