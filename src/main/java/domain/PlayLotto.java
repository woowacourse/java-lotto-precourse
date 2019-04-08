package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlayLotto {

    public int insertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public List<Lotto> purchaseLotto() {
        int LOTTO_PRICE = 1000;
        int money = insertMoney();
        int numberOfLotto; // 구입할 Lotto 개수
        List<Integer> lottoNumber; // Lotto 번호 List
        Lotto lotto;
        List<Lotto> myLotto = new ArrayList<>(); // 구입한 내 Lotto List
        while (money < 0) {
            System.out.println("Lotto 구입금액은 0이상의 자연수입니다.");
            money = insertMoney();
        }
        numberOfLotto = money / LOTTO_PRICE;
        System.out.printf("%d개를 구매했습니다.\n", numberOfLotto);
        for (int i = 0; i < numberOfLotto; i++) {
            lottoNumber = GeneratingLottoNumber.generatingLottoNumber();
            System.out.println(lottoNumber);
            lotto = new Lotto(lottoNumber);
            myLotto.add(lotto);
        }
        return myLotto;
    }

}

class GeneratingLottoNumber {
    private static final int LOTTO_COUNT = 6;
    private static final int LOTTO_NUMBER_BEGIN = 1;
    private static final int LOTTO_NUMBER_END = 45;

    static List<Integer> generatingLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>();
        for (int number = LOTTO_NUMBER_BEGIN; number < LOTTO_NUMBER_END+1; number++) {
            lottoNumber.add(number);
        }
        Collections.shuffle(lottoNumber);
        return lottoNumber.subList(0, LOTTO_COUNT);
    }
}