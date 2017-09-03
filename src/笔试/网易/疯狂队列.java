package 笔试.网易;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class 疯狂队列 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			list.add(in.nextInt());
		}
		
		Collections.sort(list);
		
		LinkedList<Integer> resultList = new LinkedList<>();
		
		int count = 0;
		while(list.size()>0) {
			if(list.size()==1)
				break;
			else {
				if(count%2==0) {
					resultList.addFirst(list.get(0));
					resultList.addLast(list.get(list.size()-1));
					list.remove(list.size()-1);
					list.remove(0);
				}
				else {
					resultList.addLast(list.get(0));
					resultList.addFirst(list.get(list.size()-1));
					list.remove(list.size()-1);
					list.remove(0);
				}
				count++;
			}
		}
		
		if(list.size()==1) {
			if(count%2==0) {
				resultList.addLast(list.get(0));
			}
			else {
				resultList.addFirst(list.get(0));
			}
			count++;
		}
		
		
		int result = 0;
		for(int i=0;i<n-1;i++) {
			//System.out.print(resultList.get(i)+" ");
			result += Math.abs(resultList.get(i)-resultList.get(i+1));
		}
		
		System.out.println(result);
	}
}
