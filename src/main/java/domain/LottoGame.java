/*
 * @(#)LottoGame.java        0.2 2019/04/09
 *
 *
 */

package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.LinkedHashMap;

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

    public void start() {
        int lottoAmount = getLottoAmount();
        List<Lotto> lottoList;
        WinningLotto winningLotto;

        lottoList = lottoPurchase(lottoAmount);
        winningLotto = requestWinningLotto();
        lottoResult(lottoList, winningLotto);
    }

    private void lottoResult(List<Lotto> lottoList, WinningLotto winningLotto) {
        Map<Rank, Integer> result = setResult();
        Rank rank;

        System.out.println("당첨 통계\n----------");
        for (int i = 0; i < lottoList.size(); i++) {
            rank = winningLotto.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
    }

    private void printResult(Map<Rank, Integer> result) {
        for (int i = Rank.values().length - 1; i >= 0; i--) {
            Rank.values()[i].printMessage(result.get(Rank.values()[i]));
        }
    }

    private Map<Rank, Integer> setResult() {
        Map<Rank, Integer> result = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    private WinningLotto requestWinningLotto() {
        List<Integer> winningNumbers;
        String userInput;

        do {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.(,구분으로 입력)");
            userInput = scanner.nextLine();
            winningNumbers = convertWinningNumber(userInput);
        } while (!checkNumberLength(winningNumbers));
        return new WinningLotto(new Lotto(winningNumbers), requestBonusNo(winningNumbers));
    }

    private int requestBonusNo(List<Integer> winningNumbers) {
        String userInput;

        do {
            System.out.println("보너스 볼을 입력해 주세요.");
            userInput = scanner.nextLine();
        } while (!checkNumber(userInput) || !checkDuplicateBonusNo(winningNumbers, Integer.parseInt(userInput.trim()))
                || !checkLottoRange(Integer.parseInt(userInput.trim())));
        return Integer.parseInt(userInput.trim());
    }

    private boolean checkDuplicateBonusNo(List<Integer> winningNumbers, int bonusNo) {
        if (winningNumbers.contains(bonusNo)) {
            System.out.println("당첨 숫자와 중복됩니다. 다시 입력해 주세요.");
            return false;
        }
        return true;
    }

    private boolean checkNumberLength(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_SIZE) {
            System.out.println("입력이 잘못 되었습니다. 중복하지 않는 1~45까지의 숫자 6개를 입력해 주세요.");
            System.out.println();
            return false;
        }
        return true;
    }

    private List<Integer> convertWinningNumber(String userInput) {
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

    private List<Lotto> lottoPurchase(int lottoAmount) {
        List<Lotto> lottoList = new ArrayList<>();

        System.out.println(lottoAmount + "개를 구매했습니다.");
        for (int i = 0; i < lottoAmount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
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
