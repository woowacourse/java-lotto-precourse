package domain.interfaces;

import java.util.List;

public interface UserInterface {

    int promptLottoPurchaseAmount();
    String promptWinningLottoNumber();
    int promptBonusNumber();
    void notifyInvalidLottoPurchaseAmount();
    void printStatistics(List<Integer> lottos);

}
