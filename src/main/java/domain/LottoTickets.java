package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoTickets {
    private static final int TIME_TO_BREAK = 300;
    private List<Lotto> tickets = new ArrayList<>();

    public LottoTickets(int numberOfTickets) {
        generateTickets(numberOfTickets);
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

    private void sleep(int timeToBreak) {
        try {
            Thread.sleep(timeToBreak);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
