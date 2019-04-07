package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Config {
    public final int INITIAL_VALUE = 0;
    public final int LOTTO_PRICE = 1000;
    public final int LOTTO_NUMBER_SIZE = 6;
    public final int LOTTO_MAX_VALUE = 45;
    public final int LOTTO_MIN_VALUE = 0;

    public Lotto[] typeSelect(Machine machine, Shop shop, int buyingCash){
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

    public int inputPrice() {
        System.out.println("구매할 금액을 입력해 주세요.");
        int price = checkPriceValidation(INITIAL_VALUE);
        return price;
    }

    public Scanner resetScanner() {
        System.out.println("유효하지 않는 값입니다.");
        Scanner scan = new Scanner(System.in);
        return scan;
    }

    public float calculateEarningrate(float amount, Rank[] rank) {
        float winningMoney = 0;
        for (int i = 0; i < rank.length; i++) {
            winningMoney = winningMoney + rank[i].getWinningMoney();
        }
        return (winningMoney / amount);
    }

    public Rank[] createRankBundle(Lotto[] lottobundle, WinningLotto winningLotto) {
        Rank[] rankBundle = new Rank[lottobundle.length];
        for (int i = 0; i < lottobundle.length; i++) {
            rankBundle[i] = winningLotto.match(lottobundle[i]);
        }
        return rankBundle;
    }

    public void printLottoResult(Rank[] rankbundle, float Earningrate) {
        System.out.println("당첨 통계\n----------");
        System.out.println(Rank.FIFTH.getCountOfMatch() + "개 일치 (" + Rank.FIFTH.getWinningMoney() + ")-" + createCountOfMatchAmount(rankbundle, Rank.FIFTH.getWinningMoney()) + "개");
        System.out.println(Rank.FOURTH.getCountOfMatch() + "개 일치 (" + Rank.FOURTH.getWinningMoney() + ")-" + createCountOfMatchAmount(rankbundle, Rank.FOURTH.getWinningMoney()) + "개");
        System.out.println(Rank.THIRD.getCountOfMatch() + "개 일치 (" + Rank.THIRD.getWinningMoney() + ")-" + createCountOfMatchAmount(rankbundle, Rank.THIRD.getWinningMoney()) + "개");
        System.out.println(Rank.SECOND.getCountOfMatch() + "개 일치, 보너스 볼 일치 (" + Rank.SECOND.getWinningMoney() + ")-" + createCountOfMatchAmount(rankbundle, Rank.SECOND.getWinningMoney()) + "개");
        System.out.println(Rank.FIRST.getCountOfMatch() + "개 일치 (" + Rank.FIRST.getWinningMoney() + ")-" + createCountOfMatchAmount(rankbundle, Rank.FIRST.getWinningMoney()) + "개");
        System.out.println("총 수익률은 " + Earningrate + "입니다.");
    }

    private int createCountOfMatchAmount(Rank[] rank, int winningMoney) {
        int countOfMatchAmount = 0;
        for (int i = 0; i < rank.length; i++) {
            countOfMatchAmount = countOfMatchAmount + pulsCountOfMatchAmount(rank[i].getWinningMoney(), winningMoney);
        }
        return countOfMatchAmount;
    }

    private int pulsCountOfMatchAmount(int userWinningMoney, int winningMoney) {
        if (userWinningMoney == winningMoney) {
            return 1;
        }
        return 0;
    }

    private int checkPriceValidation(int price) {
        Scanner scan = new Scanner(System.in);
        try {
            int signedprice = scan.nextInt();
            price = checkPrice(signedprice);
        } catch (InputMismatchException e) {
            resetScanner();
            price = checkPriceValidation(INITIAL_VALUE);
        }
        return price;
    }

    private int checkPrice(int price) {
        if (price < 0) {
            System.out.println("0원보다 큰 금액을 입력해 주세요.");
            price = checkPriceValidation(INITIAL_VALUE);
        }
        if (price % LOTTO_PRICE != 0) {
            System.out.println("1000원 단위로 입력 해주세요.");
            price = checkPriceValidation(INITIAL_VALUE);
        }
        return price;
    }
}
