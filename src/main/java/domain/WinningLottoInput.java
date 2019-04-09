package domain;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class WinningLottoInput {


    public void inputWinningLotto() {
        inputLastWinningLotto();
    }

    private void inputLastWinningLotto() {
        String winningLottoInput;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            winningLottoInput = sc.nextLine().replace(" ", "");
        } while (!checkValidWinningLottoInput(winningLottoInput));
        System.out.println("ok");
    }

    private boolean checkValidWinningLottoInput(String winningLotto) {
        TreeSet<Integer> checkSameElementBox = new TreeSet<>();

        if (!isDividedComma(winningLotto)) {
            System.out.println("쉼표(,)로 구분하여 6자리를 입력해 주세요.");
            return false;
        }
        addElementIntoSet(winningLotto, checkSameElementBox);

        return isValidNumber(checkSameElementBox);
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

    private boolean isValidNumber(TreeSet<Integer> box) {
        boolean validNumber = true;
        if (isDuplicatedNumbers(box)) {
            System.out.println("중복된 숫자가 존재합니다.");
            validNumber = !validNumber;
        } else if (isContainOutRangeNumber(box)) {
            System.out.println("1부터 45 사이의 숫자만 입력해주세요.");
            validNumber = !validNumber;
        }
        return validNumber;
    }

    private boolean isDuplicatedNumbers(TreeSet<Integer> box) {
        return box.size() != ConstValue.LOTTO_COUNT_SIZE;
    }

    private boolean isContainOutRangeNumber(TreeSet<Integer> box) {
        int validRangeNumCount = 0;

        Iterator<Integer> iter = box.iterator();
        while (iter.hasNext()) {
            validRangeNumCount += isInRange(iter.next());
        }
        return validRangeNumCount != ConstValue.LOTTO_COUNT_SIZE;
    }

    private int isInRange(int boxElement) {
        int inRangeCount = 0;
        if (boxElement >= ConstValue.MINIMUM_LOTTO_NUMBER
                && boxElement <= ConstValue.MAXMUM_LOTTO_NUMBER) {
            inRangeCount = 1;
        }
        return inRangeCount;
    }
}
