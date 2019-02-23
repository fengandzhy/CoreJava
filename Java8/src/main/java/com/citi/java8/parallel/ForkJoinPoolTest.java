package com.citi.java8.parallel;

import java.util.concurrent.ForkJoinPool;

/**
* <p>className: ForkJoinPoolTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月23日
*/
public class ForkJoinPoolTest {

	public static void main(String[] args) {
		int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		AccumulatorRecursiveTask task = new AccumulatorRecursiveTask(0, data.length, data);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer result = forkJoinPool.invoke(task);
        System.out.println("AccumulatorRecursiveTask >>" + result);
        
        AccumulatorRecursiveAction action = new AccumulatorRecursiveAction(0, data.length, data);
        forkJoinPool.invoke(action);
        System.out.println("AccumulatorRecursiveAction >>" + AccumulatorRecursiveAction.AccumulatorHelper.getResult());
	}
	
	private static int calc(int[] data) {
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            result += data[i];
        }
        return result;
    }

}
