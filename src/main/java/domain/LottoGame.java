package domain;

import java.util.*;

/**
 * 로또게임 진행을 담당하는 객체
 */
public class LottoGame {
    static final int THE_NUMBER_OF_LOTTO_NUMBERS = 6;
    static final int MAX_LOTTO_NUMBER = 45;
    static final int MIN_LOTTO_NUMBER = 1;
    static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottoList;
    private WinningLotto winningLotto;
    private LottoVendingMachine lottoVendingMachine;

    public LottoGame() {
        lottoVendingMachine = new LottoVendingMachine();
    }

    public void run() {
        lottoVendingMachine.inputLottoPurchaseMoney();
        registerLottoList();
        printPurchasedLottoList();

        lottoVendingMachine.inputWinningLottoNumbers();
        lottoVendingMachine.inputBonusNumber();
        registerWinningLotto();
        printResultMessage();
    }

    private void registerLottoList() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        lottoList = new ArrayList<>();

        for (int i = 0; i < lottoVendingMachine.getPurchasedLottoCount(); i++) {
            lottoList.add(lottoGenerator.createLotto());
        }
    }

    private void registerWinningLotto() {
        WinningLottoGenerator winningLottoGenerator = new WinningLottoGenerator();

        List<Integer> winningLottoNumber = lottoVendingMachine.getWinningLottoNumberList();
        int bonusNumber = lottoVendingMachine.getBonusNumber();

        winningLotto = winningLottoGenerator.createWinningLotto(winningLottoNumber, bonusNumber);
    }

    private void printPurchasedLottoList() {
        lottoVendingMachine.printMessage(String.format("%d개를 구매했습니다.", lottoList.size()));
        for (Lotto lotto : lottoList) {
            lottoVendingMachine.printMessage(lotto.getLottoNumberString());
        }
    }

    private void printResultMessage() {
        lottoVendingMachine.printMessage("당첨 통계\n-------------------------------------------");
        lottoVendingMachine.printMessage(getResultByRankMessage());
        lottoVendingMachine.printMessage(getEarningsRateMessage());
    }

    private String getResultByRankMessage() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = Rank.FIFTH.ordinal(); i >= 0; i--) {
            stringBuilder.append(LottoEarningsRateUtil.getResultByRankMessage(lottoList, winningLotto, Rank.values()[i]));
        }

        return stringBuilder.toString();
    }

    private String getEarningsRateMessage() {
        return String.format("총 수익률은 %.2f%%입니다.", LottoEarningsRateUtil.getEarningsRate(lottoList, winningLotto));
    }
}
