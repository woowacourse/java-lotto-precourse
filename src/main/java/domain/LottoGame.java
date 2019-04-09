package domain;

import userInput.PurchasePriceInput;
import userInput.WinningNumbersInput;

import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        int purchasePrice = new PurchasePriceInput().getPrice();
        LottoTickets lottoTickets = new LottoTickets(purchasePrice);
        lottoTickets.showNumberOfTicketsAndChanges();
        lottoTickets.showAll();

        List<Integer> winningNumbers = new WinningNumbersInput().getNumbers();
        
    }
}
