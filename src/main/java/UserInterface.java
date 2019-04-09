import domain.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInterface {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String LOTTO_NUMBER_SEPARATOR = ",";

    int getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.valueOf(scanner.nextLine());
    }

    void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }

    WinningLotto getWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String LottoWithComma = scanner.nextLine();
        List<Integer> WinningLottoNumbers = Arrays.stream(LottoWithComma.split(LOTTO_NUMBER_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(WinningLottoNumbers);

        System.out.println("보너스 볼을 입력해 주세요.");
        int BonusNo = scanner.nextInt();

        return new WinningLotto(lotto, BonusNo);
    }

    void printRankCount(LottoRankCount lottoRankCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .filter(rank -> rank != Rank.MISS)
                .map(rank -> rank.getCountOfMatch() + "개 일치" + (rank == Rank.SECOND ? ", 보너스 볼 일치" : "") + " (" + rank.getWinningMoney() + "원)- " + lottoRankCount.getCount(rank) + "개")
                .forEach(System.out::println);
    }

    void printEarningRate(EarningRate earningRate) {
        System.out.println(String.format("총 수익률은 %.3f 입니다.", earningRate.getValue()));
    }
}
