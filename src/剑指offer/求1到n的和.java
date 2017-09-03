package 剑指offer;

public class 求1到n的和 {
	public int Sum_Solution(int n) {
     	int ans = n;
        boolean flag = (ans!=0) && (ans+=Sum_Solution(n-1))!=0;
        return ans;
    }
	
	public static void main(String[] args){
		System.out.println(3^2);
	}
}
