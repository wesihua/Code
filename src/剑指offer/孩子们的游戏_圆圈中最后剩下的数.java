package 剑指offer;

import java.util.ArrayList;

public class 孩子们的游戏_圆圈中最后剩下的数 {
	public static int LastRemaining_Solution(int n, int m) {
		if(n==0||m==0)
			return 0;
			
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int start = 0;
        for(int i=n-1;i>0;i--){
        	System.out.println(list);
            int index = (start+m-1)%(i+1);
            list.remove(index);
            if(index==i)
                start = 0;
            else
                start = index;
        }
        
        return list.get(0);
    }
	
	public static void main(String[] args){
		System.out.println(LastRemaining_Solution(5, 3));
	}
}
