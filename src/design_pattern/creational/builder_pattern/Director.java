package design_pattern.creational.builder_pattern;

/**
 * 指挥者
 * 
 * @author zhenlanghuo
 *
 */
public class Director {
	private AbstractBuilder builder;
	
	public Director(AbstractBuilder builder) {
		this.builder = builder;
	}
	
	public void setBuilder(AbstractBuilder builder) {
		this.builder = builder;
	}
	
	//产品构建与组装方法
	public Product construct() {
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
		return builder.getResult();
	}
	
	public static void main(String args[]) {
		//可通过配置文件实现
		AbstractBuilder builder = new ConcreteBuilder();
		Director director = new Director(builder);
		Product product = director.construct();
	}
}
