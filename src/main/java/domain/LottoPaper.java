package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 로또 번호를 담은 배열을 담은 class
 */
public class LottoPaper extends Config {
    private String[] lottoString;
    private int[] lottoNumber;

    public LottoPaper() {
        do {
            settingConstructor();
        } while (!checkLottoSize(this.lottoNumber)
                || !checkDuplicate(this.lottoNumber)
                || !checkMaxMinLottoNumber(this.lottoNumber));
    }

    public int[] getLottoNumber() {
        return lottoNumber;
    }

    private void settingConstructor() {
        this.lottoString = createStringArray();
        this.lottoNumber = changeIntegerArrayfromStringArray(lottoString);
    }

    private String[] createStringArray() {
        Scanner scan = new Scanner(System.in);
        String lottoString = scan.next();
        String[] lottoStringArray = lottoString.split(",");
        return lottoStringArray;
    }

    private int[] changeIntegerArrayfromStringArray(String[] lottoString) {
        try {
            return Arrays.stream(lottoString).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            resetScanner();
            return changeIntegerArrayfromStringArray(createStringArray());
        }
    }

    private boolean checkLottoSize(int[] numberArray) {
        if (numberArray.length != LOTTO_NUMBER_SIZE) {
            System.out.println("로또 번호 갯수를 확인해주세요.");
            return false;
        }
        return true;
    }

    private boolean checkDuplicate(int[] numberArray) {
        Integer[] integerArray = Arrays.stream(numberArray).boxed().toArray(Integer[]::new);
        HashSet<Integer> numberSet = new HashSet<Integer>(Arrays.asList(integerArray));
        if (numberSet.size() != numberArray.length) {
            System.out.println("중복된 값은 허용하지 않습니다.");
            return false;
        }
        return true;
    }

    private boolean checkMaxMinLottoNumber(int[] numberArray) {
        Arrays.sort(numberArray);
        if (numberArray[numberArray.length - 1] > LOTTO_MAX_VALUE) {
            System.out.println("45보다 클 수 없습니다.");
            return false;
        } else if (numberArray[0] <= LOTTO_MIN_VALUE) {
            System.out.println("0보다 작을 수 없습니다.");
            return false;
        }
        return true;
    }

}
