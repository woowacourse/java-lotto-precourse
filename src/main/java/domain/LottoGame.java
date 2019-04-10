package domain;

import java.util.List;
import java.util.Scanner;

public class LottoGame {

    public void play() {
        Scanner sc = new Scanner(System.in);

        InputValid input = new InputValid(sc);
        int money = checkMoney(input, sc);
        List<Lotto> lottoList = purchase(money);

        Lotto winLotto = checkWinningNumbers(input, sc);
        int bonusNo = checkBonusNumber(input, sc, winLotto);
        List<Rank> ranks = matchWinningLottoAndLottoList(lottoList, winLotto, bonusNo);    
        statistic(ranks,money);
    }

    private int checkMoney(InputValid input, Scanner sc) {
        System.out.print(Message.INPUT_MONEY_MESSAGE);
        int money = input.checkMoney(sc.nextLine());
        return money;
    }
}
