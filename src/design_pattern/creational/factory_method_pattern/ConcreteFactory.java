package design_pattern.creational.factory_method_pattern;

/**
 * 具体工厂
 * 
 * @author zhenlanghuo
 *
 */
public class ConcreteFactory implements Factory {

	@Override
	public Product factoryMethod() {
		return new ConcreteProduct();
	}

}
