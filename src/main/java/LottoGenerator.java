import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static final int UNIT_PRICE = 1000;

    private int buyingLottosCount;
    private List<Lotto> generateLottos = new ArrayList<>();

    public LottoGenerator(int buyingMoney) {
        this.buyingLottosCount = buyingMoney / UNIT_PRICE;
    }

    public int getBuyingLottosCount() {
        return buyingLottosCount;
    }

    public List<Lotto> getGenerateLottos() {
        return generateLottos;
    }

} 
