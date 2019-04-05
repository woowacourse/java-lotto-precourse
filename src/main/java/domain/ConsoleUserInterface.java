package domain;

import domain.interfaces.UserInterface;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleUserInterface implements UserInterface {
    private boolean isResultTitlePrinted = false;
    private Scanner sc = new Scanner(System.in);

    @Override
    public int promptTotalPrice() throws InputMismatchException {
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    @Override
    public List<Integer> promptWinningNumbers() throws NumberFormatException {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String[] segments = sc.nextLine().split(",");
        return Arrays.stream(segments).map(Integer::valueOf).collect(Collectors.toList());
    }

    @Override
    public int promptBonusNumber() throws InputMismatchException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

    @Override
    public void printBoughtLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto l : lottos) {
            System.out.println(l);
        }
    }

    @Override
    public void printRank(Rank r, int wins) {
        checkIfResultTitlePrinted();
        System.out.println(String.format("%d개 일치%s(%d원)- %d 개",
            r.getCountOfMatch(),
            r.equals(Rank.SECOND) ? ". 보너스 볼 일치" : " ",
            r.getWinningMoney(),
            wins));
    }

    @Override
    public void printEarningRate(double earningRate) {
        System.out.println("총 수익률은 " + (Math.round(earningRate * 1000) / 1000) + "입니다.");
    }

    @Override
    public void notifyInvalidInput() {
        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
    }

    private void checkIfResultTitlePrinted() {
        if (!isResultTitlePrinted) {
            System.out.println("당첨 통계");
            System.out.println("---------");
            isResultTitlePrinted = true;
        }
    }
}
