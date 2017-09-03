package 剑指offer;

public class 把字符串转换成整数 {
	public static int[] multiply(int[] A) {
        int n = A.length;
		int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        
        for(int i=0;i<n;i++){
            if(i==0)
                C[i] = 1;
            else
                C[i] = C[i-1]*A[i-1];
        }
        
        for(int i=n-1;i>=0;i--){
            if(i==n-1)
                D[i] = 1;
            else
                D[i] = D[i+1]*A[i+1];
        }
        
        for(int i=0;i<n;i++){
            B[i] = C[i]*D[i];
        }
        
        return B;
    }
	
	public static int StrToInt(String str) {
        long result = 0;
        boolean minus = false;
        
        if(str.equals(""))
        	return 0;
        
        if(str.charAt(0)=='-'||str.charAt(0)=='+'){
        	if(str.charAt(0)=='-')
        		minus = true;
        }
        else if(str.charAt(0)-'0'>=0&&str.charAt(0)-'0'<=9)
        	result = str.charAt(0)-'0';
        else
        	return 0;
        
        for(int i=1;i<str.length();i++){
        	if(str.charAt(i)-'0'>=0&&str.charAt(i)-'0'<=9){
        		result = result*10 + (str.charAt(i)-'0');
        		if((!minus&&result>0x7FFFFFFF)||(minus&&(result*-1)<0x80000000))
        			return 0;
        	}
        	else
        		return 0;
        }
        
        if(!minus)
        	return (int)result;
        else
        	return (int)result*-1;
    }
	
	public static void main(String[] args){
		int[] A = {1,2,3,4,5};
		System.out.println(multiply(A));
	}
}
