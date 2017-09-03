package leetcode;

import java.util.Arrays;

public class candy {
	public int candy(int[] ratings) {
        int min = 0;
        int[] candys = new int[ratings.length];
		//初始化，每人分一颗糖
        for(int i=0;i<candys.length;i++){
            candys[i] = 1;
        }
        
        //从左到右遍历一遍，对于每个元素，检查该元素的左右两边元素，找出目前比该元素rating的低的元素的最大的糖数目n，设置分配给该元素的唐数目为n+1
        for(int i=0;i<ratings.length;i++){
        	if(i-1>=0 && ratings[i-1]<ratings[i] && candys[i-1]>=candys[i])
        		candys[i] = candys[i-1] + 1;
        	if(i+1<ratings.length && ratings[i+1]<ratings[i] && candys[i+1]>=candys[i])
        		candys[i] = candys[i+1] + 1;
        }
        
        //从右到左遍历一遍，对于每个元素，检查该元素的左右两边元素，找出目前比该元素rating的低的元素的最大的糖数目n，设置分配给该元素的唐数目为n+1
        for(int i=ratings.length-1;i>=0;i--){
        	if(i-1>=0 && ratings[i-1]<ratings[i] && candys[i-1]>=candys[i])
        		candys[i] = candys[i-1] + 1;
        	if(i+1<ratings.length && ratings[i+1]<ratings[i] && candys[i+1]>=candys[i])
        		candys[i] = candys[i+1] + 1;
        	min += candys[i];
        }
		
		return min;
    }
}
