package 笔试.阿里;

public class 四等分 {
	
	
	
	public static boolean find(int[] array){
		int i=0;
		int j=array.length-1;
		
		System.out.println(array.length);
		int[] array_sum = new int[array.length];
		for(int k=0;k<array.length;k++){
			if(k==0)
				array_sum[k] = array[k];
			else
				array_sum[k] = array_sum[k-1]+array[k];
		}
		
		for(int k=0;k<array.length;k++){
			System.out.print(array[k]+" ");
		}
		System.out.println();
		for(int k=0;k<array.length;k++){
			System.out.print(array_sum[k]+" ");
		}
		System.out.println();
		
		int[] sum = new int[4];
		sum[0] = array[0];
		sum[3] = array[j];
		
		
		while(true){
			if(sum[0]==sum[3]){
				System.out.println("i:"+i+" j:"+j);
				System.out.println(sum[0]+" "+sum[3]);
				boolean flag = true;
				int end = -1;
				for(int start=i+2;start<=j-2;start++){
					sum[1] += array[start];
					if(sum[1] == sum[0])
						end = start;
					if(sum[1]>sum[0]){
						flag = false;
						break;
					}
				}
				
				System.out.println("end:"+end);
				
				if(end==-1&&flag)
					return false;
				
				if(end!=-1){
					if(j-end<2)
						return false;
					sum[2] = array_sum[j-2]-array_sum[end+1];
					if(sum[2]==sum[0])
						return true;
					if(sum[2]<sum[0])
						return false;
				}
				
				sum[0] += array[++i];
				sum[3] += array[--j];
				sum[1] = 0;
				sum[2] = 0;
			}
			else{
				if(i+1+4>j-1){
					System.out.println("!!");
					return false;
				}
				
				if(sum[0]<sum[3])
					sum[0] += array[++i];
				else if(sum[0]>sum[3])
					sum[3] += array[--j];
				
			}
		}
		
		
	}
	
	public static void main(String[] args){
		int[] array = {2,5,3,4,3,6,5,2,4,6};
		System.out.println(find(array));
	}
}
