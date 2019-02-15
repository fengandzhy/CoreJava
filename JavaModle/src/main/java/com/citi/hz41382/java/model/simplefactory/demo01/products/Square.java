package com.citi.hz41382.java.model.simplefactory.demo01.products;

import com.citi.hz41382.java.model.simplefactory.demo01.IShape;

/**
* <p>className: Square</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class Square implements IShape {

	@Override
	public void draw() {
		System.out.println("Square.draw()");
	}

	@Override
	public void erase() {
		System.out.println("Square.erase()");
	}

}
