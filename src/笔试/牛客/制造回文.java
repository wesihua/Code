package 笔试.牛客;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class 制造回文 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		String str = in.nextLine();
		
		HashMap<Character, Integer> map = new HashMap<>(); 
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			
			if(!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, map.get(c)+1);
		}
		
		int result = 0;
		for(Entry<Character, Integer> entry:map.entrySet()) {
			//System.out.println(entry.getKey()+" "+entry.getValue());
			result += entry.getValue()%2;
		}
		
		System.out.println(result);
		
	}
}
