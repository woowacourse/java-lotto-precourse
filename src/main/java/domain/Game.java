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

    private List<String> splitWithComma(String inputLottoNumber) {
        List<String> lottoNumbers = Arrays.asList(inputLottoNumber.split(","));

        return lottoNumbers;
    }
}
