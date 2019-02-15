package com.citi.hz41382.java.thread.nz.md02;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
* <p>className: ThreadFrame</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class ThreadFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8038505776786338423L;
	private JPanel contentPane;
    private JTextArea textArea1;
    private JTextArea textArea2;
    
	public ThreadFrame() {
		
		setTitle("\u65B0\u5EFA\u6CA1\u6709\u8FD4\u56DE\u503C\u7684\u7EBF\u7A0B");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
        buttonPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JButton button1 = new JButton("\u5355\u7EBF\u7A0B\u7A0B\u5E8F");
        button1.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	button1ActionPerformed(e);
            }
        });
        button1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        buttonPanel.add(button1);
        
        JButton button2 = new JButton("\u591A\u7EBF\u7A0B\u7A0B\u5E8F");
        button2.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	button2ActionPerformed(e);
            }
        });
        button2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        buttonPanel.add(button2);
        
        JPanel contentPanel = new JPanel();
        contentPane.add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(1, 2, 5, 5));
        
        JScrollPane scrollPane1 = new JScrollPane();
        contentPanel.add(scrollPane1);
        
        textArea1 = new JTextArea();
        textArea1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        scrollPane1.setViewportView(textArea1);
        
        JScrollPane scrollPane2 = new JScrollPane();
        contentPanel.add(scrollPane2);
        
        textArea2 = new JTextArea();
        textArea2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        scrollPane2.setViewportView(textArea2);
	}
	
	protected void button1ActionPerformed(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append("《Java编程词典》\n");            
        }
        for (int i = 0; i < 5; i++) {
            sb.append("《视频学Java》\n");
        }
        textArea1.setText(sb.toString());
	}
	
	/**
	 * 在一个线程A中开起另一个线程B，如果线程B要使用线程A的局部变量，那么A的局部变量需要定义成final。
	 * 理由：局部变量是线程内部共享的，每一个线程内的不能访问其他线程的局部变量，但是上诉的情况却违背了这一原则，那么加上final为什么就可以了呢？
	 * 原因是加上final之后，在创建B线程的时候会把final标记的变量作为线程B的构造方法的参数传给B，如此一来就解决了此问题，这是一个比较巧妙的做法，通过class文件反编译可以看出这个道理。
	 * */
	protected void button2ActionPerformed(ActionEvent e) {        
		final StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < 5; i++) {
	        new Thread() {
	            public void run() {
	                sb.append("《Java编程词典》\n");
	                textArea2.setText(sb.toString());
	            };
	        }.start();
	    }
	    for (int i = 0; i < 5; i++) {
	        new Thread() {
	            public void run() {
	                sb.append("《视频学Java》\n");
	                textArea2.setText(sb.toString());
	            };
	        }.start();
	    }
	    sb.setLength(0);//注意这里一定要清空StringBuilder
	    System.out.println("数据已经被清空");
	}
}
