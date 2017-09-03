package design_pattern.creational.builder_pattern;

/**
 * 抽象建造者
 * 
 * @author zhenlanghuo
 *
 */
public abstract class AbstractBuilder {
	//创建产品对象
    protected  Product product=new Product();
   
    public  abstract void buildPartA();
    public  abstract void buildPartB();
    public  abstract void buildPartC();
   
    //返回产品对象
    public  Product getResult() {
           return  product;
    }
}
