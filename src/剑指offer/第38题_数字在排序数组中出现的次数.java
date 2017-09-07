package 剑指offer;

import java.lang.instrument.IllegalClassFormatException;

public class 第38题_数字在排序数组中出现的次数 {
	public int GetNumberOfK(int [] array , int k) {
	       return binarySearch(array, 0, array.length-1, k);
    }
	
	public int binarySearch(int[] array,int start,int end,int k){
		if(start>end)
			return 0;
		else if(start==end){
			if(array[start]==k)
				return 1;
			else
				return 0;
		}
		else if(array[start]==array[end]&&array[start]==k)
			return end-start+1;
		
		int sum = 0;
		int mid = (start+end)/2;
		if(array[mid]>k)
			sum += binarySearch(array, start, mid-1, k);
		else if(array[mid]<k)
			sum += binarySearch(array, mid+1, end, k);
		else if(array[mid]==k){
			sum += binarySearch(array, start, mid-1, k);
			sum += binarySearch(array, mid+1, end, k);
			sum += 1;
		}
		
		return sum;
			
	}
}
