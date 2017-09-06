package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 第33题_把数组排成最小的数 {
	public static String PrintMinNumber(int [] numbers) {
		List<String> list = new ArrayList<>();
		for(int i=0;i<numbers.length;i++){
			list.add(String.valueOf(numbers[i]));
		}
		
		//定义一种规则比较两个数字的大小，数字m和n，若mn<nm则定义m<n，m应该排在n的前面
		Collections.sort(list, new Comparator<String>() {
			public int compare(String o1, String o2) {
				String a = o1+o2;
				String b = o2+o1;
				return a.compareTo(b);
			}
		});
		
		StringBuilder stringBuilder = new StringBuilder();
		for(String s:list){
			stringBuilder.append(s);
		}
		
		return stringBuilder.toString();
    }
	
	public static void main(String[] args){
		int[] numbers = {3,321,32};
		System.out.println(PrintMinNumber(numbers));
	}
	
	
}
