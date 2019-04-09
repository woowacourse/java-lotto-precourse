package domain;

import java.util.Scanner;
import java.util.regex.Pattern;

public class User {

    public static final Scanner sc = new Scanner(System.in);

    private int amountLotto;

    public User() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        String price;

        do {
            System.out.println("구입금액을 입력해 주세요.");
            price = sc.nextLine();
        } while (checkPrice(price));

        calculateAmountLotto(Integer.parseInt(price));
    }

    private boolean checkPrice(String price) {
        boolean reInput = false;
        if (!isValidPrice(price)) {
            System.out.println("구입금액은 1,000 단위 입니다.");
            reInput = true;
        }
        return reInput;
    }

    /**
     * pattern :
     * 1. 입력이 없거나 공백일 수 없다.
     * 2. 입력은 정수여야 한다.
     * 3. 입력은 음수가 아니다.
     * 4. 1,000 의 배수
     *
     * @return
     */
    private boolean isValidPrice(String invalidInput) {
        String naturalNumPattern = "^[0-9]+000$";
        return Pattern.matches(naturalNumPattern, invalidInput);
    }

    private void calculateAmountLotto(int price) {
        amountLotto = price / 1000;
    }
}
