package ExceptionCheck;

import domain.AutoLotto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class NoticeOfException {
    private static final int MAX_LOTTO_SIZE = 6;

    public int inputCostNOE(Scanner sc) {           // 구매 비용에 대한 예외처리
        int cost = 0;
        try {
            cost = sc.nextInt();
            printCostNOE(cost);
        } catch (InputMismatchException e) {
            printNotNumber();
        }
        return cost;
    }

    public int inputBonusNOE(Scanner sc, List<Integer> list) {      //보너스 볼에 대한 예외처리
        System.out.println("보너스 볼을 입력해 주세요.");
        int num = -1;
        try {
            num = sc.nextInt();
            checkBonusNOE(num, list);
        } catch (InputMismatchException e) {
            printNotNumber();
        }
        return num;
    }

    private void checkBonusNOE(int num, List<Integer> list) {
        if (num < 1 || num > 45) {
            System.out.println("잘못된 입력 값입니다.\n1~45까지의 범위를 벗어났습니다.");
            System.exit(0);
        }
        checkSameNum(list, num);
    }

    private void checkSameNum(List<Integer> list, int num) {
        if (list.contains(num)) {
            printOverlapNum();
        }
    }

    public List<Integer> checkListNOE(List<String> stringList) {    //당첨 번호에 대한 예외처리
        List<Integer> list = new ArrayList<>();
        for (String str : stringList) {
            int num = changeStringNum(str);
            list.add(num);
        }
        printNotListSize(list.size());
        return list;
    }

    private int changeStringNum(String str) {
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            printNotNumber();
        }
        return num;
    }

    public void checkOverlapNOE(List<Integer> list) {
        AutoLotto autoLotto = new AutoLotto(list);
        for (int i = 0; i < MAX_LOTTO_SIZE; i++) {
            findOverlap(autoLotto, i);
        }
    }

    private void findOverlap(AutoLotto at, int i) {
        if (at.isFindOverlapNum(i)) {
            printOverlapNum();
        }
    }

    private void printCostNOE(int cost) {
        if (cost < 1000) {
            System.out.println("금액이 부족합니다.");
            System.exit(0);
        }
    }

    private void printNotNumber() {
        System.out.println("잘못된 입력 값입니다.\n숫자가 아닌 값을 입력하셨습니다.");
        System.exit(0);
    }

    private void printNotListSize(int size) {
        if (size < MAX_LOTTO_SIZE || size > MAX_LOTTO_SIZE) {
            System.out.println("잘못된 입력 값입니다.\n당첨 번호의 개수가 6개가 아닙니다.");
            System.exit(0);
        }
    }

    private void printOverlapNum() {
        System.out.println("잘못된 입력 값입니다.\n중복된 값이 포함되어 있습니다.");
        System.exit(0);
    }
}
