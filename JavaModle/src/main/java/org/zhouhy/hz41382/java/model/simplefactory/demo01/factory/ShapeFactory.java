package org.zhouhy.hz41382.java.model.simplefactory.demo01.factory;

import org.zhouhy.hz41382.java.model.simplefactory.demo01.IShape;
import org.zhouhy.hz41382.java.model.simplefactory.demo01.exceptions.BadShapeException;
import org.zhouhy.hz41382.java.model.simplefactory.demo01.products.Circle;
import org.zhouhy.hz41382.java.model.simplefactory.demo01.products.Square;
import org.zhouhy.hz41382.java.model.simplefactory.demo01.products.Triangle;

/**
* <p>className: ShapeFactory</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class ShapeFactory {
	
	private ShapeFactory(){
		
	}
	
	public static IShape getShapeInstance(String shape) throws BadShapeException{
		if(("circle").equalsIgnoreCase(shape)){
			return new Circle();
		}		
		if(("triangle").equalsIgnoreCase(shape)){
			return new Triangle();
		}
		if(("square").equalsIgnoreCase(shape)){
			return new Square();
		}
		throw new BadShapeException("no such shape");
	}
}
