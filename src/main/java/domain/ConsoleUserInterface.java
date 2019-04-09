package domain;

import domain.interfaces.UserInterface;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {

    @Override
    public int promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    @Override
    public void printLottoList(List<Lotto> lottos, int validLottoCount) {
        System.out.println(validLottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.hashCode());
            System.out.println(lotto);
        }
    }

    @Override
    public String[] promptWinningLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().split(",");
    }

    @Override
    public int promptBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    @Override
    public void notifyInvalidPurchaseAmount() {
        System.out.println("잘못된 입력입니다.");
    }

    @Override
    public void notifyInvalidWinningLotto() { System.out.println("잘못된 입력입니다."); }

    @Override
    public void notifyInvalidBonusNumber() { System.out.println("잘못된 입력입니다."); }

    @Override
    public void printStatistics(){
        StringBuilder sb = new StringBuilder();
        //List<Integer> rankValueForPrint = Arrays.asList(Rank.THIRD.getCountOfMatch())
        sb.append(Rank.FIFTH.getCountOfMatch() + "개 일치 (" + Rank.FIFTH.getWinningMoney() + "원)-" + Player.count_FIFTH + "개\n"
                + Rank.FOURTH.getCountOfMatch() + "개 일치 (" + Rank.FOURTH.getWinningMoney() + "원)-" + Player.count_FOURTH + "개\n"
                + Rank.THIRD.getCountOfMatch() + "개 일치 (" + Rank.THIRD.getWinningMoney() + "원)-" + Player.count_THIRD + "개\n"
                + Rank.SECOND.getCountOfMatch() + "개 일치, 보너스 볼 일치(" + Rank.THIRD.getWinningMoney() + "원)-" + Player.count_SECOND + "개\n"
                + Rank.FIRST.getCountOfMatch() + "개 일치 (" + Rank.FIRST.getWinningMoney() + "원)-" + Player.count_FIRST + "개");
        System.out.println(sb);
        System.out.println("총 수익률은 " + Player.profitRate +"입니다.");
    }
}
