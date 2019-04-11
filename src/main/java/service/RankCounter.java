package service;

import java.util.List;

import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;

public class RankCounter {
	
	Rank[] rank = Rank.values();
	int[] rankCount = new int[rank.length];
	
	public RankCounter(WinningLotto winningLotto, LottoGenerator lottoGenerator) {
		List<Lotto> soldLottos = lottoGenerator.getSoldLottos();
		for(int i = 0; i < soldLottos.size(); i++) {
			setRankCount(winningLotto.match(soldLottos.get(i)));
		}
	}
	
	public void setRankCount(Rank userRank) {
		System.out.println(userRank);
		for(int i = rank.length - 1; i >= 0 ; i--) {
			if( rank[i].equals(userRank) ) {
				rankCount[i]++;
				return;
			}
		}
	}

	public void calResult() {
		int sum = 0;
		for(int i = 1; i < rank.length; i++) {
			sum += (rankCount[i] * rank[i].getWinningMoney());
		}
	}

}
