package domain;

import java.util.ArrayList;
import java.util.List;

public class ExceptionHandler {

    private UserInput userInput;

    ExceptionHandler() {
        this.userInput = new UserInput();
    }

    public int RecievePurchaseAmount() {
        int purchaseAmount = 0;

        try {
            purchaseAmount = userInput.TryToRecievePurchaseAmount();
        } catch (Exception e) {
            System.out.println("올바른 구매금액을 입력해 주세요.");
            System.exit(0);
        }

        return purchaseAmount;
    }

    public List<Integer> RecieveWinningNumber() {
        List<Integer> winningNumbers = new ArrayList<>();

        try {
            winningNumbers = userInput.TryToRecieveWinningNumber();
        } catch (Exception e) {  // IlligaArgumentException, NumberFormatException 모두 같이처리합니다.
            System.out.println("올바른 형식의 숫자를 입력하세요.");
            System.exit(0);
        }
        return winningNumbers;
    }

    public int RecieveBonusNumber() {
        int bonusNumber = 0;

        try {
            bonusNumber = userInput.TryToRecieveBonusNumber();
        } catch (Exception e) {
            System.out.println("올바른 보너스 볼을 입력해주세요.");
            System.exit(0);
        }

        return bonusNumber;
    }
}
