package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Match {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final int lottoCnt = inputMoney(scan);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; ++i) {
            lottos.add(Store.buy());
            lottos.get(i).numbersPrint();
        }

        final WinningLotto win = inputWin(scan);
    }

    public static int inputMoney(Scanner scan) {
        System.out.println("구입금액을 입력해 주세요.");

        final int in = scan.nextInt();
        scan.nextLine();

        final int lottoCnt = in / 1000;
        System.out.println(lottoCnt + "구매했습니다.");
        return lottoCnt;
    }

    public static WinningLotto inputWin(Scanner scan) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] in = scan.nextLine().split(",");
        List<Integer> win = new ArrayList<>();
        for (int i = 0; i < 6; ++i) {
            win.add(Integer.valueOf(in[i]));
        }

        System.out.println("보너스 볼을 입력해 주세요.");
        final int bo = scan.nextInt();
        scan.nextLine();

        return new WinningLotto(Store.buy(win), bo);
    }
}
