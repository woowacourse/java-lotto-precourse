package domain;

import java.util.*;

public class Game {
    private final String[] SENTENCE = {
            "구입금액을 입력해 주세요.",
            "개를 구매했습니다.",
            "지난 주 당첨 번호를 입력해 주세요.",
            "보너스 볼을 입력해 주세요.",
            "당첨 통계\n" + "---------",
            "총 수익률은 ",
            "입니다."
    };

    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();

    private List<Lotto> lottos = new ArrayList<>();
    private WinningLotto winningLotto;
    private int gameNum;

    protected void execute() {
        setGameNum();

        for (int i = 0; i < gameNum; i++) {
            lottos.add(generateLotto());
        }
        printLottos();

    }

    private void printLottos() {
        System.out.println(gameNum + SENTENCE[1]);

        for (int i = 0; i < gameNum; i++) {
            lottos.get(i).print();
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

    private void setGameNum() {
        System.out.println(SENTENCE[0]);

        int total = sc.nextInt();
        sc.nextLine();
        gameNum = total / 1000;

        System.out.println();
    }
}
