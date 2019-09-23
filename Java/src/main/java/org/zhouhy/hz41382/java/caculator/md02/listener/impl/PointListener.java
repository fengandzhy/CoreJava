package org.zhouhy.hz41382.java.caculator.md02.listener.impl;

import org.zhouhy.hz41382.java.caculator.md02.emus.NumberEmu;
import org.zhouhy.hz41382.java.caculator.md02.listener.AbstractListener;

public class PointListener extends AbstractListener {

	public PointListener(String name) {
		super(name);		
	}

	@Override
	public boolean validate() {
		if(recorder.isEmpty()){
			recorder.push(NumberEmu.ZERO.getOperator());
			recorder.setExistDot(true);
			return true;
		}
		String lastStr = recorder.getList().get(recorder.size()-1);
		if(NumberEmu.isExists(lastStr) && !recorder.isExistDot()){
			recorder.setExistDot(true);
			return true;
		}
		return false;
	}

}
