package domain;

import java.util.HashMap;
import java.util.List;

public class RunProgram {
	public static void main(String[] args) {
	    LottoGame lg = new LottoGame();
	    List<Lotto> userLotto = lg.makeLotto();
	    WinningLotto winningLotto = lg.makeWinningLotto();
	    List<Rank> rank = lg.getRankResult(winningLotto, userLotto);
	    HashMap<Integer, Integer> result = lg.initHashMap();
	    result = lg.setRankInResultMap(rank, result);
	    lg.printNotice();
	    lg.printResult(lg.makeIterator(result));
	    lg.printProfitRate(lg.makeIterator(result), rank);
	}
}
