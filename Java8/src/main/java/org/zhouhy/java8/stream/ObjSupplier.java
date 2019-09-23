package org.zhouhy.java8.stream;

import java.util.Random;
import java.util.function.Supplier;

/**
* <p>className: ObjSupplier</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月21日
*/
public class ObjSupplier implements Supplier<Obj> {
	
	private int index = 0;
    private Random random = new Random(System.currentTimeMillis());
	
	@Override
	public Obj get() {
		index = random.nextInt(100);
        return new Obj(index, "Name->" + index);		
	}
}
