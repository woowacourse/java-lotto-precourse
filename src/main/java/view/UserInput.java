package view;

import controller.LottoController;
import domain.Lotto;


import java.util.*;

public class UserInput {

    private static final int LOTTO_BOUND = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;

    private Scanner sc = new Scanner(System.in);
    private LottoController lottoController;

    private Set<Integer> inputLottoNumber = new TreeSet<>();

    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int money = sc.nextInt();
            testValidMoney(money);

            this.lottoController = new LottoController(money);

        } catch (InputMismatchException e) {
            throw new InputMismatchException("숫자를 입력해 주세요.");
        }
    }

    private void testValidMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOTTO_PRICE + "보다 큰 금액을 입력해주세요.");
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE + "의 배수 금액을 입력해주세요.");
        }
    }

    public void displayLotto() {
        List<Lotto> lottoList = lottoController.getLottoList();

        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    public void inputWinningLotto() {
        System.out.println("지난 주 당첨 번호을 입력해 주세요.");
        String userInput = sc.nextLine();
        String[] inputStr = userInput.split(",");

        for (int i = 0; i < inputStr.length; i++) {
            inputLottoNumber.add(testValidLottoNumber(inputStr[i]));
        }

        testValidLotto(inputLottoNumber);
    }

    private void testValidLotto(Set<Integer> numberSet) {
        if (numberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또번호는" + LOTTO_SIZE + "자리입니다.");
        }
    }

    private int testValidLottoNumber(String str) {
        int num;

        try {
           num = Integer.parseInt(str);
           testValidLottoBounds(num);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자가 아닙니다.");
        }
        return num;
    }

    private void testValidLottoBounds(int num) {
        if ( 0 > num || num > LOTTO_BOUND ) {
            throw new IllegalArgumentException("로또 번호는" + LOTTO_BOUND + "이하 양수입니다.");
        }
    }
}
