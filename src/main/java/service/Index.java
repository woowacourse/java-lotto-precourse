package service;

import domain.*;

public class Index {
    public static void main(String[] args) {
        Program program = new Program();
        User user = new User(program.inputPrice());
        Shop shop = new Shop(user.getBuyingCash());
        Machine machine = new Machine(user.getBuyingCash());
        Lotto[] lottobundle = program.typeSelect(machine, shop, user.getBuyingCash());
        program.printLotto(lottobundle);
        WinningLotto winningLotto = shop.createWinningLotto();
        Rank[] rankBundle = program.createRankBundle(lottobundle, winningLotto);
        float Earningrate = program.calculateEarningrate(user.getBuyingCash(), rankBundle);
        program.printLottoResult(rankBundle, Earningrate);
    }
}
