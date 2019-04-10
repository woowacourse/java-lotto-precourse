package domain;

import java.util.*;

public class LottoGame {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_INTEGER_ERROR_MESSAGE = "숫자가 아닙니다. 다시 입력해주세요: ";
    private static final String MONEY_UNIT_ERROR_MESSAGE = "천단위의 숫자가 아닙니다. 다시 입력해주세요: ";
    private static final String SPLIT_STANDARD = ",";
    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String OVERLAP_ERROR_MESSAGE = "중복입니다. 다시 입력해주세요: ";
    private static final String LENGTH_ERROR_MESSAGE = "6개의 값을 입력해주세요. 다시 입력해주세요: ";
    private static final String SPLIT_ERROR_MESSAGE = ",가 존재하지않습니다. 다시 입력해주세요: ";
    private static final String NUMBER_BOUND_ERROR_MESSAGE = "1-45까지의 범위에서만 입력해주세요. 다시 입력해주세요: ";
    private static final String INPUT_LAST_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.3f입니다.\n";
    private static final String SAME_MESSAGE = "%s개 일치, 보너스 볼 일치(%s원) - %s개\n";
    private static final String SAME_BALL_MESSAGE = "%s개 일치 (%s원)- %s개 \n";
    private static final String WINNER_STATUS_MESSAGE = "당첨 통계";
    private static final String HYPHEN = "---------";
    private static final int MONEY_UNIT = 1000;
    private static final int ZERO = 0;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int NUMBER_OF_LOTTO = 6;
    private static final int SET_STANDARD_NUM = 1;

    public void run() {
        System.out.println(INPUT_MONEY_MESSAGE);
        int lottoMoney = inputLottoMoney();
        int lottoRound = calculateLottoRound(lottoMoney);
        List<Lotto> lottoList = getLottoList(lottoRound);
        printLottoNumbers(lottoList);
        System.out.println(INPUT_LAST_NUMBER);
        WinningLotto winningLotto = getWinningLotto();
        HashMap<Rank, Integer> rankMap = getMatch(lottoList, winningLotto);
        printResult(rankMap);
        calculateRate(rankMap, lottoMoney);
    }

    private void printResult(HashMap<Rank, Integer> map) {
        System.out.println();
        System.out.println(WINNER_STATUS_MESSAGE);
        System.out.println(HYPHEN);
        Rank[] rankArr = turnArray();

        for (Rank rank : rankArr) {
            changeNull(map, rank);
            isContainBonusBall(rank, map);
        }
    }

    private void changeNull(HashMap<Rank, Integer> rankMap, Rank rank) {
        if (Objects.isNull(rankMap.get(rank))) {
            rankMap.put(rank, ZERO);
        }
    }

    private void isContainBonusBall(Rank rank, HashMap<Rank, Integer> rankMap) {
        if (rank == Rank.SECOND) {
            System.out.printf(SAME_MESSAGE, rank.getCountOfMatch(), rank.getWinningMoney(), rankMap.get(rank));
            return;
        }

        System.out.printf(SAME_BALL_MESSAGE, rank.getCountOfMatch(), rank.getWinningMoney(), rankMap.get(rank));
    }

    private Rank[] turnArray() {
        int arrSize;
        Rank[] ranks = Rank.values();
        List<Rank> rankList = new ArrayList<>(Arrays.asList(ranks));

        rankList.remove(Rank.MISS);
        Collections.reverse(rankList);
        arrSize = rankList.size();

        return rankList.toArray(new Rank[arrSize]);
    }

    private void calculateRate(HashMap<Rank, Integer> rateMap, int lottoMoney) {
        float sum = 0;
        float rate;

        for (Rank key : rateMap.keySet()) {
            sum += findUserWinMoney(rateMap, key);
        }
        rate = sum / lottoMoney;

        System.out.printf(RATE_OF_RETURN_MESSAGE, rate);
    }

    private int findUserWinMoney(HashMap<Rank, Integer> rankMap, Rank rank) {
        if (rankMap.get(rank) != ZERO) {
            return rank.getWinningMoney();
        }

        return 0;
    }

    private HashMap<Rank, Integer> getMatch(List<Lotto> lottoList, WinningLotto winningLotto) {
        HashMap<Rank, Integer> matchResult = new HashMap<>();
        List<Rank> ranks = getRankArray(winningLotto, lottoList);

        for (Rank rank : ranks) {
            isKeyContains(matchResult, rank);
        }

        return matchResult;
    }

    private void isKeyContains(HashMap<Rank, Integer> result, Rank rank) {
        if (!result.containsKey(rank)) {
            result.put(rank, SET_STANDARD_NUM);
            return;
        }
        if (result.containsKey(rank)) {
            int valueCount = result.get(rank);
            valueCount++;
            result.put(rank, valueCount);
        }
    }

