package 笔试.今日头条;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Map.Entry;

public class 用户喜好 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		//int[] array = new int[n];
		for(int i=0;i<n;i++) {
			int k = in.nextInt();
			if(!map.containsKey(k))
				map.put(k, new ArrayList<Integer>());
			map.get(k).add(i+1);
			//array[i] = k;
		}
		
//		for(Entry<Integer, List<Integer>> entry:map.entrySet()) {
//			System.out.println(entry.getKey()+"-------------");
//			for(Integer i:entry.getValue())
//				System.out.print(i+" ");
//			System.out.println();
//		}
		
		int q = in.nextInt();
		
		for(int i=0;i<q;i++) {
			int l = in.nextInt();
			int r = in.nextInt();
			int k = in.nextInt();
			
			int count = 0;
			List<Integer> list = map.get(k);
			int l_index = binarySearch1(list, 0, list.size()-1, l);
			int r_index = binarySearch2(list, 0, list.size()-1, r);
			
			//System.out.println(l_index+" "+r_index);
			if(l_index<=r_index)
				count = r_index - l_index + 1;
			
			System.out.println(count);
		}
	}
	
	/**
	 * 返回第一个比target大的数的下标
	 * 如果没有target大的数，则返回end+1
	 * 
	 */
	public static int binarySearch1(List<Integer> list,int start,int end,int target) {
		if(start==end){
			if(list.get(start)>=target)
				return start;
			else
				return start+1;
		}
		
		int mid = (start+end)/2;
		if(list.get(mid)>target){
			if(mid==start)
				return start;
			return binarySearch1(list, start, mid-1, target);
		}
		else if(list.get(mid)<target)
			return binarySearch1(list, mid+1, end, target);
		else
			return mid;
	}
	
	/**
	 * 返回最后一个比target小的数的下标
	 * 如果没有target小的数，则返回start-1
	 */
	public static int binarySearch2(List<Integer> list,int start,int end,int target) {
		if(start==end) {
			if(list.get(start)<=target)
				return start;
			else
				return start-1;
		}
		
		int mid = (start+end)/2;
		if(list.get(mid)>target) {
			if(mid==start)
				return start-1;
			return binarySearch2(list, start, mid-1, target);
		}
		else if(list.get(mid)<target) {
			return binarySearch2(list, mid+1, end, target);
		}
		else
			return mid;
	}
}
