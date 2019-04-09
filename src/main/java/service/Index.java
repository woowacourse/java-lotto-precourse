package service;

import domain.*;

public class Index {
    public static void main(String[] args) {
        User user = new User(Program.inputPrice());
        Shop shop = new Shop(user.getBuyingCash());
        Machine machine = new Machine(user.getBuyingCash());
        Lotto[] lottobundle = Program.typeSelect(machine, shop, user.getBuyingCash());
        Program.printLotto(lottobundle);
        WinningLotto winningLotto = shop.createWinningLotto();
        Rank[] rankBundle = Program.createRankBundle(lottobundle, winningLotto);
        float Earningrate = Program.calculateEarningrate(user.getBuyingCash(), rankBundle);
        Program.printLottoResult(rankBundle, Earningrate);
    }
}
