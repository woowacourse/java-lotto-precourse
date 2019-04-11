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
}
