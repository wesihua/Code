package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 第29题_数组中出现次数超过一半的数字 {
	public int MoreThanHalfNum_Solution(int[] array) {
		int num = array[0];
		int times = 1;
		
		//如果num与array[i]相等，那么times加1,
		//如果num与array[i]不相等，则如果times不为0则减1，如果为0则更新num为array[i]，times更新为1
		for(int i=1;i<array.length;i++) {
			if(array[i]==num) {
				times++;
			}
			else {
				if(times==0) {
					num = array[i];
					times = 1;
				}
				else
					times--;
			}
		}
		
		//如果array数组中有一个数字次数出现超过一半，那么遍历完成后num必然是这个数
		//所以在遍历后，再对数组遍历一遍，统计num出现的次数
		int count = 0;
		for(int i=0;i<array.length;i++) {
			if(num==array[i])
				count++;
		}
		
		if(count >= (array.length/2)+1)
			return num;
		else
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
