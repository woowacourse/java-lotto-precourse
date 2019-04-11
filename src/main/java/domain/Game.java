package domain;

import java.util.ArrayList;

import static domain.Const.*;

/**
 * 로또 게임 클래스
 */
public class Game {
    private static IO io = new IO();
    private Price price;
    private ArrayList<Lotto> lottoList = new ArrayList<>();
    private WinningLotto winningLotto;
    private int[] winningArray = new int[]{0, 0, 0, 0, 0};
    private static Rank rank;

    public void Start() {
        purchaseLotto();
        userInWinningNumbers();
        winningLotto.match(lottoList.get(0));
        matchingLottoLoop();
        lottoStatistics();
    }

    private void purchaseLotto() {
        makePrice();
        if (price.getTickets() != 0) {
            makeLotto();
        }
        io.printLottoList(lottoList);
    }

    private void makePrice() {
        price = io.inputPurchaseAmount();
        io.printChange(price);
    }

    private void makeLotto() {
        for (int lottoIdx = 0; lottoIdx < price.getTickets(); ++lottoIdx) {
            NumberGenerator generator = new NumberGenerator(LOTTO_NUMBER_SIZE);
            Lotto lotto = new Lotto(generator.getNumberArrList());
            lottoList.add(lotto);
        }
        io.printPurchaseLotto(price);
    }

    private void userInWinningNumbers() {
        winningLotto = new WinningLotto(new Lotto(io.inputWinningNumber()), io.inputBonusNumber());
    }
}
