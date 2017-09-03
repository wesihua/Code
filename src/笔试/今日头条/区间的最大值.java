package 笔试.今日头条;

import java.util.Scanner;

public class 区间的最大值 {
//	public static void main(String args[]) {
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		byte[] array = new byte[n];
//		for(int i=0;i<n;i++) {
//			array[i] = in.nextByte();
//		}
//		
//		byte[] dp_min = new byte[n];
//		int[] dp_sum = new int[n];
//		
//		long max = 0;
//		
//		for(int r=0;r<n;r++) {
//			for(int i=0;i+r<n;i++) {
//				if(r==0) {
//					dp_min[i] = array[i];
//					dp_sum[i] = array[i];
//					long temp = (long)dp_min[i]*dp_sum[i];
//					if(max<temp)
//						max = temp;
//				}
//				else {
//					dp_min[i] = (byte) Math.min(dp_min[i], array[i+r]);
//					dp_sum[i] = dp_sum[i] + array[i+r];
//					long temp = (long)dp_min[i]*dp_sum[i]; 
//					if(max<temp)
//						max = temp;
//				}
//			}
//		}
//		
//		System.out.println(max);
//	}
	
	//对于数组中的每个数字，可以把它看成是当前区间的最小数，这样只需要找到这个数的左边界和右边界（第一个小于这个数的位置），
	//这个数的序列积就为这个数和左右边界区间数的和的乘积，最大的就是答案
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		byte[] array = new byte[n+1];
		int[] sum = new int[n+1];
		for(int i=1;i<=n;i++) {
			array[i] = in.nextByte();
			sum[i] = sum[i-1] + array[i];
		}
		
		int[] leftBound = new int[n+1];
		int[] rightBound = new int[n+1];
		
		//模拟单调栈
		Point1[] monotonicStack = new Point1[n+1];
		
		int len = -1;
		for(int i=1;i<=n;i++) {
			//当前数小于栈顶数，当前数的位置是栈顶数的右边界
			while(len>-1 && array[i]<monotonicStack[len].num) {
				rightBound[monotonicStack[len--].pos] = i;
			}
			monotonicStack[++len] = new Point1(array[i], i);
		}
		
		len = -1;
		for(int i=n;i>=1;i--) {
			//当前数小于栈顶数，当前数的位置是栈顶数的左边界
			while(len>-1 && array[i]<monotonicStack[len].num) {
				leftBound[monotonicStack[len--].pos] = i;
			}
			monotonicStack[++len] = new Point1(array[i], i);
		}
		
		long result = 0;
		for(int i=1;i<=n;i++) {
			if(rightBound[i]==0)
				rightBound[i] = n+1;
			
			result = Math.max(result, (sum[rightBound[i]-1]-sum[leftBound[i]])*array[i]);
		}
		
		System.out.println(result);
		
	}
}

class Point1 {
	byte num;
	//num在数组中的位置
	int pos;
	
	public Point1(byte num,int pos) {
		this.num = num;
		this.pos = pos;
	}
}
