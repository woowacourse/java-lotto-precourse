package domain;

import java.util.Scanner;

public class StartLottoGame {
    private static final int ONE_LOTTO_PRICE = 1000;
    private Lotto[] userLotto;

    public void gameStart(Scanner sc){
        int possibleBuyCnt = (inputCost(sc) / ONE_LOTTO_PRICE);
        buyLotto(possibleBuyCnt);
    }

    private int inputCost(Scanner sc){
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    private void buyLotto(int cnt){
        this.userLotto = new Lotto[cnt];
        AutoLotto al = new AutoLotto();
        for(int i=0; i<cnt; i++){
            this.userLotto[i] = new Lotto(al.makeAutoNumber(cnt));
        }

    }
    public static void main(String[] args){
        StartLottoGame lotto = new StartLottoGame();
        Scanner sc = new Scanner(System.in);
        lotto.gameStart(sc);
    }
}
