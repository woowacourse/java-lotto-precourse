package domain;

import domain.interfaces.UserInterface;

import java.util.List;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {

    @Override
    public long promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextLong();
    }

    @Override
    public void printLottoList(List<Lotto> lottos, long validLottoCount) {
        System.out.println(validLottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
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
    public void notifyInvalidInput() {
        System.out.println("예외적인 입력입니다. 다시 입력해주세요.");
    }

    @Override
    public void printStatistics(Rank rankValueForPrint, int wins){
        System.out.println(String.format("%d개 일치%s(%d원)- %d개",
                rankValueForPrint.getCountOfMatch(),
                rankValueForPrint == Rank.SECOND ? ", 보너스 볼 일치" : " ",
                rankValueForPrint.getWinningMoney(),
                wins));
    }

    @Override
    public void printProfitRate(){
        System.out.println(String.format("총 수익률은 %.1f", StatisticsCalculator.profitRate) + "%입니다.");
    }
}
