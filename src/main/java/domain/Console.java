package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Console {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MINIMUM_LOTTO_PRICE = 1000;

    public static int getInputLottoMoney() {
        Util.printConsole("구입금액을 입력해 주세요.");
        int inputLottoCount = Util.divideThousand(Util.fromStringToInteger(Util.removeBlank(Util.getConsoleInput())));
        if (!Util.isGreaterThanZero(inputLottoCount)) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다. " + MINIMUM_LOTTO_PRICE + " 이상 입력해 주세요.");
        }
        return inputLottoCount;
    }

    public static List<Integer> getWinningLottoNumber() {
        Util.printConsole("지난주 당첨 번호를 입력해 주세요.");
        List<Integer> result = new ArrayList<>();
        for (String string : Util.splitStringbyComma(Util.removeBlank(Util.getConsoleInput()))) {
            result.add(Util.fromStringToInteger(string));
        }
        checkLottoNumber(result);
        Collections.sort(result);
        return result;
    }

    public static int getWinngLottoBonus() {
        Util.printConsole("보너스볼을 입력해 주세요.");
        return Util.fromStringToInteger(Util.removeBlank(Util.getConsoleInput()));
    }

    public static List<Integer> makeLottoNumberPool() {
        return IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).boxed().collect(Collectors.toList());
    }

    public static void printResult(Map<Rank, Integer> results) {
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            Util.printConsole(getRankMessage(rank, count));
        }
    }

    public static String getRankMessage(Rank rank, int rankCount) {
        if (rank != Rank.SECOND) {
            return rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + rankCount + "개";
        }
        return rank.getCountOfMatch() + "개 일치, 보너스볼 일치 (" + rank.getWinningMoney() + "원)- " + rankCount + "개";
    }

    public static void checkBonusNumber(List<Integer> winningLottoNumber, int winningLottoBonus) {
        if (winningLottoNumber.contains(winningLottoBonus)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호와 같은 수를 가질 수 없습니다.");
        }
    }

    public static void checkLottoNumber(List<Integer> numbers) {
        List<Integer> numbersClone = checkLottoNumberMinimum(numbers);
        checkLottoNumberMaximum(numbersClone);
        checkLottoNumberDuplicate(numbers);
        checkLottoNumberCount(numbers);
    }

    private static void checkLottoNumberCount(List<Integer> result) {
        if (result.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또번호는 " + LOTTO_NUMBER_COUNT + "개 필요합니다.");
        }
    }

    private static void checkLottoNumberDuplicate(List<Integer> numbers) {
        Set<Integer> tempSet = new HashSet<>(numbers);
        if (tempSet.size() < numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private static void checkLottoNumberMaximum(List<Integer> numbersClone) {
        Collections.reverse(numbersClone);
        if (numbersClone.get(0) > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 " + MAX_LOTTO_NUMBER + "보다 같거나 작아야 합니다.");
        }
    }

    private static List<Integer> checkLottoNumberMinimum(List<Integer> numbers) {
        List<Integer> numbersClone = new ArrayList<>(numbers);
        Collections.sort(numbersClone);
        if (numbersClone.get(0) < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 " + MIN_LOTTO_NUMBER + "보다 같거나 커야 합니다.");
        }
        return numbersClone;
    }
}
