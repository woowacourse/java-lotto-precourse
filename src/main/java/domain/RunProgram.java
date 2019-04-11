package domain;

import java.util.HashMap;
import java.util.List;

/**
 * @author soojin
 *
 * 프로그램을 실행하는 메인 클래스입니다.
 */
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
