package org.zhouhy.hz41382.java.caculator.md02.framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.zhouhy.hz41382.java.caculator.md02.common.CaculatorConstant;
import org.zhouhy.hz41382.java.caculator.md02.common.Recorder;
import org.zhouhy.hz41382.java.caculator.md02.emus.BinaryOperatorsEmu;
import org.zhouhy.hz41382.java.caculator.md02.emus.NumberEmu;
import org.zhouhy.hz41382.java.caculator.md02.emus.UnaryOperatorsEmu;
import org.zhouhy.hz41382.java.caculator.md02.factory.ListenersFactory;
import org.zhouhy.hz41382.java.caculator.md02.listener.AbstractListener;

public class CalFrame {
	
	private JFrame frame;	
    private JTextField textField;   
    private Recorder recorder;
    private Map<String,AbstractListener> keyboardMap;
    private List<String> keyboardList;
    public CalFrame (){
    	
    	recorder = new Recorder();  	
    	
    	frame = new JFrame();    	
    	frame.setTitle("按钮数组实现计算器界面 "); // 设置窗体的标题
    	frame.setBounds(100, 100, 280, 280); // 设置窗体的显示位置及大小
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体关闭按钮的动作为退出
    	
    	//添加上面text
    	JPanel mainPanel = new JPanel();
    	mainPanel.setLayout(new BorderLayout(10,1));
    	textField = new JTextField("0",10);
    	textField.setEditable(false);
    	textField.setHorizontalAlignment(SwingConstants.TRAILING);
    	textField.setPreferredSize(new Dimension(12, 40));    	
    	textField.setFont(new Font("微软雅黑",Font.BOLD,16));
    	mainPanel.add(textField,BorderLayout.NORTH);
    	
    	JPanel keyboardPanel = new JPanel();
    	keyboardPanel.setLayout(new GridLayout(6, 4, 2, 2));
    	this.initParameters();
    	
    	for(String buttonName:keyboardList ){    		
    		JButton button = new JButton(buttonName);
    		button.addActionListener(keyboardMap.get(buttonName));
    		keyboardPanel.add(button);
    	}
    	
    	JPanel keyboardPane2 = new JPanel();
    	keyboardPane2.setLayout(new GridLayout(1, 2, 2, 2));
    	JButton leftbracketbutton = new JButton(CaculatorConstant.LEFT_BRACKET);    	
    	JButton rightbracketbutton = new JButton(CaculatorConstant.RIGHT_BRACKET);
    	leftbracketbutton.addActionListener(keyboardMap.get(CaculatorConstant.LEFT_BRACKET));
    	rightbracketbutton.addActionListener(keyboardMap.get(CaculatorConstant.RIGHT_BRACKET));
    	keyboardPane2.add(leftbracketbutton);
    	keyboardPane2.add(rightbracketbutton);
    	mainPanel.add(keyboardPanel,BorderLayout.CENTER);
    	mainPanel.add(keyboardPane2,BorderLayout.SOUTH);
    	frame.getContentPane().add(mainPanel, BorderLayout.CENTER);   	
    }
    
