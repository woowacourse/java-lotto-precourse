package domain;

import util.InputUtil;
import util.PrintUtil;

public class PurchaseInfo {

        private int purchaseAmount;

        public PurchaseInfo(){
                PrintUtil.printPurchaseAmountInputMessage();
                this.purchaseAmount = InputUtil.inputPurchaseAmount();
        }
}
