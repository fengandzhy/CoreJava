package org.zhouhy.hz41382.java.proxy.md02;

import net.sf.cglib.proxy.Enhancer;
/**
* <p>className: GetProxy</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月28日
*/
public class GetProxy {
	private Enhancer enhancer=new Enhancer();
	public <T> Object  getProxy(Class<T> clazz){
		enhancer.setSuperclass(clazz);//设置需要创建子类的类.
		enhancer.setCallback(new CglibProxy());//回调方法,这里需要的是一个实现了net.sf.cglib.proxy.MethodInterceptor接口的实例
		return enhancer.create();//动态创建子类实例. 
	}
}
