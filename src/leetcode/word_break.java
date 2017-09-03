package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class word_break {
	/**
	 *  题目描述：
	 	Given a string s and a dictionary of words dict, 
	 	determine if s can be segmented into a space-separated sequence of one or more dictionary words.
		For example, given
		s ="leetcode",
		dict =["leet", "code"].
		Return true because"leetcode"can be segmented as"leet code".
	 * @param s
	 * @param dict
	 * @return
	 * 动态规划
	 */
	public static boolean workBreak(String s,Set<String> dict){
		boolean[] p = new boolean[s.length()];
		
		for(int i=0;i<s.length();i++)
			p[i] = false;
		
		for(int i=0;i<s.length();i++){
			if(dict.contains(s.substring(0, i+1))){
				p[i] = true;
				break;
			}
		}
		
		for(int i=0;i<s.length();i++){
			if(p[i]){
				for(int j=i+1;j<s.length();j++){
					if(dict.contains(s.substring(i+1, j+1)))
						p[j] = true;
				}
			}
		}
		
		
		
		return p[s.length()-1];
	}
	
	public static ArrayList<String> wordBreakII(String s, Set<String> dict) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        return dfs(s, dict, map);
             
    }
     
    public static ArrayList<String> dfs(String s, Set<String> dict, HashMap<String, List<String>> map) {
        if (map.containsKey(s))
            return (ArrayList<String>) map.get(s);
         
        ArrayList<String> lists = new ArrayList();
        if (s.equals(""))
            lists.add("");
        else {
            int len = s.length();
            for (int i = 1; i <= len; i++) {
                String sub = s.substring(0, i);
                if (dict.contains(sub)) {
                    ArrayList t = dfs(s.substring(i, len), dict, map);
                    if (t.size() == 0) {
                        continue;
                    } else {
                        for (int j = 0; j < t.size(); j++) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(sub).append(" ").append(t.get(j));
                            lists.add(sb.toString().trim());
 
                        }
                    }
                }
            }
        }
        map.put(s, lists);
        return lists;
    }
	
//	public static ArrayList<StringBuffer> workBreakII(String s,Set<String> dict){
//		if(s.length()<=0 || s.equals(""))
//			return new ArrayList<StringBuffer>();
//		boolean[] p = new boolean[s.length()];
//		Map<Integer, ArrayList<StringBuffer>> map = new HashMap<>();
//		ArrayList<ArrayList<StringBuffer>> arr = new ArrayList<>(s.length());
//		
////		Set<String> dict = new HashSet<>();
////		for(int i=0;i<wordDict.size();i++){
////			dict.add(wordDict.get(i));
////		}
//		
//		for(int i=0;i<s.length();++i){
//            arr.add(null);
//        }
//		
//		for(int i=0;i<s.length();i++)
//			p[i] = false;
//		
//		for(int i=0;i<s.length();i++){
//			if(dict.contains(s.substring(0, i+1))){
//				p[i] = true;
//				ArrayList<StringBuffer> list = new ArrayList<>();
//				list.add(new StringBuffer(s.substring(0,i+1)));
//				//map.put(i, list);
//				arr.set(i, list);
//			}
//		}
//		
//		for(int i=0;i<s.length();i++){
//			System.out.println(i);
//			if(i>0){
//				arr.set(i-1, null);
//			}
//			if(p[i]){
//				for(int j=i+1;j<s.length();j++){
//					System.out.println(j);
//					if(dict.contains(s.substring(i+1, j+1))){
//						p[j] = true;
//						//ArrayList<String> list_pre = map.get(i);
//						ArrayList<StringBuffer> list_pre = arr.get(i);
//						if(arr.get(j)!=null){
//							ArrayList<StringBuffer> list = arr.get(j);
//							for(int k=0;k<list_pre.size();k++){
//								list.add(list_pre.get(k).append(" ").append(s.substring(i+1, j+1)));
//							}
//						}
//						else{
//							ArrayList<StringBuffer> list = new ArrayList<>();
//							for(int k=0;k<list_pre.size();k++){
//								list.add(list_pre.get(k).append(" ").append(s.substring(i+1, j+1)));
//							}
//							arr.set(j, list);
//						}
////						if(map.containsKey(j)){
////							ArrayList<String> list = map.get(j);
////							for(int k=0;k<list_pre.size();k++){
////								list.add(list_pre.get(k)+" "+s.substring(i+1, j+1));
////							}
////						}
////						else{
////							ArrayList<String> list = new ArrayList<>();
////							for(int k=0;k<list_pre.size();k++){
////								list.add(list_pre.get(k)+" "+s.substring(i+1, j+1));
////							}
////							map.put(j, list);
////						}
//					}
//				}
//			}
//		}
//		
//		
//		if(p[s.length()-1])
//			return arr.get(s.length()-1);
//		else 
//			return new ArrayList<StringBuffer>();
//	}
	
	public static void main(String[] args){
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		Set<String> dict = new HashSet<>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaaa");
		System.out.println(workBreak(s, dict));
		
		ArrayList<String> list = wordBreakII(s, dict);
		for(String str:list){
			System.out.println(str);
		}
	}
}
