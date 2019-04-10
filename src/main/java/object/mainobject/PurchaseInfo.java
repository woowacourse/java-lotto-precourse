package object.mainobject;

import creator.Creator;
import creator.PurchsedLottoNumberCreator;
import domain.Rank;
import object.Lotto;
import object.WinningLotto;
import util.InputUtil;
import util.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseInfo {

        private final int purchaseAmount;
        private final List<Lotto> lottos;

        public PurchaseInfo() {
                PrintUtil.printPurchaseAmountInputMessage();
                this.purchaseAmount = InputUtil.inputPurchaseAmount();
                this.lottos = purchaseLottos();
        }

        public void printPurchasedLottosNumber() {
                PrintUtil.printPurchaseConfirmMessage(this.purchaseAmount);
                PrintUtil.printPurchasedLottoList(this.lottos);
        }

        public Map<Rank, Integer> makeWinningStats(Map<Rank, Integer> map, WinningLotto winningLotto) {
                map = new HashMap<Rank, Integer>();
                for (Lotto lotto : this.lottos) {
                        Rank rank = winningLotto.match(lotto);
                        map.put(rank,map.get(rank)+1);
                }
                return map;
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
