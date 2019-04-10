package domain;

import util.InputUtil;

public class PurchaseInfo {

        private InputUtil inputer;
        private int purchaseAmount;


        public PurchaseInfo(){this.purchaseAmount = inputer.inputPurchaseAmount();}
}
