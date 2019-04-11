/**
 * class : LottoGame.class
 *
 * version : 1.0.0
 *
 * date : 2019.04.11
 *
 * author : icarus8050
 */

import Util.LottoService;
import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;

import java.util.List;
import java.util.Scanner;

/**
 * 게임의 진행을 담당하는 객체
 */
public class LottoGame {
    private Scanner scanner;
    private List<Lotto> userLottos; //유저가 구매한 로또 리스트
    private Lotto lastWinningLotto; //지난 주 당첨 번호
    private int bonusNumber;    //보너스 번호
    private WinningLotto winningLotto;  //당첨 로또
    private List<Rank> rankList;    //유저가 구매한 로또의 당첨 정보

    public LottoGame() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        userLottos = getOrder();
        System.out.println();
        printUserLottos(userLottos);
        System.out.println();
        lastWinningLotto = createLastWinningLotto();
    }

    private List<Lotto> getOrder() {
        List<Lotto> lottoList;
        String stringBasedMoney;

        do {
            System.out.println("구입금액을 입력해 주세요.");
            stringBasedMoney = scanner.nextLine();
            lottoList = LottoService.getOrder(stringBasedMoney);
        } while (lottoList == null);
        return lottoList;
    }

    private void printUserLottos(List<Lotto> userLottos) {
        System.out.println(userLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : userLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private Lotto createLastWinningLotto() {
        String lastWeekWinningNumber;
        Lotto lotto;

        do {
            System.out.println("지난 주 당첨 번호를 입력해주세요.");
            lastWeekWinningNumber = scanner.nextLine();
            lotto = LottoService.getLotto(lastWeekWinningNumber);
        } while (lotto == null);
        return lotto;
    }

    public void closeGame() {
        scanner.close();
    }
}
