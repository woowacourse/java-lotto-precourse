package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    private static final int LOTTO_PRICE = 1000;

    public void startGame() {
        List<Lotto> purchaseLottoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        assignPurchaseLottoList(purchasePrice(scanner), purchaseLottoList);

        inputWinningLotto(scanner);
        System.out.println(bonusNumber(scanner));
    }

    private int purchasePrice(Scanner scanner) {
        System.out.println("구입 금액을 입력해 주세요.");
        return (scanner.nextInt() / LOTTO_PRICE);
    }

    private void assignPurchaseLottoList(int numberOfLotto, List<Lotto> purchaseLottoList) {
        System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");

        for (int i = 0; i < numberOfLotto; i++) {
            Lotto assignLotto = new Lotto(new ArrayList<>());
            assignLotto.getLottoNumber();
            purchaseLottoList.add(assignLotto);
        }

        System.out.println();
    }

    private Lotto inputWinningLotto(Scanner scanner){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Lotto InputWinningLotto = new Lotto(new ArrayList<>());
        InputWinningLotto.assignWinningLotto(scanner.next());

        return InputWinningLotto;
    }

    private int bonusNumber(Scanner scanner){
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

}
