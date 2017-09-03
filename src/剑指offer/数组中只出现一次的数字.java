package 剑指offer;

import java.util.ArrayList;

public class 数组中只出现一次的数字 {
	public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int xorSum = array[0];
		for(int i=1;i<array.length;i++){
			xorSum = xorSum^array[i];
        }
		
		String xorSumBinaryStr = Integer.toBinaryString(xorSum);
		int lastIndexOf1 = xorSumBinaryStr.length()-xorSumBinaryStr.lastIndexOf("1");
		
		ArrayList<Integer> list0 = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		
		for(int i=0;i<array.length;i++){
			String binaryStr = Integer.toBinaryString(array[i]);
			if(binaryStr.length()<lastIndexOf1)
				list0.add(array[i]);
			else {
				char c = binaryStr.charAt(binaryStr.length()-lastIndexOf1);
				if(c=='0')
					list0.add(array[i]);
				else
					list1.add(array[i]);
			}
		}
		
		num1[0] = list0.get(0);
		num2[0] = list1.get(0);
		
		for(int i=1;i<list0.size();i++){
			num1[0] = num1[0]^list0.get(i);
		}
		
		for(int i=1;i<list1.size();i++){
			num2[0] = num2[0]^list1.get(i);
		}
    }
	
	public static void main(String[] args){
		int[] array = {4,6,1,1,1,1};
		int[] num1 = {0};
		int[] num2 = {0};
		FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0]+" "+num2[0]);
	}
}
