package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final static int PRICE = 1000;

    private LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> purchaseLottos(int purchasePrice) {
        validatePurchasePrice(purchasePrice);

        int lottoCount = purchasePrice / PRICE;

        return IntStream.rangeClosed(1, lottoCount)
                .mapToObj(x -> makeLotto())
                .collect(Collectors.toList());
    }

    private void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice % PRICE != 0) {
            throw new IllegalArgumentException("로또 구매 금액을 정확히 입력 해 주세요. 금액 : " + purchasePrice);
        }
    }

    private Lotto makeLotto() {
        List<Integer> numbers = lottoNumberGenerator.makeLottoNumbers();
        return new Lotto(numbers);
    }
}
