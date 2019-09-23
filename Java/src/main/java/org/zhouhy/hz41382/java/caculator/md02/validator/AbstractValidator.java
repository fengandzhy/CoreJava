package org.zhouhy.hz41382.java.caculator.md02.validator;

import org.zhouhy.hz41382.java.caculator.md02.common.Recorder;

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
