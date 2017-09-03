package 剑指offer;

public class 连续子数组的最大和 {
	public static int FindGreatestSumOfSubArray(int[] array) {
		int sum = 0;
        int max = array[0];
        int index = 0;
        for(int i=0;i<array.length;i++) {
        	if(array[i]<0) {
        		if(max<array[i])
        			max = array[i];
        	}
        	else {
        		sum = array[i];
        		index = i+1;
        		break;
        	}
        }
        for(int i=index;i<array.length;i++){
            sum += array[i];
            if(sum>max)
                max = sum;
            if(sum<0)
                sum = 0;
        }
        
        return max;
    }
	
	public static void main(String[] args){
		int[] array = {-23,17,-7,11,-2,1,-34};
		System.out.println(FindGreatestSumOfSubArray(array));
	}
	
}
