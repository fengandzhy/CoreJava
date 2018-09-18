package com.citi.hz41382.java.caculator.md02.splits.impl;

import java.util.List;

import com.citi.hz41382.java.caculator.md02.common.CaculatorConstant;
import com.citi.hz41382.java.caculator.md02.common.CommonUtil;
import com.citi.hz41382.java.caculator.md02.splits.AbstractSplitter;


public class MinusOpSplitter extends AbstractSplitter{

	public MinusOpSplitter(String name){
		super(name);
	}
	
	@Override
	protected boolean splitLogic(String item) {
		if(CaculatorConstant.SUBSTRACT.equals(item)){
			return true;
		}		
		return false;
	}
	
	public static void main(String args[]){
		MinusOpSplitter splitter = new MinusOpSplitter("minus");
		List<String> strList = splitter.splitString("2--2");
		System.out.println(CommonUtil.presentList(strList));
	}

}
