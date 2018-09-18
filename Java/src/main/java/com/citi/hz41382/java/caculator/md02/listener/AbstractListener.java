package com.citi.hz41382.java.caculator.md02.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import com.citi.hz41382.java.caculator.md02.common.CommonUtil;
import com.citi.hz41382.java.caculator.md02.common.Recorder;
import com.citi.hz41382.java.caculator.md02.splits.AbstractSplitter;

public abstract class AbstractListener implements ActionListener{
	
	protected String name;	
	protected JTextField textField;
	protected Recorder recorder;
	protected StringBuilder builder;
	protected AbstractSplitter splitter;
	
	public AbstractListener(String name){
		this.name = name;		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		String buttonName = e.getActionCommand();
		if(validate()){
			recorder.push(buttonName);
		}
		setTextContent();
	}
	
	public abstract boolean validate();	 
	
	protected void setTextContent(){
		if(!recorder.isEmpty()){
			textField.setText(CommonUtil.spliceString(recorder.getList()));
		}	
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}	

	public void setSplitter(AbstractSplitter splitter) {
		this.splitter = splitter;
	}

	public void setBuilder(StringBuilder builder) {
		this.builder = builder;
	}	
}
