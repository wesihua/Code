package 笔试.牛客;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 连续整数 {
	public static String find(List<Integer> list){
		int count = 0;
		int index = -1;
		for(int i=0;i<list.size()-1;i++){
			int diff = list.get(i+1)-list.get(i);
//			System.out.println(diff);
			if(diff>=3||diff==0)
				return "mistake";
			else if(diff==2){
				count++;
				index = i;
			}
		}
		
		if(count>=2)
			return "mistake";
		else if(count == 1)
			return ""+(list.get(index)+1);
		else{
			String str = "";
			if(list.get(0)-1>=1)
				str += (list.get(0)-1)+ " " + (list.get(list.size()-1)+1);
			else
				str += list.get(list.size()-1)+1;
			return str;
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++){
			list.add(sc.nextInt());
		}
		Collections.sort(list);
//		System.out.println(list);
		System.out.println(find(list));
	}
}
