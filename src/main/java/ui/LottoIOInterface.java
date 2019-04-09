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

    int[] inputWinningLottoNumbers();

    int inputBounusNumber(WinningLotto lotto);

    void showLottoNumbers(List<Lotto> lottos);

    void showWinningStatistics(List<Rank> ranks);
}
