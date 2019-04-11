/*
 * Main.java
 * version 1.0
 * 2019.04.11
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package woowacourse.lotto;

import java.util.Scanner;
import woowacourse.lotto.util.LottoShop;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LottoShop lottoShop = new LottoShop();
        lottoShop.savePayment(scan);
        lottoShop.issueLotto();
        lottoShop.saveWinningLotto(scan);
        lottoShop.matchLotto();
        lottoShop.calStats();
        scan.close();
    }
}
