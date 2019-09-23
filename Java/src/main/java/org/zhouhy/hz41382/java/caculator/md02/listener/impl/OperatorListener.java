package org.zhouhy.hz41382.java.caculator.md02.listener.impl;

import org.zhouhy.hz41382.java.caculator.md02.emus.NumberEmu;
import org.zhouhy.hz41382.java.caculator.md02.common.CaculatorConstant;
import org.zhouhy.hz41382.java.caculator.md02.emus.BinaryOperatorsEmu;
import org.zhouhy.hz41382.java.caculator.md02.listener.AbstractListener;

public class OperatorListener extends AbstractListener {

	public OperatorListener(String name) {
		super(name);
	}

	@Override
	public boolean validate() {		
		if(recorder.isEmpty()){
			recorder.push(NumberEmu.ZERO.getOperator());
			recorder.setExistDot(false);
			return true;
		}
		String lastStr = recorder.getList().get(recorder.size()-1);
		if(NumberEmu.isExists(lastStr) || CaculatorConstant.RIGHT_BRACKET.equals(lastStr)){
			recorder.setExistDot(false);
			return true;
		}
		if(BinaryOperatorsEmu.isExists(lastStr)){
			recorder.pop();
			recorder.setExistDot(false);
			return true;
		}
		return false;
	}
}
