package org.zhouhy.hz41382.java.caculator.md02.processor.impl;

import java.util.List;
import org.zhouhy.hz41382.java.caculator.md02.common.CaculatorConstant;
import org.zhouhy.hz41382.java.caculator.md02.processor.AbstractMinusOprProcessor;

public class MinusOprProcessor1 extends AbstractMinusOprProcessor{
	
	@Override
	protected boolean processLastItemCondition(List<String> tempList) {
		if (tempList.size() > 1 && CaculatorConstant.SUBSTRACT.equals(tempList.get(tempList.size() - 2))) {
			return true;
		}
		return false;
	}
}
