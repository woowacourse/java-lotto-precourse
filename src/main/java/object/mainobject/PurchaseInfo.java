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
                PrintUtil.printPurchasedLottoList(lottos);
        }

        public Map<Rank,Integer> makeWinningStats(WinningLotto winningLotto){
                Map<Rank,Integer> map = new HashMap<Rank,Integer>();
                for(Lotto lotto : lottos){
                        map.putwinningLotto.match(lotto);
                }
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
