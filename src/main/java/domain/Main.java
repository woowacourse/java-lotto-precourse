package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    final static int LOTTO_PRICE = 1000;
    static private Scanner staticSc;
    static private List<Lotto> lottoList;
    static private List<Integer> numSeq;

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


    public static void main(String[] args) {

    }
}
