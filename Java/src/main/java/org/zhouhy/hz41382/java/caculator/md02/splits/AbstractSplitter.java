package org.zhouhy.hz41382.java.caculator.md02.splits;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhouhy.hz41382.java.caculator.md02.common.CommonUtil;

public abstract class AbstractSplitter {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSplitter.class);
	private String name;	
	
	public AbstractSplitter(String name){
		this.name = name;
	}
	
	public List<String> splitString(String inputStr) {
		List<String> strList = new ArrayList<>();
		int beginIndex = 0;
		String midValue =inputStr;
		for (int i = 0; i < midValue.length(); i++) {
			String item = midValue.substring(i, i + 1);
			if (splitLogic(item)) {
				String str = midValue.substring(beginIndex, i);
				if(!"".equals(str)){
					strList.add(midValue.substring(beginIndex, i));
				}				
				strList.add(item);
				beginIndex = i + 1;
			}
		}
		String lastItem = midValue.substring(beginIndex, midValue.length());
		if(!"".equals(lastItem)){
			strList.add(midValue.substring(beginIndex, midValue.length()));
		}
		LOGGER.debug(this.name + "'s splitString:" + CommonUtil.presentList(strList));
		return strList;
	}
	
	
	
	protected abstract boolean splitLogic(String item);
}
