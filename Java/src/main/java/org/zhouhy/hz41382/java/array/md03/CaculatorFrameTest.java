package org.zhouhy.hz41382.java.array.md03;

import java.awt.EventQueue;

import javax.swing.UIManager;

import org.junit.Test;

import org.zhouhy.hz41382.java.calender.md02.DigitalClockFrame;

public class CaculatorFrameTest {

	@Test
	public static void main(String[] args) {
//		CaculatorFrame cframe = new CaculatorFrame();
//		cframe.setVisible(true);
		
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	CaculatorFrame cframe = new CaculatorFrame();
                	cframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}

}
