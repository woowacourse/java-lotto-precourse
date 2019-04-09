package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 로또게임에 필요한 함수를 생성해 놓은 클래스
 */

public class GameControler {
    private int n;
    private int pre_money;

    private Random random = new Random();
    private ArrayList<Lotto> lottos = new ArrayList<Lotto>();
    private WinningLotto winning;

    GameControler(int n) {
        this.n = n / 1000;
        this.pre_money = n;
    }

    public int getN() {
        return n;
    }

    public void setLottos() {
        for (int i = 0; i < n; i++) {
            int[] temp = getNonRepitIntArray();
            lottos.add(new Lotto(Arrays.stream(temp)
            .boxed().collect(Collectors.toList())));
        }
    }

    public int[] getNonRepitIntArray() {
        int[] temp = new int[6];
        for (int i = 0; i < temp.length; i++) {
            int ran_num = random.nextInt(45)+1;
            if (!(isRepit(temp, ran_num))) temp[i] = ran_num;
            if (isRepit(temp, ran_num)) i--;
        }
        Arrays.sort(temp);
        return temp;
    }

    public Boolean isRepit(int[] x,int num) {
        for (int item : x) {
            if (item == num) return true;
        }
        return false;
    }

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

    public void setWinningLotto(String str, int bonus) {
        String[] temp = str.split(",");
        List<Integer> numbers = Arrays
        .asList(temp).stream()
        .map(s -> Integer.parseInt(s))
        .collect(Collectors.toList());
        winning = new WinningLotto(new Lotto(numbers), bonus);
    }
}
