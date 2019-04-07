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
        while (numbers.size()<6) {
            int tmp_num = (int) (Math.random() * 45) + 1;
            addOrPassNumbers(tmp_num,numbers);
        }
    }

    /**
    * 중복된 로또 번호가 있으면 패스하고, 중복되지 않은 경우에 로또 번호를 추가한다.
    */
    public static void addOrPassNumbers(int tmp_num, List<Integer> numbers){
        if(!numbers.contains(tmp_num))
            numbers.add(tmp_num);
    }
}
