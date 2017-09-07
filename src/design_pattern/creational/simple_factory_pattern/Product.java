package design_pattern.creational.simple_factory_pattern;

/**
 * 抽象产品角色
 * 
 * @author zhenlanghuo
 *
 */
public abstract class Product {
	//所有产品类的公共业务方法
	public void methodSame() {
		
	}
	
	public abstract void methodDiff();
}
