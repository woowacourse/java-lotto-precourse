package domain;

import java.util.List;
import java.util.Scanner;

public class UserInterface extends CheckValidity {
    private Scanner sc = new Scanner(System.in);

    private static String STR1 = "개 일치";
    private static String STR2 = " (";
    private static String STR3 = ")- ";
    private static String STR4 = "개";
    private static String STR5 = ", 보너스 볼 일치";


    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력하세요.");
        return sc.nextLine();
    }

    public boolean validatePurchaseAmount(String purchaseAmountStr) {
        if (!checkIntegerFormat(purchaseAmountStr)) {
            return false;
        }

        return checkMinimumPurchaseAmount(Integer.parseInt(purchaseAmountStr));
    }

    public void printBuyLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public String[] inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine().split(",");
    }

    public boolean validateWinnerNumbers(String[] winnerNumbers) {
        if (!checkLottoNumberLength(winnerNumbers) || !checkDoubleNumbers(winnerNumbers)) {
            return false;
        }

        for (String winnerNumber : winnerNumbers) {
            if (!checkWinnerNumber(winnerNumber)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkWinnerNumber(String winnerNumberStr) {
        if (!checkIntegerFormat(winnerNumberStr)) {
            return false;
        }

        return checkLottoNumberScope(Integer.parseInt(winnerNumberStr));
    }

    public String inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.next();
    }

    public boolean validateBonusBall(List<Integer> winnerNumbers, String bonusBallStr) {
        if (!(checkIntegerFormat(bonusBallStr))) {
            return false;
        }

        int bonusBall = Integer.parseInt(bonusBallStr);
        if (checkDoubleBonus(winnerNumbers, bonusBall)) {
            return false;
        }

        return checkLottoNumberScope(bonusBall);
    }

    public void printWinStats(ResultInformation resultInformation) {
        System.out.println("당첨통계\n-------------");

        System.out.println(printRankState(Rank.FIFTH, resultInformation));
        System.out.println(printRankState(Rank.FOURTH, resultInformation));
        System.out.println(printRankState(Rank.THIRD, resultInformation));
        System.out.println(printRankState(Rank.SECOND, resultInformation));
        System.out.println(printRankState(Rank.FIRST, resultInformation));
        System.out.println("총 수익률은 " + resultInformation.getProfitRate() + "입니다.");
    }

    private String printRankState(Rank type, ResultInformation resultInformation) {
        String str;

        str = type.getCountOfMatch() + STR1;
        if (type.equals(Rank.SECOND)) {
            str += STR5;
        }
        str += STR2 + type.getWinningMoney() + STR3 + resultInformation.getRankCount(type) + STR4;

        return str;
    }
}
