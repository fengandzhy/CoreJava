package org.zhouhy.hz41382.java.caculator.md02.processor;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhouhy.hz41382.java.caculator.md02.common.CaculatorConstant;
import org.zhouhy.hz41382.java.caculator.md02.common.CommonUtil;
import org.zhouhy.hz41382.java.caculator.md02.splits.AbstractSplitter;


public abstract class AbstractMinusOprProcessor {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractMinusOprProcessor.class);
	private AbstractSplitter splitter;
	private String name;
	private boolean isPowerCaulation = false;	

	protected abstract boolean processLastItemCondition(List<String> tempList);
	
	public List<String> processMinusExpression(String expression){
		List<String> tempList = new ArrayList<>();		
		if(expression.indexOf(CaculatorConstant.SUBSTRACT)==-1){
			tempList.add(expression);
			return tempList;
		}
		tempList = splitter.splitString(expression);
		recombList(tempList);
		
		return tempList;			
	}	
	
	protected void recombList(List<String> tempList){		
		if(CaculatorConstant.SUBSTRACT.equals(tempList.get(0))){			
			StringBuilder sb = new StringBuilder();
			String number = sb.append(tempList.get(0)).append(tempList.get(1)).toString();
			tempList.add(0, number);
			tempList.remove(1);
			tempList.remove(1);
		}		
		processLastItem(tempList);
	}
	
	protected void processLastItem(List<String> tempList){		
		if(processLastItemCondition(tempList)){
			StringBuilder sb = new StringBuilder();
			String number = sb.append(tempList.get(tempList.size() - 2)).append(tempList.get(tempList.size() - 1)).toString();
			if(!isPowerCaulation){
				tempList.add(tempList.size() - 2, CaculatorConstant.ADD);
			}			
			tempList.add(tempList.size() - 2, number);
			tempList.remove(tempList.size() - 1);
			tempList.remove(tempList.size() - 1);
			LOGGER.debug("In the processLastItem the tempList is "+ CommonUtil.presentList(tempList));
		}		
	}

	public AbstractSplitter getSplitter() {
		return splitter;
	}

	public void setSplitter(AbstractSplitter splitter) {
		this.splitter = splitter;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPowerCaulation() {
		return isPowerCaulation;
	}

	public void setPowerCaulation(boolean isPowerCaulation) {
		this.isPowerCaulation = isPowerCaulation;
	}
	
}
