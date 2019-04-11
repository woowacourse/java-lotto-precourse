package game;

import domain.Lotto;

import java.util.*;

/**
 * 로또 구매자 객체
 */
public class Buyer {
    static final int  NUMBER_PER_LOTTO = 6;
    static final int LOTTO_NUMBER_BOUNDARY = 45;
    private static final int MIN_PAY_MONEY = 0;

    /*
     * 구입금액 입력이 조건에 맞으면 구매를 완료한다
     */
    public int buyMoney() {
        int money;
        System.out.println("구입금액을 입력해 주세요.");
        do {
            money = inspectBuyMoneyCondition();
        } while (money < MIN_PAY_MONEY);
        return money;
    }

    /*
     * 구입금액 입력 예외처리
     */
    public int inspectBuyMoneyCondition() {
        Scanner scanner = new Scanner(System.in);
        int money;

        try {
            money = scanner.nextInt();
        } catch (InputMismatchException e) {
            money = -1;
        }
       printReInputMoney(money);
        return money;
    }

    public void printReInputMoney(int money) {
        if (money < MIN_PAY_MONEY) {
            System.out.println("로또 규칙에 맞게 구입 금액을 다시 입력해주세요.");
        }
    }

    /*
     * 1 ~ 45 사이의 수로 중복없이 랜덤으로 6개의 숫자를 만들고 리스트에 담음
     */
    public List<Integer> makeLottoNumber() {
        Random random = new Random();
        int number;
        Set<Integer> set = new HashSet<>();

        while (set.size() != NUMBER_PER_LOTTO) {
            number = random.nextInt(LOTTO_NUMBER_BOUNDARY) + 1;
            set.add(number);
        }
        return new ArrayList(set);
    }

    /*
     * 번호를 담은 로또들의 리스트를 만들고 반환
     */
    public List<Lotto> purchaseLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumber = makeLottoNumber();
            Collections.sort(lottoNumber);
            lottos.add(new Lotto(lottoNumber));
        }
        return lottos;
    }
}
