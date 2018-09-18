package com.citi.hz41382.java.caculator.md02.listener.impl;

import com.citi.hz41382.java.caculator.md02.common.CaculatorConstant;
import com.citi.hz41382.java.caculator.md02.emus.BinaryOperatorsEmu;
import com.citi.hz41382.java.caculator.md02.emus.NumberEmu;
import com.citi.hz41382.java.caculator.md02.listener.AbstractListener;

public class MinusListener extends AbstractListener {

	public MinusListener(String name) {
		super(name);
	}

	@Override
	public boolean validate() {
		if(recorder.isEmpty()){
			return true;
		}
		String lastStr = recorder.getList().get(recorder.size()-1);
		if(NumberEmu.isExists(lastStr) || BinaryOperatorsEmu.isExists(lastStr) || CaculatorConstant.LEFT_BRACKET.equals(lastStr) || CaculatorConstant.RIGHT_BRACKET.equals(lastStr)){
			return true;
		}
		String preLastStr = recorder.getList().get(recorder.size()-2);	
		if(NumberEmu.isExists(preLastStr) && CaculatorConstant.SUBSTRACT.equals(lastStr)){
			return true;
		}
		return false;
	}
}
