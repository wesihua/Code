package 笔试.搜狗;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 圆周上两点间的距离 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bufferedReader.readLine());
		
		double[] array = new double[n];
		for(int i=0;i<n;i++) {
			array[i] = Double.valueOf(bufferedReader.readLine());
		}
		
		double max = 0;
		
		holder holder = new holder();
		for(int i=0;i<n-1;i++) {
			holder.a = array[i];
			holder.max = 0.0;
			binarySearch(array, i+1, n-1, holder);
			max = Math.max(max, holder.max);
		}
		
		System.out.println(String.format("%.8f", max));
		
	}
	
	public static void binarySearch(double[] array, int start, int end, holder holder) {
		if(start>end)
			return;
		
		int mid = (start + end)/2;
		
		double dis = array[mid]-holder.a;
		
		if(dis<180.0) {
			holder.max = Math.max(holder.max, dis);
			binarySearch(array, mid+1, end, holder);
		}
		else {
			holder.max = Math.max(holder.max, 360.0-dis);
			binarySearch(array, start, mid-1, holder);
		}
	}
}

class holder {
	double a;
	double max;
}

