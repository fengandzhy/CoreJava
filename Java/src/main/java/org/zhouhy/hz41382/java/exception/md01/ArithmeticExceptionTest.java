package org.zhouhy.hz41382.java.exception.md01;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ArithmeticExceptionTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArithmeticExceptionTest.class);
	private ArithmeticExceptionTest(){}
	@Test
	public static void main(String[] args) {
		LOGGER.info("-1.0 / 0 = " + (-1.0 / 0));// 演示负浮点数除0
        LOGGER.info("+1.0 / 0 = " + (+1.0 / 0));// 演示正浮点数除0
        LOGGER.info("-1 / 0 = " + (-1 / 0)); //这里throw了一个excption，所以程序终止不继续进行下去	
        LOGGER.info("After Exception");
	}

}
