package domain;

import java.util.*;

/**
 * 당첨번호를 생성하는 객체
 */
class WinningLottoSystem {

    WinningLotto getWinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {
        return createWinningLotto(winningLottoNumbers, bonusNumber);
    }

    private WinningLotto createWinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {
        return new WinningLotto(createLotto(winningLottoNumbers), bonusNumber);
    }

    private Lotto createLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }
}
