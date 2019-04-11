package domain;

import java.util.*;
import java.util.stream.Collectors;

public class UserInput {
    private Scanner scanner;
    private List<Integer> winningNumbers;

    UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public int TryToRecievePurchaseAmount() throws IllegalArgumentException {
        System.out.println("구매금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();

        if (Validator.isValidPurchaseAmount(purchaseAmount)) {
            return purchaseAmount;
        }

        throw new IllegalArgumentException();
    }

    public List<Integer> TryToRecieveWinningNumber() throws IllegalArgumentException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String winningNumber = scanner.nextLine();

        List<String> stringWinningNumbers = Arrays.asList(winningNumber.split(","));
        winningNumbers = ConvertListTypeToInt(stringWinningNumbers);

        if (Validator.isValidWinningNumbers(winningNumbers)) {
            return winningNumbers;
        }

        throw new IllegalArgumentException();
    }


    public int TryToRecieveBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        if (Validator.isValidRangeLottoNumber(bonusNumber)
                && Validator.isNotOverlapLottoNumber(winningNumbers, bonusNumber)) {
            return bonusNumber;
        }

        throw new IllegalArgumentException();
    }

    public List<Integer> ConvertListTypeToInt(List<String> stringWinningNumbers) {
        List<Integer> WinningNumbers = stringWinningNumbers.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return WinningNumbers;
    }
}
