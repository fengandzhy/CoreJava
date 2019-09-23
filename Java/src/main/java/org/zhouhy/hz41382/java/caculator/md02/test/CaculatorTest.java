package org.zhouhy.hz41382.java.caculator.md02.test;

import java.awt.EventQueue;
import javax.swing.UIManager;
import org.junit.Test;

import org.zhouhy.hz41382.java.caculator.md02.common.CaculatorConstant;
import org.zhouhy.hz41382.java.caculator.md02.framework.CalFrame;
import org.zhouhy.hz41382.java.caculator.md02.util.CaculatorUtil;

public class CaculatorTest {

	public static void main(String[] args) {
		CaculatorUtil util = CaculatorUtil.getCaculatorUtil();
//		String inputStr = "3-2^2+3*2/4+(2-1-9*-1)+2-2^3+20";
//		String inputStr = "(((999)))";
//		System.out.println(util.caculate(inputStr));	
		initFrame();		
	}

	
	public static String caculate(String expression){
		System.out.println(expression);
		String inputStr = processDivisionOpr(expression);
		CaculatorUtil util = CaculatorUtil.getCaculatorUtil();
		return util.caculate(inputStr);
	}
	
	public static String processDivisionOpr(String expression){
		return expression.replaceAll(CaculatorConstant.DIV, CaculatorConstant.DIVISION);
	}
	
	public static void initFrame(){
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
