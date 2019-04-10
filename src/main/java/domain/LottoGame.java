package domain;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Map;

public class LottoGame {

    private static final String MESSAGE_INPUT_MONEY = "구매금액을 입력해 주세요.";
    private static final String MESSAGE_GET_LOTTO = "개를 구매했습니다.";
    private static final String MESSAGE_INPUT_WIN_LOTTO = "지난 주 당첨번호를 입력해 주세요.";
    private static final String MESSAGE_INPUT_BONUS = "보너스 볼을 입력해주세요.";
    public static final int LOTTO_PRICE = 1000;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private List<Lotto> purchasedLottoList;
    private WinningLotto winLotto;

    private int inputMoney() {
        Scanner scan = new Scanner(System.in);
        String input;
        do {
            System.out.println(MESSAGE_INPUT_MONEY);
            input = scan.nextLine();
        }
        while (!Validation.isValidInputMoney(input));
        return Integer.parseInt(input);
    }

    private int getCountLotto(int money) {
        int count = money / LOTTO_PRICE;
        System.out.println(count + MESSAGE_GET_LOTTO);
        return count;
    }

    private void createLotto(int countLotto) {
        for (int i = 0; i < countLotto; i++) {
            Lotto lotto = new Lotto(getRandomList());
            purchasedLottoList.add(lotto);
        }
    }

    private List<Integer> getRandomList() {
        List<Integer> randomList = new ArrayList<>();
        int randomNum;
        Random random = new Random();
        while (randomList.size() < LOTTO_NUMBER_COUNT) {
            randomNum = random.nextInt(MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER;
            removeDuplication(randomList, randomNum);
            randomList.add(randomNum);
        }
        return randomList;
    }

    private void removeDuplication(List<Integer> list, int num) {
        if (list.contains(num)) {
            int idx = list.indexOf(num);
            list.remove(idx);
        }
    }

    private void printLottoList(int countLotto) {
        for (int i = 0; i < countLotto; i++) {
            purchasedLottoList.get(i).printLotto();
        }
    }

    private List<Integer> inputWinNumber() {
        System.out.println(MESSAGE_INPUT_WIN_LOTTO);
        Scanner scan = new Scanner(System.in);
        String input;
        do {
            input = scan.nextLine();
        } while (!Validation.isValidWinLottoInput(input));
        List<Integer> winNumber = makeIntegerList(input);
        return winNumber;
    }

    private List<Integer> makeIntegerList(String strList) {
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            String num = strList.split(",")[i];
            number.add(Integer.parseInt(num));
        }
        return number;
    }

    private int inputBonusNumber() {
        System.out.println(MESSAGE_INPUT_BONUS);
        Scanner scan = new Scanner(System.in);
        String inputBonus;
        do {
            inputBonus = scan.nextLine();
        }
        while (!Validation.isNumber(inputBonus));
        return Integer.parseInt(inputBonus);
    }

    private TreeMap makeResultMap() {
        TreeMap<Rank, Integer> resultMap = new TreeMap<>(Collections.reverseOrder());
        initMap(resultMap);
        for (int i = 0; i < purchasedLottoList.size(); i++) {
            Rank rank = winLotto.match(purchasedLottoList.get(i));
            resultMap.put(rank, resultMap.get(rank) + 1);
        }
        return resultMap;
    }

    private void initMap(TreeMap<Rank, Integer> map) {
        for (Rank rank : Rank.values()) {
            map.put(rank, 0);
        }
    }

    private void printResult(int lottoMoney) {
        TreeMap<Rank, Integer> result = makeResultMap();
        double profit;
        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            rank.printRank(count);
        }
        profit = getProfit(result, lottoMoney);
        System.out.println("총 수익률은 " + profit + "입니다");
    }

    private static double getProfit(Map<Rank, Integer> rankList, int lottoMoney) {
        int totalMoney = 0;
        for (Map.Entry<Rank, Integer> entry : rankList.entrySet()) {
            int winCount = entry.getValue();
            totalMoney += entry.getKey().getWinningMoney() * winCount;
        }
        return (double) totalMoney / (double) lottoMoney;
    }

    public void run() {
        purchasedLottoList = new ArrayList<>();
        int money = inputMoney();
        int countOfLotto = getCountLotto(money);
        createLotto(countOfLotto);
        printLottoList(countOfLotto);
        Lotto lotto = new Lotto(inputWinNumber());
        winLotto = new WinningLotto(lotto, inputBonusNumber());
        printResult(money);
    }
}
