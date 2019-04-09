package domain.handler;

import java.util.Scanner;
import java.util.Arrays;

import domain.validator.BonusNumValidator;
import domain.validator.PurchaseAmountValidator;
import domain.validator.Validator;
import domain.validator.WinningNumValidator;

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

    public int[] getWinningNums() {
        return getValidWinningNums();
    }

    public int getBonusNum() {
        return getValidBonusNum();
    }

    private int getValidBonusNum() {
        String bonusNum = null;
        do {
            LottoOutputHandler.printMessage("보너스 볼을 입력해 주세요.");
            bonusNum = getUserInputString();
            validator = new BonusNumValidator(bonusNum);
        } while (!validator.doesValid());

        return convertStringToInt(bonusNum);
    }

    private int[] getValidWinningNums() {
        String[] winningNums = null;
        do {
            LottoOutputHandler.printMessage("지난 주 당첨 번호를 입력해 주세요.");
            winningNums = getUserInputArrayWithDelimiter(getUserInputString(), ",");
            validator = new WinningNumValidator(winningNums);
        } while (!validator.doesValid());

        return convertStringArrayToInt(winningNums);
    }

    private int getValidPurchaseAmount() {
        String purchaseAmount = null;
        do {
            LottoOutputHandler.printMessage("구입금액을 입력해 주세요.");
            purchaseAmount = getUserInputString();
            validator = new PurchaseAmountValidator(purchaseAmount);
        } while (!validator.doesValid());

        return convertStringToInt(purchaseAmount);
    }

    private String getUserInputString() {
        return scanner.nextLine();
    }

    private String[] getUserInputArrayWithDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }

    private int convertStringToInt(String str) {
        return Integer.parseInt(str);
    }

    private int[] convertStringArrayToInt(String[] stringArray) {
        return Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();
    }
}
