package ui;

import domain.Lotto;
import domain.Rank;

import java.util.List;
import java.util.Map;

/**
 * @author delf
 */
public interface LottoIOInterface {
    int insertMoney() throws IllegalArgumentException;

    List<Integer> inputWinningLottoNumbers() throws IllegalArgumentException;

    int inputBonusNumber(Lotto lotto) throws IllegalArgumentException;

    void showLottos(List<Lotto> lottos);

    void showWinningStatistics(Map<Rank, Integer> ranks);

    /* 간단한 문자열 출력 */
    static void showPlaneText(Object s) {
        System.out.println(s.toString());
    }
}
