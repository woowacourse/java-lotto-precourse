package com.molt3nrock.lotto;

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


    private List<Integer> parseInputAsWinningNumbers(String line) throws IllegalArgumentException {
        final int COUNT_OF_NORMAL_WINNING_NUMBERS = 6;
        final int MINIMUM_NUMBER_OF_LOTTO = 1;
        final int MAXIMUM_NUMBER_OF_LOTTO = 45;
        List<Integer> numbers =  Arrays.stream(line.split(","))
            .map(s -> parseStringAsInteger(s.trim()))
            .filter( i -> i >= MINIMUM_NUMBER_OF_LOTTO && i <= MAXIMUM_NUMBER_OF_LOTTO)
            .collect(Collectors.toList());
            if (numbers.stream().distinct().count() == COUNT_OF_NORMAL_WINNING_NUMBERS) {
               return numbers;
            }
            throw new IllegalArgumentException("올바른 당첨번호 입력이 아닙니다.");
    }

    private Integer parseStringAsInteger(String input) throws IllegalArgumentException {
       try  {
           return Integer.parseInt(input);
       } catch (NumberFormatException e) {
           throw new IllegalArgumentException("올바른 번호가 아닙니다.");
       }
    }
}
