package 剑指offer;

public class 矩阵中的路径 {
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
		boolean[][] flag = new boolean[rows][cols];
		
		char[][] matrix_ = new char[rows][cols];
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				matrix_[i][j] = matrix[i*cols+j];
			}
		}
		
		return search(matrix_, 0, 0, str, 0, flag);
    }
	
	static boolean search(char[][] matrix, int row, int col, char[] str, int str_index, boolean[][] flag){
		
		if(str_index==0){
			for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix[i].length;j++){
					if(matrix[i][j]==str[str_index]){
						flag[i][j] = true;
						if(search(matrix, i, j, str, str_index+1, flag))
							return true;
						else
							flag[i][j] = false;
					}
				}
			}
		}
		else if(str_index==str.length){
			return true;
		}
		else{
			//向上
			if(row-1>=0&&!flag[row-1][col]&&matrix[row-1][col]==str[str_index]){
				flag[row-1][col] = true;
				if(search(matrix, row-1, col, str, str_index+1, flag))
					return true;
				else
					flag[row-1][col] = false;
			}
			
			//向下
			if(row+1<matrix.length&&!flag[row+1][col]&&matrix[row+1][col]==str[str_index]){
				flag[row+1][col] = true;
				if(search(matrix, row+1, col, str, str_index+1, flag))
					return true;
				else
					flag[row+1][col] = false;
			}
			
			//向左
			if(col-1>=0&&!flag[row][col-1]&&matrix[row][col-1]==str[str_index]){
				flag[row][col-1] = true;
				if(search(matrix, row, col-1, str, str_index+1, flag))
					return true;
				else
					flag[row][col-1] = false;
			}
			
			//向右
			if(col+1<matrix[row].length&&!flag[row][col+1]&&matrix[row][col+1]==str[str_index]){
				flag[row][col+1] = true;
				if(search(matrix, row, col+1, str, str_index+1, flag))
					return true;
				else
					flag[row][col+1] = false;
			}
		}
		
		return false;
	}
	
	public static void main(String args[]){
		char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
		char[] str = {'a','b','c','d'};
		System.out.println(hasPath(matrix, 3, 4, str));
	}
}
