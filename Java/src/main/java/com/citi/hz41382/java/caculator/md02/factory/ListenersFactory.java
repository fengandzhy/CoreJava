package com.citi.hz41382.java.caculator.md02.factory;

import javax.swing.JTextField;

import com.citi.hz41382.java.caculator.md02.common.CaculatorConstant;
import com.citi.hz41382.java.caculator.md02.common.Recorder;
import com.citi.hz41382.java.caculator.md02.listener.AbstractListener;
import com.citi.hz41382.java.caculator.md02.listener.impl.BracketListener;
import com.citi.hz41382.java.caculator.md02.listener.impl.EqualListener;
import com.citi.hz41382.java.caculator.md02.listener.impl.FunctionListener;
import com.citi.hz41382.java.caculator.md02.listener.impl.MinusListener;
import com.citi.hz41382.java.caculator.md02.listener.impl.NumberListener;
import com.citi.hz41382.java.caculator.md02.listener.impl.OperatorListener;
import com.citi.hz41382.java.caculator.md02.listener.impl.OtherListener;
import com.citi.hz41382.java.caculator.md02.listener.impl.PointListener;

public class ListenersFactory {
	
	
	private ListenersFactory(){
		//empty
	}
	
	public static void addAttributions(AbstractListener listener,Recorder recorder,JTextField textField){
		listener.setRecorder(recorder);
		listener.setTextField(textField);
	}
	
	public static AbstractListener createNumberListener(Recorder recorder,JTextField textField){
		AbstractListener numberListener = new NumberListener(CaculatorConstant.NUMBER);
		addAttributions(numberListener,recorder,textField);
		return numberListener;
	}
	
	public static AbstractListener createMinusListener(Recorder recorder,JTextField textField){
		AbstractListener minusListener = new MinusListener(CaculatorConstant.MINUS);
		addAttributions(minusListener,recorder,textField);
		return minusListener;
	}
	
	public static AbstractListener createEqualListener(Recorder recorder,JTextField textField){
		AbstractListener equlasListener = new EqualListener(CaculatorConstant.EQUALS);
		addAttributions(equlasListener,recorder,textField);
		return equlasListener;
	}
	
	public static AbstractListener createOperatorListener(Recorder recorder,JTextField textField){
		AbstractListener operatorListener = new OperatorListener(CaculatorConstant.OPERATOR);
		addAttributions(operatorListener,recorder,textField);
		return operatorListener;
	}
	
	public static AbstractListener createFunctionListener(Recorder recorder,JTextField textField){
		AbstractListener functionListener = new FunctionListener(CaculatorConstant.FUNCTION);
		addAttributions(functionListener,recorder,textField);
		return functionListener;
	}
	
	public static AbstractListener createOtherListener(Recorder recorder,JTextField textField){
		AbstractListener otherListener = new OtherListener(CaculatorConstant.OTHER);
		addAttributions(otherListener,recorder,textField);
		return otherListener;
	}
	
	public static AbstractListener createPointListener(Recorder recorder,JTextField textField){
		AbstractListener pointListener = new PointListener(CaculatorConstant.DOT);
		addAttributions(pointListener,recorder,textField);
		return pointListener;
	}
	
	public static AbstractListener createBracketListener(Recorder recorder,JTextField textField){
		AbstractListener bracketListener = new BracketListener(CaculatorConstant.BRACKET);
		addAttributions(bracketListener,recorder,textField);
		return bracketListener;
	}
}
