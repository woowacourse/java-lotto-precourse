package domain;

import java.util.ArrayList;
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

    private List<Lotto> purchase(int money) {
        Purchase purchase = new Purchase(money);            // 로또산다
        purchase.printLottoListOfUser();                  // 로또 출력
        return purchase.getLottoList();
    }

    private int checkMoney(InputValid input, Scanner sc) {
        System.out.print(Message.INPUT_MONEY_MESSAGE);
        int money = input.checkMoney(sc.nextLine());
        return money;
    }
    private Lotto checkWinningNumbers(InputValid input, Scanner sc) {
        System.out.print(Message.INPUT_WIN_MESSAGE);
        Lotto lotto = input.checkWinningNumbers(sc.nextLine());
        return lotto;
    }
    private int checkBonusNumber(InputValid input, Scanner sc, Lotto winningLotto) {
        System.out.print(Message.INPUT_BONUS_MESSAGE);
        int bonus = input.checkBonusNumber(sc.nextLine(), winningLotto);
        return bonus;

    }
    private List<Rank> matchWinningLottoAndLottoList(List<Lotto> lottoList, Lotto winLotto, int bonusNo) {
        List<Rank> ranks = new ArrayList<>();
        WinningLotto winningLotto = new WinningLotto(winLotto, bonusNo);
        for (Lotto lotto : lottoList) {
            Rank rank = winningLotto.match(lotto);
            ranks.add(rank);
        }
        return ranks;
    }
    private void statistic(List<Rank> ranks,int money){
        Statistic statistic=new Statistic(ranks,money);
        statistic.print();
    }

}
