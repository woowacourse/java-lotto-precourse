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
        private static WinningLotto winningLotto;
        private static  List<Rank> ranks;
        private static int[] winners = new int[5];

        public static void main(String args[]) throws IOException {
                buyLotto();
                makeLotto();
                printLotto();
                setWinningLotto();
                matchLotto();

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
                System.out.println("지난 주 당첨 번호를 입력해 주세요");

                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                String[] num = bf.readLine().split(",");
                List winningList = new ArrayList();
                for (int i = 0; i < num.length; i++) {
                        winningList.add(Integer.parseInt(num[i]));
                }
                return winningList;
        }

        private static int getBonusNumber() throws IOException {
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("보너스 볼을 입력해 주세요.");
                return Integer.parseInt(bf.readLine());
        }

        private static void matchLotto(){
                for(Lotto lotto : lottos){
                       ranks.add(winningLotto.match(lotto));
                }
                for(Rank rank : ranks){
                        setWinnerArray(rank);
                }

        }

        private static void setWinnerArray(Rank rank){
                if(Rank.FIFTH == rank){
                        winners[0]++;
                        return;
                }
                if(Rank.FOURTH == rank){
                        winners[1]++;
                        return;
                }
                if(Rank.THIRD == rank){
                        winners[2]++;
                        return;
                }
                if(Rank.SECOND == rank){
                        winners[3]++;
                        return;
                }
                if(Rank.FIRST == rank){
                        winners[4]++;
                        return;
                }
        }

}
