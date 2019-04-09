package domain;

import java.util.*;

import static domain.Constants.*;

public class LottoGame {
    private Scanner scan = new Scanner(System.in);
    private Lotto[] lotto;
    private WinningLotto winningLotto;

    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        game.doGame();
    }

    private void doGame() {
        int numOfLotto = getNumOfLotto();
        makeLotto(numOfLotto);
        printLotto(numOfLotto);
        setWinningLotto();
        Statistics statistics = new Statistics();
        statistics.compileStatistics(lotto, winningLotto);
        statistics.setRateOfReturn(numOfLotto);
        statistics.printStatistics();
    }

    private int getNumOfLotto() {
        return getPurchasePrice() / MIN_UNIT;
    }

    private int getPurchasePrice() {
        int purchasePrice;
        do {
            System.out.println("구입금액을 입력해 주세요.");
            purchasePrice = scan.nextInt();
        } while (!checkPriceValidity(purchasePrice));
        scan.nextLine();

        return purchasePrice;
    }

    private boolean checkPriceValidity(int purchasePrice) {
        return purchasePrice >= MIN_UNIT && purchasePrice <= MAX_SUM_OF_PRICE && purchasePrice % MIN_UNIT == 0;
    }

    private void makeLotto(int numOfLotto) {
        lotto = new Lotto[numOfLotto];

        for (int i = 0; i < numOfLotto; i++) {
            List<Integer> lottoNumbers = getLottoNumbers();
            Collections.sort(lottoNumbers);
            lotto[i] = new Lotto(lottoNumbers);
        }
    }

    private List<Integer> getLottoNumbers() {
        List<Integer> numbers;

        do {
            numbers = makeRandomNumbers();
        } while (!checkNumbersOverlap(numbers));

        return numbers;
    }

    private List<Integer> makeRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < NUM_OF_FIGURES; i++) {
            numbers.add(makeOneRandomNumber());
        }

        return numbers;
    }

    private int makeOneRandomNumber() {
        return (int) (Math.random() * MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER;
    }

    private boolean checkNumbersOverlap(List<Integer> numbers) {
        int[] checkOverlap = new int[MAX_LOTTO_NUMBER + 1];

        for (int i = 0; i < NUM_OF_FIGURES; i++) {
            if (checkOverlap[numbers.get(i)] != 0) return false;
            checkOverlap[numbers.get(i)]++;
        }

        return true;
    }

    private void printLotto(int numOfLotto) {
        System.out.printf("\n%d개를 구매했습니다.\n", numOfLotto);

        for (int i = 0; i < numOfLotto; i++) {
            lotto[i].printLottoNumbers();
        }
    }

    private void setWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusBall = getBonusBall(winningNumbers);
        Lotto winner = new Lotto(winningNumbers);

        winningLotto = new WinningLotto(winner, bonusBall);
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers;
        do {
            System.out.printf("\n지난 주 당첨 번호를 입력해 주세요.\n");
            String userInput = scan.nextLine();
            winningNumbers = makeWinningNumbersList(userInput);
        } while (!(checkLottoNumbers(winningNumbers) && checkNumbersOverlap(winningNumbers)));

        return winningNumbers;
    }

    private List<Integer> makeWinningNumbersList(String userInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] winningNumbersArray = userInput.split(",");

        for (int i = 0; i < winningNumbersArray.length; i++) {
            winningNumbers.add(Integer.parseInt(winningNumbersArray[i]));
        }

        return winningNumbers;
    }

    private boolean checkLottoNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUM_OF_FIGURES) return false;

        for (int i = 0; i < NUM_OF_FIGURES; i++) {
            int number = winningNumbers.get(i);
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) return false;
        }

        return true;
    }

    private int getBonusBall(List<Integer> winningNumbers) {
        int bonusBall;

        do {
            System.out.printf("\n보너스 볼을 입력해 주세요.\n");
            bonusBall = scan.nextInt();
        } while (!checkBonusBallValidity(bonusBall, winningNumbers));

        return bonusBall;
    }

    private boolean checkBonusBallValidity(int bonusBall, List<Integer> winningNumbers) {
        for (int i = 0; i < NUM_OF_FIGURES; i++) {
            if (winningNumbers.contains(bonusBall)) return false;
            if (bonusBall < MIN_LOTTO_NUMBER || bonusBall > MAX_LOTTO_NUMBER) return false;
        }

        return true;
    }
}