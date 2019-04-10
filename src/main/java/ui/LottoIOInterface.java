package ui;

import domain.Lotto;
import domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author delf
 */
public interface LottoIOInterface {
    int insertMoney();

    List<Integer> inputWinningLottoNumbers();

    int inputBounusNumber(Lotto lotto);

    void showLottos(List<Lotto> lottos);

    void showWinningStatistics(Map<Rank, Integer> ranks);

    /**
     * 간단한 문자열 출력
     */
    static void showPlaneText(String s) {
        System.out.println(s);
    }
}
