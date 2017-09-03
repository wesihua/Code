package 笔试.滴滴;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 俄罗斯套娃程序 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<Toy> list = new ArrayList<>();
		for(int i=0;i<n;i++){
			Toy toy = new Toy(in.nextInt(),in.nextInt());
			list.add(toy);
		}
		
		Collections.sort(list, new Comparator<Toy>() {
			public int compare(Toy o1, Toy o2) {
				if(o1.w == o2.w)
					return o1.h.compareTo(o2.h)*-1;
				return o1.w.compareTo(o2.w)*-1;
			}
		});
		
		List<Holder> dp = new ArrayList<>();
		
		for(int i=0;i<n;i++){
			int max = 0;
			Toy toy = null;
			for(int j=0;j<i;j++){
				if(IsToyBforToyA(dp.get(j).toy, list.get(i))){
					if(dp.get(j).max+1>max){
						max = dp.get(j).max+1;
						toy = list.get(i);
					}
				}
			}
			Holder holder = new Holder();
			if(max==0){
				holder.toy = list.get(i);
				holder.max = 1;
			}
			else{
				holder.toy = toy;
				holder.max = max;
			}
			dp.add(holder);
		}
		
		System.out.println(dp.get(dp.size()-1).max);
	}
	
	public static boolean IsToyBforToyA(Toy A,Toy B){
		if(A.w>B.w && A.h>B.h)
			return true;
		return false;
	}
	
}

class Toy{
	Integer w;
	Integer h;
	Toy(int w,int h){
		this.w = w;
		this.h = h;
	}
}

class Holder{
	Integer max;
	Toy toy;
}
