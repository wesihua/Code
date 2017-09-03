package test;

import java.util.ArrayList;

public class 全排列 {
	public static void main(String args[]){
		long start = System.currentTimeMillis();
		
		int[] array = new int[5];
		for(int i=0;i<array.length;i++){
			array[i] = i+1;
		}
		
		boolean[] flag = new boolean[array.length];
		ArrayList<Integer> list = new ArrayList<>();
		
		allPermutation(array, 0);
		//allPermutation(array, flag, 0, list);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	
	public static void allPermutation(int[] array,int level){
		if(level==array.length){
			String result = "";
			for(int i=0;i<array.length;i++){
				result += array[i] + " ";
			}
			System.out.println(result);
			return;
		}
		for(int i=level;i<array.length;i++){
			swap(array,i,level);
			allPermutation(array, level+1);
			swap(array, i, level);
		}
	}
	
	public static void allPermutation(int[] array,boolean[] flag,int level,ArrayList<Integer> list){
		if(level==array.length){
			String result = "";
			for(Integer num:list){
				result += num + " ";
			}
			//System.out.println(result);
			return;
		}
		for(int i=0;i<array.length;i++){
			if(!flag[i]){
				flag[i] = true;
				list.add(array[i]);
				allPermutation(array, flag, level+1, list);
				list.remove(list.size()-1);
				flag[i] = false;
			}
		}
	}
	
	public static void swap(int[] array,int x,int y){
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
}
