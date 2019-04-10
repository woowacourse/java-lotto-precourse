package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoGame {
	static private final int FIRST = 2000000000;
	static private final int SECOND = 30000000;
	static private final int THIRD = 1500000;
	static private final int FOURTH = 50000;
	static private final int FIFTH = 5000;
	static private final int LOTTO_PRICE = 1000;
	
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
    	
    	WinningLotto winLottoWithBonus = new WinningLotto(winLotto, winLottoGenerator.makeBonusNumber(winningNumber));
    	
    	return winLottoWithBonus;
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
		
		for(int i = 3; i < 8; i++) {
			String printResult = "";
			j = (i >= 6) ? i-1 : i;
			printResult += ((j == 6) ? j + "개 일치," : j + "개 일치, 보너스 볼 일치");
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