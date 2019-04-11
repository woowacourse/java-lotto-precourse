package util;

import domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static final int LOTTO_UNIT_AMOUNT = 1_000;
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_SIX = 6;
    private static final String MONEY_ERROR_MENT = "금액은 천원 단위로 입력해 주세요";
    private static List<Integer> allLottoNumberList =
            IntStream.range(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER + 1)
                    .boxed()
                    .collect(Collectors.toList());

    private static Lotto generateLotto() {
        Collections.shuffle(allLottoNumberList);
        List<Integer> generatedLotto = new ArrayList<>(allLottoNumberList.subList(INDEX_ZERO, INDEX_SIX));
        Collections.sort(generatedLotto);
        return new Lotto(generatedLotto);
    }

    public static List<Lotto> generateLottoList(int money) {
        if(money % LOTTO_UNIT_AMOUNT != 0){
            throw new IllegalArgumentException(MONEY_ERROR_MENT);
        }
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = INDEX_ZERO; i < money / LOTTO_UNIT_AMOUNT; i++) {
            lottoList.add(generateLotto());
        }
        return lottoList;
    }
}