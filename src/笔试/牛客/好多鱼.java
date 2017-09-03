package 笔试.牛客;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 好多鱼 {
	public static int find(int minSize,int maxSize,ArrayList<Integer> fishSizes){
		int count = 0;
		for(int i=minSize;i<=maxSize;i++){
			boolean flag = true;
			for(int j=0;j<fishSizes.size();j++){
				double k = i<fishSizes.get(j)?((double)fishSizes.get(j))/i:((double)i)/fishSizes.get(j);
				if(2.0<=k&&k<=10.0){
					flag = false;
					break;
				}
			}
			if(flag){
				count++;
				//fishSizes.add(i);
			}
		}
		
		return count;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int minSize = sc.nextInt();
		int maxSize = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<Integer> fishSizes = new ArrayList();
		for(int i=0;i<n;i++){
			fishSizes.add(sc.nextInt());
		}
		System.out.println(find(minSize, maxSize, fishSizes));
	}
}
