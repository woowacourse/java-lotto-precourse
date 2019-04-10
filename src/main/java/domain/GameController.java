package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    private static final int LOTTO_PRICE = 1000;

    public void startGame() {
        List<List<Integer>> purchaseLottoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        assignPurchaseLottoList(purchasePrice(scanner), purchaseLottoList);

    }

    private int purchasePrice(Scanner scanner) {
        System.out.println("구입 금액을 입력해 주세요.");
        return (scanner.nextInt() / LOTTO_PRICE);
    }

    private void assignPurchaseLottoList(int numberOfPrice, List<List<Integer>> purchaseLottoList) {
        System.out.println("\n" + numberOfPrice + "개를 구매했습니다.");

        for (int i = 0; i < numberOfPrice; i++) {
            Lotto assignLotto = new Lotto(new ArrayList<>());
            purchaseLottoList.add(assignLotto.getLottoNumber());
        }

    }


}
