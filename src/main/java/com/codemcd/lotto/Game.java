package com.codemcd.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    private static final int MIN_LOTTO_PRICE = 1000;
    private static final int MAX_RANK_NUMBER = 5;

    private int moneyForLotto;
    private int numberOfLotto;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;
    private int totalPrizeMoney = 0;
    private List<Integer> countOfRank = new ArrayList<>(MAX_RANK_NUMBER + 1);
    private double earningsRate;

    public void start() {
        inputMoney();
        calculateNumberOfLotto();
        buyLotto();
        printLottoNumbers();
        inputWinningAndBonusNumber();
        matchingLotto();
        printLottoResult();
    }

    private void inputMoney() {
        Scanner scanner = new Scanner(System.in);
        String inputMoneyForLotto;

        System.out.println("구입 금액을 입력해주세요.");
        inputMoneyForLotto = scanner.nextLine();
        // 입력 오류 처리
        moneyForLotto = Integer.parseInt(inputMoneyForLotto);
    }

    private void calculateNumberOfLotto() {
        numberOfLotto = moneyForLotto / MIN_LOTTO_PRICE;
        lottos = new ArrayList<>(numberOfLotto);
    }

    private void buyLotto() {
        for (int i = 0; i < numberOfLotto; ++i) {
            lottos.add(new Lotto(RandomNumber.makeLottoNumber()));
        }
    }

    private void printLottoNumbers() {
        System.out.println();
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        for (int i = 0; i < numberOfLotto; ++i) {
            System.out.println("[" + lottos.get(i).getLottoNumberWithComma() + "]");
        }
    }

    private List<Integer> inputWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        String winningNumber;

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        winningNumber = scanner.nextLine();
        // 오류 처리
        List<Integer> splitWinningNumber = new ArrayList<>();
        for(String number : winningNumber.split(",")) {
            splitWinningNumber.add(Integer.parseInt(number));
        }
        return splitWinningNumber;
    }

    private int inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        String bonusNumber;

        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNumber = scanner.nextLine();
        // 오류 처리
        return Integer.parseInt(bonusNumber);
    }

    private void inputWinningAndBonusNumber() {
        winningLotto = new WinningLotto(new Lotto(inputWinningNumber()), inputBonusNumber());
    }

    private void matchingLotto() {
        initializeCountOfRankList();
        for(int i=0; i<numberOfLotto; ++i) {
            Rank currentRank = winningLotto.match(lottos.get(i));
            countOfRank.set(currentRank.getNumberOfRank(),
                    countOfRank.get(currentRank.getNumberOfRank()) + 1);
            totalPrizeMoney += currentRank.getWinningMoney();
        }
        calculateEarningsRate();
    }

    private void initializeCountOfRankList() {
        for(int i=0; i<MAX_RANK_NUMBER+1; ++i)
            countOfRank.add(0);
    }

    private void calculateEarningsRate() {
        earningsRate = totalPrizeMoney / moneyForLotto;
    }

    private void printLottoResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(String.format("%-35s", "3개 일치 (5,000원)") + "- " + countOfRank.get(5) + "개");
        System.out.println(String.format("%-35s", "4개 일치 (50,000원)") + "- " + countOfRank.get(4) + "개");
        System.out.println(String.format("%-35s", "5개 일치 (1,500,000원)") + "- " + countOfRank.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (3,000,000원) - " + countOfRank.get(2) + "개");
        System.out.println(String.format("%-35s", "6개 일치 (2,000,000,000원)") + "- " + countOfRank.get(1) + "개");
        System.out.println("총 수익률은 " + String.format("%.3f", earningsRate) + "입니다.");
    }
}
