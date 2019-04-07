package service;

import domain.*;

public class Index {
    public static void main(String[] args) {
        Program program = new Program();
        User user = new User(program.inputPrice());
        Shop shop = new Shop(user.buyingCash);
        Machine machine = new Machine(user.buyingCash);
        Lotto[] lottobundle = program.typeSelect(machine, shop, user.buyingCash);
        shop.printLotto(lottobundle);
        WinningLotto winningLotto = shop.createWinningLotto();
        Rank[] rankBundle = program.createRankBundle(lottobundle, winningLotto);
        float Earningrate = program.calculateEarningrate(user.buyingCash, rankBundle);
        program.printLottoResult(rankBundle, Earningrate);
    }
}
