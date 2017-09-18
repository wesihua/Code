package 笔试.大疆;

import java.util.Scanner;

public class 水流量 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int H = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		int h = in.nextInt();
		int s = in.nextInt();
		
		if(x<=y) {
			if(h>=s*x)
				System.out.println(s*x);
			else
				System.out.println(h);
		}
		else {
			if(h>=s*x)
				System.out.println(s*x);
			else {
				double s_ = s-(double)h/x;
				double result = h + s_*(x-y);
				if(result<H)
					System.out.println(Math.round(result));
				else
					System.out.println(H);
			}
				
		}
	}
}
