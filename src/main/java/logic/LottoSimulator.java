package logic;

import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;
import ui.ConsoleIOInterface;
import ui.LottoIOInterface;
import util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author delf
 */
public class LottoSimulator {
    private List<Lotto> lottos;
    LottoIOInterface lottoIOInterface;

    public void run() {
        checkAssertion();

        buyAndShowLottos();
        WinningLotto winningLotto = inputWinningLottoNumbers();
        matchingAndShowResult(winningLotto);
    }

    private void checkAssertion() {
        // 구현체가 하나뿐이므로 예외를 던지는 대신 기본 구현체 할당
        if (Objects.nonNull(lottoIOInterface)) {
            lottoIOInterface = new ConsoleIOInterface();
        }
    }

    private WinningLotto inputWinningLottoNumbers() {
        WinningLotto winningLotto;
        // (indent depth 1을 구현하기 위한 나름의 방법)
        while ((winningLotto = getWinningLotto()) == null) ; // 당첨 로또 번호 입력
        return winningLotto;
    }

    public LottoSimulator with(LottoIOInterface lottoIOInterface) {
        this.lottoIOInterface = lottoIOInterface;
        return this;
    }

    private void buyAndShowLottos() {
        while (!buyLottos()) ; // 로또 번호 입력 및 로또 객체 생성
        lottoIOInterface.showLottos(lottos); // 생성된 로또 객체 출력
    }

    private void matchingAndShowResult(WinningLotto winningLotto) {
        Map<Rank, Integer> result = getResult(winningLotto); // 번호 비교 후 결과 생성
        lottoIOInterface.showWinningStatistics(result); // 결과 출력
    }


    /* 돈을 입력받고 알맞은 수의 로또를 생산한다 */
    private boolean buyLottos() {
        try {
            int money = lottoIOInterface.insertMoney();
            int nLotto = Lotto.howManyLotto(money);
            generateLottos(nLotto);

        } catch (IllegalArgumentException e) {
            LottoIOInterface.showPlaneText(e.getMessage());
            return false;
        }
        return true;
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
        try {
            List<Integer> winningNumbers = lottoIOInterface.inputWinningLottoNumbers(); // 당첨 숫자 입력
            Lotto lotto = new Lotto(winningNumbers);
            int bonusNumber = lottoIOInterface.inputBonusNumber(lotto); // 보너스 숫자 입력
            return new WinningLotto(lotto, bonusNumber);

        } catch (IllegalArgumentException e) {
            LottoIOInterface.showPlaneText(e.getMessage());
            return null;
        }
    }

    /* 생성된 당첨로또를 비교하여 결과를 리스트에 저장하여 반환한다. */
    private Map<Rank, Integer> getResult(WinningLotto winningLotto) {
        Map<Rank, Integer> counter = Rank.RANK_COUNTER();
        for (Lotto lotto : lottos) {
            counter.merge(winningLotto.match(lotto), 1, Integer::sum);
        }
        return counter;
    }
}
