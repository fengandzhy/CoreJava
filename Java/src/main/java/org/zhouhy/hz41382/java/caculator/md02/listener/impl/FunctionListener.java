package org.zhouhy.hz41382.java.caculator.md02.listener.impl;

import org.zhouhy.hz41382.java.caculator.md02.emus.BinaryOperatorsEmu;
import org.zhouhy.hz41382.java.caculator.md02.emus.UnaryOperatorsEmu;
import org.zhouhy.hz41382.java.caculator.md02.listener.AbstractListener;

public class FunctionListener extends AbstractListener{

	public FunctionListener(String name) {
		super(name);		
	}

	@Override
	public boolean validate() {
		if(recorder.isEmpty()){
			return true;
		}
		String lastStr = recorder.getList().get(recorder.size()-1);
		if(BinaryOperatorsEmu.isExists(lastStr)){
			return true;
		}
		if(UnaryOperatorsEmu.isExists(lastStr)){
			return true;
		}
		return false;
	}

	
}
