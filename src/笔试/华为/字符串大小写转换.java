package 笔试.华为;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class 字符串大小写转换 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			StringBuffer input = new StringBuffer(in.nextLine());
			for(int i=input.length()-1;i>=0;i--){
				char c = input.charAt(i);
				if(!((c>='a'&&c<='z')||(c>='A'&&c<='Z')))
					input.deleteCharAt(i);
			}
			System.out.println(input.toString().toLowerCase());
		}
		
		List<String> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		Map<String, String> map = new HashMap<>();
		ArrayDeque<String> arrayDeque = new ArrayDeque<>();
		
		
	}
}
