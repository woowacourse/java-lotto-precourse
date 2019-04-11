package lotto.domain;

import lotto.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoMachine {
    private NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> buyLottos(LottoMoney purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount.getPurchaseCount(); i++)
            lottos.add(getLotto());
        return lottos;
    }

    protected Lotto getLotto() {
        return new Lotto(generateNonDuplicateNumbers());
    }

    private List<Integer> generateNonDuplicateNumbers() {
        Set<Integer> nonDuplicateNumbers = new TreeSet<>();
        while (nonDuplicateNumbers.size() < Lotto.LOTTO_NUMBER_SIZE) {
            nonDuplicateNumbers.add(numberGenerator.getNumber());
        }

        return toList(nonDuplicateNumbers);
    }

    private List<Integer> toList(Set<Integer> nonDuplicateNumbers) {
        return new ArrayList<>(nonDuplicateNumbers);
    }

    public void setNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
}
