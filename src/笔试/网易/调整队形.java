package 笔试.网易;

import java.util.ArrayList;
import java.util.Scanner;

public class 调整队形 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String[] queues = in.nextLine().split("");
		
		System.out.println(queues.length);
		ArrayList<Integer> G_Index = new ArrayList<>();
		for(int i=0;i<queues.length;i++){
			if(queues[i].equals("G"))
				G_Index.add(i);
		}
		
		int sum1 = 0; 
		for(int i=0;i<G_Index.size();i++){
			sum1 += G_Index.get(i)-i;
		}
		
		int sum2 = 0;
		for(int i=G_Index.size()-1,j=queues.length-1;i>=0;i--,j--){
			sum2 += j-G_Index.get(i);
		}
		
		System.out.println(sum1+" "+sum2);
		
		if(sum2>sum1)
			System.out.println(sum1);
		else
			System.out.println(sum2);
		
		//System.out.println(Math.min(sum1, sum2));
	}
}
