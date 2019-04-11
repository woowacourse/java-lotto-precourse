package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static domain.LottoManager.*;

/**
 * 사용자 입력에 대한 유효성 검사를 담당하는 객체
 */
public class Validator {
    private final int ZERO = 0;
    private final String NUMBER_FORMAT_EXCEPTION_MESSAGE
            = "입력이 올바르지 않습니다. 정수인지, 수가 너무 크지는 않은지 확인해주세요.\n";
    private final String RANGE_EXCEPTION_MESSGAE = "1부터 45까지의 숫자들만 입력할 수 있습니다.\n";

    private boolean isInteger(String str, String exceptionMessage) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.print(exceptionMessage);
            return false;
        }
    }

    private boolean isEnough(int purchaseAmount) {
        if (purchaseAmount < PRICE_PER_LOTTO) {
            System.out.println("고작 그정도 돈으로는 로또를 살 수 없습니다. 적어도 1000원은 있어야 해요.");
            return false;
        }
        return true;
    }

    private boolean isMultipleOfLottoPrice(int purchaseAmount) {
        if (purchaseAmount % PRICE_PER_LOTTO != ZERO) {
            System.out.println("거스름돈을 드리기 애매합니다. 로또 가격인 1000원의 배수로만 입력해주세요.");
            return false;
        }
        return true;
    }

    public boolean takesValidPurchase(String userInput) {
        int purchaseAmount;

        if (isInteger(userInput, NUMBER_FORMAT_EXCEPTION_MESSAGE)) {
            purchaseAmount = Integer.parseInt(userInput);
            return isEnough(purchaseAmount) && isMultipleOfLottoPrice(purchaseAmount);
        }
        return false;
    }

    private boolean isIntegerList(List<String> userInput) {
        List<String> numerics = userInput.stream()
                .filter(str -> isInteger(str, ""))
                .collect(Collectors.toList());

        if(numerics.size() != userInput.size()) {
            System.out.print(NUMBER_FORMAT_EXCEPTION_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isInRange(int number, String exceptionMessage) {
        if ((number < WINNING_NUMBER_ORIGIN)
                || (number > WINNING_NUMBER_BOUND)) {
            System.out.print(exceptionMessage);
            return false;
        }
        return true;
    }

    private boolean isInRange(List<Integer> winningNumbers) {
        List<Integer> outbounds = winningNumbers.stream()
                .filter(number -> !isInRange(number, ""))
                .collect(Collectors.toList());

        if (outbounds.size() > 0) {
            System.out.print(RANGE_EXCEPTION_MESSGAE);
            return false;
        }
        return true;
    }

    private boolean hasValidSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUM_OF_WINNING_NUMBERS) {
            System.out.println(NUM_OF_WINNING_NUMBERS
                    + "개의 숫자를 쉼표로 구분해 입력해주세요.");
            return false;
        }
        return true;
    }

    private boolean hasDuplicateNumbers(List<Integer> winningNumbers) {
        Set<Integer> winningNumberSet = new HashSet<Integer>(winningNumbers);

        if (winningNumberSet.size() != winningNumbers.size()) {
            System.out.println("중복되는 숫자는 포함할 수 없습니다.");
            return true;
        }
        return false;
    }

    public boolean takesValidWinningNumbers(List<String> userInput) {
        List<Integer> winningNumbers;

        if (isIntegerList(userInput)) {
            winningNumbers = userInput.stream().map(Integer::parseInt).collect(Collectors.toList());
            return isInRange(winningNumbers) && hasValidSize(winningNumbers)
                    && !hasDuplicateNumbers(winningNumbers);
        }
        return false;
    }

    private boolean isContainedIn(List<Integer> winningNumbers, int bonus) {
        if (winningNumbers.contains(bonus)) {
            System.out.println("당첨 번호와 중복되는 숫자는 입력할 수 없습니다.");
            return true;
        }
        return false;
    }

    public boolean takesValidBonusNo(String userInput, List<Integer> winningNumbers) {
        int bonusNo;

        if (isInteger(userInput, NUMBER_FORMAT_EXCEPTION_MESSAGE)) {
            bonusNo = Integer.parseInt(userInput);
            return isInRange(bonusNo, RANGE_EXCEPTION_MESSGAE)
                    && !isContainedIn(winningNumbers, bonusNo);
        }
        return false;
    }
}