package domain;

import java.util.*;

public class Game {
    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();

    private List<Lotto> lottos = new ArrayList<>();

    protected void execute() {
        int gameNum = setGameNum();

        for (int i = 0; i < gameNum; i++) {
            lottos.add(generateLotto());
        }

    }

    private Lotto generateLotto() {
        Set<Integer> set = new HashSet<>();

        while (set.size() < 6) {
            set.add(random.nextInt(45) + 1);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        return new Lotto(list);
    }

    private int setGameNum() {
        int total = sc.nextInt();
        sc.nextLine();

        return total / 1000;
    }
}
