package 笔试.京东;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class 通过考试 {
	public static void main(String args[]){
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int[] p = new int[n];
//		for(int i=0;i<n;i++){
//			p[i] = in.nextInt();
//		}
//		
////		for(int i=0;i<n;i++){
////			System.out.println(p[i]/100.0);
////		}
//		
//		int min = (int) Math.ceil((double)n*0.6);
//		
////		System.out.println(min);
////		System.out.println(pForCorrect(p, min, 0, 0));
//		double sum = 0.0;
//		for(int i=n;i>=min;i--){
//			//System.out.println(i+":"+pForCorrect(p, i, 0, 0));
//			sum += pForCorrect(p, i, 0, 0);
//		}
//		
		
		double test = 1.226666;
//		BigDecimal bg = new BigDecimal(sum).setScale(5, BigDecimal.ROUND_HALF_UP);
		//System.out.println(bg.doubleValue());
		System.out.println(String.format("%.5f", test));
	}
	
	//计算做对m道题目的概率
	public static double pForCorrect(int[] p,int m,int now,int level){
		if(level==p.length-1){
			if(m==now)
				return (double)(100-p[level])/100.0;
			else
				return (double)p[level]/100.0;
		}
		
		double p1=0.0;
		double p2=0.0;
		if(m>now){
			double temp = pForCorrect(p, m, now+1, level+1);
			//System.out.println("p1:temp "+temp);
			p1 = (p[level]/100.0)*temp;
		}
		
		if((p.length-1-level)>=m-now){
			double temp = pForCorrect(p, m, now, level+1);
			//System.out.println("p2:temp "+temp);
			p2 = (100-p[level])/100.0*temp;
		}
		
		//System.out.println(p1+" "+p2);
		
		return p1+p2;
	}
}
