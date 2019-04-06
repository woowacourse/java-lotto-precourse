package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Shop {
    private final int INITIAL_VALUE = 0;
    private final int LOTTO_PRICE = 1000;
    private final int LOTTO_NUMBER_SIZE = 6;
    private final int LOTTO_MAX_VALUE = 45;
    private final int LOTTO_MIN_VALUE = 0;

    public int inputPrice() {
        int price = checkPriceValidation(INITIAL_VALUE);
        return price;
    }

    public Lotto[] sellLotto(int price) {
        System.out.println("로또 번호를 입력하세요. 번호는 , 로 구분됩니다.");
        int count = price / 1000;
        Lotto[] lottoBundle = new Lotto[count];
        for (int i = 0; i < count; i++) {
            lottoBundle[i] = createLotto(getLottoNumber());
            System.out.println("입력되었습니다.");
        }
        return lottoBundle;
    }

    public WinningLotto createWinningLotto() {
        new Scanner(System.in);
        System.out.println("당첨 번호를 입력해주세요");
        Lotto lotto = createLotto(getLottoNumber());
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = createBonusNumber(lotto.getLottoNumber());
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        return winningLotto;
    }

    public void printLotto(Lotto[] lottobundle) {
        int amount = lottobundle.length;
        System.out.println(amount + "개를 구매했습니다.");
        for (int i = 0; i < amount; i++) {
            System.out.println(lottobundle[i].printLottoNumber());
        }
    }

    private int createBonusNumber(List<Integer> winningNumber) {
        int bonusNumber = checkBonusNumberValidation(INITIAL_VALUE, winningNumber);
        return bonusNumber;
    }

    private int checkBonusNumberValidation(int bonusNumber, List<Integer> winningNumber) {
        Scanner scan = new Scanner(System.in);
        try {
            int signedBonusNumber = scan.nextInt();
            bonusNumber = checkBonusNumberRange(signedBonusNumber, winningNumber);
            bonusNumber = checkDuplicateBonusNumber(bonusNumber, winningNumber);
            return bonusNumber;
        } catch (InputMismatchException e) {
            resetScanner();
            bonusNumber = checkBonusNumberValidation(INITIAL_VALUE, winningNumber);
        }
        return bonusNumber;
    }

    private int checkBonusNumberRange(int bonusNumber, List<Integer> winningNumber) {
        if (bonusNumber > LOTTO_MAX_VALUE || bonusNumber<= LOTTO_MIN_VALUE) {
            System.out.println("번호는 1이상 45이하의 수만 입력이 가능합니다.");
            bonusNumber = checkBonusNumberValidation(INITIAL_VALUE,winningNumber);
        }
        return bonusNumber;
    }

    private int checkDuplicateBonusNumber(int bonusNumber, List<Integer> winningNumber){
        if(winningNumber.contains(bonusNumber)){
            System.out.println("보너스 번호는 당첨 번호와 중복 될 수 없습니다.");
            bonusNumber = checkBonusNumberValidation(INITIAL_VALUE, winningNumber);
        }
        return bonusNumber;
    }

    private Lotto createLotto(ArrayList<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    private ArrayList<Integer> getLottoNumber() {
        String[] numberStringArray = getStringLottoNumber();
        int[] numberArray = changeIntegerArrayfromStringArray(numberStringArray);
        numberArray = checkDuplicate(numberArray);
        numberArray = checkMaxMinLottoNumber(numberArray);
        numberArray = checkLottoSize(numberArray);
        ArrayList<Integer> lottoNumber = (ArrayList<Integer>) Arrays.stream(numberArray).boxed().collect(Collectors.toList());
        return lottoNumber;
    }

    private String[] getStringLottoNumber() {
        Scanner scan = new Scanner(System.in);
        String number = scan.next();
        String[] numberStringArray = number.split(",");
        return numberStringArray;
    }

    private int[] changeIntegerArrayfromStringArray(String[] numberStringArray) {
        int[] numberArray;
        try {
            numberArray = Arrays.stream(numberStringArray).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            resetScanner();
            numberStringArray = getStringLottoNumber();
            numberArray = changeIntegerArrayfromStringArray(numberStringArray);
        }
        return numberArray;
    }

    private int[] checkDuplicate(int[] numberArray) {
        Integer[] integerArray = Arrays.stream(numberArray).boxed().toArray(Integer[]::new);
        HashSet<Integer> numberSet = new HashSet<Integer>(Arrays.asList(integerArray));
        if (numberSet.size() != numberArray.length) {
            System.out.println("중복된 값은 허용하지 않습니다.");
            numberArray = checkDuplicate(changeIntegerArrayfromStringArray(getStringLottoNumber()));
        }
        return numberArray;
    }

    private int[] checkMaxMinLottoNumber(int[] numberArray) {
        Arrays.sort(numberArray);
        if (numberArray[numberArray.length - 1] > LOTTO_MAX_VALUE) {
            System.out.println("45보다 클 수 없습니다.");
            numberArray = checkMaxMinLottoNumber(checkDuplicate(changeIntegerArrayfromStringArray(getStringLottoNumber())));
        } else if (numberArray[0] < LOTTO_MIN_VALUE) {
            System.out.println("0보다 작을 수 없습니다.");
            numberArray = checkMaxMinLottoNumber(checkDuplicate(changeIntegerArrayfromStringArray(getStringLottoNumber())));
        }
        return numberArray;
    }

    private int[] checkLottoSize(int[] numberArray) {
        if (numberArray.length != LOTTO_NUMBER_SIZE) {
            System.out.println("로또 번호 갯수를 확인해주세요.");
            numberArray = checkLottoSize(checkMaxMinLottoNumber(checkDuplicate(changeIntegerArrayfromStringArray(getStringLottoNumber()))));
        }
        return numberArray;
    }

    private int checkPriceValidation(int price) {
        Scanner scan = new Scanner(System.in);
        try {
            int signedprice = scan.nextInt();
            price = checkPrice(signedprice);
            return price;
        } catch (InputMismatchException e) {
            resetScanner();
            price = checkPriceValidation(INITIAL_VALUE);
        }
        return price;
    }

    private Scanner resetScanner() {
        System.out.println("유효하지 않는 값입니다.");
        Scanner scan = new Scanner(System.in);
        return scan;
    }


    private int checkPrice(int price) {
        if (price < 0) {
            System.out.println("0원보다 큰 금액을 입력해 주세요.");
            price = checkPriceValidation(INITIAL_VALUE);
        }
        if (price % LOTTO_PRICE != 0) {
            System.out.println("1000원 단위로 입력 해주세요.");
            price = checkPriceValidation(INITIAL_VALUE);
        }
        return price;
    }

}
