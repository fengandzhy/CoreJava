package com.citi.hz41382.java.event.md01;

import org.junit.Test;


/**
 * 测试类
 * */
public class DoorEventTest {

//	private static final Logger LOGGER = LoggerFactory.getLogger(DoorEventTest.class);
	@Test
	public static void main(String[] args) {
		DoorManager manager = new DoorManager();
        manager.addDoorListener(new DoorListener1());//给门1增加监听器
        manager.addDoorListener(new DoorListener2());//给门2增加监听器
        manager.fireWorkspaceOpened();
        manager.fireWorkspaceClosed();
	}

}
