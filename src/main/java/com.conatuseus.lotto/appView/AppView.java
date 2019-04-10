/*
 *  @(#)AppView.java       3.00    2019/04/10
 *
 *  Copyright   (c) 2019 Myungki Sa.
 *  Computer Science Engineering, Java, Daejeon, Korea
 *  All rights reserved.
 *  conatuseus@gmail.com
 */

package com.conatuseus.lotto.appView;

import com.conatuseus.lotto.appController.AppController;
import com.conatuseus.lotto.model.Lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * I/O를 담당하는 클래스
 * author 사명기
 * @version 3.00    2019년 4월 10일
 */
public class AppView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String NUMBER_REGEX = "[0-9]+";
    public static final int FAIL_INPUT = -1;

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

    /* 입력 받은 구입금액 유효성 확인 메소드 */
    private static boolean isMoneyValid(String scannedMoney) {
        if (!scannedMoney.matches(NUMBER_REGEX)) {
            return false;                                   // 입력이 숫자가 아니면
        }
        int tInputMoney = Integer.parseInt(scannedMoney);
        return (tInputMoney % AppController.LOTTO_COST) == 0;           // 금액이 1000원 단위인지 아닌지 반환
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            AppView.outputLine(lotto.toString());
        }
    }

    /* 지난 주 당첨 번호 입력 메소드*/
    public static List<Integer> inputWinningLotto() throws IOException {
        String[] scannedNumbers;

        do {
            outputLine("지난 주 당첨 번호를 입력해 주세요.");
            scannedNumbers = br.readLine().split(",");
        } while (!isWinningLottoValid(scannedNumbers));

        return convertStringArrayToIntList(scannedNumbers);     // 유효한 입력이라면 List로 변경 후 반환
    }

    /**
     *  입력 받은 숫자들이 유효한지 확인하는 메소드
     * @param scannedNumbers 입력받은 지난주 당첨번호
     * @return 올바른 입력이면 true, 아니면 false
     */
    public static boolean isWinningLottoValid(String[] scannedNumbers) {
        if (scannedNumbers.length != AppController.LOTTO_LENGTH) {
            return false;                                               // 배열의 크기가 6보다 작으면
        }

        int i = 0;
        Set<Integer> set = new HashSet<>();
        while (i < AppController.LOTTO_LENGTH
                && scannedNumbers[i].length() >= 1                                              // String의 길이가 0보다 크면
                && scannedNumbers[i].matches(NUMBER_REGEX)                                      // String이 숫자아면
                && isWinningNumberValid(Integer.parseInt(scannedNumbers[i]))) {                 // 숫자가 1~45 사이의 수 이면
            set.add(Integer.parseInt(scannedNumbers[i]));
            i++;
        }

        return set.size() == AppController.LOTTO_LENGTH;                                        // set의 크기가 6인지아닌지 반환.
    }

    /* 1개의 당첨번호 1-45사이 값인지 확인 메소드 */
    public static boolean isWinningNumberValid(int scannedNumber) {
        return scannedNumber >= AppController.MIN_LOTTO_VALUE && scannedNumber <= AppController.MAX_LOTTO_VALUE;
    }

    /* 입력받은 String Array를  ArrayList<Integer>로 반환하는 메소드 */
    public static List<Integer> convertStringArrayToIntList(String[] scannedNumbers) {
        Set<Integer> set = new TreeSet<>();
        for (String number : scannedNumbers) {
            set.add(Integer.parseInt(number));
        }
        return new ArrayList<>(set);
    }

    public static int inputWinningBonusNumber() throws IOException {
        outputLine("보너스 볼을 입력해 주세요.");
        String scannedNumber = br.readLine();
        return isWinningBonusValid(scannedNumber) ? Integer.parseInt(scannedNumber) : FAIL_INPUT;
    }

    /* 보너스볼이 유효한 수인지 확인하는 메소드*/
    public static boolean isWinningBonusValid(String scannedNumber) {
        if (scannedNumber.length() == 0 || !scannedNumber.matches(NUMBER_REGEX)) {
            return false;                                                               // 길이가0 이거나, 숫자가 아니면 return false
        }
        int number = Integer.parseInt(scannedNumber);
        return (number >= AppController.MIN_LOTTO_VALUE) && (number <= AppController.MAX_LOTTO_VALUE);      // 숫자가 1~45사이의 수인지 아닌지
    }

    public static void printPrefixResultOfLotto() {
        outputLine("당첨 통계");
        outputLine("---------------");
    }
}
