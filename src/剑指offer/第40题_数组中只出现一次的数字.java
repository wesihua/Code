package 剑指offer;

import java.util.ArrayList;

public class 第40题_数组中只出现一次的数字 {
	//利用异或运算，两个相同的数字异或之后等于0
	//遍历数组，将所有数字进行异或，最后得到的结果就是数组中两个不相同的数字异或的结果
	//找出异或结果二进制表示中低位首次出现1的位置，然后以这个位置，分出两组数，一组为二进制表示该位置上是1的数字，另一组为二进制表示该位置上是0的数字
	//再分别对两组数求异或和就能求出原数组中两个不同的数字
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
