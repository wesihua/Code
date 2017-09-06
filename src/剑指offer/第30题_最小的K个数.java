package 剑指offer;

import java.util.ArrayList;

public class 第30题_最小的K个数 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		if(k>input.length)
			return list;
		for(int i=0;i<k;i++){
			for(int j=input.length-1;j>i;j--){
				if(input[j]<input[j-1]){
					swap(input, j, j-1);
				}
			}
			list.add(input[i]);
		}
		return list;
    }
	
	public void swap(int[] input,int x,int y){
		int temp = input[x];
		input[x] = input[y];
		input[y] = temp;
	}
	
}
