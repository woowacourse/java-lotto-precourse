package domain.handler;

import java.util.List;
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

    public int getBonusNum(List<Integer> winningNumList) {
        return getValidBonusNum(winningNumList);
    }

    private int getValidBonusNum(List<Integer> winningNumList) {
        String bonusNum = null;
        do {
            LottoOutputHandler.printMessage("보너스 볼을 입력해 주세요.");
            bonusNum = getUserInputString();
            validator = new BonusNumValidator(bonusNum, winningNumList);
        } while (!validator.doesValid());

        return convertStringToInt(bonusNum);
    }

    private int[] getValidWinningNums() {
        String[] winningNums = null;
        do {
            LottoOutputHandler.printMessage("지난 주 당첨 번호를 입력해 주세요.");
            winningNums = getUserInputWithDelimiter(getUserInputString(), ",");
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

    private String[] getUserInputWithDelimiter(String input, String delimiter) {
        String[] inputArray = input.split(delimiter);
        eraseCharacterExcludingDigits(inputArray);

        return inputArray;
    }

    private void eraseCharacterExcludingDigits(String[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = inputs[i].replaceAll("\\s", "");
        }
    }

    private int convertStringToInt(String str) {
        return Integer.parseInt(str);
    }

    private int[] convertStringArrayToInt(String[] stringArray) {
        return Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();
    }
}
