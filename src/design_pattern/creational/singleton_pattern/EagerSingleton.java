package design_pattern.creational.singleton_pattern;

/**
 * 饿汉式单例模式
 * 
 * @author zhenlanghuo
 *
 */
public class EagerSingleton {
	private static final EagerSingleton instance = new EagerSingleton();
	
	private EagerSingleton() {
		
	}
	
	public static EagerSingleton getInstance() {
		return instance;
	}
}
