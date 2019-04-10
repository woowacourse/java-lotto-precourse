package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

        static int lottoCount;
        private final static int ONCE_COST = 1000;
        private static Lotto[] lottos;
        private static WinningLotto winningLotto;
        private static List<Rank> ranks = new ArrayList();
        private static int[] winners = new int[5];
        private static Rank[] rankArray = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};

        private final static int LOTTO_MAX_NUM = 45;
        private final static int LOTTO_NUMBER_SIZE = 6;

        public static void main(String args[]) throws IOException {
                buyLotto();
                makeLotto();
                printLotto();
                setWinningLotto();
                matchLotto();
                printPrize();
                printRate();
        }

        private static void buyLotto() {
                System.out.println("구입금액을 입력해 주세요.");
                Scanner sc = new Scanner(System.in);
                int money = sc.nextInt();

                lottoCount = money / ONCE_COST;
                lottos = new Lotto[lottoCount];
                System.out.println();
                System.out.println(lottoCount + "개를 구매했습니다.");
        }

        private static void makeLotto() {
                for (int i = 0; i < lottoCount; i++) {
                        lottos[i] = Lotto.init();
                }
        }

        private static void printLotto() {
                for (Lotto lotto : lottos) {
                        System.out.println(lotto.getNumbers());
                }
        }

        private static void setWinningLotto() throws IOException {
                List winningList = getWinningNumber();
                int bonusNo = getBonusNumber();
                winningLotto = new WinningLotto(new Lotto(winningList), bonusNo);
        }

        private static List getWinningNumber() throws IOException {
                List winningList = new ArrayList();
                boolean valid = true;
                while (valid) {
                        System.out.println("지난 주 당첨 번호를 입력해 주세요");
                        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                        String[] num = bf.readLine().split(",");
                        valid = isValid(num, winningList);
                }

                return winningList;
        }

        private static boolean isValid(String[] num, List winningList) {
                for (int i = 0; i < num.length; i++) {
                        validParseNumber(Integer.parseInt(num[i]), winningList);
                }

                if (winningList.size() != LOTTO_NUMBER_SIZE) {
                        System.out.println("당첨 번호가 잘못되었습니다.");
                        return true;
                }

                return false;
        }

        private static void validParseNumber(int num, List winningList) {
                if (num > LOTTO_MAX_NUM) {
                        return;
                }
                winningList.add(num);
        }

        private static int getBonusNumber() throws IOException {
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("보너스 볼을 입력해 주세요.");
                return Integer.parseInt(bf.readLine());
        }

        private static void matchLotto() {
                for (Lotto lotto : lottos) {
                        Rank rank = winningLotto.match(lotto);
                        ranks.add(rank);
                }
                for (Rank rank : ranks) {
                        setWinnerArray(rank);
                }

        }

        private static void setWinnerArray(Rank rank) {
                if (Rank.FIFTH == rank) {
                        winners[0]++;
                }
                if (Rank.FOURTH == rank) {
                        winners[1]++;
                }
                if (Rank.THIRD == rank) {
                        winners[2]++;
                }
                if (Rank.SECOND == rank) {
                        winners[3]++;
                }
                if (Rank.FIRST == rank) {
                        winners[4]++;
                }
        }

        private static void printPrize() {
                System.out.println();
                System.out.println("당첨 통계");
                System.out.println("--------");
                for (int i = 0; i < rankArray.length; i++) {
                        printFormat(i);
                }

        }

        private static void printFormat(int i) {
                if (i == 3) {
                        System.out.printf("%d개 일치 보너스 볼 일치(%d)- %d개\n", rankArray[i].getCountOfMatch(), rankArray[i].getWinningMoney(), winners[i]);
                        return;
                }
                System.out.printf("%d개 일치(%d)- %d개\n", rankArray[i].getCountOfMatch(), rankArray[i].getWinningMoney(), winners[i]);

        }

        private static void printRate() {
                int prize = 0;
                for (int i = 0; i < winners.length; i++) {
                        prize += winners[i] * rankArray[i].getWinningMoney();
                }

                System.out.printf("총 수익률은 %.3f입니다.", (float) prize / (ONCE_COST * lottoCount));
        }

}
