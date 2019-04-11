package game;

import domain.Lotto;
import domain.WinningLotto;

import java.util.*;

/**
 * 로또 게임을 진행하는 클래스
 */
public class Game {
    static final int LOTTO_PRICE = 1000;
    private static List<Lotto> lottos;           // 구입한 로또들이 담긴 리스트
    private static Buyer buyer;
    private static Analyzer analyzer;
    private static LottoMachine lottoMachine;

    public static void main(String[] args) {
        buyer = new Buyer();
        int lottoBuyingCount = buyer.buyMoney() / LOTTO_PRICE;          // 로또 구입 개수
        lottos = buyer.purchaseLottos(lottoBuyingCount);
        buyer.showPurchasedLottos(lottos, lottoBuyingCount);
        lottoMachine = new LottoMachine();
        Lotto winnerLotto = lottoMachine.makeWinningLotto();
        WinningLotto winningLotto = new WinningLotto(winnerLotto, lottoMachine.makeBonusNum(winnerLotto));
        analyzer = new Analyzer();
        analyzer.showResult(lottos, winningLotto);
    }
}
