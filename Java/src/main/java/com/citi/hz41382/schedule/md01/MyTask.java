package com.citi.hz41382.schedule.md01;

import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("mytask： " + new Date());		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
