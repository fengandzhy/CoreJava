package org.zhouhy.hz41382.java.thread.nz.md07;

import org.junit.Test;

/**
* <p>className: DaemonThreadTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class DaemonThreadTest {
	
	private DaemonThreadTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public static void main(String[] args) {
		Thread userThread = new Thread(new Worker()); // 创建用户线程
        Thread daemonThread = new Thread(new Timer()); // 创建守护线程
        daemonThread.setDaemon(true); // 设置守护线程
        userThread.start(); // 启动用户线程
        daemonThread.start(); // 启动守护线程
	}
}
