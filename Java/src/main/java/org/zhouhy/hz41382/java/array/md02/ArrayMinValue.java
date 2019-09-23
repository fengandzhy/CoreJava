package org.zhouhy.hz41382.java.array.md02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.zhouhy.hz41382.java.common.StringUtils;

/**
 * @author zhouhy
 */

public class ArrayMinValue extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8270602956204327650L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JLabel label1;
	

	public ArrayMinValue() {
		setTitle("\u83B7\u53D6\u4E00\u7EF4\u6570\u7EC4\u6700\u5C0F\u503C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 149);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(6, 36, 414, 30);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton button = new JButton("\u8BA1\u7B97");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doButtonActionPerformed();
			}
		});
		button.setBounds(16, 76, 90, 30);
		contentPane.add(button);

		label = new JLabel("\u6700\u5C0F\u503C\uFF1A");
		label.setBounds(116, 82, 304, 18);
		contentPane.add(label);

		label1 = new JLabel(
				"\u8BF7\u5728\u6587\u672C\u6846\u4E2D\u8F93\u5165\u591A\u4E2A\u6574\u6570\uFF0C\u4EE5\u7A7A\u683C\u4E3A\u5206\u9694\u7B26\u3002\u4F8B\u5982\uFF1A3 5 2 562 125");
		label1.setBounds(6, 6, 422, 18);
		contentPane.add(label1);

	}

	protected void doButtonActionPerformed() {
		String arrayStr = textField.getText().trim();
		for (int i = 0; i < arrayStr.length(); i++) {// 过滤非法输入
			char charAt = arrayStr.charAt(i);
			if (!Character.isDigit(charAt) && charAt != ' ') {
				JOptionPane.showMessageDialog(null, "输入包含非数字内容");
				textField.setText("");
				return;
			}
		}
		if(StringUtils.isBlank(arrayStr)){
			label.setText("空的输入");
			return;
		}
		String[] numStrs = arrayStr.split(" {1,}");// 分割字符串将一个或多个空格分隔开		
		int[] numArray = new int[numStrs.length];// 创建整数数组
		// 转换输入为整数数组
		for (int i = 0; i < numArray.length; i++) {
			numArray[i] = Integer.valueOf(numStrs[i]);
		}
		int min = numArray[0];// 创建最小数变量
		for (int j = 0; j < numArray.length; j++) {
			if (min > numArray[j]) {// 提取最小整数
				min = numArray[j];
			}
		}
		label.setText("数组中最小的数是：" + min);
	}

}
