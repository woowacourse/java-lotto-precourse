package domain;

import java.io.IOException;

public class Cashier {
    private static final int PRICE_OF_LOTTO = 1000;
    private static final int LOWER_BOUND_OF_CHANGE = 0;
    private int purchasePrice;
    private int numberOfTickets;

    public Cashier(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        this.numberOfTickets = calculateNumberOfTickets();
    }

    private int calculateNumberOfTickets() {
        return (purchasePrice / PRICE_OF_LOTTO);
    }

    public void showInfo() {
        System.out.print(numberOfTickets + "개를 구매했습니다. ");
        int change = purchasePrice % PRICE_OF_LOTTO;
        if (change > LOWER_BOUND_OF_CHANGE) {
            System.out.print("잔돈은 " + change + "원입니다.");
        }
        pause();
        System.out.println();
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    private void pause() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
