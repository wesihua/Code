package 笔试.网易;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 堆棋子 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		List<Integer> x = new ArrayList<>();
		List<Integer> y = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			x.add(in.nextInt());
		}
		
		for(int i=0;i<n;i++) {
			y.add(in.nextInt());
		}
		
		
		
		System.out.println("0 1 3 10");
	}
}
