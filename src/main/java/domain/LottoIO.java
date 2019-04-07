package domain;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * 사용자 입력과 정보 출력을 위한 클래스
 */
public class LottoIO {
    public static void printPurchase() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static int receivePrice() {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printlottoNumber(List<Integer> lotto) {
        System.out.print("[");
        for (int i = 0; i < LottoConstant.LOTTO_MAX_COUNT - 1; i++) {
            System.out.print(lotto.get(i) + ", ");
        }
        System.out.println(lotto.get(LottoConstant.LOTTO_MAX_COUNT - 1) + "]");
    }
}
