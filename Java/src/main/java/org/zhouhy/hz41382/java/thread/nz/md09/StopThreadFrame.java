package org.zhouhy.hz41382.java.thread.nz.md09;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
* <p>className: StopThreadFrame</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class StopThreadFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8310639405682447811L;
	private JPanel contentPane;
    private JLabel lbljava;
    private CounterThread counter;
    
    public StopThreadFrame(){
    	setTitle("\u7EC8\u6B62\u6307\u5B9A\u7EBF\u7A0B");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(2, 1, 5, 5));
        
        JPanel panel1 = new JPanel();
        panel.add(panel1);
        
        lbljava = new JLabel("\u300AJava\u7F16\u7A0B\u8BCD\u5178\u300B");
        lbljava.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel1.add(lbljava);
        
        JPanel panel2 = new JPanel();
        panel.add(panel2);
        
        JButton button1 = new JButton("\u5F00\u59CB");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	button1Action(e);
            }
        });
        button1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel2.add(button1);
        
        JButton button2 = new JButton("\u7ED3\u675F");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	button2Action(e);
            }
        });
        button2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel2.add(button2);
    }
    
    protected void button1Action(ActionEvent e) {
        counter = new CounterThread(lbljava);
        new Thread(counter).start();
    }
    
    protected void button2Action(ActionEvent e) {
        if (counter == null) {
            JOptionPane.showMessageDialog(this, "先运行线程", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        counter.setStopped(false);
    }

}
