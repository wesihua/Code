package 笔试.今日头条;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Paragraph {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String[] firstLine = in.nextLine().split(" ");
		int N = Integer.valueOf(firstLine[0]);
		int M = Integer.valueOf(firstLine[1]);
		
		String[] sentences = new String[N];
		ArrayList<HashSet<String>> list = new ArrayList<>();
		for(int i=0;i<N;i++){
			sentences[i] = in.nextLine();
			String[] words = sentences[i].split(" ");
			HashSet<String> set = new HashSet<>();
			for(int j=0;j<words.length;j++){
				set.add(words[j].toUpperCase());
			}
			list.add(set);
		}
		
		HashSet<String> tempSet = new HashSet<>();
		
		String[] result = new String[M];
		for(int i=0;i<M;i++){
			//System.out.println("-------------------------------");
			int max = 0;
			String sentence = in.nextLine();
			String[] words = sentence.split(" ");
			HashSet<String> set = new HashSet<>();
			for(int j=0;j<words.length;j++){
				set.add(words[j].toUpperCase());
			}
			for(int j=0;j<list.size();j++){
				tempSet.clear();
				tempSet.addAll(list.get(j));
				tempSet.retainAll(set);
				//System.out.println(tempSet.size());
				if(tempSet.size()>max){
					result[i] = sentences[j];
					max = tempSet.size();
				}
			}
		}
		
		for(int i=0;i<M;i++){
			System.out.println(result[i]);
		}
	}
}
