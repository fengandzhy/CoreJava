package com.citi.hz41382.java.event.md01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 事件监听类1
 * */
public class DoorListener1 implements DoorListener{

	private static final Logger LOGGER = LoggerFactory.getLogger(DoorListener1.class);
	@Override
	public void doorEvent(DoorEvent event) {
		 if(event.getDoorState()!=null&&"open".equals(event.getDoorState())){
			 LOGGER.info("door 1 is open");
		 }else{
			 LOGGER.info("door 1 is closed");
		 }		
	}
	
}
