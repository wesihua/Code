package 剑指offer;

import java.util.ArrayList;

public class 第20题_顺时针打印矩阵 {
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
	       int x_end = matrix.length-1;
	       int y_end = matrix[0].length-1;
	       ArrayList<Integer> list = new ArrayList<>();
	       printMatrixByClockwise(matrix, 0, x_end, 0, y_end, 0, "y_start", "col", list);
	       return list;
    }
	
	public static void printMatrixByClockwise(int [][] matrix,int x_start,int x_end,int y_start,int y_end,int index,String from,String colOrRow,ArrayList<Integer> list){
		if(x_start>x_end||y_start>y_end)
			return;
		if(colOrRow.equals("col")){
			if(from.equals("y_start")){
				for(int i=y_start;i<=y_end;i++){
					list.add(matrix[index][i]);
				}
				printMatrixByClockwise(matrix, x_start+1, x_end, y_start, y_end, y_end, "x_start", "row", list);
			}
			else if(from.equals("y_end")){
				for(int i=y_end;i>=y_start;i--){
					list.add(matrix[index][i]);
				}
				printMatrixByClockwise(matrix, x_start, x_end-1, y_start, y_end, y_start, "x_end", "row", list);
			}
		}
		else if(colOrRow.equals("row")){
			if(from.equals("x_start")){
				for(int i=x_start;i<=x_end;i++){
					list.add(matrix[i][index]);
				}
				printMatrixByClockwise(matrix, x_start, x_end, y_start, y_end-1, x_end, "y_end", "col", list);
			}
			else if(from.equals("x_end")){
				for(int i=x_end;i>=x_start;i--){
					list.add(matrix[i][index]);
				}
				printMatrixByClockwise(matrix, x_start, x_end, y_start+1, y_end, x_start, "y_start", "col", list);
			}
		}
	}
	
	public static void main(String[] args){
		int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		System.out.println(printMatrix(matrix));
	}
}
