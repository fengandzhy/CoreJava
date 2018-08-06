package com.citi.hz41382.java.event.md01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 事件监听类2
 * */
public class DoorListener2 implements DoorListener{

	private static final Logger LOGGER = LoggerFactory.getLogger(DoorListener2.class);
	@Override
	public void doorEvent(DoorEvent event) {
		 if(event.getDoorState()!=null&&"open".equals(event.getDoorState())){
			 LOGGER.info("door 2 is open"); 
		 }else{
			 LOGGER.info("door 2 is closed");
		 }
		
	}

}
