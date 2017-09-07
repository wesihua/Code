package 剑指offer;

public class 第36题_数组中的逆序列 {
	public static int InversePairs(int [] array) {
        return (int)mergeSortAndCount(array, 0, array.length-1)%1000000007;
    }
	
	//利用分治的思想，若能把数组平均分成两段，并给两段数组都排好序，并统计好两段数组中的逆序对，那么再统计整个数组的逆序对的时候
	//就能够利用两段数组是排序的性质，统计出这两段数组之间的逆序对
	//利用归并排序，在归并排序的过程中，统计逆序对
	public static long mergeSortAndCount(int[] array,int start,int end){
		if(start>=end)
			return 0;
		int mid = (start+end)/2;
		//sum1表示数组start到mid位置的逆序对数目
		long sum1 = mergeSortAndCount(array, start, mid);
		//sum2表示数组mid+1到end位置的逆序对数目
		long sum2 = mergeSortAndCount(array, mid+1, end);
		
		return sum1+sum2+merge(array, start, mid, mid+1, end);
		
	}
	
	//对两段数组进行归并，并统计两段数组间的逆序对，排序顺序还是从小到大，而由于要求的是前面的数大于后面的数的数目，所以归并排序的时候从两个排好序的数组的尾端进行
	public static long merge(int[] array,int start1,int end1,int start2,int end2){
		long sum = 0;
		int len1 = (end1-start1)>=0?end1-start1+1:0;
		int len2 = (end2-start2)>=0?end2-start2+1:0;
		int[] new_array = new int[len1+len2];
		int index = len1+len2-1;
		int i = end1;
		int j = end2;
		while(i>=start1&&j>=start2){
			if(array[i]>array[j]){
				new_array[index--] = array[i--];
				sum += j-start2+1;
			}
			else
				new_array[index--] = array[j--];
		}
		
		while(i>=start1){
			new_array[index--] = array[i--]; 
		}
		
		while(j>=start2){
			new_array[index--] = array[j--];
		}
		
//		System.out.println("****************************************");
//		for(int k=start1;k<=end2;k++)
//			System.out.print(array[k]+" ");
//		System.out.println();
//		for(int k=0;k<new_array.length;k++)
//			System.out.print(new_array[k]+" ");
//		System.out.println();
		
		
		System.arraycopy(new_array, 0, array, start1, len1+len2);
		
		return sum;
	}
	
	public static void main(String[] args){
		int[] array = {4,9,3,3,3,0,2,7,7};
		System.out.println(InversePairs(array));
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
}
