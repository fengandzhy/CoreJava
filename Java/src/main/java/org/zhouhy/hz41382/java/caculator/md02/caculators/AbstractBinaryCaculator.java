package org.zhouhy.hz41382.java.caculator.md02.caculators;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.zhouhy.hz41382.java.caculator.md02.common.CommonUtil;
import org.zhouhy.hz41382.java.caculator.md02.emus.BinaryOperatorsEmu;
import org.zhouhy.hz41382.java.caculator.md02.exceptions.ExpressionException;


public abstract class AbstractBinaryCaculator extends AbstractCaculator {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractBinaryCaculator.class);

	
	protected String[] expressArray = new String[3];
	protected String tempString;

	public AbstractBinaryCaculator(String name) {
		super(name);
	}

	protected abstract boolean judgementLogic(String item);

	@Override
	protected String getResult(List<String> processList) {		
		return CommonUtil.spliceString(processList);
	}

	
	@Override
	protected List<String> processCharList(List<String> inputCharList) {
		List<String> processList = new ArrayList<>();
		for (String item : inputCharList) {
			processLogic(item, processList);
		}
		if(null!=tempString){
			processList.add(tempString);
			tempString = null;
		}		
		return processList;
	}
	
	protected void processLogic(String item, List<String> processList) {
		if (expressArray[1] != null) {
			List<String> tempList = processor.processMinusExpression(item);
			expressArray[2] = tempList.get(0);
			String result = cacaulateExpression(expressArray);
			tempList.remove(0);
			if (tempList.isEmpty()) {
				tempString = result;
			} else {
				processList.add(result);
				tempString = tempList.get(tempList.size() - 1);
				tempList.remove(tempList.size() - 1);
				processList.addAll(tempList);
			}
			trancateExpressionArray(expressArray);
			return;
		}
		if (judgementLogic(item)) {			
			List<String> tempList = processor.processMinusExpression(tempString);
			expressArray[0] = tempList.get(tempList.size() - 1);
			expressArray[1] = item;
			tempList.remove(tempList.size() - 1);
			processList.addAll(tempList);
			return;
		}

		if (tempString != null) {
			processList.add(tempString);
		}
		tempString = item;
	}

	protected String cacaulateExpression(String[] expressArray) {
		BinaryOperatorsEmu emu = BinaryOperatorsEmu.getOperatorByStr(expressArray[1]);
		String result;
		switch (emu) {
		case MULTIPLY:
			result = format.format(Double.parseDouble(expressArray[0]) * Double.parseDouble(expressArray[2]));
			return result;
		case DIVISION:
			double divisor = Double.parseDouble(expressArray[2]);
			if(divisor==0){
				throw new ExpressionException("A0002","The divisor value is zero!");
			}
			result = format.format(Double.parseDouble(expressArray[0]) / divisor);
			return result;
		case MODULE:
			result = format.format(Double.parseDouble(expressArray[0]) % Double.parseDouble(expressArray[2]));
			return result;
		case POWER:
			result = format.format(Math.pow(Double.parseDouble(expressArray[0]), Double.parseDouble(expressArray[2])));
			return result;
		case ADD:
			result = format.format(Double.parseDouble(expressArray[0]) + Double.parseDouble(expressArray[2]));
			return result;
		default:
			return null;
		}
	}

	protected void trancateExpressionArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
	}	
}
