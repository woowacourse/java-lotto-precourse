package com.nekisse.view;

import com.nekisse.domain.LottoNumber;

import java.util.Scanner;

public class InputView {

    public static int getInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static LottoNumber getInputBonusWinningLottoNumber() {
        System.out.println("보너스 숫자 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        return LottoNumber.getBasicNumber(inputNumber);
    }

    public static String getInputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
