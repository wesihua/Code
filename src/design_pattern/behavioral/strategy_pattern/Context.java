package design_pattern.behavioral.strategy_pattern;

/**
 * 环境类
 * 
 * @author zhenlanghuo
 *
 */
public class Context {
	//维持一个对抽象策略类的引用
	private AbstractStrategy strategy;
	
	public void setStrategy(AbstractStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void algorithm() {
		strategy.algorithm();
	}
	
	public static void main(String args[]) {
		Context context = new Context();
		//可以在运行时指定具体的策略类型
		AbstractStrategy strategy = new ConcreteStrategyA();
		context.setStrategy(strategy);
		context.algorithm();
	}
}
