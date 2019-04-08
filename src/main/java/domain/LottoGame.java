package domain;

import userInput.PurchasePriceInput;
import userInput.WinningNumbersInput;

public class LottoGame {
    public static void main(String[] args) {
        int purchasePrice = new PurchasePriceInput().getPrice();
        LottoTickets lottoTickets = new LottoTickets(purchasePrice);
        lottoTickets.showNumberOfTicketsAndChanges();
        lottoTickets.showAll();
        new WinningNumbersInput();
    }
}
