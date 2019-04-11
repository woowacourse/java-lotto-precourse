package domain;

import java.util.*;

public class Game {

    private int inputPrice;
    private int purchaseCount;
    private Lotto[] lottos;

    public void run() {
        do {
            buyLotto();
        } while (printPurchaseCount());

        createLottoObjectArray();
        createLottoInstance();
        repeatOutputLottoNumbers();
        inputLastWeekWinningLotto();
        inputBonusBallLotto();
    }

    private void buyLotto() {
        Scanner sc = new Scanner(System.in);

        try {
            inputPrice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("올바른 숫자가 아닙니다.");
            buyLotto();
        }
    }

    private boolean printPurchaseCount() {
        purchaseCount = inputPrice / 1000;

        if (purchaseCount <= 0) {
            System.out.println("로또를 살 수 없습니다.");
            return true;
        }

        System.out.println(purchaseCount + "개를 구매했습니다.");
        return false;
    }

    private void createLottoObjectArray() {
        lottos = new Lotto[purchaseCount];
    }

    private boolean checkSizeNumbers(List<Integer> numbers) {
        if (numbers.size() == 6) {
            return false;
        }

        return true;
    }

    private int createRandomNumber() {
        int randomNum = (int)(Math.random() * 45) + 1;

        return randomNum;
    }
    private void addNumbers(List<Integer> numbers, int randomNumber) {
        if (numbers.indexOf(randomNumber) == -1) {
            numbers.add(randomNumber);
        }
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (checkSizeNumbers(numbers)) {
            int randomNum = createRandomNumber();
            addNumbers(numbers, randomNum);
            sortNumbers(numbers);
        }

        return numbers;
    }

    private void createLottoInstance() {
        for (int i = 0; i < purchaseCount; i++) {
            lottos[i] = new Lotto(createLottoNumbers());
        }
    }

    private void outputLottoNumbers(Lotto lotto) {
        String numbers = lotto.getNumbers().toString();

        System.out.println(numbers);
    }

    private void repeatOutputLottoNumbers() {
        for (int i = 0; i < lottos.length; i++) {
            outputLottoNumbers(lottos[i]);
        }
    }

    private List<Integer> splitWithComma(String inputLottoNumber) {
        List<String> inputLotto = Arrays.asList(inputLottoNumber.split(","));
        List<Integer> lottoNumbers = new ArrayList<>();

        try {
            for (String number : inputLotto) {
                lottoNumbers.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자가 아닙니다.");
        }

        return lottoNumbers;
    }

    private String removeBlank(String inputLottoNumber) {
        return inputLottoNumber.replaceAll(" ", "");
    }

    private List<Integer> inputLottoNumber() {
        Scanner sc = new Scanner(System.in);

        String inputLottoNumber = removeBlank(sc.nextLine());
        List<Integer> lottoNumbers = splitWithComma(inputLottoNumber);

        return lottoNumbers;
    }

    private boolean checkNumberRangeAndFormat(int lottoNumber) {
        try {
            if (lottoNumber < 1 || lottoNumber > 45) {
                System.out.println("숫자가 너무 큽니다. 1 ~ 45 사이로 입력해주세요.");
                return true;
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닙니다. 다시 입력해주세요.");
            return true;
        }

        return false;
    }

    private boolean checkLottoNumberRangeAndFormat(List<Integer> lottoNumbers) {
        List<Boolean> checkNumber = new ArrayList<>();

        for (int lottoNumber : lottoNumbers) {
            checkNumber.add(checkNumberRangeAndFormat(lottoNumber));
        }

        return checkNumber.contains(true);
    }

    private boolean checkNumberCount(List<Integer> numbers, int listSize) {
        if (numbers.size() != listSize) {
            System.out.println("숫자 개수를 " + listSize + "로 맞추세요.");
            return true;
        }

        return false;
    }

    private List<Integer> inputLottoSelectSize(int listSize) {
        List<Integer> lottoNumbers;

        do {
            lottoNumbers = inputLottoNumber();
        } while (checkNumberCount(lottoNumbers, listSize)
                || checkLottoNumberRangeAndFormat(lottoNumbers));

        return lottoNumbers;
    }

    private List<Integer> inputLastWeekWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningLottoNumber = inputLottoSelectSize(6);

        return winningLottoNumber;
    }

    private void inputBonusBallLotto() {
        System.out.println("보너스 볼을 입력해 주세요.");
        inputLottoSelectSize(1);
    }
}
