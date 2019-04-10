package domain.util;

import domain.Lotto;
import domain.Game;

import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class PrintScan {
    private static Scanner scan = new Scanner(System.in);

    public static int requesetInputMoney() {
        System.out.format("로또를 구매할 금액을 입력해 주세요. 로또는 장당 %d원 입니다.%n", Constant.MIN_INPUT_MONEY);
        return Integer.parseInt(scan.nextLine().trim());
    }

    public static void printOutofRangeNotice(int min, int max) {
        System.out.format("%d이상 %d이하의 올바른 숫자를 입력해 주세요.%n",min, max);
    }

    public static void printRestMoney(int restMoney) {
        System.out.format("%d원의 거스름돈이 남았습니다.%n", restMoney);
    }

    public static void printUserLottoInformation(List<Lotto> lottos, int numberOfLotto) {
        System.out.format("%d장의 로또를 구입했습니다.%n", numberOfLotto);
        System.out.println("----------------------");
        for (int i = 0; i < numberOfLotto; i++) {
            String lottoNumberString = lottos.get(i).lottoListToString(lottos.get(i));
            System.out.println(lottoNumberString);
        }
    }

    public static String requestWinningNum() {
        System.out.println("지난주 로또 번호를 ','로 구분해서 입력해 주세요");
        return scan.nextLine().trim();
    }

    public static void printInvalidNumber() {
        System.out.println("형식에 맞는 유효한 숫자를 입력해주세요");
    }

    public static int requestBonusNum(){
        System.out.println("보너스 번호를 입력해주세요.");
        return Integer.parseInt(scan.nextLine().trim());
    }

}
