package com.citi.java8.collector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import org.apache.log4j.Logger;

/**
* <p>className: ToListCollector</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月23日
*/
public class ToListCollector<T> implements  Collector<T, List<T>, List<T>> {
	static Logger logger = Logger.getLogger(ToListCollector.class);
	
	private void log(final String log){
        logger.info(Thread.currentThread().getName() + "-" + log);
    }
	
	@Override
	public Supplier<List<T>> supplier() {
		log("supplier");
        return ArrayList::new;
	}

	@Override
	public BiConsumer<List<T>, T> accumulator() {
		log("accumulator");
        return List::add;
	}

	@Override
	public BinaryOperator<List<T>> combiner() {
		log("combiner");
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
	}

	@Override
	public Function<List<T>, List<T>> finisher() {
		log("finisher");
        return t -> t;
	}

	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() {
		log("characteristics");
        return Collections.unmodifiableSet(
                EnumSet.of(Collector.Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT
                ));
	}

}
