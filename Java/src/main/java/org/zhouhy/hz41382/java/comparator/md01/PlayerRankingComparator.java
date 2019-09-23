package org.zhouhy.hz41382.java.comparator.md01;

import java.util.Comparator;

/**
* <p>className: PlayerRankingComparator</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月30日
*/
public class PlayerRankingComparator implements Comparator<Player> {

	@Override
	public int compare(Player player1, Player player2) {		
		return player1.getRanking() - player2.getRanking();
	}

}
