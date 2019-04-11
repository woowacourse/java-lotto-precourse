package ui;

import domain.Lotto;
import domain.Rank;

import java.util.List;
import java.util.Map;

/**
 * @author delf
 */
public interface LottoIOInterface {

    /* 로또를 구입할 돈을 받아서 반환한다. */
    int insertMoney() throws IllegalArgumentException;

    /* 6개의 당첨 번호를 받아서 리스트로 반환한다. */
    List<Integer> inputWinningLottoNumbers() throws IllegalArgumentException;

    /* 당첨 로또의 보너스 번호를 입력한다. */
    int inputBonusNumber() throws IllegalArgumentException;

    /* 인수로 받은 로또들의 번호를 출력한다. */
    void showLottos(List<Lotto> lottos);

    /* Rank의 종류와 수를 받아 결과 값을 출력한다. */
    void showWinningStatistics(Map<Rank, Integer> ranks);

    /* 간단한 문자열 출력 */
    static void showPlaneText(Object s) {
        System.out.println(s.toString());
    }
}
