package com.citi.hz41382.java.thread.nz.md02;

import java.awt.EventQueue;
import javax.swing.UIManager;
import org.junit.Test;

/**
* <p>className: ThreadTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class ThreadTest{
	
	private ThreadTest(){
		
	}
	
	@Test
	public static void main(String args[]){
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ThreadFrame frame = new ThreadFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
}
