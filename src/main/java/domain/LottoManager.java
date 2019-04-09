package domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 로또 게임 configuration을 담당하는 객체
 */
public class LottoManager {
    public static final int PRICE_PER_LOTTO = 1000;
    public static final int WINNING_NUMBER_BOUND = 45 + 1;
    public static final int WINNING_NUMBER_ORIGIN = 1;
    public static final int NUM_OF_WINNING_NUMBERS = 6;

    private Scanner sc = new Scanner(System.in);
    private Validator validator = new Validator();

    public int inputPurchaseAmount() {
        String purchaseAmount;

        do {
            System.out.println("구매 금액을 입력해주세요.");
            purchaseAmount = sc.nextLine();
        } while(!validator.isValidPurchase(purchaseAmount));
        return Integer.parseInt(purchaseAmount);
    }

    public Lotto autoIssue() {
        Random random = new Random();
        List<Integer> autoNumbers = random.ints(NUM_OF_WINNING_NUMBERS,
                WINNING_NUMBER_ORIGIN, WINNING_NUMBER_BOUND)
                .boxed()
                .collect(Collectors.toList());

        return new Lotto(autoNumbers);
    }

    public List<Lotto> issueLottoOf(int purchasedMoney) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        int numberOfLotto = purchasedMoney / PRICE_PER_LOTTO;

        for (int i = 1; i <= numberOfLotto; i++) {
            lottos.add(autoIssue());
        }
        System.out.println("\n" + numberOfLotto + " 개를 구매하셨습니다.");
        showLottos(lottos);
        return lottos;
    }

    public void showLottos(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.print("\n");
    }

    public Lotto inputWinningNumbers() {
        List<Integer> winningNumbers;

        do {
            System.out.println("지난 주 당첨 번호를 입력해주세요.");
            winningNumbers = Arrays.stream(sc.nextLine().split(","))
                    .map(s -> Integer.valueOf(s))
                    .collect(Collectors.toList());
        } while(!validator.isValidWinningNumbers(winningNumbers));
        return new Lotto(winningNumbers);
    }

    public int inputBonus() {
        String bonus;

        do {
            System.out.println("보너스 볼을 입력해주세요");
            bonus = sc.nextLine();
        } while(!validator.isValidBonus(bonus));
        return Integer.parseInt(bonus);
    }
}