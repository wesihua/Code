package 笔试.网易;

import java.util.Scanner;

public class 赶去公司 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		String[] tX_s= in.nextLine().split(" ");
		String[] tY_s = in.nextLine().split(" ");
		String[] gx_gy_s = in.nextLine().split(" ");
		int[] gx_gy = {Integer.valueOf(gx_gy_s[0]),Integer.valueOf(gx_gy_s[1])};
		String[] times = in.nextLine().split(" ");
		int walkTime = Integer.valueOf(times[0]);
		int taxiTime = Integer.valueOf(times[1]);
		
		int[][] tx_ty = new int[n][2];
		for(int i=0;i<n;i++){
			tx_ty[i][0] = Integer.valueOf(tX_s[i]);
			tx_ty[i][1] = Integer.valueOf(tY_s[i]);
		}
		
		int sum = (Math.abs(gx_gy[0])+Math.abs(gx_gy[1]))*walkTime;
		for(int i=0;i<n;i++){
			int taxiTimes = (Math.abs(tx_ty[i][0]-gx_gy[0])+Math.abs(tx_ty[i][1]-gx_gy[1]))*taxiTime;
			int walkTimes = (Math.abs(tx_ty[i][0])+Math.abs(tx_ty[i][1]))*walkTime;
			if(taxiTimes+walkTimes<sum)
				sum = taxiTimes+walkTimes;
		}
		
		System.out.println(sum);
	}
}
