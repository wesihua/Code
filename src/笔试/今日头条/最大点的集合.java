package 笔试.今日头条;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class 最大点的集合 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<point> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(new point(in.nextInt(), in.nextInt()));
		}
		
		//LinkedList<point> list_new = new LinkedList<>(list);
		TreeSet<point> treeSet = new TreeSet<>(list);
		
		Collections.sort(list, new Comparator<point>() {
			@Override
			public int compare(point o1, point o2) {
				if(o1.x!=o2.x)
					return o1.x.compareTo(o2.x);
				else
					return o1.y.compareTo(o2.y)*-1;
			}	
		});
		
//		Collections.sort(list_new,new Comparator<point>() {
//			@Override
//			public int compare(point o1, point o2) {
//				if(o1.y!=o2.y)
//					return -1*o1.y.compareTo(o2.y);
//				else
//					return o1.x.compareTo(o2.x);
//			}	
//		});
		
		List<point> result = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			point temp = list.get(i);
			//System.out.println(temp.x+" "+temp.y);
			if(treeSet.first()==temp) {
				//System.out.println(temp.x+" "+temp.y);
				result.add(temp);
			}
			treeSet.remove(temp);
		}
		
		for(int i=0;i<result.size()-1;i++) {
			System.out.println(result.get(i).x+" "+result.get(i).y);
		}
		System.out.println(result.get(result.size()-1).x+" "+result.get(result.size()-1).y);
		
	}
}

class point implements Comparable<point>{
	Integer x;
	Integer y;
	
	public point(int x,int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(point o) {
		if(y!=o.y)
			return y.compareTo(o.y)*-1;
		else
			return x.compareTo(o.x);
	}
}


