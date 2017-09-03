package sort;


public class quickSort {
	
	public static void quickSort(int[] array,int start,int end){
		if(start>=end)
			return;
		
		int piovt = findPiovt(array, start, end);
		swap(array,piovt,end);
		int partition = getPartition(array, start, end);
		
		quickSort(array, start, partition-1);
		quickSort(array, partition+1, end);
		
	}
	
	public static int getPartition(int[] array,int start,int end){
		int i=start;
		int j=end-1;
		do{
			while(array[i]<array[end])
				i++;
			while((j-1>=start)&&array[j]>=array[end])
				j--;
			swap(array, i, j);
		}while(i<j);
		swap(array, i, j);
		swap(array, i, end);
		return i;
	}
	
	public static int findPiovt(int[] array,int start,int end){
		int x = array[start];
		int y = array[end];
		int z = array[(start+end)/2];
		
		int max = Math.max(x, Math.max(y, z));
		int min = Math.min(x, Math.min(y, z));
		
		int mid = x+y+z-max-min;
		
		if(x==mid)
			return start;
		else if(y==mid)
			return end;
		else
			return (start+end)/2;
	}
	
	
	
	public static void swap(int[] array,int x,int y){
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	public static void main(String[] args){
		//int[] array = {23,44,5,2,4,56,523,59,21,674,32};
		int[] array = {1,2,4};
		quickSort.quickSort(array, 0, array.length-1);
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}
}
