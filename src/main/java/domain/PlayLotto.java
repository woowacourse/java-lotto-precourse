package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlayLotto {
    private final int LOTTO_PRICE = 1000;
    private List<Lotto> myLotto = new ArrayList<>(); // 구입한 내 Lotto List
    private WinningLotto winningLotto;

    public void play() {
        int money = insertMoney();
        purchaseLotto(money);
        setWinningLotto();
        printWinningStatistics(money);
    }

    public int insertMoney() {
        int money;
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        money = sc.nextInt();
        while (money < 0) {
            System.out.println("Lotto 구입금액은 0이상의 자연수입니다.");
            money = sc.nextInt();
        }
        return money;
    }

    public void purchaseLotto(int money) {
        List<Integer> lottoNumber; // Lotto 번호 List
        int numberOfLotto = money / LOTTO_PRICE; // 구입할 Lotto 개수
        System.out.printf("%d개를 구매했습니다.\n", numberOfLotto);
        for (int i = 0; i < numberOfLotto; i++) {
            lottoNumber = GeneratingLottoNumber.generatingLottoNumber();
            System.out.println(lottoNumber);
            myLotto.add(new Lotto(lottoNumber));
        }
    }

    public void setWinningLotto() {
        List<Integer> winningLottoNumber = insertWinningLottoNumber();
        int bonusNumber = insertBonusNumber();
        while (hasBonusNumber(winningLottoNumber, bonusNumber)) {
            bonusNumber = insertBonusNumber();
        }
        winningLotto = new WinningLotto(new Lotto(winningLottoNumber), bonusNumber);
    }

    public List<Integer> insertWinningLottoNumber() {
        Scanner sc = new Scanner(System.in);
        String[] rawWinningNumber;
        while (true) {
            System.out.println("지난 주 당첨 번호를 입력해주세요.");
            rawWinningNumber = sc.nextLine().split(",");
            if (isValidNumberOfRange(rawWinningNumber) &&
                    isValidSizeOfWinningNumber(rawWinningNumber) &&
                    isDuplicatedNumber(rawWinningNumber)) { break; }
        }
        return convertString2Int(rawWinningNumber);
    }

    public void printWinningStatistics(int money) {
        System.out.println("\n당첨 통계\n-------");
        int totalWinningPrice = 0;
        List<Rank> lottoResultList = matchLotto();
        int lottoFrequency;
        for (Rank rank: Rank.values()) {
            lottoFrequency = frequencyOfWinningLotto(lottoResultList, rank);
            printWinningMessage(rank, lottoFrequency);
            totalWinningPrice += lottoFrequency * rank.getWinningMoney();
        }
        System.out.printf("총 수익률은 %.3f입니다.\n",
                (float) totalWinningPrice / money);
    }

    public int frequencyOfWinningLotto(List<Rank> lottoResultList, Rank rank) {
        return Collections.frequency(lottoResultList, rank);
    }

    public List<Rank> matchLotto() {
        Rank lottoResult;
        List<Rank> lottoResultList = new ArrayList<>();
        for (Lotto lotto: myLotto) {
            lottoResult = winningLotto.match(lotto);
            lottoResultList.add(lottoResult);
        }
        return lottoResultList;
    }

    public void printWinningMessage(Rank matchResult, int number) {
        int countOfMatch = matchResult.getCountOfMatch();
        int winningMoney = matchResult.getWinningMoney();
        int winningMinCount = matchResult.getWinningMinCount();
        if (matchResult == Rank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%d원)- %d개\n",
                    countOfMatch, winningMoney, number);
        }
        else if (countOfMatch >=winningMinCount ) {
            System.out.printf("%d개 일치 (%d원)- %d개\n",
                    countOfMatch, winningMoney, number);
        }
    }

    public boolean isDuplicatedNumber(String[] rawWinningNumber) {
        int frequency;
        List<Integer> intNumber = convertString2Int(rawWinningNumber);
        for (int i = 1; i < 46; i++) {
            frequency = Collections.frequency(intNumber, i);
            if (frequency > 1) {
                System.out.println("중복된 당첨번호가 있습니다.");
                return false;}
        }
        return true;
    }

    public boolean isValidNumberOfRange(String[] rawWinningNumber) {
        List<Integer> intNumber = convertString2Int(rawWinningNumber);
        for (int number: intNumber) {
            if (number < 0 || number > 45) {
                System.out.println("당첨번호는 1 ~ 45 사이의 자연수입니다.");
                return false;
            }
        }
        return true;
    }

    public boolean isValidSizeOfWinningNumber(String[] rawWinningNumber) {
        int sizeOfWinningNumber = 6; // 당첨번호의 갯수
        if (rawWinningNumber.length != sizeOfWinningNumber) {
            System.out.println("당첨번호는 콤마(,)로 구분하며 6자리입니다.");
            return false;
        }
        return true;
    }

    public List<Integer> convertString2Int(String[] rawWinningNumber) {
        List<Integer> intList = new ArrayList<>();
        for (String str: rawWinningNumber) {
            intList.add(Integer.parseInt(str));
        }
        return intList;
    }

    public int insertBonusNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해주세요.");
        int bonusNumber = sc.nextInt();
        while (!isValidBonusNumber(bonusNumber)) {
            bonusNumber = sc.nextInt();
        }
        return bonusNumber;
    }

    public boolean isValidBonusNumber(int bonusNumber) {
        if (0 < bonusNumber && bonusNumber <= 45) { return true; }
        System.out.println("보너스 볼의 범위는 1 ~ 45 사이의 자연수입니다.");
        System.out.println("보너스 볼을 입력해주세요.");
        return false;
    }

    public boolean hasBonusNumber(List<Integer> winningLottoNumber,
                                  int bonusNumber) {
        if (winningLottoNumber.contains(bonusNumber)) {
            System.out.println("당첨번호와 보너스 볼이 중복됬습니다.");
            return true;
        }
        return false;
    }
}

class GeneratingLottoNumber {
    private static final int LOTTO_COUNT = 6;
    private static final int LOTTO_NUMBER_BEGIN = 1;
    private static final int LOTTO_NUMBER_END = 45;

    static List<Integer> generatingLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>();
        for (int number = LOTTO_NUMBER_BEGIN; number < LOTTO_NUMBER_END+1; number++) {
            lottoNumber.add(number);
        }
        Collections.shuffle(lottoNumber);
        return lottoNumber.subList(0, LOTTO_COUNT);
    }
}