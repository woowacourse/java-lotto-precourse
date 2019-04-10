package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface extends CheckValidity {
    private Scanner sc = new Scanner(System.in);

    private static String STR1 = "개 일치";
    private static String STR2 = " (";
    private static String STR3 = ")- ";
    private static String STR4 = "개";
    private static String STR5 = ", 보너스 볼 일치";


    public int inputPurchaseAmount() {
        String purchaseAmountStr = "";
        boolean flag = false;

        while (!flag) {
            System.out.println("구입금액을 입력하세요.");
            purchaseAmountStr = sc.nextLine();
            flag = validatePurchaseAmount(purchaseAmountStr);
        }

        return Integer.parseInt(purchaseAmountStr);
    }

    private boolean validatePurchaseAmount(String purchaseAmountStr) {
        return (checkIntegerFormat(purchaseAmountStr)
                && checkMinimumPurchaseAmount(Integer.parseInt(purchaseAmountStr)));
    }

    public void printBuyLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public int[] inputWinnerNumbers() {
        String[] winnerNumbers = new String[0];
        boolean flag = false;

        while (!flag) {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            winnerNumbers = sc.nextLine().split(",");
            flag = validateWinnerNumbers(winnerNumbers);
        }

        return Arrays.stream(winnerNumbers).mapToInt(Integer::parseInt).toArray();
    }

    private boolean validateWinnerNumbers(String[] winnerNumbers) {
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
        return (checkIntegerFormat(winnerNumberStr)
                && checkLottoNumberScope(Integer.parseInt(winnerNumberStr)));
    }

    public int inputBonusBall(int[] winnerNumbers) {
        String bonusBallStr = "";
        boolean flag = false;

        while (!flag) {
            System.out.println("보너스 볼을 입력해 주세요.");
            bonusBallStr = sc.nextLine();
            flag = validateBonusBall(winnerNumbers, bonusBallStr);
        }

        return Integer.parseInt(bonusBallStr);
    }

    private boolean validateBonusBall(int[] winnerNumbers, String bonusBallStr) {
        return (checkIntegerFormat(bonusBallStr)
                && !checkDoubleBonus(winnerNumbers, Integer.parseInt(bonusBallStr))
                && checkLottoNumberScope(Integer.parseInt(bonusBallStr)));
    }

    public void printWinStats(ResultInformation resultInformation) {
        Rank[] rankArr = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};

        System.out.println("당첨통계\n-------------");

        for (Rank rank : rankArr) {
            System.out.println(printRankState(rank, resultInformation));
        }
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
