package com.citi.hz41382.java.model.creator.demo01.director;

import org.apache.log4j.Logger;

import com.citi.hz41382.java.model.creator.demo01.IBuilder;
import com.citi.hz41382.java.model.creator.demo01.Ipart;
import com.citi.hz41382.java.model.creator.demo01.builder.CpuBuilder;
import com.citi.hz41382.java.model.creator.demo01.builder.HardDiskBuilder;
import com.citi.hz41382.java.model.creator.demo01.builder.MainBoardBuilder;
import com.citi.hz41382.java.model.creator.demo01.parts.Cpu;
import com.citi.hz41382.java.model.creator.demo01.parts.HardDisk;
import com.citi.hz41382.java.model.creator.demo01.parts.MainBoard;
import com.citi.hz41382.java.model.creator.demo01.product.Computer;

public class Director {
	private static Logger logger = Logger.getLogger(Director.class);
	
	public Computer constructComputer(){
		Computer computer = new Computer();
		IBuilder builder = new CpuBuilder();
		Ipart cpu = builder.buildPart();
		computer.setCpu((Cpu)cpu);
		
		builder = new MainBoardBuilder();
		Ipart mainBoard = builder.buildPart();
		computer.setMainBoard((MainBoard)mainBoard);
		
		builder = new HardDiskBuilder();
		Ipart hardDisk = builder.buildPart();
		computer.setHardDisk((HardDisk)hardDisk);
		
		logger.info("Computer has been installed completely");
		
		return computer;
	}
}
