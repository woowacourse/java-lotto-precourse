package logic;

import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;
import ui.LottoIOInterface;
import util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author delf
 */
public class LottoSimulator {
    private List<Lotto> lottos;
    LottoIOInterface lottoIOInterface;

    public void run() {
        buyLottos();
        lottoIOInterface.showLottos(lottos);

        WinningLotto winningLotto = getWinningLotto();

        List<Rank> result = new ArrayList<>(Rank.values().length);
        for(Lotto lotto : lottos) {
            result.add(winningLotto.match(lotto));
        }

        lottoIOInterface.showWinningStatistics(result);
    }

    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = lottoIOInterface.inputWinningLottoNumbers(); // 당첨 숫자 입력
        Lotto lotto = new Lotto(winningNumbers);
        int bonusNumber = lottoIOInterface.inputBounusNumber(lotto); // 보너스 숫자 입력

        return new WinningLotto(lotto, bonusNumber);
    }


    private int buyLottos() {
        int money = lottoIOInterface.insertMoney();
        int nLotto = Lotto.howManyLotto(money);

        generateLottos(nLotto);

        return money % nLotto; // 남은 돈
    }

    private void generateLottos(int nLotto) {
        lottos = new ArrayList<>(nLotto);

        for (int i = 0; i < nLotto; i++) {
            List<Integer> numbers = LottoNumberGenerator.generate();
            lottos.add(new Lotto(numbers));
        }
    }
}
