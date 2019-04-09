/*
 * @(#)LottoGame.java        0.2 2019/04/09
 *
 *
 */

package domain;

import java.util.*;

/**
 * LottoGame을 담당하는 객체입니다.
 *
 * @author 반선호
 * @version 0.2 2019년 4월 09일
 */
public class LottoGame {
    private static final int TICKET_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_MIN_NUM = 1;

    private List<Lotto> lottoList = new ArrayList<>();

    public void start() {
        int lottoAmount = getLottoAmount();

        lottoPurchase(lottoAmount);
    }

    private void lottoPurchase(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
        for (int i = 0; i < lottoAmount; i++) {
            lottoList.add(makeLotto());
        }
    }

    private Lotto makeLotto() {
        List<Integer> lotto = new ArrayList<>();

        do {
            lotto.add(makeLottoNumber(lotto));
        } while (lotto.size() < LOTTO_SIZE);
        Collections.sort(lotto);
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private int makeLottoNumber(List<Integer> lotto) {
        Random random;
        int randomNumber;

        do {
            random = new Random();
            randomNumber = random.nextInt(LOTTO_MAX_NUM) + LOTTO_MIN_NUM;
        } while (lotto.contains(randomNumber));
        return randomNumber;
    }

    private int getLottoAmount() {
        int purchaseAmount = requestPurchaseAmount();

        return (purchaseAmount / TICKET_PRICE);
    }

    private int requestPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        String purchaseAmount;

        do {
            System.out.println("구입 금액을 입력해 주세요.");
            purchaseAmount = scanner.nextLine();
        } while (!checkNumber(purchaseAmount) || !checkRightPurchaseAmount(purchaseAmount));
        return Integer.parseInt(purchaseAmount);
    }

    private boolean checkNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return false;
        }
        return true;
    }

    private boolean checkRightPurchaseAmount(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);

        if ((amount < TICKET_PRICE) || ((amount % TICKET_PRICE) != 0)) {
            System.out.println("구입 금액이 잘못 되었습니다. 티켓 한장의 가격은 1000원입니다.");
            return false;
        }
        return true;
    }
}
