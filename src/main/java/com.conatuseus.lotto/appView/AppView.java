package com.conatuseus.lotto.appView;

import com.conatuseus.lotto.appController.AppController;
import com.conatuseus.lotto.model.Lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AppView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String NUMBER_REGEX = "[0-9]+";

    /* AppView 클래스 기본생성자*/
    public AppView() {
    }

    /* 매개변수 String을 print하는 메소드. 줄바꿈을 포함 */
    public static void outputLine(String aString) {
        System.out.println(aString);
    }

    /* 매개변수 String을 print하는 메소드. 줄바꿈 하지 않음 */
    public static void output(String aString) {
        System.out.print(aString);
    }

    public static int inputMoney() throws IOException {
        String scannedMoney;

        do {
            outputLine("구입금액을 입력해 주세요.(0이상 1000원 단위)");
            scannedMoney = br.readLine();
        } while (!isMoneyValid(scannedMoney));

        return Integer.parseInt(scannedMoney);
    }

    private static boolean isMoneyValid(String scannedMoney) {
        if (!scannedMoney.matches(NUMBER_REGEX)) {
            return false;
        }
        int tInputMoney = Integer.parseInt(scannedMoney);
        return (tInputMoney % 1000) == 0;
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public static List<Integer> inputWinningLotto() throws IOException {
        String[] scannedNumbers;

        do {
            outputLine("지난 주 당첨 번호를 입력해 주세요.");
            scannedNumbers = br.readLine().split(",");
        } while (!isWinningLottoValid(scannedNumbers));

        return StringArrayToIntList(scannedNumbers);
    }

    public static boolean isWinningLottoValid(String[] scannedNumbers) {
        if (scannedNumbers.length != AppController.LOTTO_LENGTH) {
            return false;
        }

        int i = 0;
        Set<Integer> set = new HashSet<>();
        while (i < AppController.LOTTO_LENGTH && scannedNumbers[i].length() >= 1
                && scannedNumbers[i].matches(NUMBER_REGEX) && isWinningNumberValid(Integer.parseInt(scannedNumbers[i]))) {
            set.add(Integer.parseInt(scannedNumbers[i]));
            i++;
        }

        return set.size() == AppController.LOTTO_LENGTH;
    }

    public static boolean isWinningNumberValid(int scannedNumber) {
        return scannedNumber >= AppController.MIN_LOTTO_VALUE && scannedNumber <= AppController.MAX_LOTTO_VALUE;
    }

    public static List<Integer> StringArrayToIntList(String[] scannedNumbers) {
        Set<Integer> set = new TreeSet<>();
        for (String number : scannedNumbers) {
            set.add(Integer.parseInt(number));
        }
        return new ArrayList<>(set);
    }

    public static int inputWinningBonusNumber() throws IOException {
        outputLine("보너스 볼을 입력해 주세요.");
        String scannedNumber = br.readLine();
        return isWinningBonusValid(scannedNumber) ? Integer.parseInt(scannedNumber) : -1;
    }

    public static boolean isWinningBonusValid(String scannedNumber) {
        if (scannedNumber.length() == 0 || !scannedNumber.matches(NUMBER_REGEX)) {
            return false;
        }
        int number = Integer.parseInt(scannedNumber);
        return (number >= AppController.MIN_LOTTO_VALUE) && (number <= AppController.MAX_LOTTO_VALUE);
    }

    public static void printResultOfLotto(){
        outputLine("당첨 통계");
        outputLine("---------------");
    }
}
