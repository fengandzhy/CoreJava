package com.citi.hz41382.java.caculator.md02.caculators.impls;


import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.citi.hz41382.java.caculator.md02.caculators.AbstractCaculator;
import com.citi.hz41382.java.caculator.md02.common.CaculatorConstant;
import com.citi.hz41382.java.caculator.md02.common.CommonUtil;
import com.citi.hz41382.java.caculator.md02.emus.UnaryOperatorsEmu;
import com.citi.hz41382.java.caculator.md02.exceptions.ExpressionException;
import com.citi.hz41382.java.caculator.md02.processor.AbstractMinusOprProcessor;
import com.citi.hz41382.java.caculator.md02.processor.impl.MinusOprProcessor2;
import com.citi.hz41382.java.caculator.md02.splits.AbstractSplitter;
import com.citi.hz41382.java.caculator.md02.splits.impl.BinaryOpsSplitter;
import com.citi.hz41382.java.caculator.md02.splits.impl.MinusOpSplitter;

public class FunctionsCaculator extends AbstractCaculator {	
	private static final Logger LOGGER = LoggerFactory.getLogger(FunctionsCaculator.class);
	
	public FunctionsCaculator(String name){
		super(name);		
	}
	
	@Override
	protected List<String> processCharList(List<String> inputCharList) {
		List<String> processList = new ArrayList<>();
		for(String item : inputCharList){
			processLogic(item, processList);
			LOGGER.debug("processing the processList is " + CommonUtil.presentList(processList));
		}
		return processList;
	}
	
	protected void processLogic(String item, List<String> processList) {
		if(!UnaryOperatorsEmu.isExists(item)){
			processList.add(item);
			return;
		}		
		if(item.indexOf(CaculatorConstant.SUBSTRACT)==-1){
			String result = caculateFunExpression(item);
			processList.add(result);
			return;
		}		
		List<String> tempList = processor.processMinusExpression(item);
		StringBuilder sb = new StringBuilder();
		sb.append(tempList.get(0));
		sb.append(tempList.get(1));
		sb.append(tempList.get(2));
		String result = caculateFunExpression(sb.toString());
		processList.add(result);
	}
	
	
	private String caculateFunExpression(String inputItem){
		String midValue = inputItem;
		int beginIndex = midValue.length()-1;
		int endIndex = midValue.length();
		while(UnaryOperatorsEmu.isExists(midValue)){
			String subStr = midValue.substring(beginIndex, endIndex);
			if(UnaryOperatorsEmu.isExists(subStr)){				
				String restult = getCaculateResult(subStr);				
				midValue = midValue.replaceAll(subStr, restult);
				beginIndex = midValue.length()-1;
				endIndex = midValue.length();				
			}else{
				beginIndex--;
			}			
		}
		return midValue;
	}
	
	public String getCaculateResult(String subStr){		
		UnaryOperatorsEmu emu = UnaryOperatorsEmu.getOperator(subStr);
		String number;
		switch(emu){
			case SIN:
				number = subStr.replaceAll(UnaryOperatorsEmu.SIN.getOperator(), "");
				return format.format(Math.sin(Double.parseDouble(number)));
			case COS:
				number = subStr.replaceAll(UnaryOperatorsEmu.COS.getOperator(), "");
				return format.format(Math.cos(Double.parseDouble(number)));
			case TAN:
				number = subStr.replaceAll(UnaryOperatorsEmu.TAN.getOperator(), "");
				return format.format(Math.tan(Double.parseDouble(number)));
			case CTG:
				number = subStr.replaceAll(UnaryOperatorsEmu.CTG.getOperator(), "");
				return format.format(1d / Math.tan(Double.parseDouble(number)));
			case LOG:
				number = subStr.replaceAll(UnaryOperatorsEmu.LOG.getOperator(), "");
				double power = Double.parseDouble(number);
				if(power<0){
					throw new ExpressionException("A0001","The power value is negative!");
				}
				return format.format(Math.log10(Double.parseDouble(number)));
			default: 
				return subStr;
		}
	}
	
	public static void main(String args[]){
		AbstractSplitter splitter = new BinaryOpsSplitter("binary");
		AbstractSplitter splitter1 = new MinusOpSplitter("minus");
		AbstractMinusOprProcessor processor = new MinusOprProcessor2();
		FunctionsCaculator caculator = new FunctionsCaculator("fun");
		processor.setSplitter(splitter1);
		caculator.setProcessor(processor);
		caculator.setSplitter(splitter);
		String str="tansin-23-2*4+log6^2";		
		System.out.println(caculator.caculate(str));
		
		
	}

	
	@Override
	protected String getResult(List<String> processList) {
		 return CommonUtil.spliceString(processList);
	}


	
}
