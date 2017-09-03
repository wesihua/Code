package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class four_sum {
	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        if(num.length<4)
        	return result;
        
        Arrays.sort(num);
        
        for(int i=0;i<num.length;i++){
        	int target_ = target - num[i];
        	
        	if(i!=0&&num[i]==num[i-1])
        		continue;
        	for(int j=i+1;j<num.length;j++){
            	int left = j+1;
            	int right = num.length-1;
            	if(j!=i+1&&num[j]==num[j-1])
            		continue;
            	while(left<right){
            		if(target_-(num[j]+num[left]+num[right])<0)
            			right--;
            		else if(target_-(num[j]+num[left]+num[right])>0)
            			left++;
            		else{
            			ArrayList<Integer> list = new ArrayList<>();
            			list.add(num[i]);
            			list.add(num[j]);
            			list.add(num[left]);
            			list.add(num[right]);
            			result.add(list);
            			left++;
            			while(left<right&&num[left]==num[left-1])
            				left++;
            		}
            	}
            }
        }
        
        return result;
    }
	
	public static void main(String args[]){
		int[] num = {-1,-5,-5,-3,2,5,0,4};
		ArrayList<ArrayList<Integer>> result = fourSum(num,-7);
		for(ArrayList<Integer> list:result){
			System.out.println(list);
		}
	}
}
