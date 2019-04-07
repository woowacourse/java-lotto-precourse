package com.codemcd.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final int MIN_LOTTO_PRICE = 1000;

    private int moneyForLotto;
    private int numberOfLotto;
    private List<Lotto> lottos;

    public void start() {
        inputMoney();
        calculateNumberOfLotto();
        buyLotto();
        printLottoNumbers();
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
}
