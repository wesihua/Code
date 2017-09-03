package 剑指offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 滑动窗口的最大值 {
	public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        if(size==0||num.length<size){
        	return result;
        }
        else{
        	for(int i=0;i<size;i++){
    			while(!deque.isEmpty()){
        			if(num[i]>deque.peekLast())
        				deque.removeLast();
        			else{
        				deque.add(num[i]);
        				break;
        			}
        		}
        		if(deque.isEmpty())
        			deque.add(num[i]);
    		}
        	result.add(deque.peek());
        	for(int i=1;i<=num.length-size;i++){
        		if(num[i-1]==deque.peek()){
        			//System.out.println((i-1)+" "+num[i-1]);
        			deque.poll();
        		}
        		while(!deque.isEmpty()){
        			if(num[i+size-1]>deque.peekLast())
        				deque.removeLast();
        			else{
        				deque.add(num[i+size-1]);
        				break;
        			}
        		}
        		if(deque.isEmpty())
        			deque.add(num[i+size-1]);
        		result.add(deque.peek());
        	}
        	return result;
        }
    }
	
	public static void main(String args[]){
		int[] num = {2,3,4,2,6,2,5,1};
		ArrayList<Integer> result = maxInWindows(num, 3);
		for(int i=0;i<result.size();i++){
			System.out.print(result.get(i)+" ");
		}
	}
}
