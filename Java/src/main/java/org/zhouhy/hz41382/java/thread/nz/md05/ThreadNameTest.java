package org.zhouhy.hz41382.java.thread.nz.md05;

import java.awt.EventQueue;

import javax.swing.UIManager;

import org.junit.Test;

/**
* <p>className: ThreadNameTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class ThreadNameTest {
	private ThreadNameTest(){
		
	}
	
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
                    ThreadNameFrame frame = new ThreadNameFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

	}
}
