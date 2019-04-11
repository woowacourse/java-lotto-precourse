package domain;

import java.util.*;

public class UserLotto {
    private Scanner scanner;
    private int price;
    private List<Lotto> lotto;

    UserLotto() {
        scanner = new Scanner(System.in);
        lotto = new ArrayList<>();
    }

    void buyUserLotto() {
        inputLottoPrice();
        printLottoAmount();
    }

    private void inputLottoPrice() {
        boolean inputChecker = false;

        while (!inputChecker) {
            System.out.println("구입금액을 입력해주세요!");
            try {
                price = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력하세요");
                scanner.nextLine();
                continue;
            }
            inputChecker = checkInputLottoPrice(price);
        }
        System.out.println();
    }

    private void printLottoAmount() {
        int amount = price / Constant.LOTTO_PRICE;
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

    private boolean checkInputLottoPrice(int price) {
        if (price < Constant.LOTTO_PRICE || price % Constant.LOTTO_PRICE != 0) {
            System.out.println("로또는 한장에 1000원 입니다.");
            return false;
        }
        return true;
    }

}
