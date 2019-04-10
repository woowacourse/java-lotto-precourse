package domain;

import domain.util.Input;
import domain.util.PrintScan;
import domain.util.Constant;

import java.util.ArrayList;
import java.util.List;


public class Game {
    public List<Lotto> userLottoList = new ArrayList();
    public WinningLotto winningLotto;

    public void startGame() {
        int insertedMoney = Input.insertMoney();
        buyingLotto(insertedMoney);
        winningLotto = WinningLotto.createWinningLotto();
        RankResult rankResult = new RankResult(userLottoList, winningLotto);
        rankResult.getRankResult();
    }

    private void buyingLotto(int money) {
        int numberOfLotto = getNumberOfLotto(money);
        for (int i = 0; i < numberOfLotto; i++) {
            userLottoList.add(Lotto.creatLotto());
        }
        PrintScan.printUserLottoInformation(userLottoList, numberOfLotto);
    }

    int getNumberOfLotto(int money) {
        int quotient = money / Constant.PRICE_OF_LOTTO;
        int rest = money % Constant.PRICE_OF_LOTTO;
        if (rest > 0) PrintScan.printRestMoney(rest);
        return quotient;
    }
}
