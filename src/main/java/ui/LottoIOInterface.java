package ui;

import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;

import java.util.List;

/**
 * @author delf
 */
public interface LottoIOInterface {
    int insertMoney();

    List<Integer> inputWinningLottoNumbers();

    int inputBounusNumber(Lotto lotto);

    void showLottos(List<Lotto> lottos);

    void showWinningStatistics(List<Rank> ranks);
}
