package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 数组中出现次数超过一半的数字 {
	public int MoreThanHalfNum_Solution(int[] array) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for(int i=0;i<array.length;i++){
			if(map.containsKey(array[i]))
				map.put(array[i], map.get(array[i])+1);
			else
				map.put(array[i], 1);
			
			if(max<map.get(array[i])){
				max = map.get(array[i]);
				if((max+array.length-i)*2<=array.length)
					return 0;
				if(max*2>array.length)
					return array[i];
			}
		}
		
		return 0;
    }
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(a+b);
		}
	}
	
}
