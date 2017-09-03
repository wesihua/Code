package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class sum_3 {
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        if(num.length<3)
        	return result;
        
        Arrays.sort(num);
        
        for(int i=0;i<num.length;i++){
        	int left = i+1;
        	int right = num.length-1;
        	if(i!=0&&num[i]==num[i-1])
        		continue;
        	/**
        	 * 固定一个数,从后面的数中选出两个数,因为数组是有序的,所以可以
        	 * 用两个数组下标left和right,left指向当前元素的后一个位置,right指向最后一个位置
        	 * 三个数相加的和等于0时,加入解集;
        	 * 小于0时,把left往右边移动;
        	 * 大于0时,把right往左边移动;
        	 */
        	while(left<right){
        		if(num[i]+num[left]+num[right]>0)
        			right--;
        		else if(num[i]+num[left]+num[right]<0)
        			left++;
        		else{
        			ArrayList<Integer> list = new ArrayList<>();
        			list.add(num[i]);
        			list.add(num[left]);
        			list.add(num[right]);
        			result.add(list);
        			left++;
        			while(left<right&&num[left]==num[left-1])
        				left++;
        		}
        	}
        }
        
        return result;
    }
	
	public static void main(String args[]){
		int[] num = {-1, 0, 1, 2, -1, -4};
		ArrayList<ArrayList<Integer>> result = threeSum(num);
		for(ArrayList<Integer> list:result){
			System.out.println(list);
		}
	}
}
