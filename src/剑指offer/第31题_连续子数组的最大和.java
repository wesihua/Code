package 剑指offer;

public class 第31题_连续子数组的最大和 {
	public static int FindGreatestSumOfSubArray(int[] array) {
		int cursum = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<array.length;i++) {
        	if(cursum<=0) 
        		cursum = array[i];
        	else
        		cursum += array[i];
        	
        	if(cursum>max)
        		max = cursum;
        }
        
        return max;
    }
	
	public static void main(String[] args){
		int[] array = {-23,17,-7,11,-2,1,-34};
		System.out.println(FindGreatestSumOfSubArray(array));
	}
	
}
