package 笔试.网易;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 操作序列 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//ArrayList<Integer> list = new ArrayList<>();
//		for(int i=0;i<n;i++) {
//			list.add(in.nextInt());
//		}
		
		ArrayDeque<Integer> linkedList = new ArrayDeque<>(n);
		
		StringBuilder stringBuilder = new StringBuilder();
		
		
		if(n%2==1) {
			for(int i=0;i<n;i++) {
				if(i%2==1)
					stringBuilder.append(in.nextInt()+" ");
				else
					stringBuilder.insert(0,in.nextInt()+" ");
			}
		}
		else {
			for(int i=0;i<n;i++) {
				if(i%2==0)
					stringBuilder.append(in.nextInt()+" ");
				else
					stringBuilder.insert(0,in.nextInt()+" ");
			}
		}
		
		System.out.println(stringBuilder.toString().trim());
		
//		int start = 0;
//		int end = n-1;
//		
//		for(int i=0;i<n;i++) {
//			if(i%2==0)
//				stringBuilder.append(list.get(end--)+" ");
//			else
//				stringBuilder.append(list.get(start++)+" ");
//		}
//		
//		System.out.println(stringBuilder.toString());
		
//		
//		for(int i=0;i<n;i++) {
//			if(i%2==1)
//				linkedList.addFirst(in.nextInt());
//			else
//				linkedList.addLast(in.nextInt());
//		}
//		
//		if(n%2==0) {
//			for(int i=0;i<n-1;i++) {
//				System.out.print(linkedList.pollFirst()+" ");
//			}
//			
//			System.out.print(linkedList.pollFirst());
//		}
//		else {
//			for(int i=n-1;i>0;i--) {
//				System.out.print(linkedList.pollLast()+" ");
//			}
//			
//			System.out.print(linkedList.pollLast());
//		}
		
	}
}
