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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 사용자의 로또 서비스를 담당하는 객체
 */
public class LottoService {
    private static final int LOTTO_PRICE = 1_000;

    public static List<Lotto> getOrder(int money) {
        int numberOfLotto = money / LOTTO_PRICE;

        List<Lotto> lottos = LottoMaker.getLottos(numberOfLotto);
        return lottos;
    }

    public static WinningLotto getWinningLotto(String winningNumber,
                                               int bonusNumber) {
        try {
            return LottoMaker.getWinningLotto(winningNumber, bonusNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
