package domain;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class LottoGame {

    private static final String MESSAGE_INPUT_MONEY = "구매금액을 입력해 주세요.";
    private static final String MESSAGE_GET_LOTTO = "개를 구매했습니다.";
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_NUMBER= 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<Lotto> purchasedLottoList;

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

    private void createLotto(int countLotto) {
        for(int i = 0; i < countLotto; i++) {
            Lotto lotto = new Lotto(getRandomList());
            purchasedLottoList.add(lotto);
        }
    }

    private List<Integer> getRandomList(){
        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            randomList.add(random.nextInt(MAX_LOTTO_NUMBER) + 1);
        }
        return randomList;
    }


}
