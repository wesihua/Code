package 剑指offer;

import java.util.Stack;

public class 第07题_用两个栈实现队列 {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
    
	//push数据都是将数据push到stack1
    public void push(int node) {
        stack1.push(node);
    }
    
    //pop数据的时候，先检查stack2中有没有数据，有数据的话从stack2中pop数据
    //如果stack2中没有数据，再检查stack1中有没有数据，有数据的话，先将stack1中的数据pop到stack2中，这样从stack2中pop出的数据就是按照先进后出的顺序
    public int pop() {
		if(stack1.empty()&&stack2.empty())
            throw new RuntimeException("Queue is empty!");
    	if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.pop();
    }
}
