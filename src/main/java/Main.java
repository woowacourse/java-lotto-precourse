import domain.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

        String purchaseAmountStr = "";
        int purchaseAmount = 0;
        boolean flag = false;

        while(!flag){
            purchaseAmountStr = ui.inputPurchaseAmount();
            flag = ui.validatePurchaseAmount(purchaseAmountStr);
        }
        purchaseAmount = Integer.parseInt(purchaseAmountStr);
    }
}
