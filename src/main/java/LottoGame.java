/**
 * class : LottoGame.class
 * <p>
 * version : 1.0.0
 * <p>
 * date : 2019.04.11
 * <p>
 * author : icarus8050
 */

import Util.LottoService;
import domain.Lotto;

import java.util.List;
import java.util.Scanner;

/**
 * 게임의 진행을 담당하는 객체
 */
public class LottoGame {
    private Scanner scanner;

    public LottoGame() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        List<Lotto> userLottos = getOrder();
        System.out.println();
        printUserLottos(userLottos);
        System.out.println();
    }

    public List<Lotto> getOrder() {
        List<Lotto> lottoList;
        int money;

        do {
            System.out.println("구입금액을 입력해 주세요.");
            money = scanner.nextInt();
            lottoList = LottoService.getOrder(money);
        } while (lottoList == null);
        return lottoList;
    }

    public void printUserLottos(List<Lotto> userLottos) {
        System.out.println(userLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : userLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void closeGame() {
        scanner.close();
    }
}
