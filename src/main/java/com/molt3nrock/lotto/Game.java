package com.molt3nrock.lotto;

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
}
