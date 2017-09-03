package 笔试.滴滴;

import java.util.Scanner;

public class 连续子串最大和 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String[] input = in.nextLine().split(" ");
		
		int[] array = new int[input.length];
		for(int i=0;i<array.length;i++) {
			array[i] = Integer.valueOf(input[i]);
		}
		
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
        
        System.out.println(max);
	}
}
