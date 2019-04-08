package domain;

public class LottoGame {


    public static void main(String[] args) {
        int purchasePrice = new Purchasing().getPrice();
        LottoTickets lottoTickets = new LottoTickets(purchasePrice);
        lottoTickets.showNumberOfTicketsAndChanges();
        lottoTickets.showAll();
    }
}
