package com.citi.hz41382.java.model.creator.demo02.client;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.citi.hz41382.java.model.creator.demo02.AutoMessage;
import com.citi.hz41382.java.model.creator.demo02.builders.WelcomeBuilder;
import com.citi.hz41382.java.model.creator.demo02.director.Director;


/**
* <p>className: CreatorClient</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月19日
*/
public class CreatorClient {	
	private static Logger logger = Logger.getLogger(CreatorClient.class);
	private CreatorClient(){
		
	}
	@Test
	public static void main(String[] args) {
		Director director = new Director(new WelcomeBuilder());
		AutoMessage message = director.getMessage("toAddress@126.com", "fromAddress@126.com");
		logger.info(message);
	}

}
