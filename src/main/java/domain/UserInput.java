/*
 * UserInput
 *
 * version 1.1
 *
 * 2019/04/10
 */

package domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 로또 번호를 발급받기 위해 사용자로부터 구입 금액을 입력받는 클래스
 *
 * @author 김성훈
 * @version 1.0 2019/04/10  사용자의 입력을 받는다. 1000원 단위의 숫자외 경우에 대한 예외처리 구현
 *          1.1 2019/04/11  지난 주 당첨 번호와 보너스 숫자를 입력받는다. 입력 형식, 범위, 갯수, 중복에 대한 예외처리 구현
 */
public class UserInput {
    private static final int PRICE_PER_LOTTO = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private Scanner sc = new Scanner(System.in);

    public int inputPurchasePrice() {
        try {
            return checkPriceUnit(setPrice());
        } catch (UserInputException e) {
            e.printErrorMessage();
            return inputPurchasePrice();
        }
    }

    private int setPrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new UserInputMismatchException();
        }
    }

    private int checkPriceUnit(int totalPrice) {
        if ((totalPrice % PRICE_PER_LOTTO) != 0) {
            throw new UserInputPriceUnitException(totalPrice);
        }
        return totalPrice / PRICE_PER_LOTTO;
    }

    public List<Integer> inputWinningNumbers() {
        try {
            List<Integer> winningNumbers = setWinningNumber();
            checkIfWinningNumbersInRange(winningNumbers);
            return isUnderSixLength(winningNumbers);
        } catch (UserInputException e) {
            e.printErrorMessage();
            return inputWinningNumbers();
        }
    }

    private List<Integer> setWinningNumber() {
        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            String[] inputWinningNumber = sc.nextLine().replaceAll(" ", "").split(",");
            return checkDuplicateWinningNumbers(parseStringArrayToInteger(inputWinningNumber));
        } catch (UserInputException e) {
            e.printErrorMessage();
            return setWinningNumber();
        }
    }

    private List<Integer> parseStringArrayToInteger(String[] winningNumbers) {
        try {
            return Arrays.stream(winningNumbers).map(Integer::valueOf).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new UserInputMismatchException();
        }
    }

    public int inputBonusNumber(List<Integer> list) {
        try {
            int bonusNumber = setBonus();
            checkIfNumberInRange(bonusNumber);
            return checkDuplicateBonusNumber(list, bonusNumber);
        } catch (UserInputException e) {
            e.printErrorMessage();
            return inputBonusNumber(list);
        }
    }

    private int setBonus() {
        try {
            System.out.println("보너스 볼을 입력해 주세요.");
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new UserInputMismatchException();
        }
    }

    private List<Integer> isUnderSixLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new UserInputWinningNumberSizeException();
        }
        return winningNumbers;
    }

    private List<Integer> checkDuplicateWinningNumbers(List<Integer> winningNumbers) {
        List<Integer> distinctList = winningNumbers.parallelStream().distinct().collect(Collectors.toList());
        if (winningNumbers.size() != distinctList.size()) {
            throw new UserInputDuplicateNumberException();
        }
        return winningNumbers;
    }

    private int checkDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new UserInputDuplicateNumberException();
        }
        return bonusNumber;
    }

    private void checkIfWinningNumbersInRange(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            checkIfNumberInRange(winningNumber);
        }
    }

    private void checkIfNumberInRange(int number) {
        if (!(LOTTO_NUMBER_MIN <= number && number <= LOTTO_NUMBER_MAX)) {
            throw new UserInputNumberRangeException();
        }
    }
}
