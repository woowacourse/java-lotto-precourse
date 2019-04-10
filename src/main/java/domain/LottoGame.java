package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LottoGame {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_INTEGER_ERROR_MESSAGE = "숫자가 아닙니다. 다시 입력해주세요: ";
    private static final String MONEY_UNIT_ERROR_MESSAGE = "천단위의 숫자가 아닙니다. 다시 입력해주세요: ";
    private static final String SPLIT_STANDARD = ",";
    private static final int MONEY_UNIT = 1000;
    private static final int ZERO = 0;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int NUMBER_OF_LOTTO = 6;

    public void run() {
        System.out.println(INPUT_MONEY_MESSAGE);
        int lottoGameMoney = inputLottoMoney();
        int lottoRound = calculateLottoRound(lottoGameMoney);

        for (int num : getLottoNumberList()) {
            System.out.println(num);
        }
    }

    private List<Integer> getLottoNumberList() {
        int randomNumber;
        List<Integer> lottoNumberList = new ArrayList<>();

        while (lottoNumberList.size() != NUMBER_OF_LOTTO) {
            randomNumber = getRandomNumber();
            addLottoNumber(lottoNumberList, randomNumber);
        }

        return lottoNumberList;
    }

    private void addLottoNumber(List<Integer> numberList, int randomNumber) {
        if (!numberList.contains(randomNumber)) {
            numberList.add(randomNumber);
        }
    }

    private int calculateLottoRound(int money) {
        return money / MONEY_UNIT;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER;
    }

    private int inputLottoMoney() {
        String money = inputMethod(true);
        int intMoney = Integer.parseInt(money);

        if (intMoney % MONEY_UNIT != ZERO || intMoney == 0) {
            System.err.println(MONEY_UNIT_ERROR_MESSAGE);
            return inputLottoMoney();
        }

        return intMoney;
    }

    private String inputMethod(boolean isSingle) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String checkString = isSingle ? input : input.replaceAll(SPLIT_STANDARD, "");

        if (isBlank(checkString) || isNotNumber(checkString)) {
            return inputMethod(isSingle);
        }

        return input;
    }

    private boolean isNotNumber(String input) {
        try {
            Long.parseLong(input);
            return false;

        } catch (NumberFormatException e) {
            System.err.println(INPUT_INTEGER_ERROR_MESSAGE);
            return true;
        }
    }

    private boolean isBlank(String input) {
        if (input.isEmpty()) {
            System.err.println("아무것도 입력되지 않았습니다.");
            return true;
        }

        return false;
    }
}
