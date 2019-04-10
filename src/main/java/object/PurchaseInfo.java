package object;

import creator.Creator;
import creator.PurchsedLottoNumberCreator;
import util.InputUtil;
import util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class PurchaseInfo {

        private final int purchaseAmount;
        private final List<Lotto> lottos;

        public PurchaseInfo() {
                PrintUtil.printPurchaseAmountInputMessage();
                this.purchaseAmount = InputUtil.inputPurchaseAmount();
                this.lottos = purchaseLottos();
        }

        private List<Lotto> purchaseLottos() {
                List<Lotto> lottos = new ArrayList<Lotto>();
                PurchsedLottoNumberCreator creator = new PurchsedLottoNumberCreator();
                for (int i = 0; i < this.purchaseAmount; i++) {
                        lottos.add(creator.create());
                }
                return lottos;
        }
}
