import domain.WinningLotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        LottoBuyer buyer = new LottoBuyer();
        buyer.setMoney();
        buyer.buyLottos();
        WinningLotto winningLotto = WinningLottoMaker.getWinningLotto();
        WinStatsPrinter.printWinStats(winningLotto,buyer);
    }
}
