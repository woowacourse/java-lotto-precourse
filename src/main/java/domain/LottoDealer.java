package domain;

import java.io.IOException;
import java.util.List;

public class LottoDealer {
    private static final int LOWER_BOUND_OF_CHANGE = 0;

    public List<Lotto> sellTickets(int purchasePrice) {
        int numberOfTickets = calculateNumberOfTickets(purchasePrice);
        System.out.print(numberOfTickets + "개를 구매했습니다. ");
        int change = purchasePrice % Lotto.PRICE;
        if (change > LOWER_BOUND_OF_CHANGE) {
            System.out.print("잔돈은 " + change + "원입니다.");
        }
        pause();
        System.out.println();
        return new LottoGenerator(numberOfTickets).getTickets();
    }

    private int calculateNumberOfTickets(int purchasePrice) {
        return (purchasePrice / Lotto.PRICE);
    }

    private void pause() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
