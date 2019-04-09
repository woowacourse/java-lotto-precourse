package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

        static int lottoCount;
        private final static int onceCost = 1000;

        public static void main(String args[]) {
                buyLotto();
        }

        public static void buyLotto() {
                System.out.println("구입금액을 입력해 주세요.");
                Scanner sc = new Scanner(System.in);
                int money = sc.nextInt();

                lottoCount = money/ onceCost;

                System.out.println(lottoCount + "개를 구매했습니다.");
        }
}
