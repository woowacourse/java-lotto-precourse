package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	
	LottoGenerator lottoGenerator = new LottoGenerator();
	WinningLottoGenerator winLottoGenerator = new WinningLottoGenerator();
	

    private List<Lotto> makeLotto() {
    	ArrayList<Lotto> lottos = lottoGenerator.makeLotto();
    	
    	for (int i = 0; i < lottos.size(); i++) {
    		System.out.println(lottos.get(i).toString());
    	}
    	
    	return lottos;
    }
    
    private WinningLotto makeWinningLotto() {
        List<Integer> winningNumber = winLottoGenerator.makeWinningNumber();

    	Lotto winLotto = new Lotto(winningNumber);
    	
    	WinningLotto winLottoWithBonus = new WinningLotto(winLotto, winLottoGenerator.makeBonusNumber(winningNumber));
    	
    	return winLottoWithBonus;
    }
    
    private List<Rank> getRankResult(WinningLotto winningLotto, List<Lotto> userLotto) {
        List<Rank> rank = new ArrayList<Rank>();

		for (Lotto lotto : userLotto) {
			rank.add(winningLotto.match(lotto));
		}
		
		return rank;
    }
	
}