package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

        static int lottoCount;
        private final static int ONCE_COST = 1000;
        private static Lotto[] lottos;
        public static void main(String args[]) {
                buyLotto();
                makeLotto();
        }

        public static void buyLotto() {
                System.out.println("구입금액을 입력해 주세요.");
                Scanner sc = new Scanner(System.in);
                int money = sc.nextInt();

                lottoCount = money / ONCE_COST;
                lottos = new Lotto[lottoCount];
                System.out.println(lottoCount + "개를 구매했습니다.");
        }

        public static void makeLotto() {
                for(int i = 0 ; i < lottoCount; i++){
                        lottos[i] = Lotto.init();
                }
        }
}
