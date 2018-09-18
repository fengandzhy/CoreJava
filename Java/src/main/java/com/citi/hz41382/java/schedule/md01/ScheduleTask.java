package com.citi.hz41382.java.schedule.md01;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScheduleTask {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleTask.class);
	private final static long JOB_INTERNAL = 1000 * (long)60 * (long)60;
	public static void main(String[] args) {
		Timer timer = new Timer();
		 
		Calendar currentTime = Calendar.getInstance();
		currentTime.setTime(new Date());
 
		int currentHour = currentTime.get(Calendar.HOUR);
 
		currentTime.set(Calendar.HOUR, currentHour+1);
		currentTime.set(Calendar.MINUTE, 0);
		currentTime.set(Calendar.SECOND, 0);
		currentTime.set(Calendar.MILLISECOND, 0);
 
		 
		Date nextHour = currentTime.getTime();
		LOGGER.info(nextHour.toString());
 
		//NextHour 是指下个运行的时间点
		timer.scheduleAtFixedRate(new MyTask(), nextHour, JOB_INTERNAL);

	}
	
	private ScheduleTask(){
		
	}

}
