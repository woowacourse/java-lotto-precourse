package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Match {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final int lottoCnt = inputMoney(scan);
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCnt; ++i) {
            lottos.add(Store.buy());
        }
    }

    public static int inputMoney(Scanner scan) {
        System.out.println("구입금액을 입력해 주세요.");

        final int in = scan.nextInt();
        scan.nextLine();

        final int lottoCnt = in / 1000;
        System.out.println(lottoCnt + "구매했습니다.");
        return lottoCnt;
    }
}
