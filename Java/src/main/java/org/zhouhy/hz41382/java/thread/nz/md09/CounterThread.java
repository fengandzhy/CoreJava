package org.zhouhy.hz41382.java.thread.nz.md09;

import javax.swing.JLabel;

/**
* <p>className: CounterThread</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class CounterThread implements Runnable {
	
	private JLabel lbljava;
	private int count = 0;
    private boolean stopped = true;
    
    public CounterThread(JLabel lbljava){
    	this.lbljava=lbljava;
    }
    
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
	
	@Override
	public void run() {		
		while (stopped) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lbljava.setText("《Java编程词典》第" + (count++) + "次更新！");
        }
	}

}
