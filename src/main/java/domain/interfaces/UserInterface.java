package domain.interfaces;

import domain.Lotto;
import domain.Rank;

import java.util.List;

public interface UserInterface {

    long promptPurchaseAmount();

    void printLottoList(List<Lotto> lottos, long validLottoCount);

    String[] promptWinningLottoNumber();

    int promptBonusNumber();

    void notifyInvalidInput();

    void printStatistics(Rank rankValueForPrint, int wins);

    void printProfitRate();

}
