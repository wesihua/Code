package 笔试.牛客;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 循环单词 {
	public static int find(HashMap<Integer, ArrayList<String>> map) {
		int count = 0;
		for(Integer key:map.keySet()){
			ArrayList<String> list = map.get(key);
			while(list.size()!=0){
				count++;
				String word = list.get(0);
				int length = word.length();
				list.remove(word);
				StringBuffer stringBuffer = new StringBuffer(word);
				for(int i=0;i<length-1;i++){
					stringBuffer.append(stringBuffer.charAt(0));
					stringBuffer.replace(0, 1, "");
					if(isInList(list, stringBuffer.toString())){
						list.remove(stringBuffer.toString());
					}
				}
			}
		}
		return count;
	}
	
	public static boolean isInList(ArrayList<String> list,String word){
		for(int i=0;i<list.size();i++){
			if(list.get(i).equals(word))
				return true;
		}
		return false;
	}
	
	public static void deleteFrom(ArrayList<String> list,String word){
		for(int i=0;i<list.size();i++){
			if(list.get(i).equals(word))
				list.remove(i);
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Integer, ArrayList<String>> map = new HashMap<>();
//		ArrayList<String> list1 = new ArrayList<>();
		for(int i=0;i<n;i++){
			String word = sc.next();
//			list1.add(word);
			if(map.containsKey(word.length())){
				map.get(word.length()).add(word);
			}
			else{
				ArrayList<String> list = new ArrayList<>();
				list.add(word);
				map.put(Integer.valueOf(word.length()), list);
			}
		}
		System.out.println(find(map));
//		System.out.println(list1.size());
//		for(String str:list1){
//			System.out.println(str);
//		}
	}
}
