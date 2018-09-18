package com.citi.hz41382.java.caculator.md02.validator;

import com.citi.hz41382.java.caculator.md02.common.Recorder;

public abstract class AbstractValidator{
	
	protected String name;
	protected String buttonName;
	protected Recorder recorder;
	
	public abstract boolean validate();

	public Recorder getRecorder() {
		return recorder;
	}

	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}
	
}
