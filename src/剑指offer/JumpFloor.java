package 剑指offer;

/**
 * 	题目描述：
 	一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author zhenlanghuo
 *
 */
public class JumpFloor {
	protected int i = 0;
	//一次只能跳1级或者2级台阶，所以f(n)=f(n-1)+f(n-2)，就是一个斐波那契数列
	public static int JumpFloor_(int target){
		if(target == 0)
			return 0;
		int i = 0;
		int j = 1;
		while(target>0){
			int temp = i;
			i = j;
			j = j + temp;
			target--;
		}
		return j;
		
		
		
		
	}
	
	//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	//f(n)=f(n-1)+f(n-2)+...+f(0)+1 n>=3
	//f(1)=1、f(2)=2
	public static int JumpFloorII_(int target){
		if(target<=2)
			return target;
		int[] array= new int[target+1];
		for(int i=0;i<=2;i++)
			array[i] = i;
		
		for(int i=3;i<=target;i++){
			for(int j=i-1;j>=0;j--){
				array[i] += array[j];
			}
			array[i] += 1;
		}
		
		return array[target];
	}
	
//	//递归方法会时间复杂度大
//	public static int JumpFloor_(int target){
//		if(target==1||target==0)
//			return 1;
//		return JumpFloor_(target-1)+JumpFloor_(target-2);
//	}  
	
	public static void main(String[] args) {
		System.out.println(JumpFloorII_(1));
	}
}
