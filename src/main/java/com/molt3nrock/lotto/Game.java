package com.molt3nrock.lotto;

import static com.molt3nrock.lotto.Constants.COUNT_OF_NUMBERS_PER_LOTTO;
import static com.molt3nrock.lotto.Constants.MAXIMUM_NUMBER_OF_LOTTO;
import static com.molt3nrock.lotto.Constants.MINIMUM_NUMBER_OF_LOTTO;
import static com.molt3nrock.lotto.Constants.PRICE_PER_LOTTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int money = getMoney(br);
            List<Lotto> lottoList = LottoBuilder.create().withMoney(money).build();
            displayLottoPurchaseResult(money, lottoList);
            Statistics.valueOf(lottoList, getWiningLotto(br)).displayStatistics();
        } catch (Exception e) {
            System.out.println(String.format("게임 오류: %s", e.getMessage()));
        }
    }

    /**
     * Lotto 구입 상태 출력.
     *
     * 거슬러 줄 돈이 있으면 그것을 출력하고 구입한 {@code List<Lotto>}의 숫자들을 출력합니다.
     *
     * @param money     사용자가 입력한 돈
     * @param lottoList 생성된 Lotto List
     */
    private static void displayLottoPurchaseResult(int money, List<Lotto> lottoList) {
        int moneyChange = money % PRICE_PER_LOTTO;
        if (money >= PRICE_PER_LOTTO && moneyChange > 0) {
            System.out.println(String.format("\n잔돈 %d원을 거슬러 드립니다.", moneyChange));
        }
        System.out.println(String.format("\n%d개를 구매했습니다", lottoList.size()));
        lottoList.forEach(System.out::println);
    }

    private static int getMoney(BufferedReader br) throws IllegalArgumentException, IOException {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 돈이 아닙니다.");
        }
    }

    private static WinningLotto getWiningLotto(BufferedReader br)
        throws IOException, IllegalArgumentException {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = parseAsWinNumbers(br.readLine());
        System.out.println("보너스 볼을 입력해 주세요.");
        Integer bonusNumber = parseAsBonusNumber(br.readLine(), winningNumbers);
        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }

    private static Integer parseAsBonusNumber(String line, List<Integer> winningNumbers)
        throws IllegalArgumentException {
        Integer bonusNumber = parseStringAsInteger(line);
        if (winningNumbers.stream().anyMatch(i -> i.equals(bonusNumber))
            || bonusNumber < MINIMUM_NUMBER_OF_LOTTO || bonusNumber > MAXIMUM_NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException("올바른 보너스번호 입력이 아닙니다.");
        }
        return bonusNumber;
    }

    private static List<Integer> parseAsWinNumbers(String line) throws IllegalArgumentException {
        List<Integer> numbers = Arrays.stream(line.split(","))
            .map(s -> parseStringAsInteger(s.trim()))
            .filter(i -> i >= MINIMUM_NUMBER_OF_LOTTO && i <= MAXIMUM_NUMBER_OF_LOTTO)
            .collect(Collectors.toList());
        if (numbers.stream().distinct().count() == COUNT_OF_NUMBERS_PER_LOTTO) {
            return numbers;
        }
        throw new IllegalArgumentException("올바른 당첨번호 입력이 아닙니다.");
    }

    private static Integer parseStringAsInteger(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 번호가 아닙니다.");
        }
    }
}
