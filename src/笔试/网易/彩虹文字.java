package 笔试.网易;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class 彩虹文字 {
	public static String statics(String content,int index){
		String result = "Case "+index+"\n";
		
		StringBuilder stringBuilder = new StringBuilder(content.substring(content.indexOf("<diary>")+7,content.indexOf("</diary>")));
		List<String> list = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		
		//System.out.println(stringBuilder.toString());
		
		for(int i=0;i<stringBuilder.length();i++){
			if(stringBuilder.charAt(i)=='<'&&i+6<stringBuilder.length()&&stringBuilder.charAt(i+6)=='='){
				i = i+7;
				String color = "";
				while(stringBuilder.charAt(i)!='>'){
					color += stringBuilder.charAt(i);
					i++;
				}
				list.add(color);
			}
			else if(stringBuilder.charAt(i)=='<'&&stringBuilder.charAt(i+1)=='/'){
				list.remove(list.size()-1);
				i = i+7;
			}
			else if(stringBuilder.charAt(i)!=' '&&stringBuilder.charAt(i)!='\t'){
				if(list.size()==0){
					if(map.containsKey("black"))
						map.put("black", map.get("black")+1);
					else
						map.put("black", 1);
				}
				else{
					if(map.containsKey(list.get(list.size()-1)))
						map.put(list.get(list.size()-1),map.get(list.get(list.size()-1))+1);
					else
						map.put(list.get(list.size()-1),1);
				}
			}
		}
		
		List<Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
		Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o2.getValue().equals(o1.getValue()))
					return o1.getKey().compareTo(o2.getKey());
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		for(Entry<String, Integer> entry:entryList){
			result += entry.getKey()+": "+entry.getValue()+"\n";
			//System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		
		
		return result;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		String[] content = new String[n];
		for(int i=0;i<n;i++){
			content[i] = in.nextLine();
		}
		
//		for(int i=0;i<n;i++){
//			System.out.print(statics(content[i], i+1));
//		}
		
		System.out.println(statics(content[0], 1));
		System.out.print(statics(content[1], 2));
		
	}
}
