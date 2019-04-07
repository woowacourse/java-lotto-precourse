/**
 * LottoBuyer.class        1.00 2019/04/06
 *
 * <Copyright 2019. LeeNamJun. All rights reserved.>
 */

package domain;

import java.util.Scanner;

/**
 * 로또를 구입하고, 구입한 로또들을 저장하는 클래스
 *
 * @version 1.00
 * @author 이남준
 */
public class LottoBuyer implements Constants {

    Scanner scanner = new Scanner(System.in);
    private Lotto[] purchasedLottos;

    public LottoBuyer() {
        buyLottos();
    }

    public Lotto[] getPurchasedLottos() {
        return purchasedLottos;
    }

    private int enterPrice() {
        int price;
        System.out.println("구입할 금액을 입력하세요.");
        price = scanner.nextInt();
        return checkPrice(price);
    }


    private int checkPrice(int price) {
        if (price % MIN_PRICE == 0 && price >= MIN_PRICE && price <= MAX_PRICE) {
            return price;
        }
        System.out.println("올바른 금액이 아닙니다. 1000 ~ 100000원 사이의 금액을 1000원 단위로 입력해주세요.");
        return enterPrice();
    }

    public void buyLottos() {
        int countOfLottos = enterPrice() / 1000;
        purchasedLottos = new Lotto[countOfLottos];
        for (int i = 0; i < countOfLottos; i++) {
            purchasedLottos[i] = new Lotto(LottoManager.MakeRandomNumber());
        }
    }
}
