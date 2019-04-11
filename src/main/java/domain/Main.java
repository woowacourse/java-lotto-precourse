package domain;

import java.util.Scanner;

public class Main {
    final static int LOTTO_PRICE = 1000;
    static private Scanner staticSc;

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

    public static void main(String[] args) {

    }
}
