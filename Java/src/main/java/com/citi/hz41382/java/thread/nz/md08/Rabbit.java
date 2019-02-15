package com.citi.hz41382.java.thread.nz.md08;

import javax.swing.JTextArea;

/**
* <p>className: Rabbit</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class Rabbit implements Runnable {
	
	private JTextArea rabbitTextArea;
	
	public Rabbit(JTextArea rabbitTextArea){
		this.rabbitTextArea = rabbitTextArea;
	}
	
	@Override
	public void run() {
		for (int i = 1; i < 11; i++) {// 循环10次模拟赛跑的过程
            String text = rabbitTextArea.getText();// 获得文本域中的信息
            try {
                Thread.sleep(1);// 线程休眠0.001秒，模拟兔子在跑步
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rabbitTextArea.setText(text + "兔子跑了" + i + "0米\n");// 显示兔子的跑步距离
            if (i == 9) {
                rabbitTextArea.setText(text + "兔子在睡觉\n");// 当跑了90米时开始睡觉
                try {
                    Thread.sleep(10000);// 线程休眠10秒，模拟兔子在睡觉
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (i == 10) {
                try {
                    Thread.sleep(1);// 线程休眠0.001秒，模拟兔子在跑步
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rabbitTextArea.setText(text + "兔子到达终点\n");// 显示兔子到达了终点
            }
        }
	}
}
