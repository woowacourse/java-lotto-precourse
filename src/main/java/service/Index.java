package service;

import domain.*;
import java.util.Scanner;

import java.util.Arrays;

public class Index {
    public static void main(String[] args){
        System.out.println("구매할 금액을 입력해 주세요.");
        Shop shop = new Shop();
        Machine machine = new Machine();
        User user = new User(shop.inputPrice());
        Lotto[] lottobundle = typeSelect(machine,shop,user.buyingCash);
        shop.printLotto(lottobundle);
        WinningLotto winningLotto = shop.createWinningLotto();
        Rank[] rankBundle = shop.createRankBundle(lottobundle,winningLotto);
        float Earningrate = shop.calculateEarningrate(user.buyingCash,rankBundle);
        shop.printLottoResult(rankBundle,Earningrate);
    }

    private static Lotto[] typeSelect(Machine machine, Shop shop, int buyingCash){
        System.out.println("자동은 1번 수동은 2번을 입력해주세요.");
        Scanner scan = new Scanner(System.in);
        String typeString = scan.next();
        if(typeString.equals("1")){
            return machine.sellLotto(buyingCash);
        }
        if(typeString.equals("2")){
            return shop.sellLotto(buyingCash);
        }
        return typeSelect(machine,shop,buyingCash);
    }
}
