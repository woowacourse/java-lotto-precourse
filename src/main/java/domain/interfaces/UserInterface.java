package domain.interfaces;

import domain.Lotto;

import java.util.List;

public interface UserInterface {

    int promptPurchaseAmount();
    void printLottoList(List<Lotto> lottos,int validLottoCount);
    String[] promptWinningLottoNumber();
    int promptBonusNumber();
    void notifyInvalidPurchaseAmount();
    void notifyInvalidWinningLotto();
    void notifyInvalidBonusNumber();
    void printStatistics();

}
