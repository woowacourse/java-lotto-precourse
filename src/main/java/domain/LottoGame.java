package domain;

import userInput.BonusBallInput;
import userInput.PurchasePriceInput;
import userInput.WinningNumbersInput;

public class LottoGame {
    public static void main(String[] args) {
        int purchasePrice = new PurchasePriceInput().getPrice();
        Cashier cashier = new Cashier(purchasePrice);
        LottoTickets lottoTickets = new LottoTickets(cashier.getNumberOfTickets());
        cashier.showInfo();
        lottoTickets.showAll();

        Lotto winningNumbers = new WinningNumbersInput().getWinningNumbers();
        int bonusNo = new BonusBallInput(winningNumbers).getBonusNo();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNo);
        new LottoStatistics(winningLotto, lottoTickets).show();
    }
}
