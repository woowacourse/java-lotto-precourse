package domain.interfaces;

import java.util.List;

public interface UserInterface {

    int promptPurchaseAmount();
    String[] promptWinningLottoNumber();
    int promptBonusNumber();
    void notifyInvalidPurchaseAmount();
    void printStatistics(List<Integer> lottos);

}
