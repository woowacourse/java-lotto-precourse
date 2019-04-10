/*
 * class : LottoService.java
 *
 * version : 1.0.0
 *
 * date : 2019.04.08
 *
 * author : icarus8050
 */

package Util;

import domain.Lotto;
import domain.WinningLotto;

import java.util.List;

/**
 * 사용자의 로또 서비스를 담당하는 객체
 */
public class LottoService {
    private static final int LOTTO_PRICE = 1_000;

    public static List<Lotto> getOrder(int money) {
        if (LOTTO_PRICE > money) {
            throw new IllegalArgumentException("주문 금액은 최소 1,000원 이상이어야 합니다.");
        }

        int numberOfLotto = money / LOTTO_PRICE;
        List<Lotto> lottos = LottoMaker.getLottos(numberOfLotto);
        return lottos;
    }

    public static Lotto getLotto(String stringNumber) {
        try {
            return LottoMaker.getLotto(stringNumber);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
