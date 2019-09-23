package org.zhouhy.hz41382.java.reflection.md04;

import java.awt.Component;
import java.awt.Container;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
* <p>className: ClassComparatorTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class ClassComparatorTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassComparatorTest.class);
	private ClassComparatorTest() {
		//empty
	}
	
	@Test
	public static void main(String[] args) {
		TreeSet<Class<?>> treeSet = new TreeSet<Class<?>>(new ClassComparator());
        LOGGER.info("向树集中添加JPanel.class");
        treeSet.add(JPanel.class);// 向树集中添加JPanel.class
        LOGGER.info("向树集中添加JComponent.class");
        treeSet.add(JComponent.class);// 向树集中添加JComponent.class
        LOGGER.info("向树集中添加Container.class");
        treeSet.add(Container.class);// 向树集中添加Container.class
        LOGGER.info("向树集中添加Component.class");
        treeSet.add(Component.class);
        printSet(treeSet);
	}
	
	public static void printSet(Set<Class<?>> set){
		if(null!=set){
			Iterator<Class<?>> iterator = set.iterator();
			while (iterator.hasNext()) {
				Class<?> clazz = iterator.next();
				LOGGER.info(clazz.getName());
			}
		}		
	}
}
