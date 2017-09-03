package hihocoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 可疑的记录 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		HashSet<Integer> parents = new HashSet<>();
		HashMap<String,ArrayList<Integer>> map = new HashMap<>();
		HashMap<Integer, Set<Integer>> childrensParents = new HashMap<>();
		
		HashMap<Integer, Integer> in_ = new HashMap<>();
		HashMap<Integer, Integer> out = new HashMap<>();
 		
		int n = in.nextInt();
		int[][] record = new int[n][2];
		String repeatKey = "";
		for(int i=0;i<n;i++){
			record[i][0] = in.nextInt();
			record[i][1] = in.nextInt();
			
			if(in_.containsKey(record[i][0])){
				in_.put(record[i][0], in_.get(record[i][0])+1);
			}
			else {
				in_.put(record[i][0], 1);
			}
			
			if(out.containsKey(record[i][1])){
				out.put(record[i][1], out.get(record[i][1])+1);
			}
			else {
				out.put(record[i][1], 1);
			}
		}
		
		String result = "";
		for(int i=0;i<record.length;i++){
			int parent = record[i][0];
			int children = record[i][1];
			if(children==1)
				result += (i+1)+" ";
			else if(out.get(children)-1==1){
				if(parent==1&&in_.get(parent)-1>0){
						result += (i+1)+" ";
				}
				else
					result += (i+1)+" ";
			}
				
		}
		if(result.charAt(result.length()-1)==' ')
			result = result.substring(0, result.length()-1);
		System.out.println(result);
	}
}
