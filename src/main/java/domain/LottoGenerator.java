package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int PRIZE_OF_LOTTO = 1000;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<Lotto> lottoList;
    private List<Integer> lottoNumbers;

    LottoGenerator() {
        lottoList = new ArrayList<>();
        lottoNumbers = new ArrayList<>();
    }

    private void GenerateLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / PRIZE_OF_LOTTO;
        for (int i = 0; i < lottoCount; i++) {
            GenerateLotto();
        }
    }

    private void GenerateLotto() {
        for (int lottoNumberCount = 1; lottoNumberCount <= LOTTO_NUMBER_COUNT; lottoNumberCount++){
            lottoNumbers.add(GenerateRandomNumber());
        }

        lottoList.add(new Lotto(lottoNumbers));
        lottoNumbers.clear();
        
    }

    private int GenerateRandomNumber() {
        boolean isNotValidLottoNumber = true;
        int candidateLottoNumber = 0;

        while (isNotValidLottoNumber) {
            candidateLottoNumber = (int) ((Math.random() * MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER);
            isNotValidLottoNumber = isNotOverlapLottoNumber(candidateLottoNumber);
        }

        return candidateLottoNumber;
    }

    private boolean isNotOverlapLottoNumber(int candidateLottoNumber) {
        return lottoNumbers.contains(candidateLottoNumber) ? false : true;
    }


}
