package domain;

import java.util.*;

/**
 * 로또를 사고 통계를 보여주는 객체
 */

public class LottoShop {
    private final List<Lotto> lottoList;
    private final int investment;

    public LottoShop() {
        investment = purchase();
        this.lottoList = lottoList;
    }

    public int purchase() {
        Scanner scan = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scan.nextInt();
    }

    public void printLottos() {


    }



    public static void main(String[] args) {
        LottoShop shop = new LottoShop();

    }
}
