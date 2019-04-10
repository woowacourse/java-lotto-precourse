package logic;

import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;
import ui.LottoIOInterface;
import util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author delf
 */
public class LottoSimulator {
    private List<Lotto> lottos;
    LottoIOInterface lottoIOInterface;

    public void run() {
        buyLottos(); // 로또 번호 입력 및 로또 객체 생성
        lottoIOInterface.showLottos(lottos); // 생성된 로또 객체 출력

        WinningLotto winningLotto = getWinningLotto(); // 당첨 로또 번호 입력

        Map<Rank, Integer> result = getResult(winningLotto); // 번호 비교 후 결과 생성
        lottoIOInterface.showWinningStatistics(result); // 결과 출력
    }

    public LottoSimulator with(LottoIOInterface lottoIOInterface) {
        this.lottoIOInterface = lottoIOInterface;
        return this;
    }

    private int buyLottos() {
        int money = lottoIOInterface.insertMoney();
        int nLotto = Lotto.howManyLotto(money);
        generateLottos(nLotto);

        return money % nLotto; // 남은 돈
    }

    /* nLotto 만큼의 로또 번호 생성한다. */
    private void generateLottos(int nLotto) {
        lottos = new ArrayList<>(nLotto);

        for (int i = 0; i < nLotto; i++) {
            List<Integer> numbers = LottoNumberGenerator.generate();
            lottos.add(new Lotto(numbers));
        }
    }

    /* 당첨 번호와 보너스 번호를 입력하고 당첨로또 객체를 생성한다. */
    private WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = lottoIOInterface.inputWinningLottoNumbers(); // 당첨 숫자 입력
        Lotto lotto = new Lotto(winningNumbers);
        int bonusNumber = lottoIOInterface.inputBounusNumber(lotto); // 보너스 숫자 입력

        return new WinningLotto(lotto, bonusNumber);
    }

    /* 생성된 당첨로또를 비교하여 결과를 리스트에 저장하여 반환한다. */
    private Map<Rank, Integer> getResult(WinningLotto winningLotto) {
        Map<Rank, Integer> counter = Rank.RANK_COUNTER();
        for(Lotto lotto : lottos) {
            counter.merge(winningLotto.match(lotto), 1, Integer::sum);
        }
        return counter;
    }
}
