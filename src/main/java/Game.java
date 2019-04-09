import domain.Lotto;
import domain.UserInput;

import java.util.Scanner;

public class Game {
    static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    static final String NOT_PURCHASE_AMOUNT_ERROR = "1000 이상의 숫자를 입력해 주세요.";

    public static int getPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        Scanner s =  new Scanner(System.in);
        String input;
        do {
            input = s.nextLine();
        }while(!isThereErrorInPurchaseAmount(input));

        return Integer.parseInt(input);
    }

    private static boolean isThereErrorInPurchaseAmount(String input) {
        if(UserInput.isInRange(input, Lotto.PRICE)) {
            return true;
        }
        System.out.println(NOT_PURCHASE_AMOUNT_ERROR);
        return false;
    }

}
