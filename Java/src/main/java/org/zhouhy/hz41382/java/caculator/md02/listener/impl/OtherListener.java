package org.zhouhy.hz41382.java.caculator.md02.listener.impl;

import java.awt.event.ActionEvent;
import java.util.List;

import org.zhouhy.hz41382.java.caculator.md02.common.CaculatorConstant;
import org.zhouhy.hz41382.java.caculator.md02.emus.BinaryOperatorsEmu;
import org.zhouhy.hz41382.java.caculator.md02.emus.NumberEmu;
import org.zhouhy.hz41382.java.caculator.md02.listener.AbstractListener;

public class OtherListener extends AbstractListener {

	public OtherListener(String name) {
		super(name);
		
	}

	@Override
	public boolean validate() {		
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonName = e.getActionCommand();
		if(validate()){
			buttonAction(buttonName);
		}
		
	}

	private void buttonAction(String buttonName){
		if(CaculatorConstant.BACK.equals(buttonName) && !recorder.isEmpty()){
			String lastStr = recorder.getList().get(recorder.size()-1);	
			processDotLogic(lastStr);
			processBracketLogic(lastStr);
			recorder.pop();
			if(recorder.isEmpty()){
				textField.setText(NumberEmu.ZERO.getOperator());
				return;
			}
			setTextContent();
		}
		
		if(CaculatorConstant.CLEAR.equals(buttonName)){
			if(!recorder.isEmpty()){
				recorder.removeAll();
			}			
			textField.setText(NumberEmu.ZERO.getOperator());
		}		
	}
	
	private void processDotLogic(String lastStr){
		if(BinaryOperatorsEmu.isExists(lastStr)){			
			List<String> list = recorder.getList();
			boolean isExistDot =  varifyDotExist(list);
			recorder.setExistDot(isExistDot);
			return;
		}
		if(CaculatorConstant.POINT.equals(lastStr)){
			recorder.setExistDot(false);
		}
	}
	
	private void processBracketLogic(String lastStr){
		if(CaculatorConstant.LEFT_BRACKET.equals(lastStr)){
			recorder.substractBracketLevel();
			return;
		}
		if(CaculatorConstant.RIGHT_BRACKET.equals(lastStr)){
			recorder.addBracketLevel();
			return;
		}
	}
	
	private boolean varifyDotExist(List<String> list){
		int beginIndex = list.size()-2;
		for(int i = beginIndex;i>-1;i--){
			String item = list.get(i);
			if(BinaryOperatorsEmu.isExists(item)){
				return false;
			}
			if(CaculatorConstant.POINT.equals(item)){
				return true;
			}
		}
		return false;
	}
	
	

}
