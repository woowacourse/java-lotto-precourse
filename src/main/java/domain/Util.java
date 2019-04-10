package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Util {
    private static Scanner sc = new Scanner(System.in);

    public static void printConsole(String message) {
        System.out.println(message);
    }

    public static void printConsole(List<Integer> message) {
        System.out.println(message);
    }

    public static String getConsoleInput() {
        return removeBlank(sc.nextLine());
    }

    public static Integer fromStringToInteger(String inputString) {
        try {
            return Integer.parseInt(inputString);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static String removeBlank(String inputString) {
        return inputString.replace(" ", "");
    }

    public static int divideThousand(int number) {
        return number / 1000;
    }

    public static boolean isGreaterThanZero(int input) {
        return (input > 0);
    }

    public static String[] splitStringbyComma(String string) {
        return string.split(",");
    }

    public static String getRankMessage(Rank rank, int rankCount) {
        if (rank != Rank.SECOND) {
            return rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + rankCount + "개";
        }
        return rank.getCountOfMatch() + "개 일치, 보너스볼 일치 (" + rank.getWinningMoney() + "원)- " + rankCount + "개";
    }

    public static void checkBonusNumber(List<Integer> winningLottoNumber, int winningLottoBonus) {
        if (winningLottoNumber.contains(winningLottoBonus)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호와 같은 수를 가질 수 없습니다.");
        }
    }

    public static void checkLottoNumber(List<Integer> numbers) {
        Set<Integer> tempSet = new HashSet<>(numbers);
        if (tempSet.size() < numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

}
