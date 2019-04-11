import domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoGenerator {
    public static final int UNIT_PRICE = 1000;
    private static final int LOTTO_NUMBERS_COUNT= 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    Random random = new Random();

    private int buyingLottosCount;
    private List<Lotto> generateLottos = new ArrayList<>();

    public LottoGenerator(int buyingMoney) {
        this.buyingLottosCount = buyingMoney / UNIT_PRICE;
        for(int i = 0; i < buyingLottosCount; i++) {
            generateLottos.add(generate());
        }
    }

    private Lotto generate() {
        List<Integer> lotto = new ArrayList<>();

        while(lotto.size() < LOTTO_NUMBERS_COUNT) {
            int number = random.nextInt(LOTTO_MAX_NUMBER) + LOTTO_MIN_NUMBER;
            if(lotto.contains(number) == false)
                lotto.add(number);
        }

        Collections.sort(lotto);
        return new Lotto(lotto);
    }

    public int getBuyingLottosCount() {
        return buyingLottosCount;
    }

    public List<Lotto> getGenerateLottos() {
        return generateLottos;
    }

} 
