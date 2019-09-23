package org.zhouhy.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import org.apache.log4j.Logger;

import static java.util.stream.Collectors.toList;

import java.time.Duration;
import java.time.ZoneId;
import java.util.ArrayList;


/**
* <p>className: StreamInAction</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月21日
*/
public class StreamInAction {
	static Logger logger = Logger.getLogger(StreamInAction.class);
	
	public static void main(String[] args) {
		
		
		
		Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
		
//        test1(transactions);
//        test2(transactions);
//        test3(transactions);
//        test4(transactions);
//        test5(transactions);
//        test6(transactions);
        test7(transactions);
//        test8(transactions);
	}
	
	//1. Find all transactions in the year 2011 and sort them by value (small to high).
	public static void test1(List<Transaction> transactions){
		Comparator<Transaction> comparator = (t1,t2)->{return t1.getValue()-t2.getValue();};
		List<Transaction> result = transactions.stream().filter(t->t.getYear()==2011)
		.sorted(comparator)
		.collect(toList());
		logger.info(result);
	}

	//2.What are all the unique cities where the traders work?
	public static void test2(List<Transaction> transactions){
		Function<Transaction, String> mapper = t -> t.getTrader().getCity();
		transactions.stream().map(mapper)
        .distinct().forEach(logger::info);
		
		
		
	}
	
	//3.Find all traders from Cambridge and sort them by name.
	public static void test3(List<Transaction> transactions){
		transactions.stream().filter(a->a.getTrader().getCity().equals("Cambridge"))
		.map(t->t.getTrader())
		.sorted(Comparator.comparing(Trader::getName)).distinct()
		.forEach(logger::info);
	}
	
	//4.Return a string of all traders’ names sorted alphabetically
	public static void test4(List<Transaction> transactions){
		String names = transactions.stream().map(t->t.getTrader())
		.sorted(Comparator.comparing(Trader::getName))
		.map(t->t.getName()).reduce("",(a,b)->a+b+","); //
		logger.info(names);		
	}
	
	//5. Are any traders based in Milan?
	public static void test5(List<Transaction> transactions){
		boolean liveInMilan = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		logger.info(liveInMilan);
	}	
	
	//6.Print all transactions’ values from the traders living in Cambridge.
	public static void test6(List<Transaction> transactions){
		transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge"))
		.map(t->t.getValue()).forEach(logger::info);
	}
	
	//7.What’s the highest value of all the transactions?
	public static void test7(List<Transaction> transactions){
		BinaryOperator<Integer> accumulator = (i,j)->Integer.max(i, j);
		Integer maxValue = transactions.stream().map(t->t.getValue()).reduce(accumulator).get();
		logger.info(maxValue);
	}
	
	//8.Find the transaction with the smallest value.
	public static void test8(List<Transaction> transactions){
		BinaryOperator<Integer> accumulator = (i,j)->Integer.min(i, j);
		Integer minValue = transactions.stream().map(t->t.getValue()).reduce(accumulator).get();
		logger.info(minValue);
	}
}
