package game;

import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;

import java.util.*;

import static game.Game.LOTTO_PRICE;

/**
 * 수익률을 분석하는 객체
 */
public class Analyzer {
    private static HashMap<Rank, Integer> map;           // 매칭 결과를 담을 HashMap

    public void showResult(List<Lotto> lottos, WinningLotto winningLotto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        String[] result = putCorrectCount(lottos, winningLotto);
        double benefitRate = putBenefitRate(lottos);
        for (String value : result) {
            System.out.println(value);
        }
        System.out.println("총 수익률은 " + benefitRate + "입니다.");
    }

    /*
     * 출력할 문장을 랭크 오름차순으로 문자열에 담는다
     */
    public String[] putCorrectCount(List<Lotto> lottos, WinningLotto winningLotto) {
        int index = 0;
        setHashMap(lottos, winningLotto);
        String[] result = new String[map.size()];
        int[] order = {3, 2, 4, 0, 1};
        for (Rank rank : map.keySet()) {
            result[order[index++]] = tellCorrectCountAndMoney(rank);
        }
        return result;
    }
}
