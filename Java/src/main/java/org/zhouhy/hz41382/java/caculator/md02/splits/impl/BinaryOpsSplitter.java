package org.zhouhy.hz41382.java.caculator.md02.splits.impl;

import org.zhouhy.hz41382.java.caculator.md02.common.CommonUtil;
import org.zhouhy.hz41382.java.caculator.md02.emus.BinaryOperatorsEmu;
import org.zhouhy.hz41382.java.caculator.md02.splits.AbstractSplitter;

public class BinaryOpsSplitter extends AbstractSplitter {	
	
	
	
	public BinaryOpsSplitter(String name){
		super(name);
	}
	
	@Override
	protected boolean splitLogic(String item) {
		if(BinaryOperatorsEmu.isExists(item)){
			return true;
		}		
		return false;
	}
	
	public static void main(String args[]){
		String str = "3-2^2+3*2/4+(2-1-9*-1)+2-2^3+20+";
		AbstractSplitter splitter = new BinaryOpsSplitter("bac");		
		System.out.println(CommonUtil.presentList(splitter.splitString(str)));
		System.out.println(splitter.splitString(str).size());
	}

}
