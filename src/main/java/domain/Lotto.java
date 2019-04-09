package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현
    public static Lotto createRandomLotto() {
        ArrayList<Integer> totalNumbers = createPossibleNumbers();
        ArrayList<Integer> lottoNumbers = new ArrayList<Integer>();
        for (int j = 0; j < GameSetting.LOTTO_NORMAL_NUMBER_COUNT; j++) {
            int randomIndex = (new Random()).nextInt(totalNumbers.size());
            int randomNumber = totalNumbers.get(randomIndex);
            totalNumbers.remove(randomIndex);

            lottoNumbers.add(randomNumber);
        }
        return new Lotto(lottoNumbers);
    }

    private static ArrayList<Integer> createPossibleNumbers() {
        ArrayList<Integer> possibleNumbers = new ArrayList<Integer>();
        for (int i = GameSetting.MIN_LOTTO_NUMBER; i <= GameSetting.MAX_LOTTO_NUMBER; i++) {
            possibleNumbers.add(i);
        }

        return possibleNumbers;
    }

    public void printLottoNumbers() {
        ArrayList<String> mylottoNumStringList = new ArrayList<String>();
        for (int i = 0; i < numbers.size(); i++) {
            mylottoNumStringList.add(numbers.get(i) + "");
        }
        String printComment = "[" + String.join(",", mylottoNumStringList) + "]";
        System.out.println(printComment);
    }
}
