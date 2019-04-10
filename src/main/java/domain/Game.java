package domain;

import domain.util.Input;
import domain.util.PrintScan;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public final static int PRICE_OF_LOTTO = 1000;
    public List <Lotto> lottoList = new ArrayList();

    void startGame () {
        int insertedMoney = Input.insertMoney();
        buyingLotto(insertedMoney);
    }

    private void buyingLotto(int money){
        int numberOfLotto = getNumberOfLotto(money);
        for (int i = 0; i < numberOfLotto; i++) {

        }
    }

    int getNumberOfLotto(int money){
        int quotient = money / PRICE_OF_LOTTO;
        int rest = money % PRICE_OF_LOTTO;
        if (rest > 0) PrintScan.printRestMoney(rest);
        return quotient;
    }
}
