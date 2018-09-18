package com.citi.hz41382.java.caculator.md02.caculators;

import java.text.DecimalFormat;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citi.hz41382.java.caculator.md02.processor.AbstractMinusOprProcessor;
import com.citi.hz41382.java.caculator.md02.splits.AbstractSplitter;
public abstract class AbstractCaculator {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractBinaryCaculator.class);
	protected DecimalFormat format;
	protected String name;
	protected AbstractSplitter splitter;
	protected AbstractMinusOprProcessor processor;
	public AbstractCaculator(String name) {
		this.name = name;
		this.format = new DecimalFormat("####.###");
	}
	
	
	public String caculate(String inputStr) {
		LOGGER.info(this.name + "'s the inputStr is " + inputStr);
		List<String> inputCharList = splitter.splitString(inputStr);
		List<String> processList = processCharList(inputCharList);
		return getResult(processList);
	}
	
	protected abstract List<String> processCharList(List<String> processList);
	
	protected abstract String getResult(List<String> processList);
	
	public AbstractSplitter getSplitter() {
		return splitter;
	}

	public AbstractMinusOprProcessor getProcessor() {
		return processor;
	}

	public void setProcessor(AbstractMinusOprProcessor processor) {
		this.processor = processor;
	}

	public void setSplitter(AbstractSplitter splitter) {
		this.splitter = splitter;
	}
}
