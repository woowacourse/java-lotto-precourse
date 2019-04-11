package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    final static int LOTTO_PRICE = 1000;
    static private WinningLotto winningLotto;
    static private Scanner staticSc;
    static private List<Lotto> lottoList;
    static private List<Integer> numSeq;
    static private Map<Rank, Integer> rankMap;

    private Scanner getScanner() {
        if (staticSc == null) {
            staticSc = new Scanner(System.in);
        }

        return staticSc;
    }

    private int getTrials() {
        int value, trials;
        Scanner sc = getScanner();
        System.out.println("구입금액을 입력해주세요.");

        value = sc.nextInt();
        trials = (int)Math.floor(value / LOTTO_PRICE);

        return trials;
    }

    private void initNumSeq() {
        numSeq = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            numSeq.add(i + 1);
        }
    }

    private void shuffleNumSeq() {
        if (numSeq == null) {
            initNumSeq();
        }

        for (int i = 0; i < 45; i++) {
            int tmp = numSeq.get(i);
            int target = (int)(Math.random() * (45 - i)) + i;
            numSeq.set(target, numSeq.get(i));
            numSeq.set(i, tmp);
        }
    }

    private Lotto buyLotto() {
        shuffleNumSeq();
        return new Lotto(numSeq.subList(0, 5));
    }

    private void buyMultipleLotto(int trials) {
        lottoList = new ArrayList<>();
        System.out.println(String.format("%d 개를 구매했습니다.", trials));
        for (int i = 0; i < trials; i++) {
            Lotto tmp = buyLotto();
            System.out.println(tmp.toString());
            lottoList.add(tmp);
        }
    }

    private List<Integer> separateToList(String str) {
        return Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private void getWinningLotto() {
        Scanner sc = getScanner();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> numList = separateToList(sc.next());

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = sc.nextInt();

        winningLotto = new WinningLotto(new Lotto(numList), bonus);
    }


    public static void main(String[] args) {

    }
}
