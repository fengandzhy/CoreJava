package org.zhouhy.hz41382.java.caculator.md02.listener.impl;

import java.awt.event.ActionEvent;

import org.zhouhy.hz41382.java.caculator.md02.common.CaculatorConstant;
import org.zhouhy.hz41382.java.caculator.md02.common.CommonUtil;
import org.zhouhy.hz41382.java.caculator.md02.emus.NumberEmu;
import org.zhouhy.hz41382.java.caculator.md02.listener.AbstractListener;
import org.zhouhy.hz41382.java.caculator.md02.test.CaculatorTest;

public class EqualListener extends AbstractListener {

	public EqualListener(String name) {
		super(name);		
	}

	@Override
	public boolean validate() {
		if(recorder.isEmpty()){
			return false;
		}
		String lastStr = recorder.getList().get(recorder.size()-1);
		if(recorder.isBracketClosed() && (NumberEmu.isExists(lastStr) || CaculatorConstant.RIGHT_BRACKET.equals(lastStr))){
			return true;
		}		
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(validate()){			
			String result = CaculatorTest.caculate(CommonUtil.spliceString(recorder.getList()));
			recorder.removeAll();
			textField.setText(result);
		}
	}

}
