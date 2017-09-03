package design_pattern.creational.singleton_pattern;

/**
 * 懒汉式单例模式（双重检查）
 * 
 * @author zhenlanghuo
 *
 */
public class LazySingleton {
	private volatile static LazySingleton instance = null;
	
	private LazySingleton() {
		
	}
	
	public LazySingleton getInstance() {
		if(instance==null) {
			synchronized (instance) {
				if(instance==null)
					instance = new LazySingleton();
			}
		}
		
		return instance;
	}
}
