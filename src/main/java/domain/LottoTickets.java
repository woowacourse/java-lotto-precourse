package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTickets {
    public static final int PRICE_OF_LOTTO = 1000;
    public static final int LOWER_BOUND_OF_CHANGE = 0;
    private List<Lotto> tickets = new ArrayList<>();
    private int purchasePrice;

    public LottoTickets(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        int numberOfTickets = calculateNumberOfTickets();
        generateTickets(numberOfTickets);
    }

    private int calculateNumberOfTickets() {
        return (purchasePrice / PRICE_OF_LOTTO);
    }

    public void showNumberOfTicketsAndChanges() {
        System.out.print(tickets.size() + "개를 구매했습니다. ");
        int change = purchasePrice % PRICE_OF_LOTTO;
        if (change > LOWER_BOUND_OF_CHANGE) {
            System.out.print("잔돈은 " + change + "원입니다.");
        }
        System.out.println();
    }

    private void generateTickets(int numberOfTickets) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(new Lotto(numbers));
        }
    }
}
