package domain;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PurchaseInput {

    public PurchaseInput() {

    }

    public int purchaseLotto() {
        String price;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("구입금액을 입력해 주세요.");
            price = sc.nextLine();
        } while (checkValidPriceInput(price));

        return calculateAmountLotto(Integer.parseInt(price));
    }

    private boolean checkValidPriceInput(String price) {
        boolean shouldInputAgain = false;

        if (!isValidPrice(price)) {
            System.out.println("구입금액은 1,000 단위 입니다.");
            shouldInputAgain = true;
        }
        return shouldInputAgain;
    }

    private boolean isValidPrice(String invalidInput) {
        String pattern = ConstValue.MULTIPLE_THOUSAND_PATTERNS;
        return Pattern.matches(pattern, invalidInput);
    }

    private int calculateAmountLotto(int price) {
        return price / 1000;
    }
}
