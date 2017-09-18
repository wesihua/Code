package 笔试.网易游戏;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class 流量统计 {
	public static void main(String args[]) throws ParseException, IOException {
		//Scanner in = new Scanner(System.in);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		Integer N = Integer.valueOf(bufferedReader.readLine());
		
		long[] array = new long[N];
		long[] sum = new long[N+1];
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		for(int i=0;i<N;i++) {
			String[] strs = bufferedReader.readLine().split(" ");
			sum[i+1] = sum[i] + Long.valueOf(strs[2]);
			array[i] = formatter.parse(strs[0]+" "+strs[1]).getTime();
		}
		
		Integer M = Integer.valueOf(bufferedReader.readLine());
		for(int i=0;i<M;i++) {
			String[] strs = bufferedReader.readLine().split(" ");
			long start = formatter.parse(strs[0]+" "+strs[1]).getTime();
			long end = formatter.parse(strs[2]+" "+strs[3]).getTime();
			
			
			int left = binarySearch1(array, 0, array.length-1, start);
			int right = binarySearch2(array, 0, array.length-1, end);
			
			long result = 0;
			if(left<=right) {
				result = sum[right+1] - sum[left];
			}
			
			if(i!=M-1)
				System.out.println(result);
			else
				System.out.print(result);
		}
	}
	
	/**
	 * 返回第一个比target大的数的下标
	 * 如果没有target大的数，则返回end+1
	 * 
	 */
	public static int binarySearch1(long[] array,int start,int end,long target) {
		if(start==end){
			if(array[start]>=target)
				return start;
			else
				return start+1;
		}
		
		int mid = (start+end)/2;
		if(array[mid]>target){
			if(mid==start)
				return start;
			return binarySearch1(array, start, mid-1, target);
		}
		else if(array[mid]<target)
			return binarySearch1(array, mid+1, end, target);
		else
			return mid;
	}
	
	/**
	 * 返回最后一个比target小的数的下标
	 * 如果没有target小的数，则返回start-1
	 */
	public static int binarySearch2(long[] array,int start,int end,long target) {
		if(start==end) {
			if(array[start]<=target)
				return start;
			else
				return start-1;
		}
		
		int mid = (start+end)/2;
		if(array[mid]>target) {
			if(mid==start)
				return start-1;
			return binarySearch2(array, start, mid-1, target);
		}
		else if(array[mid]<target) {
			return binarySearch2(array, mid+1, end, target);
		}
		else
			return mid;
	}
	
}
