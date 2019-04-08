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

}

class GeneratingLottoNumber {
    private static final int LOTTO_COUNT = 6;
    private static final int LOTTO_NUMBER_BEGIN = 1;
    private static final int LOTTO_NUMBER_END = 1;

    static List<Integer> generatingLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>();
        for (int number = LOTTO_NUMBER_BEGIN; number < LOTTO_NUMBER_END+1; number++) {
            lottoNumber.add(number);
        }
        Collections.shuffle(lottoNumber);
        return lottoNumber.subList(0, LOTTO_COUNT);
    }
}