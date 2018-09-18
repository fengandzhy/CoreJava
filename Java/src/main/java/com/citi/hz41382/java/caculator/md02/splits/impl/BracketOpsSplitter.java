package com.citi.hz41382.java.caculator.md02.splits.impl;

import com.citi.hz41382.java.caculator.md02.common.CaculatorConstant;
import com.citi.hz41382.java.caculator.md02.common.CommonUtil;
import com.citi.hz41382.java.caculator.md02.splits.AbstractSplitter;

public class BracketOpsSplitter extends AbstractSplitter {

	public BracketOpsSplitter(String name) {
		super(name);		
	}

	@Override
	protected boolean splitLogic(String item) {
		if(CaculatorConstant.LEFT_BRACKET.equals(item) || CaculatorConstant.RIGHT_BRACKET.equals(item)){
			return true;
		}
		return false;
	}
	
	public static void main(String args[]){
		String str = "((9))";
		AbstractSplitter splitter = new BracketOpsSplitter("bac");		
		System.out.println(CommonUtil.presentList(splitter.splitString(str)));
		System.out.println(splitter.splitString(str).size());
	}

}
