package test;

public class 基本类型 {
	public static void main(String args[]){
		byte b = 1;
		short s = 1;
		int i = 1;
		long l = 1;
		long l_ = 0xfffL;
		long l__ = 0xfff;
		float f = 1;
		//java的小数默认duoble类型，所以赋值给float类型要显式类型转换
		//float f = 1.0f
		double d = 1;
		double d_ = 0x12345678;
		
		Byte B = 1;
		Short S = 1;
		Integer I = 1;
		Long L = 1L;
		Float F = 1F;
		Double D = 1D;
		
		//true,自动拆箱封箱
		System.out.println(b==B);
		//false,equals先比较类型
		System.out.println(B.equals(S));
		//不同类型数据不能用==运算符
		//System.out.println(B==S);
		
		//byte、short类型运算会自动转换为int类型，所以要进行显式类型转换
		byte a = (byte)(b*b);
		float c = f*f;
		
		//低精度到高精度能自动隐式转换，高精度到低精度需要显式强制类型转换
		i = b;
		b = (byte)i;
		d = i;
		i = (int)d;
	}
}
