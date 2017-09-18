package 笔试.网易;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 游历魔法王国 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int L = in.nextInt();
		
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i=0;i<n-1;i++) {
			int num = in.nextInt();
			if(!map.containsKey(num)) {
				map.put(num, new ArrayList<>());
			}
			map.get(num).add(i+1);
		}
		
		System.out.println(Math.min(n,L+1));
		
	}
}


