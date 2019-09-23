package org.zhouhy.hz41382.java.thread.nz.md05;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
* <p>className: ThreadNameFrame</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class ThreadNameFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2073229039000463039L;
	private JPanel contentPane;
    private JTable table;
    private JTextField textField1;
    private JTextField textField2;
    
    public ThreadNameFrame(){
    	addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                windowPerformed(e);
            }
        });
        setTitle("\u67E5\u770B\u548C\u4FEE\u6539\u7EBF\u7A0B\u540D\u79F0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        textField1 = new JTextField();
        textField1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(textField1);
        textField1.setColumns(6);
        
        JButton button1 = new JButton("\u65B0\u5EFA\u7EBF\u7A0B");
        button1.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        button1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(button1);
        
        textField2 = new JTextField();
        textField2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(textField2);
        textField2.setColumns(6);
        
        JButton button2 = new JButton("\u4FEE\u6539\u540D\u79F0");
        button2.addActionListener(new ActionListener() {
            @Override
        	public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });
        
        button2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(button2);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        table.setRowHeight(30);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        header.setPreferredSize(new Dimension(header.getWidth(), 35));
        scrollPane.setViewportView(table);
    }
    
    protected void windowPerformed(WindowEvent e) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[] { "线程ID", "线程名称" });
        for (Thread thread : threads) {
            model.addRow(new Object[] { thread.getId(), thread.getName() });
        }
        table.setModel(model);
    }
    
    protected void button1ActionPerformed(ActionEvent e) {
        Object[] newThread = null;
        String name = textField1.getText();
        if (name.isEmpty()) {
            Thread thread = new Thread(new Forever());
            thread.start();
            newThread = new Object[] { thread.getId(), thread.getName() };
        } else {
            Thread thread = new Thread(new Forever(), name);
            thread.start();
            newThread = new Object[] { thread.getId(), name };
        }
        ((DefaultTableModel) table.getModel()).addRow(newThread);
    }
    
    protected void button2ActionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        String newName = textField2.getText();
        if ((selectedRow == -1) || newName.isEmpty()) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setValueAt(newName, selectedRow, 1);
        repaint();
    }  
   	
}
