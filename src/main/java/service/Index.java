package service;

import domain.*;

public class Index {
    public static void main(String[] args){
        Shop shop = new Shop();
        User user = new User(shop.inputPrice());
        Machine machine = new Machine(user.buyingCash);
        Config config = new Config();

        Lotto[] lottobundle = config.typeSelect(machine,shop,user.buyingCash);
        shop.printLotto(lottobundle);
        WinningLotto winningLotto = shop.createWinningLotto();
        Rank[] rankBundle = config.createRankBundle(lottobundle,winningLotto);
        float Earningrate = config.calculateEarningrate(user.buyingCash,rankBundle);
        config.printLottoResult(rankBundle,Earningrate);
    }
}
