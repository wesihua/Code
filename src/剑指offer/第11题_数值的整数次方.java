package 剑指offer;

public class 第11题_数值的整数次方 {
	/**
	 * 
	 * 递归：n为偶数，a^n=a^n/2*a^n/2;n为奇数，a^n=（a^（n-1）/2）*（a^（n-1/2））*a
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public double Power(double base, int exponent) {
        int n=Math.abs(exponent);
		if(n==0)
			return 1;
		if(n==1)
			return base;
		double result=Power(base,n>>1);
		result*=result;
		if((n&1)==1)
			result*=base; 
		if(exponent<0)
			result=1/result;
		return result;
  }
}
