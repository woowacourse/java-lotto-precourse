package game;

import domain.Lotto;

import java.util.*;

import static game.Buyer.NUMBER_PER_LOTTO;
import static game.Buyer.LOTTO_NUMBER_BOUNDARY;

/**
 * 당첨 번호와 보너스 번호를 만드는 객체
 */
public class LottoMachine {
    private static final int MIN_BOUNDARY = 1;
    private static int bonusNumInput;            // 입력받은 보너스 숫자

    /*
     * 당첨 번호가 조건에 맞으면 발급
     */
    public Lotto makeWinningLotto() {
        String input;
        Scanner scanner = new Scanner(System.in);
        List<Integer> list;

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        do {
            input = scanner.nextLine();
            list = inspector(input);
        } while (!inspectLottoCondition(list));
        return new Lotto(list);
    }
}
