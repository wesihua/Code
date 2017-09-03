package design_pattern.behavioral.template_method_pattern;

/**
 * 模板抽象类
 * 
 * @author zhenlanghuo
 *
 */
public abstract class AbstractClass {
	//模板方法  
	public void TemplateMethod()   
	{  
	        primitiveOperation1();  
	        primitiveOperation2(); 
	        if(isOperation3())
	        	primitiveOperation3();  
	}  
	  
	//基本方法—具体方法  
	public void primitiveOperation1()   
	{  
	    //实现代码  
	}  
	  
	//基本方法—抽象方法  
	public abstract void primitiveOperation2();      
	  
	//基本方法—抽象方法  
	public abstract void primitiveOperation3();
	
	//钩子方法
	public boolean isOperation3() {
		return true;
	}
	
}
