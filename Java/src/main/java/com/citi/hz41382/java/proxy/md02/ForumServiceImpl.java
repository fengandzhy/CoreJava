package com.citi.hz41382.java.proxy.md02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* <p>className: ForumServiceImpl</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月28日
*/
public class ForumServiceImpl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ForumServiceImpl.class);
	public void removeForum(int forumId) {
		LOGGER.info("delete forum "+forumId);
		try{
			Thread.currentThread();
			Thread.sleep(20);
		}catch(InterruptedException e){
			LOGGER.error(e.getMessage());
			
		}
	}

	public void removeTopic(int topicId) {
		LOGGER.info("delete topic "+topicId);
		try {
			Thread.currentThread();
			Thread.sleep(20);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage());			
		}
	}
}
