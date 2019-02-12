package com.citi.hz41382.java.model.creator.demo01.builder;

import com.citi.hz41382.java.model.creator.demo01.IBuilder;
import com.citi.hz41382.java.model.creator.demo01.Ipart;
import com.citi.hz41382.java.model.creator.demo01.parts.MainBoard;

/**
* <p>className: MainBoardBuilder</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class MainBoardBuilder implements IBuilder {
	
	@Override
	public Ipart buildPart() {
		return new MainBoard();
	}
}
