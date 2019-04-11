package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MENT = "구입금액을 입력해 주세요";
    private static final String INPUT_WINNING_LOTTO_MENT = "지난 주 당첨 번호를 입력해 주세요";
    private static final String INTPUT_BONUS_BALL_MENT = "보너스 볼을 입력해 주세요";
    public static final String INPUT_ERROR_MENT = "입력 형식이 올바르지 않습니다.";

    public static int getUserMoney(Scanner scanner) {
        try {
            System.out.println(INPUT_PURCHASE_AMOUNT_MENT);
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(INPUT_ERROR_MENT);
        }
    }

    public static String getWinningLottoNumbers(Scanner scanner) {
        try {
            scanner.nextLine();
            System.out.println(INPUT_WINNING_LOTTO_MENT);
            return scanner.nextLine();
        } catch (Exception e) {
            throw new RuntimeException(INPUT_ERROR_MENT);
        }
    }

    public static int getBounusBall(Scanner scanner) {
        try {
            System.out.println(INTPUT_BONUS_BALL_MENT);
            return scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(INPUT_ERROR_MENT);
        }
    }
}

