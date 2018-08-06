package com.citi.hz41382.java.event.md02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleListener implements ActionListener{

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleListener.class);
	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonName = e.getActionCommand();  
		if("button1".equals(buttonName)){
			LOGGER.info("button1 was clicked");
		}		
	}	
}
