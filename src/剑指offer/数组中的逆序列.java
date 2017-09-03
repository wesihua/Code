package 剑指offer;

public class 数组中的逆序列 {
	public static int InversePairs(int [] array) {
        return (int)mergeSortAndCount(array, 0, array.length-1)%1000000007;
    }
	
	public static long mergeSortAndCount(int[] array,int start,int end){
		if(start>=end)
			return 0;
		int mid = (start+end)/2;
		long sum1 = mergeSortAndCount(array, start, mid);
		long sum2 = mergeSortAndCount(array, mid+1, end);
		
		return sum1+sum2+merge(array, start, mid, mid+1, end);
		
	}
	
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
