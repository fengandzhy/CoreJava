package org.zhouhy.hz41382.java.model.simplefactory.demo01.test;

import org.apache.log4j.Logger;
import org.junit.Test;

import org.zhouhy.hz41382.java.model.simplefactory.demo01.IShape;
import org.zhouhy.hz41382.java.model.simplefactory.demo01.exceptions.BadShapeException;
import org.zhouhy.hz41382.java.model.simplefactory.demo01.factory.ShapeFactory;

/**
* <p>className: SimpleFactoryClient</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class SimpleFactoryClient {	
	private static Logger logger = Logger.getLogger(SimpleFactoryClient.class);
	private SimpleFactoryClient(){}	
	@Test
	public static void main(String[] args) {
		
		try {
			IShape circle = ShapeFactory.getShapeInstance("circle");
			circle.draw();
			IShape triangle = ShapeFactory.getShapeInstance("triangle");
			triangle.draw();
			IShape diamond = ShapeFactory.getShapeInstance("diamond");
			diamond.draw();
		} catch (BadShapeException e) {
			logger.error(e.getLocalizedMessage());			
		}
	}
}
