package 笔试.携程;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 乘积最大 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a = 2;
		List<Integer> list = new ArrayList<>();
		while(a<=n){
			n = n-a;
			list.add(a);
			a++;
		}
		int k = list.size()-1;
		while(n>0){
			list.set(k, list.get(k)+1);
			k = (list.size()+k-1)%list.size();
			n--;
		}
		int ans = 1;
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
			ans *= list.get(i);
		}
		
		System.out.println(ans);
	
	}
}
