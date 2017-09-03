package 剑指offer;

import java.util.Stack;
public class 第21题_包含min函数的栈 {
	Stack<Integer> stackA = new Stack<>();
	//stackB的栈顶元素永远是stackA中的最小的元素
	Stack<Integer> stackB = new Stack<>();
	
	public void push(int node) {
        stackA.push(node);
        //如果push的元素小于等于stackB的栈顶元素，则也该元素push进stackB
        if(stackB.empty()||stackB.peek()>=node){
        	stackB.push(node);
        }
    }
    
    public void pop() {
    	//如果stackA的栈顶元素等于stackB的栈顶元素，则pop出stackA栈顶元素的同时也 pop出stackB栈顶元素
        if(stackA.peek()==stackB.peek())
        	stackB.pop();
        stackA.pop();
    }
    
    public int top() {
        return stackA.peek();
    }
    
    public int min() {
        return stackB.peek();
    }
    
    public static void main(String[] args){
    	第21题_包含min函数的栈 s = new 第21题_包含min函数的栈();
    	s.push(3);
    	System.out.println(s.min());
    	s.push(4);
    	System.out.println(s.min());
    	s.push(2);
    	System.out.println(s.min());
    	s.push(3);
    	System.out.println(s.min());
    	s.pop();
    	System.out.println(s.min());
    	s.pop();
    	System.out.println(s.min());
    	s.pop();
    	System.out.println(s.min());
    	s.push(0);
    	System.out.println(s.min());
    }
}
