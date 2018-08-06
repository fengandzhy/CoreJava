package com.citi.hz41382.java.array.md02;

import java.awt.EventQueue;
import javax.swing.UIManager;


public class ArrayMinValueTest {

	public static void main(String[] args){
//		ArrayMinValue amvalue = new ArrayMinValue();
//		amvalue.setVisible(true);
		
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArrayMinValue frame = new ArrayMinValue();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
}
