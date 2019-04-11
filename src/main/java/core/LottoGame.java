/**
 * 우아한테크코스 프리코스 3주차 미션
 * 로또 게임
 *
 * @author JiHoon Kim
 * @version 1.0
 */

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
        checkRank();
    }

    /**
     * @return 입력한 수가 마이너스면 False를 리턴
     */
    private boolean enterBudget() {
        int budget = 0;
        System.out.println("구입 금액을 입력해 주세요.");
        try {
            budget = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("잘못된 입력입니다.");                       /* 문자를 입력값으로 받았을 때 */
            enterBudget();
        }

        return player.setBudget(budget);
    }

    /**
     * 사용자의 구매 금액을 입력받아 로또 객체들을 생성하고 출력하는 클래스
     *
     * @return 로또를 살 돈이 부족하면 False를 리턴
     */
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
        System.out.println();

        return true;
    }

    private boolean enterWinningInfo() {
        enterWinningNums();
        enterWinningBonus();

        if (lottoStudio.containBonusNum())                      /* 보너스 번호가 당첨 번호에 포함 됬을 때 다시 입력 받음 */
            enterWinningInfo();

        return true;
    }

    private boolean enterWinningNums() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        try {
            while (!lottoStudio.enterWinningNums(scanner.nextLine())) ;
        } catch (NumberFormatException nfe) {                               /* 문자를 입력했을 때 */
            System.out.println("문자를 입력하셨습니다.");
            enterWinningNums();
        } catch (Exception e) {                                             /* 번호의 갯수, 범위가 로또 규칙과 다를 때 */
            System.out.println(e.getMessage());
            enterWinningNums();
        }
        return true;
    }

    private boolean enterWinningBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            while (!lottoStudio.enterWinningBonus(scanner.nextLine())) ;
        } catch (NumberFormatException nfe) {                               /* 문자를 입력했을 때 */
            System.out.println("문자를 입력하셨습니다.");
            enterWinningBonus();
        } catch (Exception e) {                                             /* 번호의 범위가 로또 규칙과 다를 때 */
            System.out.println(e.getMessage());
            enterWinningBonus();
        }
        return true;
    }

    private void checkRank() {
        int[] myLottoRank = player.checkRank(lottoStudio.getWinningLotto());
        printResult(myLottoRank, player.getPrizeMoney());
    }

    private void printResult(int[] rankArray, int prizeMoney) {
        System.out.println("\n당첨 통계\n---------------\n");
        System.out.println("3개 일치 (5000원) - " + rankArray[1] + "개");
        System.out.println("4개 일치 (50000원) - " + rankArray[2] + "개");
        System.out.println("5개 일치 (1500000원) - " + rankArray[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + rankArray[4] + "개");
        System.out.println("6개 일치 (2000000000원) - " + rankArray[5] + "개");
        System.out.println("총 수익률은 " +
                String.format("%.2f", Float.parseFloat(String.valueOf(prizeMoney * 1.0 / player.getMoneySpent()))) + "입니다.");
    }
}
