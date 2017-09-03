package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class three_sum_closest {
	public static int threeSumClosest(int[] num, int target) {
		
        Arrays.sort(num);
        
        int closets = 0;
        if(num.length<3){
        	for(int i=0;i<num.length;i++){
        		closets += num[i];
        	}
        	return closets;
        }
        
        closets = num[0]+num[1]+num[2];
        
        for(int i=0;i<num.length;i++){
        	int left = i+1;
        	int right = num.length-1;
        	if(i!=0&&num[i]==num[i-1])
        		continue;
        	while(left<right){
        		if(target-(num[i]+num[left]+num[right])<0){
        			if(Math.abs(target-(num[i]+num[left]+num[right]))<Math.abs(target-closets))
        				closets = num[i]+num[left]+num[right];
        			right--;
        		}
        		else if(target-(num[i]+num[left]+num[right])>0){
        			if(Math.abs(target-(num[i]+num[left]+num[right]))<Math.abs(target-closets))
        				closets = num[i]+num[left]+num[right];
        			left++;
        		}
        		else{
        			closets = num[i]+num[left]+num[right];
        			return closets;
        		}
        	}
        }
        
        return closets;    
    }
	
	public static void main(String args[]){
//		int[] num = {-1, 0, 1, 2, -1, -4};
		int[] num = {-1, 2, 1, -4};
		System.out.println(threeSumClosest(num, 1));
	}
	
}
