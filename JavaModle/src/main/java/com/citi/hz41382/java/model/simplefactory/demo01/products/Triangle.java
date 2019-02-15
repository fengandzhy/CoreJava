package com.citi.hz41382.java.model.simplefactory.demo01.products;

import com.citi.hz41382.java.model.simplefactory.demo01.IShape;

/**
* <p>className: Triangle</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class Triangle implements IShape {

	@Override
	public void draw() {
		System.out.println("Triangle.draw()");
	}

	@Override
	public void erase() {
		System.out.println("Triangle.erase()");
	}

}
