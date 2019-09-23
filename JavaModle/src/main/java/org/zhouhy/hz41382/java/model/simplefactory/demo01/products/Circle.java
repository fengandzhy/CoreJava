package org.zhouhy.hz41382.java.model.simplefactory.demo01.products;

import org.zhouhy.hz41382.java.model.simplefactory.demo01.IShape;

/**
* <p>className: Circle</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class Circle implements IShape {

	@Override
	public void draw() {
		System.out.println("Circle.draw()");
	}

	@Override
	public void erase() {
		System.out.println("Circle.erase()");
	}

}
