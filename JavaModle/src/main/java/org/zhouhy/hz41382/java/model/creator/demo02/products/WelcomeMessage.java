package org.zhouhy.hz41382.java.model.creator.demo02.products;

import org.apache.log4j.Logger;

import org.zhouhy.hz41382.java.model.creator.demo02.AutoMessage;

/**
* <p>className: WelcomeMessage</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class WelcomeMessage extends AutoMessage{	
	private static Logger logger = Logger.getLogger(WelcomeMessage.class);
	
	public WelcomeMessage(){
		logger.info("发送欢迎信息");
    }
}
