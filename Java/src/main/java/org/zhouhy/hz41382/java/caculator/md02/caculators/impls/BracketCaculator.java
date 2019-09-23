package org.zhouhy.hz41382.java.caculator.md02.caculators.impls;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhouhy.hz41382.java.caculator.md02.caculators.AbstractCaculator;
import org.zhouhy.hz41382.java.caculator.md02.common.CaculatorConstant;
import org.zhouhy.hz41382.java.caculator.md02.common.CommonUtil;
import org.zhouhy.hz41382.java.caculator.md02.util.CaculatorUtil;

public class BracketCaculator extends AbstractCaculator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BracketCaculator.class);	
	private CaculatorUtil util;	

	public BracketCaculator(String name) {		
		super(name);
		util = CaculatorUtil.getCaculatorUtil();
	}
	
	@Override
	protected List<String> processCharList(List<String> processList) {		
		if(processList.size()<3){			
			LOGGER.info("There is no bracket in the expression");
			return processList;
		}		
		for(int i = 2;i<processList.size();i++){
			if(CaculatorConstant.LEFT_BRACKET.equals(processList.get(i-2))&& CaculatorConstant.RIGHT_BRACKET.equals(processList.get(i))){
				String expression = processList.get(i-1);
				String result = caculateExpression(expression);
				processList.add(i-2, result);
				processList.remove(i-1);
				processList.remove(i-1);
				processList.remove(i-1);
				break;
			}
		}
		return processList;
	}
	
	@Override
	protected String getResult(List<String> processList) {
		String result = CommonUtil.spliceString(processList);
		while(result.indexOf(CaculatorConstant.LEFT_BRACKET)!=-1){
			result = this.caculate(result);
		}
		return result;
	}
	
	private String caculateExpression(String expression){
		return this.util.caculate(expression);
	}		
}
