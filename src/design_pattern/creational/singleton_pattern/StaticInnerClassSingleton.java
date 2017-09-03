package design_pattern.creational.singleton_pattern;

/**
 * 静态内部类式单例模式
 * @author zhenlanghuo
 *
 */
public class StaticInnerClassSingleton {
	private StaticInnerClassSingleton() {
		
	}
	
	private static class HolderClass {
		private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
	}
	
	public static StaticInnerClassSingleton getInstance() {
		return HolderClass.instance;
	}
}
