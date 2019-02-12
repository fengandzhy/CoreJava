package com.citi.hz41382.java.thread.nz.md07;
/**
* <p>className: Worker</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class Worker implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
            System.out.println("《Java编程词典》第" + i + "次更新！");// 用户线程用来输出一些语句
        }		
	}

}
