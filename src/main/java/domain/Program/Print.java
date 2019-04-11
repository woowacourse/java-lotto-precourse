package domain.Program;

import domain.Elements.Lotto;
import domain.Elements.Rank;
import domain.Elements.Winningstatistics;

public class Print {
    public static void getLottoBundle(Lotto[] lottoBunbdle) {
        System.out.println(lottoBunbdle.length + "개 구입하셨습니다.");
        for (Lotto lotto : lottoBunbdle) {
            System.out.println(lotto.getLottoNumber());
        }
    }

    public static void getWinningstatisticsResult(Winningstatistics winningstatistics, double earningRate) {
        System.out.println("당첨 통계\n -----------");
        for (Rank rankKey : winningstatistics.getStatisticsMap().keySet()) {
            int countOfMatch = rankKey.getCountOfMatch();
            int winningMoney = rankKey.getWinningMoney();
            int userCountOfmatch = winningstatistics.getStatisticsMap().get(rankKey);
            System.out.println(countOfMatch + "개 일치 (" + winningMoney + "원)- " + userCountOfmatch + " 개");
        }
        getEarningRate(earningRate);
    }

    public static void getInputPrice() {
        System.out.println("금액을 입력해주세요");
    }

    public static void getLottoSetter() {
        System.out.println("로또 번호를 형식에 맞춰 입력해 주세요. ex)1,2,3,4,5,6");
    }

    public static void getType() {
        System.out.println("타입을 선택해주세요.\n 1:자동 2:수동");
    }

    public static void getValidation() {
        System.out.println("유효하지 않는 값입니다.");
    }

    public static void getRange() {
        System.out.println("범위를 벗어났습니다.");
    }

    public static void getPriceValidation() {
        System.out.println("1000단위로 입력해주세요");
    }

    public static void getWinningLottoSetter() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public static void getBonusNumberSetter() {
        System.out.println("보너스 번호를 입력해주세요.");
    }

    public static void getLottoInputValidation() {
        System.out.println("형식에 맞추어 작성해주세요. ex)1,2,3,4,5,6");
    }

    public static void getBonusDuplication() {
        System.out.println("당첨 번호와 중복일 수 없습니다.");
    }

    public static void getInputSuccess() {
        System.out.println("입력되었습니다.\n");
    }

    public static void getInputFail(){
        System.out.println("입력에 실패했습니다.\n");
    }

    private static void getEarningRate(double earningRate) {
        System.out.println(String.format("총 수익률은 %.3f 입니다.", earningRate));
    }
}
