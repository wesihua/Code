package 笔试.滴滴;

import java.util.HashSet;
import java.util.Scanner;

public class xor {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] array = new int[n];
		for(int i=0;i<n;i++) {
			array[i] = in.nextInt();
		}
		
		HashSet<Integer> set = new HashSet<>();
		int count = array[0] == 0 ? 1 : 0;
		int xor = 0;
		if(count==0)
			xor = array[0];
		
		for(int i=1;i<n;i++) {
			xor = xor^array[i];
			if(array[i]==0 || xor==0 || set.contains(xor)) {
				count++;
				xor = 0;
				set.clear();
			}
			else
				set.add(xor);
		}
		
		System.out.println(count);
	}
}
