package 笔试.今日头条;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 数列 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String[] firstLine = in.nextLine().split(" ");
		int n = Integer.valueOf(firstLine[0]);
		int q = Integer.valueOf(firstLine[1]);
		int[] A = new int[n];
		int[] B = new int[n];
		for(int i=0;i<n;i++){
			A[i] = in.nextInt();
		}
		for(int i=0;i<n;i++){
			B[i] = in.nextInt();
		}
		
		ArrayList<Holder> list = new ArrayList<>();
		for(int i=0;i<n;i++){
			list.add(new Holder(A[i], B[i]));
		}
		
		Collections.sort(list);
		
		int[][] query = new int[q][2];
		for(int i=0;i<q;i++){
			query[i][0] = in.nextInt();
			query[i][1] = in.nextInt();
		}
		
		for(int i=0;i<q;i++){
			int a_index = binarySearch(list, query[i][0], "A", 0, n);
			int b_index = binarySearch(list, query[i][1], "B", 0, n);
			
			if(!(list.get(a_index).a>=query[i][0]))
				a_index++;
			if(a_index>=n)
				a_index = n-1;
			
			int result = 0;
			for(int j=a_index;j<n;j++){
				if(A[j]>=query[i][0]&&B[j]>=query[i][1])
					result++;
			}
			System.out.println(result);
			
		}
	}
	
	public static int binarySearch(ArrayList<Holder> list,int target,String AorB,int start,int end){
		if(start==end)
			return start;
		int middle = (start+end)/2;
		if(AorB.equals("A")){
			if(list.get(middle).a>=target){
				if(middle==start)
					return start;
				return binarySearch(list, target, AorB, start, middle-1);
			}
			else if(list.get(middle).a<target){
				if(middle==end)
					return end;
				return binarySearch(list, target, AorB, middle+1, end);
			}
		}
		else{
			if(list.get(middle).b>=target){
				if(middle==0)
					return 0;
				return binarySearch(list, target, AorB, start, middle-1);
			}
			else if(list.get(middle).b<target)
				return binarySearch(list, target, AorB, middle+1, end);
		}
		
		return -1;
	}
}

class Holder implements Comparable<Holder>{
	Integer a = 0;
	Integer b = 0;
	
	public Holder(Integer a,Integer b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Holder o) {
		if(a!=o.a)
			return a.compareTo(o.a);
		else
			return b.compareTo(o.b);
	}
	
}
