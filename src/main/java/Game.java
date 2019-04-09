import domain.Lotto;
import domain.UserInput;

import java.util.List;
import java.util.Scanner;

public class Game {
    static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    static final String NOT_PURCHASE_AMOUNT_ERROR = "1000 이상의 숫자를 입력해 주세요.";
    static final String NOT_LOTTO_NUMBERS_ERROR = "쉼표로 구분된, " +
            "중복되지 않은 6개의 로또 숫자(1~45)를 입력해 주세요.";
    static final String NOT_BONUS_NUMBER_ERROR = "당첨 번호들과 중복되지 않는 1개의 " +
            "로또 숫자(1~45)를 입력해 주세요.";
    static final String YOU_BOUGHT_IT = "개를 구매했습니다.";
    static final String ASK_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    static final String ASK_BONUS_BALL = "보너스 볼을 입력해 주세요.";

    public static int getPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        String input;
        Scanner s =  new Scanner(System.in);
        do {
            input = s.nextLine().trim();
        }while(!isThereErrorInPurchaseAmount(input));

        return Integer.parseInt(input);
    }

    private static boolean isThereErrorInPurchaseAmount(String input) {
        if(UserInput.isInRange(input, Lotto.PRICE)) {
            return true;
        }
        System.out.println(NOT_PURCHASE_AMOUNT_ERROR);
        return false;
    }

    public static List<Lotto> generateAndShowLottos(int purchaseAmount) {
        List<Lotto> lottos = Lotto.generateLottos(purchaseAmount);
        showLottos(lottos);
        return lottos;
    }

    private static void showLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + YOU_BOUGHT_IT);
        for (Lotto lotto : lottos
             ) {
            System.out.println(lotto);
        }
        System.out.println();
    }


    public static int getBonusNumber(Lotto lotto) {
        System.out.println(ASK_BONUS_BALL);
        String input;
        Scanner s = new Scanner(System.in);
        do {
            input = s.nextLine().trim();
        } while(!isThereErrorInBonusNumber(lotto, input));

        return Integer.parseInt(input);
    }

    private static boolean isThereErrorInBonusNumber(Lotto lotto, String input) {
        if(UserInput.isInRange(input, Lotto.BOTTOM, Lotto.TOP) &&
                !lotto.hasNumber(Integer.parseInt(input))) {
            return true;
        }
        System.out.println(NOT_BONUS_NUMBER_ERROR);
        return false;
    }

    public static Lotto getWinningLottoWithoutBonusNumber() {
        System.out.println(ASK_WINNING_LOTTO);
        String input;
        do {
            Scanner s = new Scanner(System.in);
            input = s.nextLine();
        } while(!isThereErrorInLottoNumbers(input));

        return new Lotto(UserInput.convertsToLottoNumbers(input));
    }

    private static boolean isThereErrorInLottoNumbers(String input) {
        List<Integer> lottoNumbers = UserInput.convertsToLottoNumbers(input);
        if(lottoNumbers.size() == Lotto.COUNT_OF_LOTTO_NUMBERS
                && (!UserInput.hasRepeatedNumbers(lottoNumbers))) {
            return true;
        }
        System.out.println(NOT_LOTTO_NUMBERS_ERROR);
        return false;
    }

}
