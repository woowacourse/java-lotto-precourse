package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoGenerator {
    private List<Lotto> tickets = new ArrayList<>();

    public LottoGenerator(int numberOfTickets) {
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
        while (numbers.size() != Lotto.SIZE) {
            numbers.add((int) (Math.random() * Lotto.LAST_NUMBER) + Lotto.FIRST_NUMBER);
        }

        return new ArrayList<>(numbers);
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
