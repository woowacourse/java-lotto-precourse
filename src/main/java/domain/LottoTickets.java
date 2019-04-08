package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    public static final int PRICE_OF_LOTTO = 1000;
    public static final int LOWER_BOUND_OF_CHANGE = 0;
    private List<Lotto> tickets = new ArrayList<>();

    public LottoTickets(int purchasePrice) {
        int numberOfTickets = calculateNumberOfTickets(purchasePrice);
        showTicketsAndChanges(numberOfTickets, purchasePrice);

    }

    private int calculateNumberOfTickets(int purchasePrice) {
        return (purchasePrice / PRICE_OF_LOTTO);
    }

    private void showTicketsAndChanges(int numberOfTickets, int purchasePrice) {
        System.out.print(numberOfTickets + "개를 구매했습니다. ");
        int change = purchasePrice - (numberOfTickets * PRICE_OF_LOTTO);
        if (change > LOWER_BOUND_OF_CHANGE) {
            System.out.print("잔돈은 " + change + "원입니다.");
        }
        System.out.println();
    }
}
