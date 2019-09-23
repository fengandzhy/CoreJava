package org.zhouhy.hz41382.java.calender.md02;

import java.awt.EventQueue;
import javax.swing.UIManager;
import org.junit.Test;



public class DigitalClockTest {

	@Test
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	DigitalClockFrame frame = new DigitalClockFrame();
                	frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
}
