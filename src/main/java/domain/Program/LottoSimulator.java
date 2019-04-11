package domain.Program;

import domain.Elements.Lotto;
import domain.Elements.LottoPaper;
import domain.Elements.WinningLotto;
import domain.Elements.Winningstatistics;
import domain.Program.Config.Constant;


public class LottoSimulator {
    public void play() {
        long pay = Input.setPrice();
        int type = Input.setType();
        Lotto[] lottoBundle = buyLottoBundle(pay, type);
        Print.getLottoBundle(lottoBundle);
        Print.getWinningLottoSetter();
        Lotto winningLottoPaper = new Lotto(new LottoPaper(Constant.TYPE_SELF).getLottoNumber());
        WinningLotto winningLotto = new WinningLotto(winningLottoPaper, Input.setBonusNumber(winningLottoPaper.getLottoNumber()));
        Winningstatistics winningstatistics = Winningstatistics.createWinningStatistics(lottoBundle, winningLotto);
        double earningRate = Calculator.setEarningRate(winningstatistics, pay);
        Print.getWinningstatisticsResult(winningstatistics, earningRate);
    }

    private Lotto[] buyLottoBundle(long pay, int type) {
        int amount = Calculator.setAmount(pay, Constant.LOTTO_PRICE);
        return ObjectWrapper.createLottoBundle(type, amount);
    }
}
