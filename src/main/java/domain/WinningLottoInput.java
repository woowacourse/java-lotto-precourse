package domain;

import java.util.*;
import java.util.regex.Pattern;

public class WinningLottoInput {

    private TreeSet<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLotto decideWinningLotto() {
        inputWinningLotto();
        return createWinningLotto();
    }

    private void inputWinningLotto() {
        inputLastWinningLotto();
        inputBonusNumber();
    }

    private void inputLastWinningLotto() {
        String winningLottoInput;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            winningLottoInput = sc.nextLine().replace(" ", "");
        } while (checkValidWinningLottoInput(winningLottoInput) == false);
    }

    private boolean checkValidWinningLottoInput(String winningLotto) {
        winningNumbers = new TreeSet<>();

        if (isDividedComma(winningLotto) == false) {
            System.out.println("쉼표(,)로 구분하여 6자리를 입력해 주세요.");
            return false;
        }
        addElementIntoSet(winningLotto, winningNumbers);

        return isValidAllElement(winningNumbers);
    }

    private boolean isDividedComma(String numbers) {
        String pattern = Constant.SIX_NUMBERS_DIVIDED_COMMA_PATTERNS;
        return Pattern.matches(pattern, numbers);
    }

    private void addElementIntoSet(String numbers, TreeSet<Integer> box) {
        String[] dividedNumbers = numbers.split(",");

        for (int i = 0; i < dividedNumbers.length; i++) {
            box.add(Integer.parseInt(dividedNumbers[i]));
        }
    }

    private boolean isValidAllElement(TreeSet<Integer> box) {
        boolean isUniqueAndValidRange = true;

        if (hasDuplicatedElement(box)) {
            System.out.println("중복된 숫자가 존재합니다.");
            isUniqueAndValidRange = false;
        } else if (hasOutRangeElement(box)) {
            System.out.println("1부터 45 사이의 숫자만 입력해 주세요.");
            isUniqueAndValidRange = false;
        }
        return isUniqueAndValidRange;
    }

    private boolean hasDuplicatedElement(TreeSet<Integer> box) {
        return box.size() != Constant.LOTTO_NUMBER_SIZE;
    }

    /* 유효한 범위의 원소 개수를 카운트하여 판별 */
    private boolean hasOutRangeElement(TreeSet<Integer> box) {
        int validRangeNumCount = 0;

        Iterator<Integer> iter = box.iterator();
        while (iter.hasNext()) {
            validRangeNumCount += plusIfElementInRange(iter.next());
        }
        return validRangeNumCount != Constant.LOTTO_NUMBER_SIZE;
    }

    private int plusIfElementInRange(int boxElement) {
        int valueIfElementInRange = 0;

        if (boxElement >= Constant.MINIMUM_LOTTO_NUMBER
                && boxElement <= Constant.MAXIMUM_LOTTO_NUMBER) {
            valueIfElementInRange = 1;
        }
        return valueIfElementInRange;
    }

    private void inputBonusNumber() {
        String bonusNumberInput;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("보너스 볼을 입력해 주세요.");
            bonusNumberInput = sc.nextLine();
        } while (checkValidBonusNumberInput(bonusNumberInput) == false);

        bonusNumber = Integer.parseInt(bonusNumberInput);
    }

    private boolean checkValidBonusNumberInput(String number) {
        return isValidBonusNumber(number)
                && isUniqueWinningNumber(number);
    }

    private boolean isValidBonusNumber(String number) {
        boolean isValidNumberAndInRange = true;

        if (isBonusNumberPattern(number) == false) {
            System.out.println("숫자를 입력해주세요.");
            isValidNumberAndInRange = false;
        } else if (isOutRangeNumber(Integer.parseInt(number))) {
            System.out.println("1부터 45 사이의 숫자만 입력해 주세요.");
            isValidNumberAndInRange = false;
        }
        return isValidNumberAndInRange;
    }

    private boolean isBonusNumberPattern(String number) {
        String pattern = Constant.BONUS_NUMBER_PATTERNS;
        return Pattern.matches(pattern, number);
    }

    private boolean isOutRangeNumber(int number) {
        return number < Constant.MINIMUM_LOTTO_NUMBER
                || number > Constant.MAXIMUM_LOTTO_NUMBER;
    }

    private boolean isUniqueWinningNumber(String number) {
        boolean isUniqueNumber = true;

        if (winningNumbers.contains(Integer.parseInt(number))) {
            System.out.println("당첨 번호에 중복된 수가 존재합니다.");
            isUniqueNumber = false;
        }
        return isUniqueNumber;
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumberList = new ArrayList<>(winningNumbers);

        Lotto lotto = new Lotto(winningNumberList);

        return new WinningLotto(lotto, bonusNumber);
    }
}
