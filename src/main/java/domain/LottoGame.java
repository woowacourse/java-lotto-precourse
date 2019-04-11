package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author soojin
 *
 * 로또 게임을 실행하는 클래스입니다.
 */
public class LottoGame {
	private static final int FIRST = 2000000000;
	private static final int SECOND = 30000000;
	private static final int THIRD = 1500000;
	private static final int FOURTH = 50000;
	private static final int FIFTH = 5000;
	private static final int LOTTO_PRICE = 1000;
	private static final int START_FROM_THIRD = 3;
	private static final int END_BY_EIGHT = 8;
	private static final int OVER_SECOND_RANK = 6;
	
	LottoGenerator lottoGenerator = new LottoGenerator();
	WinningLottoGenerator winLottoGenerator = new WinningLottoGenerator();
	
    public List<Lotto> makeLotto() {
    	ArrayList<Lotto> lottos = lottoGenerator.makeLotto();
    	
    	for (int i = 0; i < lottos.size(); i++) {
    		System.out.println(lottos.get(i).toString());
    	}
    	
    	return lottos;
    }
    
    public WinningLotto makeWinningLotto() {
        List<Integer> winningNumber = winLottoGenerator.makeWinningNumber();

    	Lotto winLotto = new Lotto(winningNumber);
    	
    	WinningLotto winningLottoWithBonusNum = new WinningLotto(winLotto, winLottoGenerator.makeBonusNumber(winningNumber));
    	
    	return winningLottoWithBonusNum;
    }
    
    public List<Rank> getRankResult(WinningLotto winningLotto, List<Lotto> userLotto) {
        List<Rank> rank = new ArrayList<Rank>();

		for (Lotto lotto : userLotto) {
			rank.add(winningLotto.match(lotto));
		}
		
		return rank;
    }
    
    public HashMap<Integer, Integer> initHashMap() {
  		LinkedHashMap<Integer, Integer> result = new LinkedHashMap<Integer, Integer>();
  		
  		result.put(0, 0);
  		result.put(FIFTH, 0);
  		result.put(FOURTH, 0);
  		result.put(THIRD, 0);
  		result.put(SECOND, 0);
  		result.put(FIRST, 0);
  		
  		return result;
      }
    
    public HashMap<Integer, Integer> setRankInResultMap(List<Rank> rank, HashMap<Integer, Integer> result) {
		int key = 0;
		int value = 0;
		
		for (int i = 0; i < rank.size(); i++) {
			key = rank.get(i).getWinningMoney();
			value = result.get(key) + 1;
			result.put(key, value);
		}
		
		return result;
	}
	
    public List<Iterator<Integer>> makeIterator(HashMap<Integer, Integer> result) {
		List<Iterator<Integer>> iterators = new ArrayList<Iterator<Integer>>();
		Iterator<Integer> valueIter = result.values().iterator();
		Iterator<Integer> keyIter = result.keySet().iterator();
		
		valueIter.next();
		keyIter.next();
		iterators.add(keyIter);
		iterators.add(valueIter);

		return iterators;
	}
	
    public void printNotice() {
		System.out.println("\n당첨 통계");
		System.out.println("---------");
	}
	
    public void printResult(List<Iterator<Integer>> iterators) {
		int j = 0;
		String printResult = "";
		
		for(int i = START_FROM_THIRD; i < END_BY_EIGHT; i++) {
			j = (i >= 6) ? i-1 : i;
			printResult += ((j == OVER_SECOND_RANK) ? j + "개 일치," : j + "개 일치, 보너스 볼 일치");
			printResult += " ("+ iterators.get(0).next() + "원 ) - " + iterators.get(1).next() + "개";
			System.out.println(printResult);
		}
	}

    public void printProfitRate(List<Iterator<Integer>> iterators, List<Rank> rank) {
		int totalIncome = 0;		
		int purchaseCost = rank.size() * LOTTO_PRICE;
		
		while (iterators.get(0).hasNext()) {
			totalIncome += iterators.get(0).next() * iterators.get(1).next();
		}
		
		double profitRate = (double) totalIncome / (double) purchaseCost ;

		System.out.println("총 수익률은 " + Math.round(profitRate * 1000) / 1000.0 + "입니다.");
	}
	
}