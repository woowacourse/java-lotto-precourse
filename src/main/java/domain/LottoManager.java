package domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 로또 게임 configuration과 사용자 인터페이스를 담당하는 객체
 */
public class LottoManager {
    Scanner sc = new Scanner(System.in);
    Validator validator = new Validator();

    private final int PRICE_PER_LOTTO = 1000;
    private final int NUM_OF_WINNING_NUMBER = 6;
    private final int WINNING_NUMBER_BOUND = 45 + 1;
    private final int WINNING_NUMBER_ORIGIN = 1;

    private int purchaseAmount;

    public int inputPurchaseAmount() {
        String purchaseAmount;

        do {
            System.out.println("구매 금액을 입력해주세요.");
            purchaseAmount = sc.nextLine();
        } while(!validator.isValidPurchase(purchaseAmount));

        this.purchaseAmount = Integer.parseInt(purchaseAmount);
        return this.purchaseAmount;
    }

    public Lotto autoIssue() {
        Random random = new Random();
        List<Integer> autoNumbers = random.ints(NUM_OF_WINNING_NUMBER, WINNING_NUMBER_ORIGIN, WINNING_NUMBER_BOUND)
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

        return lottos;
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
            System.out.println("보너스 볼을 읿력해주세요");
            bonus = sc.nextLine();
        } while(!validator.isValidBonus(bonus));

        return Integer.parseInt(bonus);
    }

    public void showEarningRate(HashMap<Lotto, Rank> matchResult) {

    }
}