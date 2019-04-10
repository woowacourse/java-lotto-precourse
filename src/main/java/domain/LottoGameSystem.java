package domain;

import java.util.*;

/**
 * 로또게임의 운영을 담당하는 객체
 */
class LottoGameSystem {
    static final int THE_NUMBER_OF_LOTTO_NUMBERS = 6;
    static final int MAX_LOTTO_NUMBER = 45;
    static final int MIN_LOTTO_NUMBER = 1;
    static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottoList;
    private WinningLotto winningLotto;

    static LottoGameSystem turnOn() {

        return new LottoGameSystem();
    }

    void run(LottoVendingMachine lottoVendingMachine) {
        registerLottoList(lottoVendingMachine.getUserPurchasedLottoCount());
        lottoVendingMachine.printLottoResult();

        List<Integer> winningLottoNumbers = lottoVendingMachine.getWinningLottoNumbers();
        int bonusNumber = lottoVendingMachine.getBonusNumber(winningLottoNumbers);

        registerWinningLotto(winningLottoNumbers,bonusNumber);
        lottoVendingMachine.printResult();
    }

    private void registerLottoList(int lottoCount) {
        LottoSystem lottoSystem = new LottoSystem();
        lottoList = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(lottoSystem.getLotto());
        }
    }

    private void registerWinningLotto(List<Integer> winningLottoNumber, int bonusNumber) {
        WinningLottoSystem winningLottoSystem = new WinningLottoSystem();

        winningLotto = winningLottoSystem.getWinningLotto(winningLottoNumber, bonusNumber);
    }

    void printLottoList() {
        System.out.println(String.format("%d개를 구매했습니다.", lottoList.size()));
        for (Lotto lotto : lottoList) {
            lotto.printLottoNumbers();
        }
    }

    void printResult() {
        System.out.println("당첨 통계\n-------------------------------------------");
        printResultByRank();
        printEarningsRate();
    }

    private void printResultByRank() {
        LottoEarningsRateSystem lottoEarningsRateSystem = new LottoEarningsRateSystem();

        lottoEarningsRateSystem.printResultByRank(lottoList, winningLotto, Rank.FIFTH);
        lottoEarningsRateSystem.printResultByRank(lottoList, winningLotto, Rank.FOURTH);
        lottoEarningsRateSystem.printResultByRank(lottoList, winningLotto, Rank.THIRD);
        lottoEarningsRateSystem.printResultByRank(lottoList, winningLotto, Rank.SECOND);
        lottoEarningsRateSystem.printResultByRank(lottoList, winningLotto, Rank.FIRST);
    }

    private void printEarningsRate() {
        System.out.println(String.format("총 수익률은 %.2f%%입니다.", getEarningsRate()));
    }

    private double getEarningsRate() {
        LottoEarningsRateSystem lottoEarningsRateSystem = new LottoEarningsRateSystem();

        return lottoEarningsRateSystem.getEarningsRate(lottoList, winningLotto);
    }
}
