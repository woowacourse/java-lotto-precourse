package service;

import domain.*;

import java.util.Arrays;

public class Index {
    public static void main(String[] args){
        Shop shop = new Shop();
        User user = new User(shop.inputPrice());
        Lotto[] lottobundle = shop.sellLotto(user.buyingCash);
        shop.printLotto(lottobundle);
        WinningLotto winningLotto = shop.createWinningLotto();
        Rank[] rankBundle = shop.createRankBundle(lottobundle,winningLotto);
    }
}
