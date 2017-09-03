package 笔试.微众;

import java.util.Scanner;

public class 分配 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		Holder holder = new Holder();
		solution(a, b, c, 1, 0, n, holder);
		System.out.println(holder.count);
		
	}
	
	public static void solution(int a,int b,int c,int level,int sum,int target,Holder holder){
		if(level==1){
//			if(a==0)
//				solution(a, b, c, level+1, sum, target, holder);
			for(int i=-1;i<a;i++){
				if(i!=-1){
					sum += 5;
					if(sum==target){
						holder.count++;
						return;
					}
					else if(sum>target){
						break;
					}
				}
				solution(a, b, c, level+1, sum, target, holder);
			}
		}
		else if(level==2){
//			if(b==0)
//				solution(a, b, c, level+1, sum, target, holder);
			for(int i=-1;i<b;i++){
				if(i!=-1){
					sum += 8;
					if(sum==target){
						holder.count++;
						return;
					}
					else if(sum>target){
						break;
					}
				}
				solution(a, b, c, level+1, sum, target, holder);
			}
		}
		else if(level==3){
			for(int i=-1;i<c;i++){
				if(i!=-1){
					sum += 10;
					if(sum==target){
						holder.count++;
						return;
					}
					else if(sum>target){
						break;
					}
				}
			}
		}
	}
}

class Holder{
	int count;
}
