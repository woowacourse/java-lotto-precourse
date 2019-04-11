package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 로또 게임 configuration을 담당하는 객체
 */
public class LottoManager {
    public static final int PRICE_PER_LOTTO = 1000;
    public static final int WINNING_NUMBER_BOUND = 45;
    public static final int WINNING_NUMBER_ORIGIN = 1;
    public static final int NUM_OF_WINNING_NUMBERS = 6;

    private Scanner sc;
    private Validator validator;

    public LottoManager() {
        sc = new Scanner(System.in);
        validator = new Validator();
    }

    public int inputPurchaseAmount() {
        String purchaseAmount;

        do {
            System.out.println("구매 금액을 입력해주세요.");
            purchaseAmount = sc.nextLine().trim();
        } while (!validator.takesValidPurchase(purchaseAmount));

        return Integer.parseInt(purchaseAmount);
    }

    private int randomPop(List<Integer> numberSet) {
        int randomIdx = (new Random()).nextInt(numberSet.size());

        return numberSet.remove(randomIdx);
    }

    public Lotto autoIssue() {
        List<Integer> autoNumbers = new ArrayList<Integer>();
        List<Integer> lottoNumberSet = IntStream.rangeClosed(WINNING_NUMBER_ORIGIN, WINNING_NUMBER_BOUND)
                .boxed().collect(Collectors.toList());

        for (int i = 0; i < NUM_OF_WINNING_NUMBERS; i++) {
            autoNumbers.add(randomPop(lottoNumberSet));
        }

        return new Lotto(autoNumbers);
    }

    public List<Lotto> issueLottoWorthOf(int purchasedMoney) {
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
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.print("\n");
    }

    private List<String> trimAllElementsOf(String[] splited) {
        return Arrays.stream(splited)
                .map(String::trim)
                .filter(str -> !str.equals(""))
                .collect(Collectors.toList());
    }

    public List<Integer> inputWinningNumbers() {
        List<String> winningNumbers;

        do {
            System.out.println("지난 주 당첨 번호를 입력해주세요.");
            winningNumbers = trimAllElementsOf(sc.nextLine().split(","));
        } while (!validator.takesValidWinningNumbers(winningNumbers));

        return winningNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public int inputBonusOf(List<Integer> winningNumbers) {
        String bonusNo;

        do {
            System.out.println("보너스 볼을 입력해주세요");
            bonusNo = sc.nextLine().trim();
        } while (!validator.takesValidBonusNo(bonusNo, winningNumbers));

        return Integer.parseInt(bonusNo);
    }
}
