package 笔试.牛客;

import java.util.HashMap;
import java.util.Scanner;

public class DNA片段 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('T', 1);
		map.put('C', 2);
		map.put('G', 3);
		
		int status = -1;
		int tempLength = 0;
		int maxLength = 0;
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			
//			if(map.containsKey(c)) {
//				int index = map.get(c);
//				
//				if(status==-1) {
//					if(index==0) {
//						if(tempLength>maxLength)
//							maxLength = tempLength;
//						tempLength = 1;
//						status = index;
//					}
//				}
//				else {
//					if(index-status==1 || index-status==-3) {
//						status = index;
//						tempLength++;
//					}
//					else
//						status = -1;
//				}
//			}
//			else
//				status = -1;
			
			if(map.containsKey(c)) {
				tempLength++;
			}
			else {
				if(tempLength>maxLength)
					maxLength = tempLength;
				tempLength = 0;
			}
		}
		
		if(tempLength>maxLength)
			maxLength = tempLength;
		
		System.out.println(maxLength);
	}
}
