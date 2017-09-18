package 笔试.滴滴;

import java.util.Scanner;

public class 寻找丑数 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		if(n<0)
        	System.out.println(0);
		if(n==1)
        	System.out.println(1);
		
		Integer[] d = {2,3,5};
        Integer[] t = {0,0,0};
        Integer[] temp = {0,0,0};
        int[] array = new int[n];
        array[0] = 1;
        
        int currIndex = 0;
        while(true){
        	for(int i=0;i<3;i++){
            	for(int j=t[i];j<=currIndex;j++){
            		if(d[i]*array[j]>array[currIndex]){
            			temp[i] = d[i]*array[j];
            			t[i] = j;
            			break;
            		}
            	}
            }
    	
        	array[++currIndex] = Math.min(temp[0], Math.min(temp[1], temp[2]));
        	if(currIndex==n-1)
        		break;
        }
        
        System.out.println(array[currIndex]);
	}
}
