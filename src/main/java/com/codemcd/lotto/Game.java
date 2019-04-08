package com.codemcd.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    private static final int MIN_LOTTO_PRICE = 1000;

    private int moneyForLotto;
    private int numberOfLotto;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    public void start() {
        inputMoney();
        calculateNumberOfLotto();
        buyLotto();
        printLottoNumbers();
        inputWinningAndBonusNumber();
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
            lottos.get(i).printLotto();
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
        winningLotto.printLotto();
    }
}
