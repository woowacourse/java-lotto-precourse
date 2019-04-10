package domain;

import userInput.PurchasePriceInput;

import java.util.List;

public class LottoBuyer {
    private static final int TIME_TO_BREAK = 300;
    private int purchasePrice;
    private List<Lotto> tickets;

    public LottoBuyer() {
        purchasePrice = PurchasePriceInput.takeMoney();
    }

    public void showAllTickets() {
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println(tickets.get(i).toString());
            sleep(TIME_TO_BREAK);
        }
        System.out.println();
    }

    private void sleep(int timeToBreak) {
        try {
            Thread.sleep(timeToBreak);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }
}
