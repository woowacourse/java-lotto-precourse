import domain.WinningLotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        LottoBuyer buyer = new LottoBuyer(Integer.valueOf(sc.nextLine()));
        buyer.buyLottos();
        WinningLotto winningLotto = WinningLottoMaker.getWinningLotto();
        WinStatsPrinter.printWinStats();
    }
}
