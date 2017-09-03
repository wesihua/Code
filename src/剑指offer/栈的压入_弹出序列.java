package 剑指offer;

import java.util.Stack;

public class 栈的压入_弹出序列 {
	public static boolean IsPopOrder(int [] pushA,int [] popA) {
	      Stack<Integer> stack = new Stack<>();
	      int index_popA = 0;
	      for(int i=0;i<pushA.length;i++){
	    	  stack.push(pushA[i]);
	    	  if(popA[index_popA]==stack.peek()){
	    		  stack.pop();
	    		  index_popA++;
	    	  }
	      }
	      
	      for(int i=index_popA;i<popA.length;i++){
	    	  if(popA[i]!=stack.peek())
	    		  return false;
	    	  stack.pop();
	      }
	      
	      return true;
    }
	
	public static void main(String[] args){
		int[] pushA = {1,2,3,4,5};
		int[] popA = {4,5,3,2,1};
		System.out.println(IsPopOrder(pushA, popA));
	}
}
