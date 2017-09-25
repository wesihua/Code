package 笔试.顺丰;

import java.util.Scanner;

public class 木木的密码 {
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;
            
        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }
  
        res = solve(_a);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
	
	static int[] solve(int[] a) {
		int[] result = new int[a.length];
		
		for(int i=a.length-1;i>=0;i--) {
			result[i] += a[i];
			for(int j=1,k=i;k+j<a.length;j++) {
				if(j%2==1)
					result[i] += result[k+j];
				else
					result[i] -= result[k+j];
			}
		}
		
		return result;
    }
}
