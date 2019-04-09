package domain;

import java.util.*;

public class Game {

    private int inputPrice;
    private int purchaseCount;
    private Lotto[] lottos;

    public void run() {
        do {
            buyLotto();
        } while (printPurchaseCount());

        createLottoObjectArray();
    }

    private void buyLotto() {
        Scanner sc = new Scanner(System.in);

        try {
            inputPrice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("올바른 숫자가 아닙니다.");
            buyLotto();
        }
    }

    private boolean printPurchaseCount() {
        purchaseCount = inputPrice / 1000;

        if (purchaseCount <= 0) {
            System.out.println("로또를 살 수 없습니다.");
            return true;
        }

        System.out.println(purchaseCount + "개를 구매했습니다.");
        return false;
    }

    private void createLottoObjectArray() {
        lottos = new Lotto[purchaseCount];
    }

    private boolean checkSizeNumbers(List<Integer> numbers) {
        if (numbers.size() == 6) {
            return false;
        }

        return true;
    }
}
