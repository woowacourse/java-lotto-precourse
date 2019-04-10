package core;

import domain.Lotto;
import domain.Person;
import domain.Store;
import domain.Studio;

import java.util.List;
import java.util.Scanner;

class LottoGame {
    private Person player;
    private Store lottoStore;
    private Studio lottoStudio;
    private Scanner scanner;

    LottoGame() {
        player = new Person();
        lottoStore = new Store();
        lottoStudio = new Studio();
        scanner = new Scanner(System.in);
    }

    void init() {
        enterBudget();
        sellLotto();
        enterWinningInfo();
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

    private boolean enterWinningInfo() {
        enterWinningNums();
        enterWinningBonus();

        if (lottoStudio.containBonusNum())
            enterWinningInfo();

        return true;
    }

    private boolean enterWinningNums() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        try {
            while (!lottoStudio.enterWinningNums(scanner.nextLine())) ;
        } catch (NumberFormatException nfe) {
            System.out.println("문자를 입력하셨습니다.");
            enterWinningNums();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            enterWinningNums();
        }
        return true;
    }

    private boolean enterWinningBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            while (!lottoStudio.enterWinningBonus(scanner.nextLine())) ;
        } catch (NumberFormatException nfe) {
            System.out.println("문자를 입력하셨습니다.");
            enterWinningBonus();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            enterWinningBonus();
        }
        return true;
    }
}
