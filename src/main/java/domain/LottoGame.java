package domain;

public class LottoGame {


    public static void main(String[] args) {
        int purchasePrice = new Purchasing().getPrice();
        System.out.println(purchasePrice);
    }
}
