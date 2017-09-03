package 剑指offer;

import java.util.ArrayList;

public class 和为S的连续正数序列 {
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		int i = sum;
		while(i>=2){
			int k = 0;
			if(((2*sum)%i)==0&&((2*sum)/i+1-i)%2==0){
				k = ((2*sum)/i+1-i)/2;
				if(k>=1){
					ArrayList<Integer> list = new ArrayList<>();
					for(int j=0;j<i;j++){
						list.add(k+j);
					}
					result.add(list);
				}
			}
			i--;
		}
		
		return result;
	}
	
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> result = FindContinuousSequence(2);
		for(ArrayList<Integer> list:result){
			System.out.println(list);
		}
	}
}
