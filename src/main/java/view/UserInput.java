package view;

import controller.LottoController;


import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

    private Scanner sc = new Scanner(System.in);
    private LottoController lottoController;

    public void inputMoney() throws Exception {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int money = sc.nextInt();
            testValidArgument(money);

            this.lottoController = new LottoController(money);

        } catch (InputMismatchException e) {
            throw new InputMismatchException("숫자를 입력해 주세요.");
        }
    }

    private void testValidArgument(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("1000보다 큰 금액을 입력해주세요.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000의 배수 금액을 입력해주세요.");
        }
    }


}
