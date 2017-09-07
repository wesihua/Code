package design_pattern.creational.simple_factory_pattern;

/**
 * 工厂角色
 * 
 * @author zhenlanghuo
 *
 */
public class Factory {
	//静态工厂方法
	public static Product getProduct(String arg) {
		Product product = null;
		
		if(arg.equalsIgnoreCase("A"))
			product = new ConcreteProductA();
		else if(arg.equalsIgnoreCase("B"))
			product = new ConcreteProductB();
		
		return product;
	}
	
	public static void main(String args[]) {  
        Product product;   
        product = Factory.getProduct("A"); //通过工厂类创建产品对象  
        product.methodSame();  
        product.methodDiff();  
    } 
}
