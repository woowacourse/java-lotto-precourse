package domain;

import java.util.Scanner;

public class LottoGame {
    private static int printInitialLines() {
        Scanner scan = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요");
        int purchase = scan.nextInt();
        int count = purchase / 1000;
        System.out.println((count) + "개를 구매했습니다.");

        scan.nextLine();
        return count;
    }

    public static void main(String[] args) {
        int gameCount = printInitialLines();
    }
}
