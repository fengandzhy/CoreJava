package com.citi.hz41382.java.caculator.md02.util;


import com.citi.hz41382.java.caculator.md02.caculators.AbstractCaculator;
import com.citi.hz41382.java.caculator.md02.exceptions.ExpressionException;
import com.citi.hz41382.java.caculator.md02.factory.CaculatorsFactory;

public class CaculatorUtil {
	private static CaculatorUtil util;	
	private AbstractCaculator[] caculators;
	
	private CaculatorUtil(){
		//empty
	}
	
	public static CaculatorUtil getCaculatorUtil(){
		if(null == util){
			synchronized(CaculatorUtil.class){
				if(null == util){
					util = new CaculatorUtil();
				}
			}
		}
		return util;
	}
	
	
	public String caculate(String inputStr){		
		if(null == caculators || caculators.length!=5 ){
			initCaculators();
		}
		String result = inputStr;
		try {
			for (AbstractCaculator caculator : caculators) {
				result = caculator.caculate(result);
			} 
		} catch (ExpressionException e) {
			result = e.getErrMsg();
		}
		return result;
	}
	
	private void initCaculators(){
		this.caculators = new AbstractCaculator[5];		
		caculators[0] = CaculatorsFactory.createBracketCaculator();
		caculators[1] = CaculatorsFactory.createFunctionsCaculator();
		caculators[2] = CaculatorsFactory.createPowerCaculator();
		caculators[3] = CaculatorsFactory.createMultiplyDivisionCaculator();
		caculators[4] = CaculatorsFactory.createAddSubstractCaculator();
	}
	
}
