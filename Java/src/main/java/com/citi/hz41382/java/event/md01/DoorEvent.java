package com.citi.hz41382.java.event.md01;

import java.util.EventObject;

/**
 * 事件类
 * @author hz41382
 * 2018-07-03
 * */
public class DoorEvent extends EventObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3491224521091519601L;
	private String doorState = "";
	
	public DoorEvent(Object source, String doorState) {
		super(source);
		this.doorState = doorState;
	}

	public String getDoorState() {
		return doorState;
	}

	public void setDoorState(String doorState) {
		this.doorState = doorState;
	}	
}
