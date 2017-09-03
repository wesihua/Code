package 笔试.牛客;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class 字符串分类 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		Set<String> set = new HashSet<>();
		for(int i=0;i<n;i++){
			String str = in.nextLine();
			ArrayList<Character> list = new ArrayList<>();
			for(int k=0;k<str.length();k++){
				list.add(str.charAt(k));
			}
			Collections.sort(list);
			str = "";
			for(int k=0;k<list.size();k++){
				str += list.get(k);
			}
			set.add(str);
		}
		
		System.out.println(set.size());
		
	}
}
