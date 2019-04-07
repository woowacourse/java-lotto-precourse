package domain;

import java.util.*;

import domain.Lotto;

public class PlayLotto {
    public static int purchase_amount;
    public static List<Lotto> lottos;
    public static Scanner sc;

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_COUNT = 6;

    public static void main(String[] args) {
        getPurchaseAmount();
        makeLottoObject();
        System.out.println("dd");
    }

    public static void getPurchaseAmount() {
        sc = new Scanner(System.in);
        int purchase_money = 0;
        boolean flag = false;
        while (!flag) {
            System.out.println("구입금액을 입력해주세요");
            purchase_money = sc.nextInt();
            flag = isPurchaseMoneyValid(purchase_money);
        }
        purchase_amount = purchase_money / LOTTO_PRICE;
    }

    public static boolean isPurchaseMoneyValid(int amount) {
        if (amount <= 0)
            return false;
        else if (amount % LOTTO_PRICE == 0)
            return true;
        return false;
    }

    public static void makeLottoObject() {
        lottos = new ArrayList();
        int i;
        for (i = 0; i < purchase_amount; i++) {
            List<Integer> numbers = new ArrayList<Integer>();
            makeNumbers(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public static void makeNumbers(List<Integer> numbers) {
        for (int i = 0; i < LOTTO_COUNT; i++) {
            numbers.add((int) (Math.random() * 45) + 1);
        }
    }
}
