package domain;

import java.util.*;

class LottoController {

    public void startLotto() {
        List<Lotto> purchaseLottoList = new ArrayList<>();
        UserLotto userLotto = new UserLotto();
        ProcessWinningLotto assignWinning = new ProcessWinningLotto();
        Scanner scanner = new Scanner(System.in);

        int purchasePrice = userLotto.inputPrice(scanner);

        userLotto.assignPurchaseLottoList(purchasePrice, purchaseLottoList);
        assignWinning.statsWinningLotto(purchaseLottoList, scanner, purchasePrice);
    }

}
