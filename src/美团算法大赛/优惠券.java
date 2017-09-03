package 美团算法大赛;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 优惠券 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		//记录购买了的优惠券
		Map<Integer, Integer> map = new HashMap<>();
		//?号的行计数
		int unknow = 0;
		while(in.hasNext()){
			int n = Integer.valueOf(in.nextLine());
			int result = -1;
			for(int i=1;i<=n;i++){
				String input = in.nextLine();
				if(input.equals("?"))
					unknow++;
				else{
					String[] inputs = input.split(" ");
					String str = inputs[0];
					Integer x = Integer.valueOf(inputs[1]);
					if(str.equals("I")){
						if(!map.containsKey(x))
							map.put(x, 0);
						map.put(x, map.get(x)+1);
					}
					else if(str.equals("O")){
						if(!map.containsKey(x)||map.get(x)==0){
							if(unknow==0){
								if(result==-1)
									result = i;
							}
							else
								unknow--;
						}
						else
							map.put(x, map.get(x)-1);
					}
					else {
						if(result==-1)
							result = i;
					}
				}
			}
			
			System.out.println(result);
			map = new HashMap<>();
			unknow=0;
		}
	}
}
