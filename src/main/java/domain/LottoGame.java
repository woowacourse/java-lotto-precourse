package domain;

import userInput.BonusBallInput;
import userInput.PurchasePriceInput;
import userInput.WinningNumbersInput;

public class LottoGame {
    public static void main(String[] args) {
        int purchasePrice = new PurchasePriceInput().getPrice();
        LottoTickets lottoTickets = new LottoTickets(purchasePrice);
        lottoTickets.showNumberOfTicketsAndChanges();
        lottoTickets.showAll();

        Lotto winningNumbers = new WinningNumbersInput().getWinningNumbers();
        int bonusNo = new BonusBallInput(winningNumbers).getBonusNo();

    }
}
