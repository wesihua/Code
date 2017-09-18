package 笔试.网易游戏;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 三杀 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T= in.nextInt();
		for(int r=0;r<T;r++) {
			int hp = in.nextInt();
			int atk = in.nextInt();
			int cd = in.nextInt();
			int[] x = new int[3];
			for(int i=0;i<3;i++) {
				x[i] = in.nextInt();
			}
			
			int hp1 = in.nextInt();
			int y1 = in.nextInt();
			int hp2 = in.nextInt();
			int y2 = in.nextInt();
			int hp3 = in.nextInt();
			int y3 = in.nextInt();
			
			List<ATK_CD> xList = new ArrayList<>();
			for(int i=0;i<x.length;i++) {
				if(x[i]>atk) {
					xList.add(new ATK_CD(x[i], 0));
				}
			}
			
			Collections.sort(xList,new Comparator<ATK_CD>() {
				public int compare(ATK_CD o1, ATK_CD o2) {
					return o2.x-o1.x;
				}			
			});
			
			int killTime1 = getKillTime(hp1, atk, cd, xList);
			int killTime2 = getKillTime(hp2, atk, cd, xList);
			int killTime3 = getKillTime(hp3, atk, cd, xList);
			
			int result1 = getResumeHp(hp, y1, killTime1, y2, killTime2, y3, killTime3);
			int result2 = getResumeHp(hp, y1, killTime1, y3, killTime3, y2, killTime2);
			int result3 = getResumeHp(hp, y2, killTime2, y1, killTime1, y3, killTime3);
			int result4 = getResumeHp(hp, y2, killTime2, y3, killTime3, y1, killTime1);
			int result5 = getResumeHp(hp, y3, killTime3, y1, killTime1, y2, killTime2);
			int result6 = getResumeHp(hp, y3, killTime3, y2, killTime2, y1, killTime1);
			
			int result = -1;
			if(result1>0)
				result = Math.max(result1, result);
			if(result2>0)
				result = Math.max(result2, result);
			if(result3>0)
				result = Math.max(result3, result);
			if(result4>0)
				result = Math.max(result4, result);
			if(result5>0)
				result = Math.max(result5, result);
			if(result6>0)
				result = Math.max(result6, result);
			
			if(r!=T-1)
				System.out.println(result);
			else
				System.out.print(result);
		}
	}
	
	public static int getKillTime(int hp,int atk,int cd,List<ATK_CD> xList) {
		int result = 0;
		
		if(xList.size()==0) {
			result += hp%atk==0 ? hp/atk : hp/atk + 1;
		}
		else {
			while(hp>0) {
				for(int i=0;i<xList.size();i++) {
					hp -= xList.get(i).x;
					result += 1;
					if(hp<0)
						break;
				}
				
				if(hp>0) {
					if((cd-xList.size())*atk>=hp) {
						result += hp%atk==0 ? hp/atk : hp/atk + 1;
						break;
					}
					else {
						result += cd-xList.size();
						hp -= (cd-xList.size())*atk;
					}
				}
			}
		}
		
		return result;
	}
	
	public static int getResumeHp(int hp,int y1,int time1,int y2,int time2,int y3,int time3) {
		return hp - ((y1+y2+y3)*time1 + (y2+y3)*time2 + y3*time3);
	}
}

class ATK_CD {
	int x;
	int cd;
	
	public ATK_CD(int x,int cd) {
		this.x = x;
		this.cd = cd;
	}
}
