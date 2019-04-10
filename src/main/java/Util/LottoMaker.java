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

    /**
     * 정해진 번호를 가진 로또 생성
     *
     * @param stringNumbers
     * @return
     */
    public static Lotto getLotto(String stringNumbers) throws RuntimeException {
        List<Integer> lottoNumberList = stringToIntegerList(stringNumbers);
        checkNumberCount(lottoNumberList.size());
        checkUniqueNumber(lottoNumberList);
        checkNumberListRange(lottoNumberList);
        return new Lotto(lottoNumberList);
    }

    private static List<Integer> stringToIntegerList(String stringNumbers) {
        try {
            return Arrays.stream(stringNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(stringNumbers + "에 숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private static void checkNumberCount(int size) {
        if (size != LOTTO_NUMBER_MAX_LENGTH)
            throw new IllegalArgumentException("로또 번호의 개수가 올바르지 않습니다.");
    }

    private static void checkUniqueNumber(List<Integer> lottoNumberList) {
        Set<Integer> lottoNumberSet = new HashSet<>(lottoNumberList);
        if (lottoNumberSet.size() != LOTTO_NUMBER_MAX_LENGTH)
            throw new IllegalArgumentException(lottoNumberList + "에 중복된 숫자가 존재합니다.");
    }

    private static void checkNumberListRange(List<Integer> lottoNumberList)
            throws IllegalArgumentException {
        for (int number : lottoNumberList) {
            checkNumberRange(number);
        }
    }

    private static void checkNumberRange(int number) {
        if ((number < LOTTO_MIN_NUMBER) || (number > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException("로또 번호의 범위가 유효하지 않습니다.");
        }
    }

    public static WinningLotto getWinningLotto(Lotto lotto, int bonusNumber)
            throws IllegalArgumentException {
        checkNumberRange(bonusNumber);
        checkUniqueNumber(lotto.getNumbers(), bonusNumber);
        return new WinningLotto(lotto, bonusNumber);
    }

    private static void checkUniqueNumber(List<Integer> lottoNumberList, int bonusNumber) {
        Set<Integer> lottoNumberSet = new HashSet<>(lottoNumberList);
        if (lottoNumberSet.contains(bonusNumber))
            throw new IllegalArgumentException(lottoNumberList + "에 중복된 숫자가 존재합니다.");
    }
}
