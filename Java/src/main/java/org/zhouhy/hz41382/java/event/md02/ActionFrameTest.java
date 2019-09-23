package org.zhouhy.hz41382.java.event.md02;

import java.awt.EventQueue;

import javax.swing.UIManager;

import org.junit.Test;

public class ActionFrameTest {

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
                	ActionFrame frame = new ActionFrame();
                	frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}

}