    public void initParameters(){
    	this.keyboardList = new ArrayList<>();
    	keyboardList.add(NumberEmu.ONE.getOperator());
    	keyboardList.add(NumberEmu.TWO.getOperator());
    	keyboardList.add(NumberEmu.THREE.getOperator());
    	keyboardList.add(BinaryOperatorsEmu.ADD.getOperator());    	
    	keyboardList.add(NumberEmu.FOUR.getOperator());
    	keyboardList.add(NumberEmu.FIVE.getOperator());
    	keyboardList.add(NumberEmu.SIX.getOperator());
    	keyboardList.add(CaculatorConstant.SUBSTRACT);    	
    	keyboardList.add(NumberEmu.SEVEN.getOperator());
    	keyboardList.add(NumberEmu.EIGHT.getOperator());
    	keyboardList.add(NumberEmu.NINE.getOperator());
    	keyboardList.add(BinaryOperatorsEmu.MULTIPLY.getOperator());    	
    	keyboardList.add(NumberEmu.ZERO.getOperator());
    	keyboardList.add(CaculatorConstant.POINT);
    	keyboardList.add(CaculatorConstant.EQUALOPR);
    	keyboardList.add(CaculatorConstant.DIV);
    	
    	
    	
    	keyboardList.add(BinaryOperatorsEmu.POWER.getOperator());
    	keyboardList.add(BinaryOperatorsEmu.MODULE.getOperator());
    	keyboardList.add(UnaryOperatorsEmu.SIN.getOperator());
    	keyboardList.add(UnaryOperatorsEmu.COS.getOperator());
    	
    	keyboardList.add(UnaryOperatorsEmu.TAN.getOperator());
    	keyboardList.add(UnaryOperatorsEmu.CTG.getOperator());
    	keyboardList.add(CaculatorConstant.BACK);
    	keyboardList.add(CaculatorConstant.CLEAR);
    	

    	
    	AbstractListener numberListener = ListenersFactory.createNumberListener(recorder, textField);     	
    	AbstractListener minusListener = ListenersFactory.createMinusListener(recorder, textField);    	
    	AbstractListener equlasListener =ListenersFactory.createEqualListener(recorder, textField);    	
    	AbstractListener operatorListener = ListenersFactory.createOperatorListener(recorder, textField);    	
    	AbstractListener functionListener = ListenersFactory.createFunctionListener(recorder, textField);    	
    	AbstractListener otherListener = ListenersFactory.createOtherListener(recorder, textField);    	
    	AbstractListener pointListener = ListenersFactory.createPointListener(recorder, textField);    	
    	AbstractListener bracketListener = ListenersFactory.createBracketListener(recorder, textField);
    	
    	
    	this.keyboardMap = new HashMap<>();
    	keyboardMap.put(NumberEmu.ONE.getOperator(),numberListener);
    	keyboardMap.put(NumberEmu.TWO.getOperator(),numberListener);
    	keyboardMap.put(NumberEmu.THREE.getOperator(),numberListener);
    	keyboardMap.put(BinaryOperatorsEmu.ADD.getOperator(),operatorListener);
    	
    	keyboardMap.put(NumberEmu.FOUR.getOperator(),numberListener);
    	keyboardMap.put(NumberEmu.FIVE.getOperator(),numberListener);
    	keyboardMap.put(NumberEmu.SIX.getOperator(),numberListener);
    	keyboardMap.put(CaculatorConstant.SUBSTRACT,minusListener);
    	
    	keyboardMap.put(NumberEmu.SEVEN.getOperator(),numberListener);
    	keyboardMap.put(NumberEmu.EIGHT.getOperator(),numberListener);
    	keyboardMap.put(NumberEmu.NINE.getOperator(),numberListener);
    	keyboardMap.put(BinaryOperatorsEmu.MULTIPLY.getOperator(),operatorListener);
    	
    	keyboardMap.put(NumberEmu.ZERO.getOperator(),numberListener);
    	keyboardMap.put(CaculatorConstant.POINT,pointListener);
    	keyboardMap.put(CaculatorConstant.EQUALOPR,equlasListener);
    	keyboardMap.put(CaculatorConstant.DIV,operatorListener);
    	
    	keyboardMap.put(BinaryOperatorsEmu.POWER.getOperator(),operatorListener);
    	keyboardMap.put(BinaryOperatorsEmu.MODULE.getOperator(),operatorListener);
    	keyboardMap.put(UnaryOperatorsEmu.SIN.getOperator(),functionListener);
    	keyboardMap.put(UnaryOperatorsEmu.COS.getOperator(),functionListener);
    	
    	keyboardMap.put(UnaryOperatorsEmu.TAN.getOperator(),functionListener);
    	keyboardMap.put(UnaryOperatorsEmu.CTG.getOperator(),functionListener);
    	keyboardMap.put(CaculatorConstant.BACK,otherListener);
    	keyboardMap.put(CaculatorConstant.CLEAR,otherListener);
    	
    	keyboardMap.put(CaculatorConstant.LEFT_BRACKET,bracketListener);
    	keyboardMap.put(CaculatorConstant.RIGHT_BRACKET,bracketListener);
    }
    
    public void setVisible(boolean b){		
        frame.setVisible(b); 
	}    
    
	public static void main(String args[]){
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	CalFrame cframe = new CalFrame();
                	cframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
}
