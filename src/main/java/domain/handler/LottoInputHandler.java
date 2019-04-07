package domain.handler;

import java.util.Scanner;

import domain.validator.LottoInputValidator;
import domain.validator.PurchaseAmountValidator;
import domain.validator.Validator;

public class LottoInputHandler {

    private final Scanner scanner;
    private Validator validator;

    public LottoInputHandler() {
        scanner = new Scanner(System.in);
        validator = null;
    }

    public int getPurchaseAmount() {
        return getValidPurchaseAmount();
    }

    private int getValidPurchaseAmount() {
        String validInput = null;
        int purchaseAmount;
        do {
            validInput = getValidUserInput();
            purchaseAmount = parseIntFromUserInputString(validInput);
            validator = new PurchaseAmountValidator(purchaseAmount);
        } while (!validator.doesValid());
        return purchaseAmount;
    }

    private String getValidUserInput() {
        String input = null;
        do {
            System.out.println("구입금액을 입력해 주세요.");   // TODO 출력을 담당하는 클래스에게 위임
            input = getUserInputString();
            validator = new LottoInputValidator(input);
        } while (!validator.doesValid());
        return input;
    }

    private String getUserInputString() {
        return scanner.nextLine();
    }

    private int parseIntFromUserInputString(String input) {
        return Integer.parseInt(input);
    }
}
