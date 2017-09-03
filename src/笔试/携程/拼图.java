package 笔试.携程;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


import java.util.Scanner;

public class 拼图{

    /*请完成下面这个函数，实现题目要求的功能*/
    /*当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */
    /******************************开始写代码******************************/
    static int run(int[][] array){
		int count = 0;
		
		int i=0;
		int j=0;
		boolean flag = false;
		
		for(i=0;i<3;i++){
            for(j=0;j<3;j++){
            	if(array[i][j]==0){
            		flag = true;
            		break;
            	}
            }
            if(flag)
            	break;
        }
		
		int[][] copy_array = new int[3][3];
		int diff = 0;
		while((diff=diff(array))!=0){
			int diff_1 = 10;
			int diff_2 = 10;
			int diff_3 = 10;
			int diff_4 = 10;
			
			if(i-1>=0){
				copy(array,copy_array);
				change(copy_array, i, j, i-1, j);
				diff_1 = diff(copy_array);
				//diff_1 = diff - change(copy_array, i, j, i-1, j);
			}
			if(i+1<=2){
				copy(array,copy_array);
				change(copy_array, i, j, i+1, j);
				diff_2 = diff(copy_array);
				//diff_2 = diff - change(copy_array, i, j, i+1, j);
			}
			if(j-1>=0){
				copy(array,copy_array);
				change(copy_array, i, j, i, j-1);
				diff_3 = diff(copy_array);
				//diff_3 = diff - change(copy_array, i, j, i, j-1);
			}
			if(j+1<=2){
				copy(array,copy_array);
				change(copy_array, i, j, i, j+1);
				diff_4 = diff(copy_array);
				//diff_4 = diff - change(copy_array, i, j, i, j+1);
			}
			
			//System.out.println(diff_1+" "+diff_2+" "+diff_3+" "+diff_4);
			int min = Math.min(Math.min(diff_1, diff_2), Math.min(diff_3, diff_4));
			if(min==diff_1){
				//System.out.println("1");
				change(array, i, j, i-1, j);
				i = i-1;
			}
			else if(min==diff_2){
				//System.out.println("2");
				change(array, i, j, i+1, j);
				i = i+1;
			}
			else if(min==diff_3){
				//System.out.println("3");
				change(array, i, j, i, j-1);
				j = j-1;
			}
			if(min==diff_4){
				//System.out.println("4");
				change(array, i, j, i, j+1);
				j = j+1;
			}
			
			count++;
		}
		
		return count;
    }
   /******************************结束写代码******************************/
    
    static int change(int[][] array,int i,int j,int i_,int j_){
    	int count1 = 0;
    	int count2 = 0;
    	
    	if(i==2&&j==2){
    		if(array[i][j]!=0)
    			count1++;
    	}
    	else if(array[i][j]!=i*3+j+1)
    		count1++;
    	
    	
    	if(i_==2&&i_==2){
    		if(array[i_][j_]!=0)
    			count1++;
    	}
    	else if(array[i_][j_]!=i_*3+j_+1)
    		count1++;
    	
    	int temp = array[i][j];
    	array[i][j] = array[i_][j_];
    	array[i_][j_] = temp;
    	
    	if(i==2&&j==2){
    		if(array[i][j]!=0)
    			count2++;
    	}
    	else if(array[i][j]!=i*3+j+1)
    		count2++;
    	
    	
    	if(i_==2&&i_==2){
    		if(array[i_][j_]!=0)
    			count2++;
    	}
    	else if(array[i_][j_]!=i_*3+j_+1)
    		count2++;
    	
    	return count1-count2;
    }
    
    static void copy(int[][] array,int[][] copy_array){
    	for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
            	copy_array[i][j] = array[i][j];
            }
        }
    }
    
    
    static int diff(int[][] array){
    	int count = 0;
    	for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
            	if(i==2&&j==2){
            		if(array[i][j]!=0)
            			count++;
            	}
            	else if(array[i][j]!=i*3+j+1)
            		count++;
            }
        }
    	
    	return count;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
      
        int[][] array = new int[3][3]; 
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
            	array[i][j] = scan.nextInt();
            }
        }
 
        int res = run(array);
      
        System.out.println(String.valueOf(res));
    }
}
