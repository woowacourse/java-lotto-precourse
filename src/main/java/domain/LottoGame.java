package domain;

import java.util.*;

class LottoGame {
    private static final int LOTTO_NUMBER_COUNT = 6;
    static final int MAX_LOTTO_NUMBER = 45;
    static final int MIN_LOTTO_NUMBER = 1;
    private Scanner scanner = new Scanner(System.in);
    private int userInputPrice;
    private List<Lotto> LottoList = new ArrayList<>();
    private RandomLottoNumber randomLottoNumber = new RandomLottoNumber();
    private WinningLotto winningLotto;
    LottoGame() {
        userInputPrice = userInputPurchase();
        issueLotto();
        userInputWinningLotto();
        System.out.println("당첨 통계 \n---------");
        printResult();
    }

    private int userInputPurchase() {
        System.out.println("구입 금액을 입력해주세요");
        int purchasePrice = userInputStringToInt();
        while (!inputPriceVerify(purchasePrice)) {
            System.out.println("잘못된 금액을 입력하셧습니다.");
            System.out.println("구입 금액을 입력해주세요");
            purchasePrice = userInputStringToInt();
        }
        return purchasePrice;
    }

    private boolean inputPriceVerify(int userInput) {
        return (userInput > 0 && userInput % 1000 == 0);
    }

    private int userInputStringToInt() {
        String userInput = scanner.nextLine();
        return stringToInt(userInput);
    }

    private int stringToInt(String string) {
        try {
            return  Integer.parseInt(string);
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
        for(Lotto lotto : LottoList)
            System.out.println(lotto.toString());
    }

    private List<Integer> makeRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        randomLottoNumber.shuffle();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            numbers.add(randomLottoNumber.getNumbers().get(i));
        }
        Collections.sort(numbers);
        return numbers;
    }

    private void userInputWinningLotto() {
        ArrayList<Integer> winningNumbers;
        System.out.println("지난 주 당첨 번호를 쉼표로 구분하여 입력해 주세요.");
        winningNumbers = userInputSplit();
        while (!winningLottoNumbersVerify(winningNumbers)) {
            System.out.println("잘못된 번호를 입력했습니다.");
            System.out.println("지난 주 당첨 번호를 쉼표로 구분하여 입력해 주세요.");
            winningNumbers = userInputSplit();
        }
        int bonusBallNumber = userInputBonusBall(winningNumbers);
        winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusBallNumber);
    }

    private ArrayList<Integer> userInputSplit() {
        String userInput = scanner.nextLine();
        if (userInput == null || userInput.equals(""))
            return new ArrayList<>();
        String[] result = userInput.split(",");
        ArrayList<String> splitList = new ArrayList<>(Arrays.asList(result));
        ArrayList<Integer> resultList = stringListToIntegerList(splitList);
        Collections.sort(resultList);
        return resultList;
    }

    private ArrayList<Integer> stringListToIntegerList(ArrayList<String> splitList) {
        ArrayList<Integer> result = new ArrayList<>();
        for (String number : splitList) {
            result.add(stringToInt(number));
        }
        return result;
    }

    private boolean winningLottoNumbersVerify(ArrayList<Integer> winningNumbers) {
        boolean result = true;
        if (winningNumbers.size() != 6)
            return false;
        for (int number : winningNumbers) {
            result = lottoNumberVerify(number, winningNumbers) & result;
        }
        return result;
    }

    private int userInputBonusBall(ArrayList<Integer> winningNumbers) {
        System.out.println("보너스 볼을 입력해주세요");
        int bonusBallNumber = userInputStringToInt();
        while (!lottoNumberVerify(bonusBallNumber, winningNumbers) || !bonusNumberVerify(bonusBallNumber, winningNumbers)) {
            System.out.println("잘못된 번호를 입력했습니다.");
            System.out.println("보너스 볼을 입력해주세요");
            bonusBallNumber = userInputStringToInt();
        }
        return bonusBallNumber;
    }

    private boolean lottoNumberVerify(int number, ArrayList<Integer> winningNumbers) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)
            return false;
        int first = winningNumbers.indexOf(number);
        int second = winningNumbers.lastIndexOf(number);
        return first == second;
    }

    private boolean bonusNumberVerify(int number, ArrayList<Integer> winningNumbers) {
        return !winningNumbers.contains(number);
    }

    private void printResult() {
        double proceeds = 0.0;
        Map<Rank, Integer> resultMap = new LinkedHashMap<>();
        for (Rank rank : Rank.values())
            resultMap.put(rank, 0);
        for (Lotto lotto : LottoList)
            resultMap.put(winningLotto.match(lotto), resultMap.get(winningLotto.match(lotto)) + 1);
        for (int i = 4; i >= 0; i--) {
            proceeds = proceeds + matchRankMap(resultMap, Rank.values()[i]);
        }
        System.out.println("총 수익률은 " + proceeds / userInputPrice + "입니다.");
    }

    private double matchRankMap(Map<Rank, Integer> resultMap, Rank rank) {
        int countOfMatch = rank.getCountOfMatch();
        int getWinningMoney = rank.getWinningMoney();
        if (getWinningMoney == 30000000) {
            System.out.println(countOfMatch + "개 일치, 보너스볼 일치 (" + getWinningMoney + "원) - " + resultMap.get(rank) + "개");
            return getWinningMoney * resultMap.get(rank);
        }
        System.out.println(countOfMatch + "개 일치 (" + getWinningMoney + "원) - " + resultMap.get(rank) + "개");
        return getWinningMoney * resultMap.get(rank);
    }

}
