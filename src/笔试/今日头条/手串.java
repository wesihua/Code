package 笔试.今日头条;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class 手串 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int c = in.nextInt();
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			int num_i = in.nextInt();
			for(int j=0;j<num_i;j++) {
				int num = in.nextInt();
				if(!map.containsKey(num))
					map.put(num, new ArrayList<>());
				map.get(num).add(i+1);
			}
		}
		
		int count = 0;
		for(Entry<Integer, List<Integer>> entry:map.entrySet()) {
			List<Integer> list = entry.getValue();
			if(list.size()<2)
				continue;
			for(int i=0;i<list.size();i++) {
				int left = list.get(i);
				int right = list.get((i+1)%list.size());
				if((right-left+1+n)%n<=m || (n-(right-left))%n<=m) {
					count++;
					break;
				}
			}
			//System.out.println(count);
		}
		
		System.out.println(count);
	}
}
