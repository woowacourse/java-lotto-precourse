package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;

/**
 * 로또게임에 필요한 함수를 생성해 놓은 클래스
 */

public class GameControler {
    private int n;  // 구매한 로또 갯수를 나타내는 변수
    private int pre_money;  // 초기 구매비용을 나타내는 변수
    private int total_winning_money = 0;    // 총 상금을 나타내는 변수

    private Random random = new Random();
    private WinningLotto winning;   // 당첨번호와 보너스번호를 저장하는 변수
    private ArrayList<Lotto> lottos = new ArrayList<Lotto>();   // 유저가 구입한 로또를 저장하는 변수
    private ArrayList<Rank> match_lottos = new ArrayList<Rank>();   // 유저가 구입한 로또의 Rank로 저장하는 변수

    GameControler(int n) {
        this.n = n / 1000;
        this.pre_money = n;
    }

    public int getN() {
        return n;
    }

    // 유저가 구입한 로또의 갯수에 따라 로또를 셋팅하는 함수
    public void setLottos() {
        for (int i = 0; i < n; i++) {
            int[] temp = getNonRepitIntArray();
            lottos.add(new Lotto(Arrays.stream(temp).boxed().collect(Collectors.toList())));
        }
    }

    public int[] getNonRepitIntArray() {
        int[] temp = new int[6];
        for (int i = 0; i < temp.length; i++) {
            int ran_num = random.nextInt(45) + 1;
            if (!(isRepit(temp, ran_num)))
                temp[i] = ran_num;
            if (isRepit(temp, ran_num))
                i--;
        }
        Arrays.sort(temp);
        return temp;
    }

    public Boolean isRepit(int[] x, int num) {
        for (int item : x) {
            if (item == num)
                return true;
        }
        return false;
    }

    // 유저가 구입한 로또를 출력하는 함수
    public void printLottos() {
        for (Lotto item : lottos) {
            printLotto(item);
        }
    }

    public void printLotto(Lotto item) {
        String[] temp = convertIntegersToChar(item.getNumbers());
        String sentence = String.join(",", temp);
        System.out.printf("[%s]\n", sentence);
    }

    public String[] convertIntegersToChar(List<Integer> integers) {
        String[] temp = new String[integer.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.toString(integers.get(i).intValue());
        }
        return temp;
    }

    // 당첨 번호와 보너스 번호를 셋팅하는 함수
    public void setWinningLotto(String str, int bonus) {
        String[] temp = str.split(",");
        List<Integer> numbers = Arrays.asList(temp).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        winning = new WinningLotto(new Lotto(numbers), bonus);
    }

    // 최종 결과를 출력할 함수
    public void printResult() {
        matchingAll();
        String[] rank = { "FIFTH", "FOURTH", "THIRD", "SECOND", "FIRST" };
        for (String item : rank) {
            System.out.println(printRank(item));
        }
        System.out.println("총 수익률은 " + (float) total_winning_money / pre_money + "입니다.");
    }

    public void matchingAll() {
        for (int i = 0; i < lottos.size(); i++) {
            match_lottos.add(winning.match(lottos.get(i)));
        }
    }

    public String printRank(String str) {
        Rank temp = Rank.getRankByString(str);
        int count = matchCount(temp);

        if (str.equals("SECOND")) {
            return temp.getCountOfMatch() + "개 일치, 보너스볼 일치(" + temp.getWinningMoney() + ")- " + count + "개";
        }
        return temp.getCountOfMatch() + "개 일치 (" + temp.getWinningMoney() + ")- " + count + "개";
    }

    public int matchCount(Rank rank) {
        int count = 0;
        for (int i = 0; i < match_lottos.size(); i++) {
            if (temp.getCountOfMatch() == match_lottos.get(i).getCountOfMatch()) {
                count++;
                this.total_winning_money += temp.getWinningMoney();
            }
        }
        return count;
    }
}
