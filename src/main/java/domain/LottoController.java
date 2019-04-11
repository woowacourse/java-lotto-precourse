/*
 * 클래스 이름: LottoController.java
 * 버전 정보: 1.0.0
 * 날짜: 2019/04/11
 * Copyright 2019 Inkwon Lee
 */
package domain;

import java.util.*;

public class LottoController {

    public void startLotto() {
        List<Lotto> purchaseLottoList = new ArrayList<>();
        UserLotto userLotto = new UserLotto();
        ProcessWinningLotto assignWinning = new ProcessWinningLotto();
        Scanner scanner = new Scanner(System.in);

        int purchasePrice = userLotto.inputPrice(scanner);

        userLotto.assignPurchaseLottoList(purchasePrice, purchaseLottoList);
        assignWinning.statsWinningLotto(purchaseLottoList, scanner, purchasePrice);
        scanner.close();
    }

}
