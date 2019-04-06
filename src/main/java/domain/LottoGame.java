package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LottoGame {
    private static int MAX_RANDOM = 44;
    private static int LOTTO_NUMBER_COUNT = 6;
    private int userInput;
    private List<Lotto> LottoList = new ArrayList<>();
    public LottoGame() {
        userInput = userInputPurchase();
        issueLotto();
    }

    private int userInputPurchase() {
        int purchase = userInputStringToInt();
        while (!userInputVerify(purchase)) {
            System.out.println("잘못된 금액을 입력하셧습니다.");
            purchase = userInputStringToInt();
        }
        return purchase;
    }

    private boolean userInputVerify(int userInput) {
        if (userInput <= 0 || userInput % 1000 != 0) {
            return false;
        }
        return true;
    }

    private int userInputStringToInt() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("구입 금액을 입력해주세요");
            String userInput = scanner.nextLine();
            int result = Integer.parseInt(userInput);
            return result;
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private void issueLotto() {
        final int NUMBER_LOTTO = this.userInput / 1000;
        System.out.println(NUMBER_LOTTO + "를 구입했습니다.");
        for (int i = 0; i < NUMBER_LOTTO; i++) {
            LottoList.add(new Lotto(makeRandomNumbers()));
        }
        for (int i = 0; i < LottoList.size(); i++) {
            System.out.println(LottoList.get(i).toString());
        }
    }

    private List<Integer> makeRandomNumbers() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            numbers.add(random.nextInt(MAX_RANDOM) + 1);
        }
        return numbers;
    }
}
