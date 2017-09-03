package 笔试.京东;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 站队 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		String content = in.nextLine();
		Set<Integer> set = new HashSet<>();
		ArrayList<Integer> xIndexList = new ArrayList<>();
		for(int i=0;i<content.length();i++){
			if(content.charAt(i)=='X')
				xIndexList.add(i);
			else if(content.charAt(i)!='#'){
				int num = content.charAt(i)-'0';
				for(int j=i-num;j<=i+num;j++){
					set.add(j);
				}
			}
		}
		
		int count = 0;
		for(Integer xIndex:xIndexList){
			if(set.contains(xIndex))
				count++;
		}
		
		System.out.println(count);
	}
}
