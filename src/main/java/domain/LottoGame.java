package domain;

import java.util.*;

public class LottoGame {
    private static final int LOTTO_NUMBER_COUNT = 6;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    private Scanner scanner = new Scanner(System.in);
    private int userInputPrice;
    private List<Lotto> LottoList = new ArrayList<>();
    private RandomLottoNumber randomLottoNumber = new RandomLottoNumber();
    private ArrayList<String> winningNumbers;
    private String bonusBall;
    public LottoGame() {
        userInputPrice = userInputPurchase();
        issueLotto();
        userInputWinningLotto();
        userInputBonusBall();
    }

    private int userInputPurchase() {
        System.out.println("구입 금액을 입력해주세요");
        String userInput = scanner.nextLine();
        int purchase = userInputStringToInt(userInput);
        while (!inputPriceVerify(purchase)) {
            System.out.println("잘못된 금액을 입력하셧습니다.");
            System.out.println("구입 금액을 입력해주세요");
            userInput = scanner.nextLine();
            purchase = userInputStringToInt(userInput);
        }
        return purchase;
    }

    public boolean inputPriceVerify(int userInput) {
        if (userInput <= 0 || userInput % 1000 != 0) {
            return false;
        }
        return true;
    }

    private int userInputStringToInt(String userInput) {
        try {
            int result = Integer.parseInt(userInput);
            return result;
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private void issueLotto() {
        final int NUMBER_LOTTO = this.userInputPrice / 1000;
        System.out.println(NUMBER_LOTTO + "를 구입했습니다.");
        for (int i = 0; i < NUMBER_LOTTO; i++) {
            LottoList.add(new Lotto(makeRandomNumbers()));
        }
        for (int i = 0; i < LottoList.size(); i++) {
            System.out.println(LottoList.get(i).toString());
        }
    }

    private List<Integer> makeRandomNumbers() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        randomLottoNumber.shuffle();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            numbers.add(randomLottoNumber.getNumbers().get(i));
        }
        Collections.sort(numbers);
        return numbers;
    }

    private void userInputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 쉼표로 구분하여 입력해 주세요.");
        winningNumbers = userInputSplit();
        while (!winningLottoNumbersVerify()) {
            System.out.println("잘못된 번호를 입력했습니다.");
            System.out.println("지난 주 당첨 번호를 쉼표로 구분하여 입력해 주세요.");
            winningNumbers = userInputSplit();
        }
    }

    private void userInputBonusBall() {
        System.out.println("보너스 볼을 입력해주세요");
        bonusBall = scanner.nextLine();
        while (!lottoNumberVerify(bonusBall) || !bonusNumberVerify(bonusBall)) {
            System.out.println("잘못된 번호를 입력했습니다.");
            System.out.println("보너스 볼을 입력해주세요");
            bonusBall = scanner.nextLine();
        }
    }

    public ArrayList<String> userInputSplit() {
        String userInput = scanner.nextLine();
        if (userInput == null || userInput.equals("")) {
            return new ArrayList<>();
        }
        String[] result = userInput.split(",");
        ArrayList<String> resultList = new ArrayList<>(Arrays.asList(result));
        Collections.sort(resultList);
        return resultList;
    }

    private boolean winningLottoNumbersVerify() {
        boolean result = true;
        for (String number : winningNumbers) {
            result = lottoNumberVerify(number) & result;
        }
        return result;
    }

    private boolean lottoNumberVerify(String number) {
        if (winningNumbers.size() < 6)
            return false;
        int lottoNumber = userInputStringToInt(number);
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            return false;
        }
        int first = winningNumbers.indexOf(number);
        int second = winningNumbers.lastIndexOf(number);
        return first == second;
    }

    private boolean bonusNumberVerify(String number) {
        if (winningNumbers.contains(number)) {
            return false;
        }
        return true;
    }
}
