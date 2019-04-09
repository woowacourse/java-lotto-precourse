package com.molt3nrock.lotto;

import static com.molt3nrock.lotto.Constants.COUNT_OF_NUMBERS_PER_LOTTO;
import static com.molt3nrock.lotto.Constants.MAXIMUM_NUMBER_OF_LOTTO;
import static com.molt3nrock.lotto.Constants.MINIMUM_NUMBER_OF_LOTTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private int parseInput(String line) throws IllegalArgumentException {
        int money;
        try {
            money = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 돈이 아닙니다.");
        }
        return money;
    }

    private Integer parseInputAsBonusNumber(String line, List<Integer> winningNumbers)
        throws IllegalArgumentException {
        Integer bonusNumber = parseStringAsInteger(line);
        if (winningNumbers.stream().anyMatch(i -> i.equals(bonusNumber))
            || bonusNumber < MINIMUM_NUMBER_OF_LOTTO || bonusNumber > MAXIMUM_NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException("올바른 보너스번호 입력이 아닙니다.");
        }
        return bonusNumber;
    }

    private List<Integer> parseInputAsWinningNumbers(String line) throws IllegalArgumentException {
        List<Integer> numbers = Arrays.stream(line.split(","))
            .map(s -> parseStringAsInteger(s.trim()))
            .filter(i -> i >= MINIMUM_NUMBER_OF_LOTTO && i <= MAXIMUM_NUMBER_OF_LOTTO)
            .collect(Collectors.toList());
        if (numbers.stream().distinct().count() == COUNT_OF_NUMBERS_PER_LOTTO) {
            return numbers;
        }
        throw new IllegalArgumentException("올바른 당첨번호 입력이 아닙니다.");
    }

    private Integer parseStringAsInteger(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 번호가 아닙니다.");
        }
    }
}
