package 笔试.滴滴;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 第K大数 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String[] input = in.nextLine().split(" ");
		
		int[] array = new int[input.length];
		for(int i=0;i<array.length;i++) {
			array[i] = Integer.valueOf(input[i]);
		}
		
		int k = in.nextInt();
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
		
		for(int i=0;i<array.length;i++) {
			if(priorityQueue.size()<k)
				priorityQueue.add(array[i]);
			else {
				if(priorityQueue.peek()<array[i]) {
					priorityQueue.poll();
					priorityQueue.add(array[i]);
				}
			}
		}
		
		System.out.println(priorityQueue.peek());
		
	}
}
