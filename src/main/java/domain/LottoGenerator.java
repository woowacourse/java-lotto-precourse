package domain;

import java.util.*;

/**
 * 로또를 생성하는 객체
 */
class LottoGenerator {

    Lotto createLotto() {
        List<Integer> lottoNumbers = createLottoNumbers();
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < LottoGame.THE_NUMBER_OF_LOTTO_NUMBERS) {
            int lottoNumber = createLottoNumber();
            addLottoNumber(lottoNumber, lottoNumbers);
        }

        return lottoNumbers;
    }

    private int createLottoNumber() {
        return (int) (Math.random() * LottoGame.MAX_LOTTO_NUMBER) + LottoGame.MIN_LOTTO_NUMBER;
    }

    private void addLottoNumber(int lottoNumber, List<Integer> lottoNumbers) {
        if (!lottoNumbers.contains(lottoNumber)) {
            lottoNumbers.add(lottoNumber);
        }
    }
}
