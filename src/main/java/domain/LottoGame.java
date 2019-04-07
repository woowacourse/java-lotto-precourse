package domain;

import ExceptionCheck.NoticeOfException;

import java.util.*;

public class LottoGame {
    private static final NoticeOfException NOE = new NoticeOfException();

    private Lotto[] userLotto;
    private WinningLotto winningLotto;

    public int inputCost(Scanner sc) {
        System.out.println("구입금액을 입력해 주세요.");
        int cost = NOE.inputCostNOE(sc);                    //예외 처리
        return cost;
    }

    public void buyLotto(int cnt) {
        userLotto = new Lotto[cnt];
        for (int i = 0; i < cnt; i++) {
            AutoLotto al = new AutoLotto();
            userLotto[i] = new Lotto(al.makeAutoNumber());
        }
    }

    public void lastWeekNumber(Scanner sc) {
        Lotto winLotto = inputNumbers(sc);
        NOE.checkOverlap(winLotto.getNumbers());
        int bounusNumber = NOE.inputBonusNOE(sc, winLotto.getNumbers());
        winningLotto = new WinningLotto(winLotto, bounusNumber);
    }

    private Lotto inputNumbers(Scanner sc) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        sc.nextLine();
        String strNumber = sc.nextLine();
        return changeTypeNumbers(strNumber);
    }

    private Lotto changeTypeNumbers(String strNum) {
        List<Integer> list = eraseComma(strNum);
        Collections.sort(list);
        Lotto winLotto = new Lotto(list);
        return winLotto;
    }

    private List<Integer> eraseComma(String str) {
        List<String> strList = Arrays.asList(str.split(","));
        return NOE.checkListNOE(strList);
    }

    public void matchNumbers(WinningMoney wm) {
        for (int i = 0; i < userLotto.length; i++) {
            Rank rank = winningLotto.match(userLotto[i]);
            int winningMoney = rank.getWinningMoney();
            setCountMoney(winningMoney, wm);
        }
        wm.printCountMoney();
    }

    private void setCountMoney(int money, WinningMoney wm) {
        if (money != 0) {
            wm.setCountMoney(money);
        }
    }
}
