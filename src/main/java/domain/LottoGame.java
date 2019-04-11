package domain;

import java.util.List;

/**
 * 로또 게임 실행
 * 1. 구입 금액 입력 -> 해당 수량의 로또 생성
 * 2. 당첨 번호 입력
 * 3. 당첨 결과 및 통계
 */
public class LottoGame {

    private LottoShop lottoShop;
    private WinningLottoInput winningLottoInput;
    private WinningLotto winningLotto;
    private LottoStatistics lottoStatistics;

    public LottoGame() {
        lottoShop = new LottoShop();
        winningLottoInput = new WinningLottoInput();
        lottoStatistics = new LottoStatistics();
    }

    public void play() {
        List<Lotto> lottoList;
        List<Rank> lottoRanks;

        lottoList = lottoShop.purchaseLotto();
        winningLotto = winningLottoInput.decideWinningLotto();

        lottoRanks = winningLotto.checkHowManyMatch(lottoList);
        resultLottoGame(lottoRanks);
    }

    private void resultLottoGame(List<Rank> lottoRanks) {
        lottoStatistics.addWinStats(lottoRanks);
        lottoStatistics.printStatistic();
    }
}
