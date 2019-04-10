package domain;

import userInput.BonusBallInput;
import userInput.WinningNumbersInput;

import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        LottoBuyer lottoBuyer = new LottoBuyer();
        List<Lotto> tickets = new LottoDealer().sellTickets(lottoBuyer.getPurchasePrice());
        lottoBuyer.setTickets(tickets);
        lottoBuyer.showAllTickets();

        Lotto winningNumbers = WinningNumbersInput.getWinningNumbers();
        int bonusNo = BonusBallInput.getBonusBall(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNo);
        new LottoStatistics(winningLotto, tickets).show();
    }
}
