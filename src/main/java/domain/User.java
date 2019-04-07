package domain;

public class User {
    private int buyingCash;

    public User(int price) {
        this.buyingCash = price;
    }

    public int getBuyingCash(){
        return buyingCash;
    }
}
