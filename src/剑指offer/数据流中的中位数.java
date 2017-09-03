package 剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数据流中的中位数 {
	PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			
			return o1.compareTo(o2)*-1;
		}
	});
	PriorityQueue<Integer> right = new PriorityQueue<>();
	
	public void Insert(Integer num) {
		if((left.size()+right.size())%2==0){
			if(!right.isEmpty()&&num>right.peek()){
				left.add(right.poll());
				right.add(num);
			}
			else
				left.add(num);
		}
		else{
			if(num<left.peek()){
				right.add(left.poll());
				left.add(num);
			}
			else
				right.add(num);
		}
    }

    public Double GetMedian() {
    	if((left.size()+right.size())%2==0){
    		return (left.peek()+right.peek())/2.0;
    	}
    	else{
    		return (double)left.peek();
    	}
    }
    
    public static void main(String args[]){
    	数据流中的中位数 test = new 数据流中的中位数();
    	test.Insert(5);
    	System.out.println(test.GetMedian());
    	test.Insert(2);
    	System.out.println(test.GetMedian());
    	test.Insert(3);
    	System.out.println(test.GetMedian());
    	test.Insert(4);
    	System.out.println(test.GetMedian());
    	test.Insert(1);
    	System.out.println(test.GetMedian());
    	test.Insert(6);
    	System.out.println(test.GetMedian());
    	test.Insert(7);
    	System.out.println(test.GetMedian());
    	test.Insert(0);
    	System.out.println(test.GetMedian());
    	test.Insert(8);
    	System.out.println(test.GetMedian());
    	
    }
}
