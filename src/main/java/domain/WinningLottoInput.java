package domain;

import java.util.*;
import java.util.regex.Pattern;

public class WinningLottoInput {

    private TreeSet<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLotto decideWinningLotto(){
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
        } while (!checkValidWinningLottoInput(winningLottoInput));
    }

    private boolean checkValidWinningLottoInput(String winningLotto) {
        winningNumbers = new TreeSet<>();

        if (!isDividedComma(winningLotto)) {
            System.out.println("쉼표(,)로 구분하여 6자리를 입력해 주세요.");
            return false;
        }
        addElementIntoSet(winningLotto, winningNumbers);

        return isValidElement(winningNumbers);
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

        if (hasDuplicatedElement(box)) {
            System.out.println("중복된 숫자가 존재합니다.");
            validElement = !validElement;
        } else if (hasOutRangeElement(box)) {
            System.out.println("1부터 45 사이의 숫자만 입력해 주세요.");
            validElement = !validElement;
        }
        return validElement;
    }

    private boolean hasDuplicatedElement(TreeSet<Integer> box) {
        return box.size() != ConstValue.LOTTO_COUNT_SIZE;
    }

    /* 유효한 범위의 원소 개수를 카운트하여 판별 */
    private boolean hasOutRangeElement(TreeSet<Integer> box) {
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
                && boxElement <= ConstValue.MAXIMUM_LOTTO_NUMBER) {
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

        bonusNumber = Integer.parseInt(bonusNumberInput);
    }

    private boolean checkValidBonusNumberInput(String number) {
        return isValidNumber(number)
                && noContainBonusNumber(number);
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
                || number > ConstValue.MAXIMUM_LOTTO_NUMBER;
    }

    private boolean noContainBonusNumber(String number){
        boolean isUniqueNumber = true;

        if(winningNumbers.contains(Integer.parseInt(number))){
            System.out.println("당첨 번호에 중복된 수가 존재합니다.");
            isUniqueNumber = !isUniqueNumber;
        };
        return isUniqueNumber;
    }

    private WinningLotto createWinningLotto(){
        List<Integer> winningNumberList = new ArrayList<>(winningNumbers);

        Lotto lotto = new Lotto(winningNumberList);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        return winningLotto;
    }
}
