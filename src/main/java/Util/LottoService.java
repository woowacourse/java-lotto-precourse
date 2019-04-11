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
import domain.Rank;
import domain.WinningLotto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자의 로또 서비스를 담당하는 객체
 */
public class LottoService {
    private static final int LOTTO_PRICE = 1_000;

    public static List<Lotto> getOrder(String stringBasedMoney) {
        try {
            int money = convertStringToInteger(stringBasedMoney);
            checkMinMoney(money);
            return LottoMaker.getLottos(money / LOTTO_PRICE);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    private static int convertStringToInteger(String stringNumber) {
        int number;

        try {
            number = Integer.parseInt(stringNumber);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("잘못된 숫자를 입력하였습니다.");
        }
        return number;
    }

    private static void checkMinMoney(int money) {
        if (LOTTO_PRICE > money) {
            throw new IllegalArgumentException("주문 금액은 최소 1,000원 입니다.");
        }
    }

    public static Lotto getLotto(String stringNumber) {
        try {
            return LottoMaker.getLotto(stringNumber);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public static WinningLotto getWinningLotto(Lotto lotto, String stringNumber) {
        try {
            int bonusNumber = convertStringToInteger(stringNumber);
            return LottoMaker.getWinningLotto(lotto, bonusNumber);
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public static List<Rank> getMatchOfLotto(WinningLotto winningLotto,
                                             List<Lotto> userLottos) {
        try {
            return userLottos.stream()
                    .map(lotto -> winningLotto.match(lotto))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
