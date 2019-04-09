import domain.Lotto;
import domain.UserInput;

import java.util.List;
import java.util.Scanner;

public class Game {
    static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    static final String NOT_PURCHASE_AMOUNT_ERROR = "1000 이상의 숫자를 입력해 주세요.";
    static final String YOU_BOUGHT_IT = "개를 구매했습니다.";

    public static int getPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        Scanner s =  new Scanner(System.in);
        String input;
        do {
            input = s.nextLine();
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
    }

}
