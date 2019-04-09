package domain;

import java.io.IOException;
import java.util.*;

public class LottoTickets {
    private static final int PRICE_OF_LOTTO = 1000;
    private static final int LOWER_BOUND_OF_CHANGE = 0;
    private static final int TIME_TO_BREAK = 300;
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
        pause();
        System.out.println();
    }

    private void generateTickets(int numberOfTickets) {
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> numbers = generateLottoNumbers();
            tickets.add(new Lotto(numbers));
        }
    }

    private List<Integer> generateLottoNumbers() {
        Set<Integer> numbers = new TreeSet<>();
        while (numbers.size() != Lotto.SIZE_OF_LOTTO) {
            numbers.add((int) (Math.random() * Lotto.LAST_NUMBER) + Lotto.FIRST_NUMBER);
        }

        return new ArrayList<>(numbers);
    }

    public void showAll() {
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println(tickets.get(i).toString());
            sleep(TIME_TO_BREAK);
        }
        System.out.println();
    }

    private void pause() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sleep(int timeToBreak) {
        try {
            Thread.sleep(timeToBreak);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
