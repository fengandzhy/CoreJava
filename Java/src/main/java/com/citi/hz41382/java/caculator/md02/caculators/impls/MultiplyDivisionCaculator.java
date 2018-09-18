package com.citi.hz41382.java.caculator.md02.caculators.impls;




import com.citi.hz41382.java.caculator.md02.caculators.AbstractBinaryCaculator;
import com.citi.hz41382.java.caculator.md02.common.CaculatorConstant;
import com.citi.hz41382.java.caculator.md02.processor.AbstractMinusOprProcessor;
import com.citi.hz41382.java.caculator.md02.processor.impl.MinusOprProcessor1;
import com.citi.hz41382.java.caculator.md02.splits.AbstractSplitter;
import com.citi.hz41382.java.caculator.md02.splits.impl.BinaryOpsSplitter;
import com.citi.hz41382.java.caculator.md02.splits.impl.MinusOpSplitter;


public class MultiplyDivisionCaculator extends AbstractBinaryCaculator {
	
	public MultiplyDivisionCaculator(String name){
		super(name);		
	}	
		
	@Override
	protected boolean judgementLogic(String item) {
		if(item.equals(CaculatorConstant.MULTIPLY) || item.equals(CaculatorConstant.DIVISION) || item.equals(CaculatorConstant.MODUEL)){
			return true;
		}
		return false;
	}
	
	
	
	public static void main(String args[]){
		AbstractSplitter splitter = new BinaryOpsSplitter("binary");
		AbstractSplitter splitter1 = new MinusOpSplitter("minus");
		AbstractMinusOprProcessor processor = new MinusOprProcessor1();
		processor.setSplitter(splitter1);
		MultiplyDivisionCaculator caculator = new MultiplyDivisionCaculator("b");
		caculator.setProcessor(processor);
		caculator.setSplitter(splitter);
		String str = "6/0";
//		String str = "3%2-6/2+3";
		System.out.println(caculator.caculate(str));		
	}

	

	
}
