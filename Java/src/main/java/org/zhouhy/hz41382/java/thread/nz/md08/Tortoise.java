package org.zhouhy.hz41382.java.thread.nz.md08;

import javax.swing.JTextArea;

/**
* <p>className: Tortoise</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class Tortoise implements Runnable {
	
	private JTextArea tortoiseTextArea;
	
	public Tortoise(JTextArea tortoiseTextArea){
		this.tortoiseTextArea = tortoiseTextArea;
	}	
	
	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {
            String text = tortoiseTextArea.getText();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tortoiseTextArea.setText(text + "乌龟跑了" + i + "0米\n");
            if (i == 10) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tortoiseTextArea.setText(text + "乌龟到达终点\n");
            }
        }
	}
}
