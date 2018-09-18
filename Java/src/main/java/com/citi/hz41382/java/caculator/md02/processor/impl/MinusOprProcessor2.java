package com.citi.hz41382.java.caculator.md02.processor.impl;

import java.util.List;

import com.citi.hz41382.java.caculator.md02.common.CaculatorConstant;
import com.citi.hz41382.java.caculator.md02.processor.AbstractMinusOprProcessor;

public class MinusOprProcessor2 extends AbstractMinusOprProcessor {

	@Override
	protected boolean processLastItemCondition(List<String> tempList) {
		if (tempList.size() > 2 && CaculatorConstant.SUBSTRACT.equals(tempList.get(tempList.size() - 2)) && CaculatorConstant.SUBSTRACT.equals(tempList.get(tempList.size() - 3))) {
			return true;
		}
		return false;
	}
}
