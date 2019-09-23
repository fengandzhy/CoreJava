package org.zhouhy.hz41382.java.event.md01;

import java.util.EventListener;

/**
 * 事件监听接口
 * @author hz41382
 * */
public interface DoorListener extends EventListener{
	public void doorEvent(DoorEvent event);
}
