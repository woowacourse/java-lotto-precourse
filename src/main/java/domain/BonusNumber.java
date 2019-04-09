package domain;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 보너스 번호를 의미하는 class
 */
public class BonusNumber extends Config {
    private int bonusNumber;

    public BonusNumber(List<Integer> winningNumber) {
        do {
            checkBonusNumberValidation(winningNumber);
        } while (!checkBonusNumberRange()
                || !checkDuplicateBonusNumber(winningNumber));
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void checkBonusNumberValidation(List<Integer> winningNumber) {
        Scanner scan = new Scanner(System.in);
        try {
            this.bonusNumber = scan.nextInt();
        } catch (InputMismatchException e) {
            resetScanner();
            checkBonusNumberValidation(winningNumber);
        }
    }

    private boolean checkBonusNumberRange() {
        if (bonusNumber > LOTTO_MAX_VALUE || bonusNumber <= LOTTO_MIN_VALUE) {
            System.out.println("번호는 1이상 45이하의 수만 입력이 가능합니다.");
            return false;
        }
        return true;
    }

    private boolean checkDuplicateBonusNumber(List<Integer> winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            System.out.println("보너스 번호는 당첨 번호와 중복 될 수 없습니다.");
            return false;
        }
        return true;
    }
}
