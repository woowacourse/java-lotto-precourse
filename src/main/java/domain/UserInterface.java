package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface extends CheckValidity {
    private Scanner sc = new Scanner(System.in);

    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력하세요.");
        return sc.nextLine();
    }

    public boolean validatePurchaseAmount(String purchaseAmountStr) {
        if(!checkIntegerFormat(purchaseAmountStr)){
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
        if (!checkLottoNumberLength(winnerNumbers)) {
            return false;
        }

        List<Integer> winnerNumberList = new ArrayList<>();
        int number;
        for (String winnerNumber : winnerNumbers) {
            if (!checkIntegerFormat(winnerNumber)) {
                return false;
            }

            number = Integer.parseInt(winnerNumber);
            if (!checkLottoNumberScope(number)) {
                return false;
            }

            if (checkDouble(winnerNumberList, number)) {
                return false;
            }

            winnerNumberList.add(number);
        }

        return true;
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
        if (checkDouble(winnerNumbers, bonusBall)) {
            return false;
        }

        return checkLottoNumberScope(bonusBall);
    }

    public void printWinStats(ResultInformation resultInformation) {
        System.out.println("당첨통계\n-------------");

        System.out.println(Rank.FIFTH.getCountOfMatch() + "개 일치 ("
                + Rank.FIFTH.getWinningMoney() + "원)- " + resultInformation.getRankCount(Rank.FIFTH) + "개");
        System.out.println(Rank.FOURTH.getCountOfMatch() + "개 일치 ("
                + Rank.FOURTH.getWinningMoney() + "원)- " + resultInformation.getRankCount(Rank.FOURTH) + "개");
        System.out.println(Rank.THIRD.getCountOfMatch() + "개 일치 ("
                + Rank.THIRD.getWinningMoney() + "원)- " + resultInformation.getRankCount(Rank.THIRD) + "개");
        System.out.println(Rank.SECOND.getCountOfMatch() + "개 일치, 보너스 볼 일치 ("
                + Rank.SECOND.getWinningMoney() + "원)- " + resultInformation.getRankCount(Rank.SECOND) + "개");
        System.out.println(Rank.FIRST.getCountOfMatch() + "개 일치 ("
                + Rank.FIRST.getWinningMoney() + "원)- " + resultInformation.getRankCount(Rank.FIRST) + "개");
        System.out.println("총 수익률은 " + resultInformation.getProfitRate() + "입니다.");
    }
}
