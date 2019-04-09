package domain;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class WinningLottoInput {

    private TreeSet<Integer> checkSameElementBox;

    public void inputWinningLotto() {
        inputLastWinningLotto();
        inputBonusNumber();

        Iterator<Integer> iter = checkSameElementBox.iterator();
        while (iter.hasNext()) {
            System.out.printf(iter.next() + " ");
        }
    }

    private void inputLastWinningLotto() {
        String winningLottoInput;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            winningLottoInput = sc.nextLine().replace(" ", "");
        } while (!checkValidWinningLottoInput(winningLottoInput));
    }

    private boolean checkValidWinningLottoInput(String winningLotto) {
        checkSameElementBox = new TreeSet<>();

        if (!isDividedComma(winningLotto)) {
            System.out.println("쉼표(,)로 구분하여 6자리를 입력해 주세요.");
            return false;
        }
        addElementIntoSet(winningLotto, checkSameElementBox);

        return isValidElement(checkSameElementBox);
    }

    private boolean isDividedComma(String numbers) {
        String pattern = ConstValue.SIX_NUMBERS_DIVIDED_COMMA;
        return Pattern.matches(pattern, numbers);
    }

    private void addElementIntoSet(String numbers, TreeSet<Integer> box) {
        String[] dividedNumbers = numbers.split(",");

        for (int i = 0; i < dividedNumbers.length; i++) {
            box.add(Integer.parseInt(dividedNumbers[i]));
        }
    }

    private boolean isValidElement(TreeSet<Integer> box) {
        boolean validElement = true;

        if (isDuplicatedNumbers(box)) {
            System.out.println("중복된 숫자가 존재합니다.");
            validElement = !validElement;
        } else if (isContainOutRangeNumber(box)) {
            System.out.println("1부터 45 사이의 숫자만 입력해 주세요.");
            validElement = !validElement;
        }
        return validElement;
    }

    private boolean isDuplicatedNumbers(TreeSet<Integer> box) {
        return box.size() != ConstValue.LOTTO_COUNT_SIZE;
    }

    private boolean isContainOutRangeNumber(TreeSet<Integer> box) {
        int validRangeNumCount = 0;

        Iterator<Integer> iter = box.iterator();
        while (iter.hasNext()) {
            validRangeNumCount += isElementInRange(iter.next());
        }
        return validRangeNumCount != ConstValue.LOTTO_COUNT_SIZE;
    }

    private int isElementInRange(int boxElement) {
        int isInRangeElement = 0;

        if (boxElement >= ConstValue.MINIMUM_LOTTO_NUMBER
                && boxElement <= ConstValue.MAXMUM_LOTTO_NUMBER) {
            isInRangeElement = 1;
        }
        return isInRangeElement;
    }

    private void inputBonusNumber() {
        String bonusNumberInput;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("보너스 볼을 입력해 주세요.");
            bonusNumberInput = sc.nextLine();
        } while (!checkValidBonusNumberInput(bonusNumberInput));

        checkSameElementBox.add(Integer.parseInt(bonusNumberInput));
    }

    private boolean checkValidBonusNumberInput(String bonusNumber) {
        return isValidNumber(bonusNumber)
                && noContainBonusNumber(bonusNumber);
    }

    private boolean isValidNumber(String number){
        boolean validNumber = true;

        if (!isNumber(number)) {
            System.out.println("숫자를 입력해주세요.");
            validNumber = !validNumber;
        } else if (isOutRangeNumber(Integer.parseInt(number))) {
            System.out.println("1부터 45 사이의 숫자만 입력해 주세요.");
            validNumber = !validNumber;
        }
        return validNumber;
    }

    private boolean isNumber(String number) {
        String pattern = ConstValue.NUMBER_PATTERNS;
        return Pattern.matches(pattern, number);
    }

    private boolean isOutRangeNumber(int number) {
        return number < ConstValue.MINIMUM_LOTTO_NUMBER
                || number > ConstValue.MAXMUM_LOTTO_NUMBER;
    }

    private boolean noContainBonusNumber(String number){
        boolean isUniqueNumber = true;

        if(checkSameElementBox.contains(Integer.parseInt(number))){
            System.out.println("당첨 번호에 중복된 수가 존재합니다.");
            isUniqueNumber = !isUniqueNumber;
        };
        return isUniqueNumber;
    }
}
