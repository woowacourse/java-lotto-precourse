package domain;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * 당첨 통계와 수익률을 찾는 객체
 */
public class LottoGameManager {
	public static LinkedHashMap<Rank, Integer> initLottoResult() {
		// 사용자 로또가 해당 Rank에 몇 개 해당되는 지 저장
		LinkedHashMap<Rank, Integer> lottoResult = new LinkedHashMap<Rank, Integer>();
		lottoResult.put(Rank.MISS, 0);
		lottoResult.put(Rank.FIFTH, 0);
		lottoResult.put(Rank.FOURTH, 0);
		lottoResult.put(Rank.THIRD, 0);
		lottoResult.put(Rank.SECOND, 0);
		lottoResult.put(Rank.FIRST, 0);
		return lottoResult;
	}

	public static double getYield(LinkedHashMap<Rank, Integer> lottoResult) {
		double lottoPrice = lottoResult.size() * (new LottoGenerator().get_EACH_LOTTO_PRICE());
		double lottoReward = 0;
		for (Map.Entry<Rank, Integer> entry : lottoResult.entrySet()) {
			lottoReward += entry.getKey().getWinningMoney() * entry.getValue();
		}
		lottoResult.remove(Rank.MISS);
		DecimalFormat df = new DecimalFormat("0.000");
		return Double.parseDouble(df.format(lottoReward / lottoPrice));
	}

	public static void print(LinkedHashMap<Rank, Integer> lottoResult) {
		System.out.println();
		System.out.println("당첨 통계");
		System.out.println("------");
		double yeild = getYield(lottoResult);
		for (Map.Entry<Rank, Integer> entry : lottoResult.entrySet()) {
			System.out.print(entry.getKey().getCountOfMatch() + "개 일치 ");
			System.out.println("(" + entry.getKey().getWinningMoney() + "원) - " + entry.getValue() + "개");
		}
		System.out.println("총 수익률은 " + yeild + "입니다.");
	}

	public static void main(String[] args) {
		List<Lotto> userLottos = new LottoGenerator().generateUserLottos();
		WinningLotto winningLotto = new WinningLottoGenerator().generateWinningLotto();
		LinkedHashMap<Rank, Integer> lottoResult = initLottoResult();
		for (int i = 0; i < userLottos.size(); i++) {
			Rank rank = winningLotto.match(userLottos.get(i));
			lottoResult.put(rank, lottoResult.get(rank) + 1);
		}
		print(lottoResult);
	}
}
