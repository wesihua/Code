package test;

class Parent {
	public Parent() {
		System.out.println("parent 默认构造函数");
	}
	
	public Parent(String arg) {
		System.out.println("parent 带参数构造函数："+arg);
	}
	
	static {
		System.out.println("parent 静态初始化代码块");
	}
	
	{
		System.out.println("parent 初始化代码块");
	}
	
}

class Child extends Parent {
	public Child() {
		System.out.println("child 默认构造函数");
	}
	
	public Child(String arg) {
		super(arg);
		System.out.println("child 带参数构造函数："+arg);
	}
	
	static {
		System.out.println("child 静态初始化代码块");
	}
	
	{
		System.out.println("child 初始化代码块");
	}
}

public class 类初始化顺序测试 {
	public static void main(String args[]) {
		Child child = new Child("aa");
	}
}