    private List<Rank> getRankArray(WinningLotto winningLotto, List<Lotto> lottoList) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            ranks.add(winningLotto.match(lotto));
        }

        return ranks;
    }

    private WinningLotto getWinningLotto() {
        int bonusBall;
        Lotto lotto = new Lotto(getLastWinningNumberList());
        System.out.println(INPUT_BONUS_MESSAGE);

        bonusBall = inputBonusBall(lotto);

        return new WinningLotto(lotto, bonusBall);
    }

    private int inputBonusBall(Lotto lotto) {
        String stringBonusNumber = inputMethod(true);
        int bonusNumber = Integer.parseInt(stringBonusNumber);
        if (isInRange(stringBonusNumber)) {
            return inputBonusBall(lotto);
        }
        if (lotto.getNumbers().contains(bonusNumber)) {
            System.err.println(OVERLAP_ERROR_MESSAGE);
            return inputBonusBall(lotto);
        }
        return bonusNumber;
    }

    private List<Integer> getLastWinningNumberList() {
        List<Integer> winningNumberList = new ArrayList<>();
        String[] winningNumberArr = inputLastNumber();

        getAdd(winningNumberList, winningNumberArr);
        winningNumberList = checkOverlap(winningNumberList);

        return winningNumberList;
    }

    private void getAdd(List<Integer> winningNumberList, String[] winningNumber) {
        for (String number : winningNumber) {
            winningNumberList.add(Integer.parseInt(number));
        }
    }

    private String[] inputLastNumber() {
        String winningNumbers = inputMethod(false);
        String[] winningNumberArr = winningNumbers.split(SPLIT_STANDARD);

        if (isNotInComma(winningNumbers) || isInRange(winningNumbers)) {
            return inputLastNumber();
        }

        return inputSixNumberJudge(winningNumberArr);
    }

    private boolean isInRange(String str) {
        String[] winningNumbersArr = str.split(SPLIT_STANDARD);
        int index = 0;
        int winningNumbers;
        boolean check;

        do {
            winningNumbers = Integer.parseInt(winningNumbersArr[index++]);
        } while (!(check = numberBoundCheck(winningNumbers)) && index < winningNumbersArr.length);

        return check;
    }

    private boolean numberBoundCheck(int numbers) {
        if (numbers < MIN_LOTTO_NUMBER || numbers > MAX_LOTTO_NUMBER) {
            System.err.println(NUMBER_BOUND_ERROR_MESSAGE);
            return true;
        }

        return false;
    }

    private boolean isNotInComma(String winningNumber) {
        String[] winningNumbersArr = winningNumber.split("");
        List<String> list = new ArrayList<>(Arrays.asList(winningNumbersArr));

        if (!list.contains(SPLIT_STANDARD)) {
            System.err.println(SPLIT_ERROR_MESSAGE);
            return true;
        }

        return false;
    }

    private String[] inputSixNumberJudge(String[] lastWinningNumber) {
        if (lastWinningNumber.length != NUMBER_OF_LOTTO) {
            System.err.println(LENGTH_ERROR_MESSAGE);
            return inputLastNumber();
        }

        return lastWinningNumber;
    }

    private List<Integer> checkOverlap(List<Integer> winningNumber) {
        Set<Integer> set = new HashSet<>(winningNumber);

        if (set.size() != winningNumber.size()) {
            System.err.println(OVERLAP_ERROR_MESSAGE);
            return getLastWinningNumberList();
        }

        return winningNumber;
    }

    private void printLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }

        System.out.println();
    }

    private List<Lotto> getLottoList(int round) {
        List<Lotto> lottoList = new ArrayList<>();
        System.out.println();
        System.out.println(round + PURCHASE_COUNT_MESSAGE);

        for (int i = 0; i < round; i++) {
            lottoList.add(new Lotto(getLottoNumberList()));
        }

        return lottoList;
    }

    private List<Integer> getLottoNumberList() {
        int randomNumber;
        List<Integer> lottoNumberList = new ArrayList<>();

        while (lottoNumberList.size() != NUMBER_OF_LOTTO) {
            randomNumber = getRandomNumber();
            addLottoNumber(lottoNumberList, randomNumber);
        }

        return lottoNumberList;
    }

    private void addLottoNumber(List<Integer> numberList, int randomNumber) {
        if (!numberList.contains(randomNumber)) {
            numberList.add(randomNumber);
        }
    }

    private int calculateLottoRound(int money) {
        return money / MONEY_UNIT;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER;
    }

    private int inputLottoMoney() {
        String money = inputMethod(true);
        int intMoney = Integer.parseInt(money);

        if (intMoney % MONEY_UNIT != ZERO || intMoney == 0) {
            System.err.println(MONEY_UNIT_ERROR_MESSAGE);
            return inputLottoMoney();
        }

        return intMoney;
    }

    private String inputMethod(boolean isSingle) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String checkString = isSingle ? input : input.replaceAll(SPLIT_STANDARD, "");

        if (isBlank(checkString) || isNotNumber(checkString)) {
            return inputMethod(isSingle);
        }

        return input;
    }

    private boolean isNotNumber(String input) {
        try {
            Long.parseLong(input);
            return false;

        } catch (NumberFormatException e) {
            System.err.println(INPUT_INTEGER_ERROR_MESSAGE);
            return true;
        }
    }

    private boolean isBlank(String input) {
        if (input.isEmpty()) {
            System.err.println("아무것도 입력되지 않았습니다.");
            return true;
        }

        return false;
    }
}
