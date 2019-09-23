package org.zhouhy.hz41382.java.caculator.md02.caculators.impls;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhouhy.hz41382.java.caculator.md02.caculators.AbstractBinaryCaculator;
import org.zhouhy.hz41382.java.caculator.md02.common.CaculatorConstant;
import org.zhouhy.hz41382.java.caculator.md02.common.CommonUtil;
import org.zhouhy.hz41382.java.caculator.md02.processor.AbstractMinusOprProcessor;
import org.zhouhy.hz41382.java.caculator.md02.processor.impl.MinusOprProcessor1;
import org.zhouhy.hz41382.java.caculator.md02.splits.AbstractSplitter;
import org.zhouhy.hz41382.java.caculator.md02.splits.impl.BinaryOpsSplitter;
import org.zhouhy.hz41382.java.caculator.md02.splits.impl.MinusOpSplitter;


public class AddSubstractCaculator extends AbstractBinaryCaculator {
	private static final Logger LOGGER = LoggerFactory.getLogger(AddSubstractCaculator.class);

	public AddSubstractCaculator(String name) {
		super(name);
	}
	
	@Override
	protected String getResult(List<String> processList) {
		LOGGER.debug("In the getResult is the processList is "+ CommonUtil.presentList(processList));
		String result = CommonUtil.spliceString(processList);
		while(result.indexOf(CaculatorConstant.ADD)!=-1){
			result = this.caculate(result);
		}
		return result;
	}

	@Override
	protected boolean judgementLogic(String item) {
		if(item.equals(CaculatorConstant.ADD)){
			return true;
		}
		return false;
	}

	public static void main(String args[]){
		AbstractSplitter splitter = new BinaryOpsSplitter("binary");
		AbstractSplitter splitter1 = new MinusOpSplitter("minus");
		AbstractMinusOprProcessor processor = new MinusOprProcessor1();
		processor.setSplitter(splitter1);
		AbstractBinaryCaculator caculator = new AddSubstractCaculator("add");
		caculator.setProcessor(processor);
		caculator.setSplitter(splitter);
		
		String inputStr = "1-2-1-3+3";
		System.out.println(caculator.caculate(inputStr));
	}
}
