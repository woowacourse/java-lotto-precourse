package domain;

import java.awt.peer.LabelPeer;
import java.util.Scanner;

public class LottoGame {

    private static final String MESSAGE_INPUT_MONEY = "구매금액을 입력해 주세요.";
    private static final String MESSAGE_GET_LOTTO = "개를 구매했습니다.";
    private static final int LOTTO_PRICE = 1000;

    private int inputMoney() {
        Scanner scan = new Scanner(System.in);
        String input;
        do {
            System.out.println(MESSAGE_INPUT_MONEY);
            input = scan.nextLine();
        }
        while (!Validation.isValidInputMoney(input));
        return Integer.parseInt(input);
    }

    private int getCountLotto(int money){
        int count = money / LOTTO_PRICE;
        System.out.println(count+MESSAGE_GET_LOTTO);
        return count;
    }


}
