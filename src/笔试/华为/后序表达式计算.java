package 笔试.华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 后序表达式计算 {
	public static int postfixCalc(String input) {
		String[] tokens = getTokens(input);
		List<Integer> num_stack = new ArrayList<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                int num1 = num_stack.get(num_stack.size()-1);
                num_stack.remove(num_stack.size()-1);
                int num2 = num_stack.get(num_stack.size()-1);
                num_stack.remove(num_stack.size()-1);
                int num3 = 0;
                switch(tokens[i]){
                    case "+":num3 = num1+num2;
                        	break;
                    case "-":num3 = num1-num2;
                        	break;
                    case "*":num3 = num1*num2;
                        	break;
                    case "/":num3 = num1/num2;
                        	break;
                }
                num_stack.add(num3);
            }
            else{
                num_stack.add(Integer.valueOf(tokens[i]));
            }
        }
        
        return num_stack.get(0);
    }
	
	public static String[] getTokens(String input){
		String[] tokens = new String[input.length()];
		for(int i=0;i<input.length();i++){
			char c = input.charAt(i);
			if(c>='A'&&c<='Z'){
				tokens[i] = String.valueOf(c-55);
			}
			else
				tokens[i] = c+"";
		}
		
//		for(int i=0;i<tokens.length;i++){
//			System.out.print(tokens[i]+" ");
//		}
//		System.out.println();
		
		return tokens;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println(postfixCalc(input));
	}
	
}
