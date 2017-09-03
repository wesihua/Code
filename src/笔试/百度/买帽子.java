package 笔试.百度;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 买帽子 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<n;i++)
			set.add(in.nextInt());
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		if(list.size()>=3)
			System.out.println(list.get(2));
		else
			System.out.println("-1");
	}
}
