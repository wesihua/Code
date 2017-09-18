package 笔试.大疆;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 包装花束 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int r = in.nextInt();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(n, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		
		for(int i=0;i<n;i++) {
			priorityQueue.add(in.nextInt()/r);
		}
		
		int count = 0;
		while(true) {
			boolean flag = false;
			for(int i=0;i<m;i++) {
				int num = priorityQueue.poll();
				if(num==0) {
					flag = true;
					break;
				}
				else
					priorityQueue.add(num-1);
			}
			
			if(flag)
				break;
			else
				count++;
		}
		
		System.out.println(count);
	}
}
