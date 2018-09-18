package com.citi.hz41382.java.caculator.md02.factory;

import com.citi.hz41382.java.caculator.md02.caculators.AbstractCaculator;
import com.citi.hz41382.java.caculator.md02.caculators.impls.AddSubstractCaculator;
import com.citi.hz41382.java.caculator.md02.caculators.impls.BracketCaculator;
import com.citi.hz41382.java.caculator.md02.caculators.impls.FunctionsCaculator;
import com.citi.hz41382.java.caculator.md02.caculators.impls.MultiplyDivisionCaculator;
import com.citi.hz41382.java.caculator.md02.caculators.impls.PowerCaculator;
import com.citi.hz41382.java.caculator.md02.common.CaculatorConstant;
import com.citi.hz41382.java.caculator.md02.processor.AbstractMinusOprProcessor;
import com.citi.hz41382.java.caculator.md02.processor.impl.MinusOprProcessor1;
import com.citi.hz41382.java.caculator.md02.processor.impl.MinusOprProcessor2;
import com.citi.hz41382.java.caculator.md02.splits.AbstractSplitter;
import com.citi.hz41382.java.caculator.md02.splits.impl.BinaryOpsSplitter;
import com.citi.hz41382.java.caculator.md02.splits.impl.BracketOpsSplitter;
import com.citi.hz41382.java.caculator.md02.splits.impl.MinusOpSplitter;

public class CaculatorsFactory {
	
	private static AbstractSplitter binarysplitter;
	private static AbstractSplitter minussplitter;
	private static AbstractSplitter bracketsplitter;
	private static AbstractMinusOprProcessor processor1;
	private static AbstractMinusOprProcessor processor2;
	
	private CaculatorsFactory(){
		// empty
	}
	
	private static void initParameters(){
		if(null == binarysplitter){
			binarysplitter = new BinaryOpsSplitter(CaculatorConstant.BINARY);
		}
		if(null == minussplitter){
			minussplitter = new MinusOpSplitter(CaculatorConstant.MINUS);
		}
		if(null == bracketsplitter){
			bracketsplitter = new BracketOpsSplitter(CaculatorConstant.BRACKET);
		}
		if(null == processor1){
			processor1 = new MinusOprProcessor1();
		}
		if(null == processor2){
			processor2 = new MinusOprProcessor2();
		}
	}
	
	
	public static AbstractCaculator createAddSubstractCaculator(){
		initParameters();
		processor1.setSplitter(minussplitter);
		AbstractCaculator caculator = new AddSubstractCaculator(CaculatorConstant.ADDSUBSTRACT);
		caculator.setSplitter(binarysplitter);
		caculator.setProcessor(processor1);		
		return caculator;
	}
	
	public static AbstractCaculator createMultiplyDivisionCaculator(){
		initParameters();
		processor1.setSplitter(minussplitter);
		AbstractCaculator caculator = new MultiplyDivisionCaculator(CaculatorConstant.MULTIPLYDIVISION);
		caculator.setSplitter(binarysplitter);
		caculator.setProcessor(processor1);		
		return caculator;
	}
	
	public static AbstractCaculator createPowerCaculator(){
		initParameters();
		processor2.setSplitter(minussplitter);
		AbstractCaculator caculator = new PowerCaculator(CaculatorConstant.POWERCACULATION);
		processor2.setPowerCaulation(true);
		caculator.setSplitter(binarysplitter);
		caculator.setProcessor(processor2);		
		return caculator;
	}
	
	public static AbstractCaculator createFunctionsCaculator(){
		initParameters();
		processor2.setSplitter(minussplitter);
		AbstractCaculator caculator = new FunctionsCaculator(CaculatorConstant.FUNCTION);
		processor2.setPowerCaulation(true);
		caculator.setSplitter(binarysplitter);
		caculator.setProcessor(processor1);		
		return caculator;
	}
	
	public static AbstractCaculator createBracketCaculator(){
		initParameters();
		processor2.setSplitter(minussplitter);
		AbstractCaculator caculator = new BracketCaculator(CaculatorConstant.BRACKET);		
		caculator.setSplitter(bracketsplitter);
		caculator.setProcessor(processor1);		
		return caculator;
	}	
}
