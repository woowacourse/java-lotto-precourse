/*
 * @(#)LottoGame.java        0.2 2019/04/09
 *
 *
 */

package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LottoGame을 담당하는 객체입니다.
 *
 * @author 반선호
 * @version 0.2 2019년 4월 09일
 */
public class LottoGame {
    private static final int TICKET_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_MIN_NUM = 1;

    private static final Scanner scanner = new Scanner(System.in);

    private List<Lotto> lottoList = new ArrayList<>();
    private WinningLotto winningLotto;

    public void start() {
        int lottoAmount = getLottoAmount();

        lottoPurchase(lottoAmount);
        requestWinningLotto();
    }

    private void requestWinningLotto() {
        List<Integer> winningNumbers;
        String userInput;

        do {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.(,구분으로 입력)");
            userInput = scanner.nextLine();
            winningNumbers = checkRightWinningNumber(userInput);
        } while (!checkNumberLength(winningNumbers));
    }

    private boolean checkNumberLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_SIZE) {
            System.out.println("입력이 잘못 되었습니다. 중복하지 않는 1~45까지의 숫자 6개를 입력해 주세요.");
            System.out.println();
            return false;
        }
        return true;
    }

    private List<Integer> checkRightWinningNumber(String userInput) {
        String[] splitInput = userInput.split(",");
        return Arrays.stream(splitInput).
                limit(LOTTO_SIZE).
                distinct().
                filter(this::checkNumber).
                map(i -> Integer.parseInt(i.trim())).
                filter(this::checkLottoRange).
                sorted().
                collect(Collectors.toList());
    }

    private boolean checkLottoRange(int number) {
        if ((number < LOTTO_MIN_NUM) || (number > LOTTO_MAX_NUM)) {
            System.out.println("[" + number + "] 로또 숫자 범위(1~45)를 벗어났습니다.");
            return false;
        }
        return true;
    }

    private void lottoPurchase(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
        for (int i = 0; i < lottoAmount; i++) {
            lottoList.add(makeLotto());
        }
    }

    private Lotto makeLotto() {
        List<Integer> lotto = new ArrayList<>();

        do {
            lotto.add(makeLottoNumber(lotto));
        } while (lotto.size() < LOTTO_SIZE);
        Collections.sort(lotto);
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private int makeLottoNumber(List<Integer> lotto) {
        Random random;
        int randomNumber;

        do {
            random = new Random();
            randomNumber = random.nextInt(LOTTO_MAX_NUM) + LOTTO_MIN_NUM;
        } while (lotto.contains(randomNumber));
        return randomNumber;
    }

    private int getLottoAmount() {
        int purchaseAmount = requestPurchaseAmount();

        return (purchaseAmount / TICKET_PRICE);
    }

    private int requestPurchaseAmount() {
        String purchaseAmount;

        do {
            System.out.println("구입 금액을 입력해 주세요.");
            purchaseAmount = scanner.nextLine();
        } while (!checkNumber(purchaseAmount) || !checkRightPurchaseAmount(purchaseAmount));
        return Integer.parseInt(purchaseAmount);
    }

    private boolean checkNumber(String userInput) {
        try {
            Integer.parseInt(userInput.trim());
        } catch (NumberFormatException e) {
            System.out.println("[" + userInput + "]는 숫자가 아닙니다. 숫자를 입력해 주세요.");
            return false;
        }
        return true;
    }

    private boolean checkRightPurchaseAmount(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);

        if ((amount < TICKET_PRICE) || ((amount % TICKET_PRICE) != 0)) {
            System.out.println("구입 금액이 잘못 되었습니다. 티켓 한장의 가격은 1000원입니다.");
            return false;
        }
        return true;
    }
}
