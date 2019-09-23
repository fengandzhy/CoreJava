package org.zhouhy.hz41382.java.comparator.md01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
* <p>className: CompatorTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class CompatorTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(CompatorTest.class);
	
	@Test
	public static void main(String[] args) {
		List<Player> footballTeam = new ArrayList<>();
	    Player player1 = new Player(59, "John", 20);
	    Player player2 = new Player(67, "Roger", 22);
	    Player player3 = new Player(45, "Steven", 24);
	    Player player4 = new Player(50, "Frank", 21);
	    footballTeam.add(player1);
	    footballTeam.add(player2);
	    footballTeam.add(player3);
	    footballTeam.add(player4);
	    LOGGER.info("Before Sorting Ranking: ");
	    printTeam(footballTeam);
	    Collections.sort(footballTeam,new PlayerRankingComparator());
	    LOGGER.info("After Sorting Ranking: ");
	    printTeam(footballTeam);
	    
	    LOGGER.info("Before Sorting Age: ");
	    printTeam(footballTeam);
	    Collections.sort(footballTeam,new PlayerAgeComparator());
	    LOGGER.info("After Sorting Age: ");
	    printTeam(footballTeam);
	}
	
	public static void printTeam(List<Player> footballTeam){
		if(null!=footballTeam){
			Iterator<Player> iterator = footballTeam.iterator();
			while (iterator.hasNext()) {
				Player player = iterator.next();
				 LOGGER.info("Ranking : " +player.getRanking()+",Name:"+player.getName()+",Age:"+player.getAge());
			}
		}		
	}
}
