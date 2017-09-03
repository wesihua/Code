package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *	题目描述：
	Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	Valid operators are+,-,*,/. Each operand may be an integer or another expression.
	Some examples:
  	["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  	["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @author zhenlanghuo
 *
 */
public class evaluate_reverse_polish_notation {
	
	public static void main(String[] agrs){
		double d = ((double)1/2);
		System.out.println(d);
		
		Integer i = 0;
		test(i);
		System.out.println(i);
	}
	
	public static void test(Integer i){
		i++;
	}
	
	public int evalRPN(String[] tokens) {
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
        
        return 0;
    }
}
