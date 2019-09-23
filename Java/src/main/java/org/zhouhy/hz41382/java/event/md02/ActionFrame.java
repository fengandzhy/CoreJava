package org.zhouhy.hz41382.java.event.md02;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionFrame {
	private static JFrame frame; // 定义为静态变量以便main使用
	private static JPanel myPanel; // 该面板用来放置按钮组件
	private JButton button1; // 这里定义按钮组件
	
	public ActionFrame() { 
		frame = new JFrame("Simple1"); // 新建JFrame		
        myPanel = new JPanel();  
        // 新建按钮  
        button1 = new JButton("button1"); // 新建按钮1         
        SimpleListener ourListener = new SimpleListener(); //建立listener 
        button1.addActionListener(ourListener);  
        myPanel.add(button1); // 添加按钮到面板  
        frame.getContentPane().add(myPanel);       
	}
	
	public void setVisible(boolean b){
		frame.pack();  
        frame.setVisible(b); 
	}
}
