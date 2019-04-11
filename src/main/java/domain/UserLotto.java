package domain;

import java.util.*;

public class UserLotto {
    private final static int LOTTO_PRICE = 1000;
    private Scanner scanner;
    private int price;
    private List<Lotto> lotto;

    UserLotto() {
        scanner = new Scanner(System.in);
        lotto = new ArrayList<>();
    }

    void buyUserLotto(){
        inputLottoPrice();
        printLottoAmount();
    }

    private void inputLottoPrice() {
        System.out.println("구입금액을 입력해주세요");
        price = scanner.nextInt();
        System.out.println();
    }

    private void printLottoAmount() {
        int amount = price / LOTTO_PRICE;
        System.out.println(amount + "개를 구매했습니다.");
        makeLotto(amount);
    }

    private void makeLotto(int amount) {
        for (int i = 0; i < amount; i++) {
            lotto.add(new Lotto(makeLottoNum()));
            System.out.println(lotto.get(i).getNumbers());
        }
    }

    List<Lotto> getLotto() {
        return lotto;
    }

    private List<Integer> makeLottoNum() {

        List<Integer> lottoNumber = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            lottoNumber.add(i);
        }
        Collections.shuffle(lottoNumber);

        return lottoNumber.subList(0, 6);
    }
}
