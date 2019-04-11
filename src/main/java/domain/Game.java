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
//        lottoStatistics();
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

    private void matchingLottoLoop() {
        for (int i = 0; i < lottoList.size(); ++i) {
            matchingLotto(i);
        }
    }

    /*
     *  10Line 초과
     */
    private void matchingLotto(int idx) {
        rank = winningLotto.match(lottoList.get(idx));
        if (rank == Rank.FIRST) {
            winningArray[0]++;
        }
        if (rank == Rank.SECOND) {
            winningArray[1]++;
        }
        if (rank == Rank.THIRD) {
            winningArray[2]++;
        }
        if (rank == Rank.FOURTH) {
            winningArray[3]++;
        }
        if (rank == Rank.FIFTH) {
            winningArray[4]++;
        }
    }
}
