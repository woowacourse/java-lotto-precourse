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
}
