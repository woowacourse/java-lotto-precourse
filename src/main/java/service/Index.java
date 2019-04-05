package service;

import domain.Lotto;
import domain.Shop;
import domain.User;

public class Index {
    public static void main(String[] args){
        Shop shop = new Shop();
        User user = new User(shop.inputPrice());
        System.out.println(user.buyingCash);
    }
}
