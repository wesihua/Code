package 笔试.华为;

import java.util.ArrayList;
import java.util.Scanner;

public class 集五福 {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int sum = 0;
		while(in.hasNextInt()){
			sum += in.nextInt();
		}
		
		String[][] array = new String[3][3];
		
		//System.out.println(sum);
		String sumString = String.valueOf(sum);
		int min = sumString.charAt(0)-48;
		for(int i=1;i<sumString.length();i++){
			int value = sumString.charAt(i)-48;
			if(value<min)
				min = value;
		}
		
		System.out.println(min);
		
	}
}
