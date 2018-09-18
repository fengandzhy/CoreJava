package com.citi.hz41382.java.caculator.md02.listener.impl;
import com.citi.hz41382.java.caculator.md02.common.CaculatorConstant;
import com.citi.hz41382.java.caculator.md02.emus.BinaryOperatorsEmu;
import com.citi.hz41382.java.caculator.md02.emus.NumberEmu;
import com.citi.hz41382.java.caculator.md02.emus.UnaryOperatorsEmu;
import com.citi.hz41382.java.caculator.md02.listener.AbstractListener;
public class NumberListener extends AbstractListener {
	
	
	public NumberListener(String name) {
		super(name);		
	}

	@Override
	public boolean validate() {
		if(recorder.isEmpty()){
			return true;
		}
		String lastStr = recorder.getList().get(recorder.size()-1);	
		if(lastStr.equals(NumberEmu.ZERO.getOperator()) && recorder.size() == 1){
			recorder.pop();
			return true;
		}
		if(isOperator(lastStr)){			
			return true;
		}		
		if(recorder.size()>1 && isZeroAfterOperator() ){			
			return true;
		}		
		if(NumberEmu.isExists(lastStr) || CaculatorConstant.POINT.equals(lastStr)){			
			return true;
		}		
		return false;
	}
	
	private boolean isOperator(String lastStr){		
		if(BinaryOperatorsEmu.isExists(lastStr)|| UnaryOperatorsEmu.isExists(lastStr)|| CaculatorConstant.SUBSTRACT.equals(lastStr) || CaculatorConstant.LEFT_BRACKET.equals(lastStr)){			
			return true;
		}
		return false;
	}
	
	private boolean isZeroAfterOperator(){
		String lastStr = recorder.getList().get(recorder.size()-1);		
		String preLastStr = recorder.getList().get(recorder.size()-2);	
		if(isOperator(preLastStr) && lastStr.equals(NumberEmu.ZERO.getOperator())){
			recorder.pop();
			return true;
		}		
		return false;		
	}	
}
