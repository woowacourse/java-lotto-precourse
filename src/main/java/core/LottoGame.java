package core;

import domain.Lotto;
import domain.Person;
import domain.Store;

import java.util.List;
import java.util.Scanner;

public class LottoGame {
    private Person player;
    private Store lottoStore;
    private Scanner scanner;

    public LottoGame() {
        player = new Person();
        lottoStore = new Store();
        scanner = new Scanner(System.in);
    }

    public void init() {
        enterBudget();
        sellLotto();
    }

    private boolean enterBudget() {
        int budget = 0;
        System.out.println("구입 금액을 입력해 주세요.");
        try {
            budget = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("잘못된 입력입니다.");
            enterBudget();
        }

        return player.setBudget(budget);
    }

    private boolean sellLotto() {
        List<Lotto> lottoList = lottoStore.sellLotto(player.payBudget());
        if (lottoList.size() == 0)
            return false;
        printLotto(lottoList);
        player.keepLotto(lottoList);

        return true;
    }

    private boolean printLotto(List<Lotto> lottoList) {
        System.out.println("\n" + lottoList.size() + "개를 구매하셨습니다.");
        for (Lotto lotto : lottoList)
            lotto.printNums();

        return true;
    }
}