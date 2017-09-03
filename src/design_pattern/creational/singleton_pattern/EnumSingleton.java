package design_pattern.creational.singleton_pattern;

interface Singleton {
	void doSomeThing();
}

/**
 * 枚举式单例模式
 * @author zhenlanghuo
 *
 */
public enum EnumSingleton implements Singleton{
	INSTANCE{
		@Override
		public void doSomeThing() {
			
		}	
	};
	
	public static Singleton getInstance() {
		return EnumSingleton.INSTANCE;
	}
}
