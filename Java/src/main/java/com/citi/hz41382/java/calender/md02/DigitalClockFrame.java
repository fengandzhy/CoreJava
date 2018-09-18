package com.citi.hz41382.java.calender.md02;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DigitalClockFrame {
	private static JFrame frame; // 定义为静态变量以便main使用
	private static JPanel contentPane; // 该面板用来放置按钮组件
	private JLabel label;
	
	public DigitalClockFrame(){
		frame = new JFrame();
		frame.setTitle("\u6570\u5B57\u65F6\u949F");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 200, 100);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(new BorderLayout(0, 0));
	    
	    label = new JLabel("");
        label.setFont(new Font("微软雅黑", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label, BorderLayout.CENTER);
	    frame.setContentPane(contentPane);
	    
	    frame.addWindowListener(new WindowAdapter(){
	    	@Override
            public void windowActivated(WindowEvent event) {
	    		doWindowActivated();
            }
	    });
	}
	
	public void setVisible(boolean b){		
        frame.setVisible(b); 
	}
	
	protected void doWindowActivated() {
        new Thread(new ClockRunnable(label)).start();
    }
}
