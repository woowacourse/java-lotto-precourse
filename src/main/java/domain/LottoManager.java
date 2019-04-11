package domain;

import util.InputUtil;
import util.LottoGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Scanner;

public class LottoManager {
    private Scanner scanner;
    private LottoResult lottoResult;

    private LottoManager() {
        scanner = new Scanner(System.in);
        lottoResult = LottoResult.getInstance();
    }

    private static class LottoManagerHolder {
        static LottoManager INSTANCE = new LottoManager();
    }

    public static LottoManager getInstance() {
        return LottoManagerHolder.INSTANCE;
    }

    public void startLotto() {
        int money = InputView.getUserMoney(scanner);
        List<Lotto> lottoList = LottoGenerator.generateLottoList(money);
        OutputView.printPurchasedLottoCount(lottoList, money);
        List<Integer> winningLottoNumberList = InputUtil.convertToList(InputView.getWinningLottoNumbers(scanner).split(","));
        int bonusBall = InputView.getBounusBall(scanner);
        progressLotto(winningLottoNumberList, bonusBall, lottoList);
        endLotto(money);
    }

    private void progressLotto(List<Integer> winningLottoNumberList, int bonusBall, List<Lotto> lottoList) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumberList), bonusBall);
        lottoList.forEach(lotto -> lottoResult.insertResult(winningLotto.match(lotto)));
    }

    private void endLotto(int money) {
        OutputView.printResultMent(lottoResult);
        OutputView.printEarningRateMent(lottoResult.calculateEarningRate(money));
    }
}
