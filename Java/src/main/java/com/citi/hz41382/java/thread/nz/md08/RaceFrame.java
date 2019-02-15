package com.citi.hz41382.java.thread.nz.md08;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
* <p>className: RaceFrame</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class RaceFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2872082282219558706L;
	private JPanel contentPane;
    private JTextArea rabbitTextArea;
    private JTextArea tortoiseTextArea;
    
    public RaceFrame(){
    	setTitle("\u4F11\u7720\u5F53\u524D\u7EBF\u7A0B");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        JButton button = new JButton("\u6BD4\u8D5B\u5F00\u59CB");
        button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	buttonAction(arg0);
            }
        });
        buttonPanel.add(button);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JPanel rabbitPanel = new JPanel();
        panel.add(rabbitPanel);
        rabbitPanel.setLayout(new BorderLayout(0, 0));
        
        JLabel rabbitLabel = new JLabel("\u5154\u5B50\u7684\u6BD4\u8D5B\u8BB0\u5F55");
        rabbitLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        rabbitLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rabbitPanel.add(rabbitLabel, BorderLayout.NORTH);
        
        JScrollPane rabbitScrollPane = new JScrollPane();
        rabbitPanel.add(rabbitScrollPane, BorderLayout.CENTER);
        
        rabbitTextArea = new JTextArea();
        rabbitTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        rabbitScrollPane.setViewportView(rabbitTextArea);
        
        JPanel tortoisePanel = new JPanel();
        panel.add(tortoisePanel);
        tortoisePanel.setLayout(new BorderLayout(0, 0));
        
        JLabel tortoiseLabel = new JLabel("\u4E4C\u9F9F\u7684\u6BD4\u8D5B\u8BB0\u5F55");
        tortoiseLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tortoiseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tortoisePanel.add(tortoiseLabel, BorderLayout.NORTH);
        
        JScrollPane tortoiseScrollPane = new JScrollPane();
        tortoisePanel.add(tortoiseScrollPane, BorderLayout.CENTER);
        
        tortoiseTextArea = new JTextArea();
        tortoiseTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        tortoiseScrollPane.setViewportView(tortoiseTextArea);
    }
    
    protected void buttonAction(ActionEvent arg0) {
        Runnable run1 = new Rabbit(rabbitTextArea);
        Runnable run2 = new Tortoise(tortoiseTextArea);
        Thread rabbit = new Thread(run1);
        Thread tortoise = new Thread(run2);
        rabbit.start();
        tortoise.start();
    }
	
}
