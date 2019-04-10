package domain;

import domain.util.Input;

public class Game {
    private int insertedMoney;
    void startGame () {
        this.insertedMoney = Input.insertMoney();

    }
}
