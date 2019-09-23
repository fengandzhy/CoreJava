package org.zhouhy.java8.collector;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
* <p>className: MySetCollector</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年5月5日
*/
public class MySetCollector<T> implements Collector<T, Set<T>, Set<T>>{

	@Override
    public Supplier<Set<T>> supplier() {
        System.out.println("MySetCollector supplier invoked");
        return HashSet<T>::new;
    }
 
    //累加器：添加一个元素到容器
    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("MySetCollector accumulator invoked");
        //return HashSet<T>::add;//这里不能给一个具体的Set，因为supplier方法可能返回的是TreeSet，不一定是HashSet
 
        return Set<T>::add;
    }
 
    //把并行流多个结果合并
    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("MySetCollector combiner invoked");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }
 
    //完成器：合并完返回最终结果
    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("MySetCollector finisher invoked");
        //return t -> t;
        return Function.identity();//与上面那个等价
 
        //throw new UnsupportedOperationException();
    }
 
    //返回一个集合，标识这个集合的诸多特性
 
    /**
     * Characteristics有3个值：
     * CONCURRENT：表示可以并行收集
     * UNORDERED：元素不保证顺序的
     * IDENTITY_FINISH：表示会执行一个强制类型转换,会调用finisher()方法
     */
    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("MySetCollector characteristics invoked");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED));
    }
}
