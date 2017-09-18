package 笔试.大疆;

import java.util.Scanner;

public class 小车碰撞 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int len = in.nextInt();
			int a_power = in.nextInt();
			int a_pos = in.nextInt();
			int a_direct = in.nextInt();
			int b_power = in.nextInt();
			int b_pos = in.nextInt();
			int b_direct = in.nextInt();
			
			int count = 0;
			
			//a车在右，b车在左
			if(a_pos>b_pos) {
				//a向右，b向左
				if(a_direct==1&&b_direct==-1) {
					if(a_power>=len-a_pos)
						count++;
					if(b_power>=b_pos+1)
						count++;
				}
				//a向右，b向右
				else if (a_direct == 1 && b_direct == 1) {
					if(a_power>=len-a_pos) {
						count++;
						if(b_power>=len-a_pos)
							count++;
					}
					else {
						a_pos += a_power;
						b_power = a_pos-b_pos-1;
						if(b_power>0) {
							int num = b_power/2;
							if(num+a_pos>=len)
								count++;
							if(num+b_pos>len)
								count++;
						}
					}
				}
				else if(a_direct==-1&&b_direct==-1) {
					if(b_power>=b_pos+1) {
						count++;
						if(a_power>=a_pos+1)
							count++;
					}
					else {
						b_pos -= b_power;
					}
				}
			}
			//a在左，b在右
			else {
				
			}
		}
	}
}
