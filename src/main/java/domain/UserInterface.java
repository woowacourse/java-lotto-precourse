package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);

    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LENGTH_LOTTO = 6;

    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력하세요.");
        return sc.nextLine();
    }

    public boolean validatePurchaseAmount(String purchaseAmountStr) {
        int purchaseAmount;

        try {
            purchaseAmount = Integer.parseInt(purchaseAmountStr);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return false;
        }

        if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
            System.out.println("유효하지 않은 금액입니다.");
            return false;
        }

        return true;
    }

    public void printBuyLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
    }

    public String[] inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine().split(",");
    }

    public boolean validateWinnerNumbers(String[] winnerNumbers) {
        if (winnerNumbers.length != LENGTH_LOTTO) {
            return false;
        }

        List<Integer> winnerNumberList = new ArrayList<>();
        for (String winnerNumber : winnerNumbers) {
            try {
                winnerNumberList.add(Integer.parseInt(winnerNumber));
            } catch (NumberFormatException e) {
                return false;
            }
        }

        for (Integer number : winnerNumberList) {
            if ((MIN_NUMBER > number) || (number > MAX_NUMBER)) {
                return false;
            }
        }

        return true;
    }
}
