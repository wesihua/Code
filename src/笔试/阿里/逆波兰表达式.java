package 笔试.阿里;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class 逆波兰表达式 {
	public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
        
    }

    // write your code here
    public static int resolve(String expr) {
       String[] content = expr.split(" ");
       Stack<Integer> stack = new Stack<>();
       for(int i=0;i<content.length;i++){
    	   if(!content[i].equals(" ")&&!content[i].equals("")){
    		   if(content[i].equals("^")){
    			   if(stack.size()<1)
    				   return -1;
    			   int num = stack.pop();
    			   num++;
    			   stack.push(num);
    		   }
    		   else if(content[i].equals("+")){
    			   if(stack.size()<2)
    				   return -1;
    			   int num1 = stack.pop();
    			   int num2 = stack.pop();
    			   stack.push(num1+num2);
    		   }
    		   else if(content[i].equals("*")){
    			   if(stack.size()<2)
    				   return -1;
    			   int num1 = stack.pop();
    			   int num2 = stack.pop();
    			   stack.push(num1*num2);
    		   }
    		   else{
    			   if(stack.size()==16)
    				   return -2;
    			   stack.push(Integer.valueOf(content[i]));
    		   }
    	   }
       }
       
       return stack.pop();
    }
}
