package org.zhouhy.hz41382.java.model.creator.demo01.director;

import org.apache.log4j.Logger;

import org.zhouhy.hz41382.java.model.creator.demo01.IBuilder;
import org.zhouhy.hz41382.java.model.creator.demo01.Ipart;
import org.zhouhy.hz41382.java.model.creator.demo01.builder.CpuBuilder;
import org.zhouhy.hz41382.java.model.creator.demo01.builder.HardDiskBuilder;
import org.zhouhy.hz41382.java.model.creator.demo01.builder.MainBoardBuilder;
import org.zhouhy.hz41382.java.model.creator.demo01.parts.Cpu;
import org.zhouhy.hz41382.java.model.creator.demo01.parts.HardDisk;
import org.zhouhy.hz41382.java.model.creator.demo01.parts.MainBoard;
import org.zhouhy.hz41382.java.model.creator.demo01.product.Computer;

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
