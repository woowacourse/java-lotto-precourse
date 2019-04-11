/*
 * LottoShop.java
 * version 1.0
 * 2019.04.11
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package woowacourse.lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoShop {
    static final int PRICE_PER_LOTTO = 1000;
    static final int NUMBER_PER_LOTTO = 6;
    static final int NUMBER_LOWER_BOUND = 1;
    static final int NUMBER_UPPER_BOUND = 45;
    private static final String GET_ANSWER_NUMBER_GUIDE =
            "\n지난주 당첨번호를 입력해 주세요.";
    private static final String GET_BONUS_BALL_GUIDE =
            "보너스볼을 입력해 주세요.";
    private static final String DELIM_WARNING =
            "공백으로 구분된 지난주 당첨번호를 입력해 주세요.";
    private static final String NUMBER_BOUND_WARNING =
            "1-45 사이의 수를 입력해 주세요.";
    private static final String NUMBER_REPEAT_WARNING =
            "서로 다른 %d개 수를 입력해 주세요.\n";
    private static final String NOT_NUMBER_WARNING =
            "보너스볼 값을 입력해 주세요.";
    private static final String BONUS_NUMBER_REPEAT_WARNING =
            "당첨번호와 다른 수를 입력해 주세요.";

    private Price userPrice;
    private int numLotto;
    private UserLottoSet userLottoSet;
    private Lotto answerLotto;
    private int bonusBall;
    private WinningLotto winningLotto;
    private ArrayList<Rank> matchedRanks;
    private Stats finalStats;

    public LottoShop() {
        userPrice = new Price();
        userLottoSet = new UserLottoSet();
        matchedRanks = new ArrayList<>();
        finalStats = new Stats();
    }

    public void savePayment(Scanner scan) {
        userPrice.saveTotalPrice(scan);
        numLotto = userPrice.getNumLotto();
    }

    public void issueLotto() {
        userLottoSet.saveUserLotto(numLotto);
    }

    public void saveWinningLotto(Scanner scan) {
        System.out.println(GET_ANSWER_NUMBER_GUIDE);
        while (!getAnswerNumbers(scan)) ;
        System.out.println(GET_BONUS_BALL_GUIDE);
        while (!getBonusBall(scan)) ;
        winningLotto = new WinningLotto(answerLotto, bonusBall);
    }

    private boolean getAnswerNumbers(Scanner scan) {
        String[] inputStrings = scan.nextLine().split("\\s");
        List<Integer> numberSet = new ArrayList<>();
        for (String s : inputStrings) {
            try {
                numberSet.add(Integer.valueOf(s));
            } catch (NumberFormatException e) {
                System.out.println(DELIM_WARNING);
                return false;
            }
        }
        if (checkAnswerNumbers(numberSet)) {
            answerLotto = new Lotto(numberSet);
            return true;
        }
        return false;
    }

    private boolean checkAnswerNumbers(List<Integer> numberSet) {
        numberSet = numberSet.stream().distinct().sorted()
                .collect(Collectors.toList());
        if (numberSet.size() != NUMBER_PER_LOTTO) {
            System.out.format(NUMBER_REPEAT_WARNING, NUMBER_PER_LOTTO);
            return false;
        }
        if ((numberSet.get(0) < NUMBER_LOWER_BOUND)
                || (numberSet.get(NUMBER_PER_LOTTO - 1) > NUMBER_UPPER_BOUND)) {
            System.out.println(NUMBER_BOUND_WARNING);
            return false;
        }
        return true;
    }

    private boolean getBonusBall(Scanner scan) {
        try {
            bonusBall = Integer.valueOf(scan.nextLine().trim());
            return checkBonusBall();
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMBER_WARNING);
            return false;
        }
    }

    private boolean checkBonusBall() {
        if ((bonusBall < NUMBER_LOWER_BOUND)
                || (bonusBall > NUMBER_UPPER_BOUND)) {
            System.out.println(NUMBER_BOUND_WARNING);
            return false;
        }
        if (answerLotto.hasNumber(bonusBall)) {
            System.out.println(BONUS_NUMBER_REPEAT_WARNING);
            return false;
        }
        return true;
    }

    public void matchLotto() {
        userLottoSet.saveMatchResult(winningLotto, matchedRanks);
    }

    public void calStats() {
        finalStats.printRankCount(matchedRanks);
        finalStats.calYield(numLotto * PRICE_PER_LOTTO);
    }
}
