package com.citi.hz41382.java.model.creator.demo02.products;

import org.apache.log4j.Logger;

import com.citi.hz41382.java.model.creator.demo02.AutoMessage;

/**
* <p>className: GoodbyeMessage</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class GoodbyeMessage extends AutoMessage {
	private static Logger logger = Logger.getLogger(GoodbyeMessage.class);
	
	public GoodbyeMessage(){
        logger.info("发送欢送信息");
    }
}
