package domain;

import java.util.*;

/**
 * 로또를 생성하는 객체
 */
class LottoGeneratorUtil {

    static WinningLotto createWinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {

        return new WinningLotto(createLotto(winningLottoNumbers), bonusNumber);
    }

    static Lotto createLotto() {
        List<Integer> lottoNumbers = createLottoNumbers();
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    static private Lotto createLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    static private List<Integer> createLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < LottoGameProgram.THE_NUMBER_OF_LOTTO_NUMBERS) {
            int lottoNumber = createLottoNumber();
            addLottoNumber(lottoNumber, lottoNumbers);
        }

        return lottoNumbers;
    }

    static private int createLottoNumber() {
        return (int) (Math.random() * LottoGameProgram.MAX_LOTTO_NUMBER) + LottoGameProgram.MIN_LOTTO_NUMBER;
    }

    static private void addLottoNumber(int lottoNumber, List<Integer> lottoNumbers) {
        if (!lottoNumbers.contains(lottoNumber)) {
            lottoNumbers.add(lottoNumber);
        }
    }
}
