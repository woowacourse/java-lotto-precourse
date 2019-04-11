package game;

import domain.Lotto;

import java.util.*;

/**
 * 로또 구매자 객체
 */
public class Buyer {
    static final int  NUMBER_PER_LOTTO = 6;
    static final int LOTTO_NUMBER_BOUNDARY = 45;
    private static final int MIN_PAY_MONEY = 0;

    /*
     * 구입금액 입력이 조건에 맞으면 구매를 완료한다
     */
    public int buyMoney() {
        int money;
        System.out.println("구입금액을 입력해 주세요.");
        do {
            money = inspectBuyMoneyCondition();
        } while (money < MIN_PAY_MONEY);
        return money;
    }
}
