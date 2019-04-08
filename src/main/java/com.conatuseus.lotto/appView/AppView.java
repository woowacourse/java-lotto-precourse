package com.conatuseus.lotto.appView;

import com.conatuseus.lotto.model.Lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class AppView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String MONEY_REGEX = "[0-9]+";

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
        if (!scannedMoney.matches(MONEY_REGEX)) {
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

}
