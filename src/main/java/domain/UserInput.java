package domain;

import java.util.*;
import java.util.stream.Collectors;

public class UserInput {
    private Scanner scanner = new Scanner(System.in);
    private List<Integer> winningNumbers;

    public int RecievePurchaseAmount() {
        int purchaseAmount = 0;

        try {
            purchaseAmount = TryToRecievePurchaseAmount();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return purchaseAmount;
    }

    private int TryToRecievePurchaseAmount() throws IllegalArgumentException {
        System.out.println("구매금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();

        if (Validator.isValidPurchaseAmount(purchaseAmount)) {
            return purchaseAmount;
        }

        throw new IllegalArgumentException(purchaseAmount + "는 유효하지 않은 값입니다.");
    }

    public List<Integer> RecieveWinningNumber() {
        List<Integer> winningNumbers = new ArrayList<>();

        try {
            winningNumbers = TryToRecieveWinningNumber();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return winningNumbers;
    }

    private List<Integer> TryToRecieveWinningNumber() throws IllegalArgumentException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String winningNumber = scanner.nextLine();

        List<String> stringWinningNumbers = Arrays.asList(winningNumber.split(","));
        winningNumbers = ConvertListTypeToInt(stringWinningNumbers);

        if (Validator.isValidWinningNumbers(winningNumbers)) {
            return winningNumbers;
        }

        throw new IllegalArgumentException(winningNumber + "은 유효하지 않은 값입니다.");
    }

    public int RecieveBonusNumber() {
        int bonusNumber = 0;

        try {
            bonusNumber = TryToRecieveBonusNumber();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return bonusNumber;
    }

    private int TryToRecieveBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        if (Validator.isValidRangeLottoNumber(bonusNumber)
                && Validator.isNotOverlapLottoNumber(winningNumbers, bonusNumber)) {
            return bonusNumber;
        }

        throw new IllegalArgumentException(bonusNumber + "은 유효하지 않은 값입니다.");
    }

    private List<Integer> ConvertListTypeToInt(List<String> stringWinningNumbers) {
        List<Integer> WinningNumbers = stringWinningNumbers.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return WinningNumbers;
    }
}
