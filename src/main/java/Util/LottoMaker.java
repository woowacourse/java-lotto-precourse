/*
 * class : LottoMaker.java
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

import java.util.*;
import java.util.stream.Collectors;

/**
 * 로또를 생성하는 객체
 */
public class LottoMaker {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_MAX_LENGTH = 6;

    public static List<Lotto> getLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(getLotto());
        }
        return lottos;
    }

    /**
     * 무작위 번호를 가진 로또 생성
     *
     * @return
     */
    private static Lotto getLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(getUniqueNumberSet());
        return new Lotto(lottoNumbers);
    }

    private static Set<Integer> getUniqueNumberSet() {
        Set<Integer> uniqueNumberSet = new HashSet<>();

        while (uniqueNumberSet.size() != LOTTO_NUMBER_MAX_LENGTH) {
            uniqueNumberSet.add(getRandomNumber());
        }
        return uniqueNumberSet;
    }

    private static int getRandomNumber() {
        return ((int) (Math.random() * LOTTO_MAX_NUMBER) + LOTTO_MIN_NUMBER);
    }

    public static WinningLotto getWinningLotto(String winningNumber, int bonusNumber) {
        try {
            List<Integer> numberList = stringToIntegerList(winningNumber);
            checkUniqueNumber(numberList);
            checkValidNumberRange(numberList);
            return new WinningLotto(getLotto(numberList), bonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(winningNumber + "는 유효하지 않은 값입니다.");
        }
    }

    private static List<Integer> stringToIntegerList(String stringBasedNumber)
            throws NumberFormatException {
        return Arrays.stream(stringBasedNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void checkUniqueNumber(List<Integer> winningNumber) {
        Set<Integer> winningNumberSet = new HashSet<>(winningNumber);
        if (winningNumberSet.size() != LOTTO_NUMBER_MAX_LENGTH)
            throw new IllegalArgumentException();
    }

    private static void checkValidNumberRange(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            if ((number < LOTTO_MIN_NUMBER) || (number > LOTTO_MAX_NUMBER)) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * 정해진 번호를 가진 로또 생성
     *
     * @param lottoNumber
     * @return
     */
    private static Lotto getLotto(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }
}
