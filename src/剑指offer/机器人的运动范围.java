package 剑指offer;

public class 机器人的运动范围 {
	public static int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] flag = new boolean[rows][cols];
        travel(flag, 0, 0, threshold);
        int count = 0;
        for(int i=0;i<rows;i++){
        	for(int j=0;j<cols;j++){
        		if(flag[i][j])
        			count++;
        	}
        }
        return count;
    }
	
	static void travel(boolean[][] flag, int row, int col, int threshold){
		if(row>=0&&row<flag.length&&
		   col>=0&&col<flag[row].length&&
		   check(row, col, threshold)&&!flag[row][col]){
			flag[row][col] = true;
			travel(flag, row-1, col, threshold);
			travel(flag, row+1, col, threshold);
			travel(flag, row, col-1, threshold);
			travel(flag, row, col+1, threshold);
		}
	}
	
	static boolean check(int row,int col,int threshold){
		int factor = 1;
		while(row/factor>0){
			threshold = threshold - row%(factor*10)/factor;
			if(threshold<0)
				return false;
			factor *= 10;
		}
		
		factor = 1;
		while(col/factor>0){
			threshold = threshold - col%(factor*10)/factor;
			if(threshold<0)
				return false;
			factor *= 10;
		}
		
		return true;
	}
	
	public static void main(String args[]){
		System.out.println(movingCount(5, 10, 10));
	}
	
}
