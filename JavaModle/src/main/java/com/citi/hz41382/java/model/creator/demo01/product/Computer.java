package com.citi.hz41382.java.model.creator.demo01.product;

import org.apache.log4j.Logger;

import com.citi.hz41382.java.model.creator.demo01.parts.Cpu;
import com.citi.hz41382.java.model.creator.demo01.parts.HardDisk;
import com.citi.hz41382.java.model.creator.demo01.parts.MainBoard;

/**
* <p>className: Computer</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class Computer {
	private static Logger logger = Logger.getLogger(Computer.class);
	private Cpu cpu;
	private MainBoard mainBoard;
	private HardDisk hardDisk;
	public Cpu getCpu() {
		return cpu;
	}
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
		logger.info("cpu has been installed!");
	}
	public MainBoard getMainBoard() {
		return mainBoard;
	}
	public void setMainBoard(MainBoard mainBoard) {
		this.mainBoard = mainBoard;
		logger.info("mainboard has been installed!");
	}
	public HardDisk getHardDisk() {
		return hardDisk;
	}
	public void setHardDisk(HardDisk hardDisk) {
		this.hardDisk = hardDisk;
		logger.info("hardDisk has been installed!");
	}	
}
