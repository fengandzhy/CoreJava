package com.citi.hz41382.java.caculator.md02.caculators.impls;

import com.citi.hz41382.java.caculator.md02.caculators.AbstractBinaryCaculator;
import com.citi.hz41382.java.caculator.md02.common.CaculatorConstant;
import com.citi.hz41382.java.caculator.md02.processor.AbstractMinusOprProcessor;
import com.citi.hz41382.java.caculator.md02.processor.impl.MinusOprProcessor2;
import com.citi.hz41382.java.caculator.md02.splits.AbstractSplitter;
import com.citi.hz41382.java.caculator.md02.splits.impl.BinaryOpsSplitter;
import com.citi.hz41382.java.caculator.md02.splits.impl.MinusOpSplitter;

public class PowerCaculator extends AbstractBinaryCaculator{	
	
	public PowerCaculator(String name) {
		super(name);		
	}

	@Override
	protected boolean judgementLogic(String item) {
		if(item.equals(CaculatorConstant.POWER)){
			return true;
		}
		return false;		
	}

	public static void main(String args[]){
		AbstractSplitter splitter = new BinaryOpsSplitter("binary");
		AbstractSplitter splitter1 = new MinusOpSplitter("minus");
		AbstractMinusOprProcessor processor = new MinusOprProcessor2();
		processor.setPowerCaulation(true);
		processor.setSplitter(splitter1);
		PowerCaculator caculator = new PowerCaculator("abc");
		caculator.setProcessor(processor);
		caculator.setSplitter(splitter);
		
//		String str = "-2+2--2^2+-2^-2-3*5*2--2*5+3%2+1-6/2";
		String str = "3-2^2";
		System.out.println(caculator.caculate(str));	
		//-2,+,2,-,4,+,-2,0.25,2,-
		//-2,+,2,-,4,+,-2,0.25,2,-,3,
	}
}
