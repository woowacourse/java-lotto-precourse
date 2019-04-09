package domain;

/**
 * 로또를 구매하는 유저를 의미하는 class
 */
public class User {
    private int buyingCash;

    public User(int price) {
        this.buyingCash = price;
    }

    public int getBuyingCash(){
        return buyingCash;
    }
}
