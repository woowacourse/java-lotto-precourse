package service;

import domain.*;

public class Index {
    public static void main(String[] args){
        Config config = new Config();
        User user = new User(config.inputPrice());
        Machine machine = new Machine(user.buyingCash);
        Shop shop = new Shop(user.buyingCash);

        Lotto[] lottobundle = config.typeSelect(machine,shop,user.buyingCash);
        shop.printLotto(lottobundle);
        WinningLotto winningLotto = shop.createWinningLotto();
        Rank[] rankBundle = config.createRankBundle(lottobundle,winningLotto);
        float Earningrate = config.calculateEarningrate(user.buyingCash,rankBundle);
        config.printLottoResult(rankBundle,Earningrate);
    }
}
