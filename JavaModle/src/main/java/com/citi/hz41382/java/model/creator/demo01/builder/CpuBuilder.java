package com.citi.hz41382.java.model.creator.demo01.builder;

import com.citi.hz41382.java.model.creator.demo01.IBuilder;
import com.citi.hz41382.java.model.creator.demo01.Ipart;
import com.citi.hz41382.java.model.creator.demo01.parts.Cpu;

/**
* <p>className: CpuBuilder</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class CpuBuilder implements IBuilder {

	@Override
	public Ipart buildPart() {
		return new Cpu();
	}

}