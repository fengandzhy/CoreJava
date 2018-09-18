package com.citi.hz41382.java.caculator.md02.listener.impl;

import java.awt.event.ActionEvent;

import com.citi.hz41382.java.caculator.md02.common.CaculatorConstant;
import com.citi.hz41382.java.caculator.md02.emus.BinaryOperatorsEmu;
import com.citi.hz41382.java.caculator.md02.emus.NumberEmu;
import com.citi.hz41382.java.caculator.md02.listener.AbstractListener;

public class BracketListener extends AbstractListener {

	public BracketListener(String name) {
		super(name);
	}

	@Override
	public boolean validate() {
		if(recorder.isEmpty()){
			return true;
		}		
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonName = e.getActionCommand();
		boolean isRightBracket = processRightBracket(buttonName);
		if(isRightBracket){
			setTextContent();
			return;
		}
		processLeftBracket(buttonName);
		setTextContent();
	}
	
	private boolean processRightBracket(String buttonName){
		if(CaculatorConstant.RIGHT_BRACKET.equals(buttonName)){
			if(recorder.isEmpty()){
				return true;
			}
			String lastStr = recorder.getList().get(recorder.size()-1);	
			if(NumberEmu.isExists(lastStr) && !recorder.isBracketClosed()){				
				return addRightBracket(buttonName);
			}
			if(CaculatorConstant.RIGHT_BRACKET.equals(lastStr) && !recorder.isBracketClosed()){
				return addRightBracket(buttonName);
			}
			return true;
		}
		return false;
	}
	
	private boolean processLeftBracket(String buttonName){
		if(CaculatorConstant.LEFT_BRACKET.equals(buttonName)){
			if(recorder.isEmpty()){
				return addLeftBracket(buttonName);
			}
			String lastStr = recorder.getList().get(recorder.size()-1);	
			if(BinaryOperatorsEmu.isExists(lastStr)){
				return addLeftBracket(buttonName);
			}
			if(CaculatorConstant.LEFT_BRACKET.equals(lastStr)){
				return addLeftBracket(buttonName);
			}
			return true;
		}
		return false;
	}
	
	private boolean addRightBracket(String buttonName){
		recorder.substractBracketLevel();
		recorder.push(buttonName);
		return true;
	}
	
	private boolean addLeftBracket(String buttonName){
		recorder.addBracketLevel();
		recorder.push(buttonName);
		return true;
	}
}
