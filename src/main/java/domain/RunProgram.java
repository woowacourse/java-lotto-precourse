package domain;

import java.util.HashMap;
import java.util.List;

public class RunProgram {
	public static void main(String[] args) {
	    LottoGame lg = new LottoGame();
	    List<Rank> rank = lg.getRankResult(lg.makeWinningLotto(), lg.makeLotto());
	    HashMap<Integer, Integer> result = lg.initHashMap();
	    result = lg.setRankInResultMap(rank, result);
	    lg.printNotice();
	    lg.printResult(lg.makeIterator(result));
	    lg.printProfitRate(lg.makeIterator(result), result);
	}
}
